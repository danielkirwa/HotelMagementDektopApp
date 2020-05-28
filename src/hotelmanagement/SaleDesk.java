/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagement;

import com.sun.javafx.print.PrinterImpl;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.print.Printer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;


/**
 *
 * @author owner
 */
public final class SaleDesk extends javax.swing.JFrame {

    /**
     * Creates new form SaleDesk
     */
    
    Connection conn;
    Statement st;
    ResultSet rs;
    PreparedStatement pst;
    
    
     String url = "jdbc:mysql://localhost:3306/hoteldb";
     String username = "root";
     String password = "";
    
    java.sql.Date saledate;
    java.util.Date jsaledate;
    int resetspinner = 0;
    String resetreceipt = "";
    int dby;
    String cat ;
    //integer for item pricess 
    int tea,coffee,cocoa,blacktea,chocolate,milk,scons,bread,maffin,queencake,pancake,tost,chapo,mariandazi,donats,cookies,ugali,rice,potatoes,cookedbanana,pitza,sheders,
            chips,fish,beeffry,beefchoma,pock,chicken,cabbage,kales,pineapple,mango,orange,banana,watermellon,avocado,coconut,roy;
    //string for populating the receipt
    String s,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24,
            s25,s26,s27,s28,s29,s30,s31,s32,s33,s34,s35,s36,s37,s38;
    public SaleDesk() {
        initComponents();
           sptea.setEnabled(false);
        spcoffee.setEnabled(false);
        spcocoa.setEnabled(false);
        spblacktea.setEnabled(false);
        spchocolate.setEnabled(false);
        spmilk.setEnabled(false);
        spbread.setEnabled(false);
        spmaffin.setEnabled(false);
        spscons.setEnabled(false);
        spqcake.setEnabled(false);
        sppcake.setEnabled(false);
        sptost.setEnabled(false);
        spcookies.setEnabled(false);
        spugali.setEnabled(false);
        sprice.setEnabled(false);
        sppotatoes.setEnabled(false);
        spbananas.setEnabled(false);
        sppitza.setEnabled(false);
        spsheders.setEnabled(false);
        spchips.setEnabled(false);
        spfish.setEnabled(false);
        spbeeffry.setEnabled(false);
        spbeefchoma.setEnabled(false);
        sppock.setEnabled(false);
        spchicken.setEnabled(false);
        spcabbage.setEnabled(false);
        spkales.setEnabled(false);
        spmango.setEnabled(false);
        sporanges.setEnabled(false);
        spcbanans.setEnabled(false);
        sppineaples.setEnabled(false);
        spwatermellon.setEnabled(false);
        spavocado.setEnabled(false);
        spcoconat.setEnabled(false);
        sproy.setEnabled(false);
        spchapo.setEnabled(false);
        spmariandazi.setEnabled(false);
        spdonats.setEnabled(false);
        
        
    
        
        showdate();
        showtime();
        loadicon();
        queryitemprice();
        priceloader();
        
    }
     void showdate(){
    Date d = new Date();
    SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
    lbdate.setText("Date :"+s.format(d));
    lbrecieptdate.setText("Date :"+s.format(d));
    }
     void showtime(){
          new Timer (0, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent ae) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             
                 Date d = new Date();
    SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
    lbtime.setText("Time :"+s.format(d));
    lbreciepttime.setText("Time :"+s.format(d));
             }
         }){
             
         }.start();
    
    }
     void loadicon(){
    ImageIcon icon = new ImageIcon();
    icon = new ImageIcon("Images/logo.png");
    setIconImage(icon.getImage());
    }
     
     void queryitemprice(){
     try{
     String url = "jdbc:mysql://localhost:3306/hoteldb";
     String username = "root";
     String password = "";
     conn = DriverManager.getConnection(url, username,password);
     st = conn.createStatement();
     String sqlselectprice = "SELECT * FROM tblbevarage ";
    rs = st.executeQuery(sqlselectprice);
    if(rs.next()){
    
      cat = rs.getString("CATEGORY");
      tea = rs.getInt("TEA");
      coffee = rs.getInt("COFFEE");
      cocoa = rs.getInt("COCOA");
      blacktea = rs.getInt("BLACKTEA");
      chocolate = rs.getInt("CHOCOLATE");
      milk = rs.getInt("MILK");
      
     
    }
    String selectsnacks = "SELECT * FROM tblsnacks";
    rs = st.executeQuery(selectsnacks);
    if(rs.next()){
        
    bread = rs.getInt("BREAD");
    maffin = rs.getInt("MAFFIN");
    scons = rs.getInt("SCONS");
    queencake = rs.getInt("QUEENCAKE");
    pancake = rs.getInt("PANCAKE");
    tost = rs.getInt("TOST");
    chapo = rs.getInt("CHAPO");
    mariandazi = rs.getInt("MARIANDAZI");
    donats = rs.getInt("DONATS");
    cookies = rs.getInt("COOKIES");
    
    }
    
    String selectmainmeals = "SELECT * FROM tblmainmeals";
    rs = st.executeQuery(selectmainmeals);
    if(rs.next()){
        
    ugali = rs.getInt("UGALI");
    rice = rs.getInt("RICE");
    potatoes = rs.getInt("POTATOES");
    cookedbanana = rs.getInt("BANANA");
    pitza = rs.getInt("PITZA");
    chips = rs.getInt("CHIPS");
    sheders = rs.getInt("SHEDERS");
    fish = rs.getInt("FISH");
    beeffry = rs.getInt("BEEFFRY");
    beefchoma = rs.getInt("BEEFCHOMA");
    pock = rs.getInt("POCK");
    chicken = rs.getInt("CHICKEN");
    cabbage = rs.getInt("CABBAGE");
    kales = rs.getInt("KALES");
    }
    
    String selectfruits = "SELECT * FROM tblfruits";
    rs = st.executeQuery(selectfruits);
    if(rs.next()){
        
    mango = rs.getInt("MANGO");
    orange = rs.getInt("ORANGE");
    banana = rs.getInt("BANANA");
    pineapple = rs.getInt("PINEAPPLE");
    watermellon = rs.getInt("WATERMELLON");
    avocado = rs.getInt("AVOCADO");
    coconut = rs.getInt("COCONUT");
    roy = rs.getInt("ROY");
   
    }
    
    else{
    JOptionPane.showMessageDialog(null,"Updating items price failed !!!");
               
    }
     
     
     }catch(Exception ex){
     JOptionPane.showMessageDialog(null,ex);
     }
     
     
     
     }
    void priceloader(){
    JOptionPane.showMessageDialog(null,"priceloader");
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
     
     
     
     
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbhotelname = new javax.swing.JLabel();
        lbdate = new javax.swing.JLabel();
        lbtime = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnexit = new javax.swing.JButton();
        btncheckprice = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        btnsale = new javax.swing.JButton();
        btnaddsale = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnreceipt = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        sptea = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        spcoffee = new javax.swing.JSpinner();
        spcocoa = new javax.swing.JSpinner();
        spblacktea = new javax.swing.JSpinner();
        spchocolate = new javax.swing.JSpinner();
        spmilk = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        spqcake = new javax.swing.JSpinner();
        sppcake = new javax.swing.JSpinner();
        sptost = new javax.swing.JSpinner();
        spcookies = new javax.swing.JSpinner();
        spscons = new javax.swing.JSpinner();
        spmariandazi = new javax.swing.JSpinner();
        spdonats = new javax.swing.JSpinner();
        spchapo = new javax.swing.JSpinner();
        spmaffin = new javax.swing.JSpinner();
        spbread = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        sppotatoes = new javax.swing.JSpinner();
        spcbanans = new javax.swing.JSpinner();
        sppitza = new javax.swing.JSpinner();
        spsheders = new javax.swing.JSpinner();
        spchips = new javax.swing.JSpinner();
        sprice = new javax.swing.JSpinner();
        spugali = new javax.swing.JSpinner();
        spbeefchoma = new javax.swing.JSpinner();
        spbeeffry = new javax.swing.JSpinner();
        spfish = new javax.swing.JSpinner();
        spkales = new javax.swing.JSpinner();
        spcabbage = new javax.swing.JSpinner();
        spchicken = new javax.swing.JSpinner();
        sppock = new javax.swing.JSpinner();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        spwatermellon = new javax.swing.JSpinner();
        spavocado = new javax.swing.JSpinner();
        spcoconat = new javax.swing.JSpinner();
        sproy = new javax.swing.JSpinner();
        spmango = new javax.swing.JSpinner();
        sporanges = new javax.swing.JSpinner();
        spbananas = new javax.swing.JSpinner();
        sppineaples = new javax.swing.JSpinner();
        jpreceipt = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        lbrecieptdate = new javax.swing.JLabel();
        lbreciepttime = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txtamount = new javax.swing.JLabel();
        txtpay = new javax.swing.JLabel();
        txtbalance = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tareceipt = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LUXURY HOTEL SALEDESK");
        setName("jfsaledesk"); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 160, 7));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N

        lbhotelname.setFont(new java.awt.Font("Wide Latin", 0, 18)); // NOI18N
        lbhotelname.setText("LUXURY HOTEL SALEDESK");

        lbdate.setFont(new java.awt.Font("Wide Latin", 0, 18)); // NOI18N
        lbdate.setText("DATE :");

        lbtime.setFont(new java.awt.Font("Wide Latin", 0, 18)); // NOI18N
        lbtime.setForeground(new java.awt.Color(255, 255, 255));
        lbtime.setText("TIME :");

        jPanel2.setBackground(new java.awt.Color(255, 200, 124));

        btnexit.setBackground(new java.awt.Color(255, 0, 0));
        btnexit.setFont(new java.awt.Font("Wide Latin", 0, 12)); // NOI18N
        btnexit.setForeground(new java.awt.Color(255, 255, 255));
        btnexit.setText("EXIT");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        btncheckprice.setBackground(new java.awt.Color(204, 102, 255));
        btncheckprice.setFont(new java.awt.Font("Wide Latin", 0, 12)); // NOI18N
        btncheckprice.setText("CHECH PRICE");

        btnreset.setBackground(new java.awt.Color(102, 255, 255));
        btnreset.setFont(new java.awt.Font("Wide Latin", 0, 12)); // NOI18N
        btnreset.setText("RESET");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        btnsale.setBackground(new java.awt.Color(0, 255, 0));
        btnsale.setFont(new java.awt.Font("Wide Latin", 0, 12)); // NOI18N
        btnsale.setText("SALE");
        btnsale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaleActionPerformed(evt);
            }
        });

        btnaddsale.setBackground(new java.awt.Color(102, 255, 102));
        btnaddsale.setFont(new java.awt.Font("Wide Latin", 0, 12)); // NOI18N
        btnaddsale.setText("ADD SALE");
        btnaddsale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddsaleActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnreceipt.setBackground(new java.awt.Color(102, 255, 255));
        btnreceipt.setFont(new java.awt.Font("Wide Latin", 0, 18)); // NOI18N
        btnreceipt.setText("PRINT");
        btnreceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreceiptActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Wide Latin", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MEALS");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Wide Latin", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("BEVERAGE");
        jLabel5.setToolTipText("");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Wide Latin", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("FRUITS");

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Wide Latin", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("SNACKS");

        jLabel8.setText("TEA");

        sptea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spteaMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                spteaMouseReleased(evt);
            }
        });

        jLabel9.setText("COFFEE");

        jLabel10.setText("COCOA");

        jLabel11.setText("BLACK TEA");

        jLabel12.setText("CHOCOLATE");

        jLabel13.setText("MILK");

        jLabel14.setText("BREAD");

        jLabel15.setText("MAFFIN");

        jLabel16.setText("SCONS");

        jLabel17.setText("QUEEN CAKE");

        jLabel18.setText("PAN CAKE");

        jLabel19.setText("TOST");

        jLabel20.setText("COOKIES");

        jLabel21.setText("CHAPO");

        jLabel22.setText("MARIANDAZI");

        jLabel23.setText("DONATS");

        jLabel2.setText("UGALI");

        jLabel3.setText("RICE");

        jLabel24.setText("POTATOES");

        jLabel25.setText("BANANAS");

        jLabel26.setText("PITZA");

        jLabel27.setText("SHEDERS");

        jLabel28.setText("CHIPS");

        jLabel29.setText("FISH");

        jLabel30.setText("BEEF FRY");

        jLabel31.setText("BEEF CHOMA");

        jLabel32.setText("POCK");

        jLabel33.setText("CHICKEN");

        jLabel34.setText("CABBAGE");

        jLabel35.setText("KALES");

        jLabel36.setBackground(new java.awt.Color(0, 0, 0));
        jLabel36.setFont(new java.awt.Font("Wide Latin", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("RECIEPT");

        jLabel37.setText("MANGO");

        jLabel38.setText("ORANGES");

        jLabel39.setText("BANANAS");

        jLabel40.setText("PINEAPLES");

        jLabel41.setText("WATERMELLON");

        jLabel42.setText("AVOCADO");

        jLabel43.setText("COCONAT");

        jLabel44.setText("ROY");

        jpreceipt.setBackground(new java.awt.Color(255, 255, 255));

        jLabel45.setText("LUXURY HOTEL DESK");

        lbrecieptdate.setText("DATE");

        lbreciepttime.setText("TIME");

        jLabel48.setText("PO BOX 0001- 3006    ELDORET");

        jLabel49.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        jLabel49.setText("THANK YOU WELCOME AGAIN");

        jLabel50.setFont(new java.awt.Font("Segoe Print", 0, 11)); // NOI18N
        jLabel50.setText("GOODS ONCE SOLED CAN'T BE RETURNED");

        txtamount.setText("TOTAL AMOUNT");

        txtpay.setText("PAY");

        txtbalance.setText("BALANCE");

        tareceipt.setColumns(20);
        tareceipt.setRows(5);
        tareceipt.setEnabled(false);
        jScrollPane3.setViewportView(tareceipt);

        javax.swing.GroupLayout jpreceiptLayout = new javax.swing.GroupLayout(jpreceipt);
        jpreceipt.setLayout(jpreceiptLayout);
        jpreceiptLayout.setHorizontalGroup(
            jpreceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpreceiptLayout.createSequentialGroup()
                .addGroup(jpreceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpreceiptLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpreceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48)
                            .addComponent(jLabel49)
                            .addComponent(jLabel50)
                            .addGroup(jpreceiptLayout.createSequentialGroup()
                                .addComponent(lbrecieptdate)
                                .addGap(47, 47, 47)
                                .addComponent(lbreciepttime))))
                    .addGroup(jpreceiptLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel45))
                    .addGroup(jpreceiptLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtamount)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpreceiptLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtpay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtbalance)
                .addGap(90, 90, 90))
            .addComponent(jScrollPane3)
        );
        jpreceiptLayout.setVerticalGroup(
            jpreceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpreceiptLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpreceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbrecieptdate)
                    .addComponent(lbreciepttime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtamount)
                .addGap(16, 16, 16)
                .addGroup(jpreceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpay)
                    .addComponent(txtbalance))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel50)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addComponent(btnaddsale, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnsale, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btncheckprice, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jLabel7))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sptea, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                    .addComponent(spcoffee)
                                    .addComponent(spcocoa)
                                    .addComponent(spblacktea)
                                    .addComponent(spchocolate)
                                    .addComponent(spmilk)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel16))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(spmaffin, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                                    .addComponent(spscons)))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(spqcake, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                                        .addComponent(sppcake)
                                                        .addComponent(sptost)
                                                        .addComponent(spcookies))
                                                    .addComponent(spbread, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel21))))
                        .addGap(110, 110, 110))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(63, 63, 63))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(spdonats, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(74, 74, 74)
                                            .addComponent(spmariandazi, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(spchapo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)))))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(246, 246, 246))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel24)
                                            .addComponent(jLabel25)
                                            .addComponent(jLabel26)
                                            .addComponent(jLabel27)
                                            .addComponent(jLabel28)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2))
                                        .addGap(32, 32, 32)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(sppotatoes, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                            .addComponent(spcbanans)
                                            .addComponent(sppitza)
                                            .addComponent(spsheders)
                                            .addComponent(spchips)
                                            .addComponent(sprice)
                                            .addComponent(spugali))
                                        .addGap(137, 137, 137)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel31)
                                            .addComponent(jLabel30)
                                            .addComponent(jLabel29)
                                            .addComponent(jLabel35)
                                            .addComponent(jLabel34)
                                            .addComponent(jLabel33)
                                            .addComponent(jLabel32))
                                        .addGap(38, 38, 38)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(spbeefchoma, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                            .addComponent(spbeeffry)
                                            .addComponent(spfish)
                                            .addComponent(spkales)
                                            .addComponent(spcabbage)
                                            .addComponent(spchicken)
                                            .addComponent(sppock)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel38)
                                            .addComponent(jLabel39)
                                            .addComponent(jLabel40))
                                        .addGap(43, 43, 43)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(sporanges, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(spbananas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(sppineaples, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(128, 128, 128)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel43)
                                            .addComponent(jLabel42)
                                            .addComponent(jLabel44)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel37)
                                        .addGap(59, 59, 59)
                                        .addComponent(spmango, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(125, 125, 125)
                                        .addComponent(jLabel41)
                                        .addGap(40, 40, 40)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(sproy)
                                            .addComponent(spcoconat)
                                            .addComponent(spavocado)
                                            .addComponent(spwatermellon, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(211, 211, 211)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnreceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jpreceipt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(1052, Short.MAX_VALUE)
                    .addComponent(jLabel36)
                    .addGap(50, 50, 50)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(sptea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(spcoffee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(spcocoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(spblacktea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(spchocolate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(spmilk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel21)
                                    .addComponent(spchapo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spbread, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel22)
                                    .addComponent(spmariandazi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spmaffin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel23)
                                    .addComponent(spscons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spdonats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17)
                                    .addComponent(spqcake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(sppcake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(sptost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(spcookies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 67, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jpreceipt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnreceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel29)
                            .addComponent(spugali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spfish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel30)
                            .addComponent(sprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spbeeffry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel24)
                                .addComponent(jLabel31)
                                .addComponent(spbeefchoma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(sppotatoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel32)
                            .addComponent(spcbanans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sppock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(jLabel33)
                            .addComponent(sppitza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spchicken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jLabel34)
                            .addComponent(spsheders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spcabbage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jLabel35)
                            .addComponent(spchips, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spkales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(jLabel41)
                            .addComponent(spwatermellon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spmango, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(jLabel42)
                            .addComponent(spavocado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sporanges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(jLabel43)
                            .addComponent(spcoconat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spbananas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(jLabel44)
                            .addComponent(sproy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sppineaples, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncheckprice, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsale, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnaddsale, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jLabel36)
                    .addContainerGap(555, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbhotelname)
                .addGap(78, 78, 78)
                .addComponent(lbdate)
                .addGap(79, 79, 79)
                .addComponent(lbtime)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbhotelname)
                    .addComponent(lbdate)
                    .addComponent(lbtime))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_btnexitActionPerformed

    private void btnreceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreceiptActionPerformed
        
            // TODO add your handling code here:
            
            PrinterJob pjob = PrinterJob.getPrinterJob();
            pjob.setJobName("SALE RECEIPT");
            pjob.setPrintable(new Printable(){ 
            public int print(Graphics pg ,PageFormat pf, int pagenum){
            pf.setOrientation(PageFormat.LANDSCAPE);
            if(pagenum > 0){
            return Printable.NO_SUCH_PAGE;
            }
            java.awt.Graphics2D g2 = (java.awt.Graphics2D)pg;
            g2.translate(pf.getImageableX(), pf.getImageableY());
            g2.scale(0.63, 0.97);
            jpreceipt.paint(g2);
            return Printable.PAGE_EXISTS;
            }
            });
            boolean  ok = pjob.printDialog();
            if(ok){
            try{
            pjob.print();
            }catch(PrinterException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
            }
            
            
            
         
    }//GEN-LAST:event_btnreceiptActionPerformed

    private void btnsaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaleActionPerformed
        // TODO add your handling code here:
        try{
            
            int y = (int) sptea.getValue();int y1 = (int) spcoffee.getValue();int y2 = (int) spcocoa.getValue(); int y3 = (int) spblacktea.getValue();
            int y4 = (int) spchocolate.getValue();int y5 = (int) spmilk.getValue();int y6= (int) spbread.getValue();int y7 = (int) spmaffin.getValue();
            int y8 = (int) spscons.getValue();int y9 = (int) spqcake.getValue();int y10 = (int) sppcake.getValue();int y11 = (int) sptost.getValue();
            int y12 = (int) spcookies.getValue();int y13 = (int) spugali.getValue();int y14 = (int) sprice.getValue();int y15 = (int) sppotatoes.getValue();
            int y16 = (int) spcbanans.getValue();int y17 = (int) sppitza.getValue();int y18 = (int) spsheders.getValue();int y19 = (int) spchips.getValue();
            int y20 = (int) spfish.getValue();int y21 = (int) spbeeffry.getValue();int y22 = (int) spbeefchoma.getValue();int y23 = (int) sppock.getValue();
            int y24 = (int) spchicken.getValue();int y25 = (int) spcabbage.getValue();int y26 = (int) spkales.getValue();int y27 = (int) spmango.getValue();
            int y28 = (int) sporanges.getValue();int y29 = (int) spbananas.getValue();int y30 = (int) spwatermellon.getValue();int y31 = (int) spavocado.getValue();
            int y32 = (int) spcoconat.getValue();int y33 = (int) sproy.getValue();int y34 = (int) spchapo.getValue();int y35 = (int) spdonats.getValue();
            int y36 = (int) spmariandazi.getValue();int y37 = (int) sppineaples.getValue();
            
            if(y  < 0 || y1 < 0 || y2 < 0 || y3 < 0 || y4 < 0 || y5 < 0 || y6 < 0 || y7 < 0 || y8 < 0 || y9 < 0 || y10 < 0 || y11 < 0 || y12 < 0 || y13 < 0
                    || y14 < 0 || y15 < 0 || y16 < 0 || y17 < 0 || y18 < 0 || y19 < 0 || y20 <  0 || y21 < 0 || y22 < 0 || y23 < 0 || y24 < 0 || y25 < 0 || y26 < 0
                    || y27 < 0 || y28 < 0 || y29 < 0 || y30 < 0 || y31 < 0 || y32 < 0 || y33 < 0 || y34 < 0 || y35 < 0 || y36 < 0 || y37 < 0){
            JOptionPane.showMessageDialog(null, "<html> <b  style=\"color: red; font-size: 20px;\"> (-) SELECTION NOT ALLOWED</b></html>");
            }
            else if (y  > 0 || y1 > 0 || y2 > 0 || y3 > 0 || y4 > 0 || y5 > 0 || y6 > 0 || y7 > 0 || y8 > 0 || y9 > 0 || y10 > 0 || y11 > 0 || y12 > 0 || y13 > 0
                    || y14 > 0 || y15 > 0 || y16 > 0 || y17 > 0 || y18 > 0 || y19 > 0 || y20 > 0 || y21 > 0 || y22 > 0 || y23 > 0 || y24 > 0 || y25 > 0 || y26 > 0
                    || y27 > 0 || y28 > 0 || y29 > 0 || y30 > 0 || y31 > 0 || y32 > 0 || y33 > 0 || y34 > 0 || y35 > 0 || y36 > 0 || y37 > 0 ){
                int sbtotal1 = (y * tea) + (y1* coffee)+ (y2* cocoa)+ (y3* blacktea)+ (y4* chocolate)+ (y5* milk)+ (y6* bread)+ (y7* maffin)+ (y8* scons)+ (y9* queencake)+ (y10* pancake)+ (y11* tost)+ (y12* cookies);
                int sbtotal2 =  (y13* ugali)+ (y14* rice)+ (y15* potatoes)+ (y16* cookedbanana)+ (y17* pitza)+ (y18* sheders)+ (y19* chips)+ (y20* fish)+ (y21* beeffry)+ (y22* beefchoma)+ (y23* pock)+ (y24* chicken);
                int sbtotal3 = (y25* kales)+ (y26* cabbage)+ (y27* mango)+ (y28* orange)+ (y29* banana)+ (y30* watermellon)+ (y31* avocado)+ (y32* coconut)+ (y33* roy)+ (y34* chapo)+ (y35* donats)+ (y36* mariandazi)+ (y37* pineapple);
                int total = sbtotal1 + sbtotal2+sbtotal3;
              String payamount =  JOptionPane.showInputDialog(null,  "Enter pay amount" +"Ksh :"+total);
              int amout = Integer.parseInt(payamount);
              
              int balance = amout - total;
              if(amout >= total){
                  if(y >0 ){
                s = "Tea" +" " + " X"+"  " + y +"  "+ "Ksh : "+tea+"\n" ;
                  }else {
                     s = "";     
                  }
                  if(y1 > 0 ){
                s1 = "Coffee" +" " + " X"+"  " + y1 +"  "+ "Ksh : "+coffee+" \n" ;
                  }
                  else {
                     s1 = "";     
                  }
                   if(y2 > 0 ){
                s2 = "Cocoa" +" " + " X"+"  " + y2 +"  "+ "Ksh : "+cocoa+"\n" ;
                  }
                   else {
                     s2 = "";     
                  }
                    if(y3 > 0 ){
                s3 = "Black tea" +" " + " X"+"  " + y3 +"  "+ "Ksh : "+blacktea+"\n" ;
                  }
                    else {
                     s3 = "";     
                  }
                     if(y4 > 0 ){
                s4 = "Chocolate" +" " + " X"+"  " + y4 +"  "+ "Ksh : "+chocolate+" \n" ;
                  }else {
                     s4 = "";     
                  }
                      if(y5 > 0 ){
                s5 = "Milk" +" " + " X"+"  " + y5 +"  "+ "Ksh : "+milk+" \n" ;
                  }
                     else {
                     s5 = "";     
                  }
                       if(y6 > 0 ){
                s6 = "Bread" +" " + " X"+"  " + y6 +"  "+ "Ksh : "+bread+" \n" ;
                  }
                       else {
                     s6 = "";     
                  }
                        if(y7 > 0 ){
                s7 = "Maffin" +" " + " X"+"  " + y7 +"  "+ "Ksh : "+maffin+" \n" ;
                  } else {
                     s7 = "";     
                  }
                         if(y8 > 0 ){
                s8 = "Scons" +" " + " X"+"  " + y8 +"  "+ "Ksh : "+scons+" \n" ;
                  }
                        else {
                     s8 = "";     
                  }
                          if(y9 > 0 ){
                s9 = "Queen Cake " +" " + " X"+"  " + y9 +"  "+ "Ksh : "+queencake+" \n" ;
                  }
                          else {
                     s9 = "";     
                  }
                           if(y10 > 0 ){
                s10 = "Pan Cake" +" " + " X"+"  " + y10 +"  "+ "Ksh : "+pancake+" \n" ;
                  }
                          else {
                     s10 = "";     
                  }
                            if(y11 > 0 ){
                s11 = "Tost" +" " + " X"+"  " + y11 +"  "+ "Ksh : "+tost+" \n" ;
                  }
                            else {
                     s11 = "";     
                  }
                             if(y12 > 0 ){
                s12 = "Cookies" +" " + " X"+"  " + y12 +"  "+ "Ksh : "+cookies+" \n" ;
                  }
                            else {
                     s12 = "";     
                  }
                             if(y13 > 0 ){
                s13 = "Ugali" +" " + " X"+"  " + y13 +"  "+ "Ksh : "+ugali+" \n" ;
                  }
                             else {
                     s13 = "";     
                  }
                               if(y14 > 0 ){
                s14 = "Rice" +" " + " X"+"  " + y14 +"  "+ "Ksh : "+rice+" \n" ;
                  }
                            else {
                     s14 = "";     
                  }
                                if(y15 > 0 ){
                s15 = "Potatoes" +" " + " X"+"  " + y15 +"  "+ "Ksh : "+potatoes+" \n" ;
                  } else {
                     s15 = "";     
                  }
                                 if(y16 > 0 ){
                s16 = "Cooked Bananas" +" " + " X"+"  " + y16 +"  "+ "Ksh : "+cookedbanana+" \n" ;
                  }
                                 else {
                     s16 = "";     
                  }
                                  if(y17 > 0 ){
                s17 = "Pitza" +" " + " X"+"  " + y17 +"  "+ "Ksh : "+pitza+" \n" ;
                  }
                                else {
                     s17 = "";     
                  }
                                   if(y18 > 0 ){
                s18 = "Sheders" +" " + " X"+"  " + y18 +"  "+ "Ksh : "+sheders+" \n" ;
                  }
                                   else {
                     s18 = "";     
                  }
                                    if(y19 > 0 ){
                s19 = "Chips" +" " + " X"+"  " + y19 +"  "+ "Ksh :  "+chips+" \n" ;
                  }
                                    else {
                     s19= "";     
                  }
                                     if(y20 > 0 ){
                s20 = "Fish" +" " + " X"+"  " + y20 +"  "+ "Ksh : "+fish+" \n" ;
                  }
                                     else {
                     s20 = "";     
                  }
                                      if(y21 > 0 ){
                s21 = "Beef Fry" +" " + " X"+"  " + y21 +"  "+ "Ksh : "+beeffry+" \n" ;
                  }
                                      else {
                     s21 = "";     
                  }
                                       if(y22 > 0 ){
                s22 = "Beef Choma" +" " + " X"+"  " + y22 +"  "+ "Ksh : "+beefchoma+" \n" ;
                  }
                                       else {
                     s22 = "";     
                  }
                                        if(y23 > 0 ){
                s23 = "Pock" +" " + " X"+"  " + y23 +"  "+ "Ksh : "+pock+" \n" ;
                  }
                                        else {
                     s23 = "";     
                  }
                                         if(y24 > 0 ){
                s24 = "Chicken" +" " + " X"+"  " + y24 +"  "+ "Ksh : "+chicken+" \n" ;
                  }
                                         else {
                     s24 = "";     
                  }
                                          if(y25 > 0 ){
                s25 = "kales" +" " + " X"+"  " + y25 +"  "+ "Ksh : "+kales+" \n" ;
                  }
                                          else {
                     s25 = "";     
                  }
                                           if(y26 > 0 ){
                s26 = "Cabbage" +" " + " X"+"  " + y26 +"  "+ "Ksh : "+cabbage+" \n" ;
                  }
                                           else {
                     s26 = "";     
                  }
                                            if(y27 > 0 ){
                s27 = "Mango" +" " + " X"+"  " + y27 +"  "+ "Ksh : "+mango+" \n" ;
                  }
                                            else {
                     s27 = "";     
                  }
                                             if(y28 > 0 ){
                s28 = "Orange" +" " + " X"+"  " + y28 +"  "+ "Ksh : "+orange+" \n" ;
                  }
                                             else {
                     s28 = "";     
                  }
                                              if(y29 > 0 ){
                s29 = "Banana" +" " + " X"+"  " + y29 +"  "+ "Ksh : "+banana+" \n" ;
                  }
                                              else {
                     s29 = "";     
                  }
                   
                                               if(y30 > 0 ){
                s30 = "WaterMellon" +" " + " X"+"  " + y30 +"  "+ "Ksh : "+watermellon+" \n" ;
                  }
                                               else {
                     s30 = "";     
                  }
                                               if(y31 > 0 ){
                s31 = "Avocado" +" " + " X"+"  " + y31 +"  "+ "Ksh : "+avocado+" \n" ;
                  }
                                               else {
                     s31 = "";     
                  }
                                               if(y32 > 0 ){
                s32 = "Coconat" +" " + " X"+"  " + y32 +"  "+ "Ksh : "+coconut+" \n" ;
                  }
                                               else {
                     s32 = "";     
                  }
                                               if(y33 > 0 ){
                s33 = "Roy" +" " + " X"+"  " + y33 +"  "+ "Ksh : "+roy+" \n" ;
                  }
                                               else {
                     s33 = "";     
                  }
                                                if(y34 > 0 ){
                s34 = "Chapo" +" " + " X"+"  " + y34 +"  "+ "Ksh : "+chapo+" \n" ;
                  }
                                                else {
                     s34 = "";     
                  }
                                                 if(y35 > 0 ){
                s35 = "Donats" +" " + " X"+"  " + y35 +"  "+ "Ksh : "+donats+" \n" ;
                  }
                                                 else {
                     s35 = "";     
                  }
                                                  if(y36 > 0 ){
                s36 = "Mariandazi" +" " + " X"+"  " + y36 +"  "+ "Ksh : "+mariandazi+" \n" ;
                  }
                                                  else {
                     s36 = "";     
                  }
                                                if(y37 > 0 ){
                s37 = "Pineaple" +" " + " X"+"  " + y37 +"  "+ "Ksh : "+pineapple+" \n" ;
                  }
                                                else {
                     s37 = "";     
                  }
            
        tareceipt.setText(s+s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17+s18+s19+s20+s21+s22+s23+s24+s25+s26+s27+s28+s29+s30+s31+s32+s33+s34+s35+s36+s37);
        txtbalance.setText("balance : " +"Ksh "+ balance);
        txtamount.setText("Total Cost :"+ "Ksh "+ total);
        txtpay.setText("Pay :" + "Ksh "+ amout);
        int dis = 0;
      
        conn = DriverManager.getConnection(url,username,password);
        st = conn.createStatement();
        String sqlsave = "INSERT INTO tblsalesrecord(SALEDATE,ITEMLIST,AMOUNT,DISCOUNTS) VALUES ('"+lbrecieptdate.getText()+"',"
                + "'"+tareceipt.getText()+"','"+total+"','"+dis+"')";
       st.execute(sqlsave);
              
              }else{
              JOptionPane.showMessageDialog(null,  "Pay amount is Less");
              }
        
            }else{
            JOptionPane.showMessageDialog(null,  "select item");
            }
            
            
            
            sptea.setEnabled(false);
        spcoffee.setEnabled(false);
        spcocoa.setEnabled(false);
        spblacktea.setEnabled(false);
        spchocolate.setEnabled(false);
        spmilk.setEnabled(false);
        spbread.setEnabled(false);
        spmaffin.setEnabled(false);
        spscons.setEnabled(false);
        spqcake.setEnabled(false);
        sppcake.setEnabled(false);
        sptost.setEnabled(false);
        spcookies.setEnabled(false);
        spugali.setEnabled(false);
        sprice.setEnabled(false);
        sppotatoes.setEnabled(false);
        spbananas.setEnabled(false);
        sppitza.setEnabled(false);
        spsheders.setEnabled(false);
        spchips.setEnabled(false);
        spfish.setEnabled(false);
        spbeeffry.setEnabled(false);
        spbeefchoma.setEnabled(false);
        sppock.setEnabled(false);
        spchicken.setEnabled(false);
        spcabbage.setEnabled(false);
        spkales.setEnabled(false);
        spmango.setEnabled(false);
        sporanges.setEnabled(false);
        spcbanans.setEnabled(false);
        sppineaples.setEnabled(false);
        spwatermellon.setEnabled(false);
        spavocado.setEnabled(false);
        spcoconat.setEnabled(false);
        sproy.setEnabled(false);
        spchapo.setEnabled(false);
        spmariandazi.setEnabled(false);
        spdonats.setEnabled(false);
        }
        catch(HeadlessException | NumberFormatException ex){
        JOptionPane.showMessageDialog(null,ex);
        } catch (SQLException ex) {
            Logger.getLogger(SaleDesk.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,ex);
        }
        
       
    }//GEN-LAST:event_btnsaleActionPerformed

    private void btnaddsaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddsaleActionPerformed
        // TODO add your handling code here:
        sptea.setEnabled(true);spcoffee.setEnabled(true);spcocoa.setEnabled(true);spblacktea.setEnabled(true);spchocolate.setEnabled(true);spmilk.setEnabled(true);
        spbread.setEnabled(true);spmaffin.setEnabled(true);spscons.setEnabled(true);spqcake.setEnabled(true);sppcake.setEnabled(true);sptost.setEnabled(true);
        spcookies.setEnabled(true);spugali.setEnabled(true);sprice.setEnabled(true);sppotatoes.setEnabled(true);spbananas.setEnabled(true);sppitza.setEnabled(true);
        spsheders.setEnabled(true);spchips.setEnabled(true);spfish.setEnabled(true);spbeeffry.setEnabled(true);spbeefchoma.setEnabled(true);sppock.setEnabled(true);
        spchicken.setEnabled(true);
        spcabbage.setEnabled(true);
        spkales.setEnabled(true);
        spmango.setEnabled(true);
        sporanges.setEnabled(true);
        spcbanans.setEnabled(true);
        sppineaples.setEnabled(true);
        spwatermellon.setEnabled(true);
        spavocado.setEnabled(true);
        spcoconat.setEnabled(true);
        sproy.setEnabled(true);
        spchapo.setEnabled(true);
        spmariandazi.setEnabled(true);
        spdonats.setEnabled(true);
        //reset the spinner
        sptea.setValue(resetspinner);
        sptea.setValue(resetspinner);
        spcoffee.setValue(resetspinner);
        spcocoa.setValue(resetspinner);
        spblacktea.setValue(resetspinner);
        spchocolate.setValue(resetspinner);
        spmilk.setValue(resetspinner);
        spbread.setValue(resetspinner);
        spmaffin.setValue(resetspinner);
        spscons.setValue(resetspinner);
        spqcake.setValue(resetspinner);
        sppcake.setValue(resetspinner);
        sptost.setValue(resetspinner);
        spcookies.setValue(resetspinner);
        spugali.setValue(resetspinner);
        sprice.setValue(resetspinner);
        sppotatoes.setValue(resetspinner);
        spbananas.setValue(resetspinner);;
        sppitza.setValue(resetspinner);
        spsheders.setValue(resetspinner);
        spchips.setValue(resetspinner);
        spfish.setValue(resetspinner);
        spbeeffry.setValue(resetspinner);
        spbeefchoma.setValue(resetspinner);
        sppock.setValue(resetspinner);
        spchicken.setValue(resetspinner);
        spcabbage.setValue(resetspinner);
        spkales.setValue(resetspinner);
        spmango.setValue(resetspinner);
        sporanges.setValue(resetspinner);
        spcbanans.setValue(resetspinner);
        sppineaples.setValue(resetspinner);
        spwatermellon.setValue(resetspinner);
        spavocado.setValue(resetspinner);
        spcoconat.setValue(resetspinner);
        sproy.setValue(resetspinner);
        spchapo.setValue(resetspinner);
        spmariandazi.setValue(resetspinner);
        //reset the reciept
        //String[] clearreceipt = {resetreceipt};
        tareceipt.setText(resetreceipt);
        txtamount.setText("Total amount : Ksh 0.00");
        txtpay.setText("Pay : Ksh 0.00");
        txtbalance.setText("Balance : Ksh 0.00");
        
        
    }//GEN-LAST:event_btnaddsaleActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnresetActionPerformed

    private void spteaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spteaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_spteaMouseClicked

    private void spteaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spteaMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_spteaMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SaleDesk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaleDesk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaleDesk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaleDesk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SaleDesk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaddsale;
    private javax.swing.JButton btncheckprice;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnreceipt;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnsale;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jpreceipt;
    private javax.swing.JLabel lbdate;
    private javax.swing.JLabel lbhotelname;
    private javax.swing.JLabel lbrecieptdate;
    private javax.swing.JLabel lbreciepttime;
    private javax.swing.JLabel lbtime;
    private javax.swing.JSpinner spavocado;
    private javax.swing.JSpinner spbananas;
    private javax.swing.JSpinner spbeefchoma;
    private javax.swing.JSpinner spbeeffry;
    private javax.swing.JSpinner spblacktea;
    private javax.swing.JSpinner spbread;
    private javax.swing.JSpinner spcabbage;
    private javax.swing.JSpinner spcbanans;
    private javax.swing.JSpinner spchapo;
    private javax.swing.JSpinner spchicken;
    private javax.swing.JSpinner spchips;
    private javax.swing.JSpinner spchocolate;
    private javax.swing.JSpinner spcocoa;
    private javax.swing.JSpinner spcoconat;
    private javax.swing.JSpinner spcoffee;
    private javax.swing.JSpinner spcookies;
    private javax.swing.JSpinner spdonats;
    private javax.swing.JSpinner spfish;
    private javax.swing.JSpinner spkales;
    private javax.swing.JSpinner spmaffin;
    private javax.swing.JSpinner spmango;
    private javax.swing.JSpinner spmariandazi;
    private javax.swing.JSpinner spmilk;
    private javax.swing.JSpinner sporanges;
    private javax.swing.JSpinner sppcake;
    private javax.swing.JSpinner sppineaples;
    private javax.swing.JSpinner sppitza;
    private javax.swing.JSpinner sppock;
    private javax.swing.JSpinner sppotatoes;
    private javax.swing.JSpinner spqcake;
    private javax.swing.JSpinner sprice;
    private javax.swing.JSpinner sproy;
    private javax.swing.JSpinner spscons;
    private javax.swing.JSpinner spsheders;
    private javax.swing.JSpinner sptea;
    private javax.swing.JSpinner sptost;
    private javax.swing.JSpinner spugali;
    private javax.swing.JSpinner spwatermellon;
    private javax.swing.JTextArea tareceipt;
    private javax.swing.JLabel txtamount;
    private javax.swing.JLabel txtbalance;
    private javax.swing.JLabel txtpay;
    // End of variables declaration//GEN-END:variables
}
