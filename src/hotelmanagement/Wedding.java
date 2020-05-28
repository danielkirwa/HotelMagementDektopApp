/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagement;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author owner
 */
public class Wedding extends javax.swing.JFrame {

    /**
     * Creates new form Wedding
     */
    Connection conn;
    Statement st;
    ResultSet rs;
    PreparedStatement pst;
    
    String url = "jdbc:mysql://localhost:3306/hoteldb";
    String username = "root";
    String password = "";
    
    
    public Wedding() {
        initComponents();
        loadicon();
        deactivateupdatenanddelete();
    }
    void loadicon(){
    ImageIcon icon = new ImageIcon();
    icon = new ImageIcon("Images/logo.png");
    setIconImage(icon.getImage());
    }
   void  deactivateupdatenanddelete(){
   btnupdate.setEnabled(false);
   btndelete.setEnabled(false);
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
        jLabel1 = new javax.swing.JLabel();
        btnback = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnsaveprice = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnsearch = new javax.swing.JButton();
        btnnewiground = new javax.swing.JButton();
        cmbground = new javax.swing.JComboBox<>();
        txtprice = new javax.swing.JTextField();
        txtmeala = new javax.swing.JTextField();
        txtmealb = new javax.swing.JTextField();
        txtconvoyp = new javax.swing.JTextField();
        txtconvoyh = new javax.swing.JTextField();
        txtdiscount = new javax.swing.JTextField();
        txtnewground = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LUXURY   HOTEL  WEDDING");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(240, 82, 5));

        jLabel1.setFont(new java.awt.Font("Wide Latin", 0, 14)); // NOI18N
        jLabel1.setText("LUXURY   HOTEL   WEDDING");

        btnback.setBackground(new java.awt.Color(255, 255, 255));
        btnback.setFont(new java.awt.Font("Wide Latin", 0, 14)); // NOI18N
        btnback.setForeground(new java.awt.Color(0, 0, 153));
        btnback.setText("BACK");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(240, 142, 51));

        jLabel2.setText("SELECT GROUND");

        jLabel3.setText("CLASS B MEALS");

        jLabel4.setText("NET PRICE");

        jLabel5.setText("CLASS A MEALS");

        jLabel6.setText("PRESIDENTIAL CONVOY");

        jLabel7.setText("HOTEL CONVOY");

        jLabel8.setText("DISCOUNT");

        jLabel9.setText("NEW GROUND ");

        btnsaveprice.setText("SAVE PRICE");
        btnsaveprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsavepriceActionPerformed(evt);
            }
        });

        btnupdate.setText("UPDATE");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btndelete.setText("DELETE");

        btnsearch.setText("SEARCH");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        btnnewiground.setText("NEW GROUND");

        cmbground.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NAIROBI", "KISUMU", "ELDORET", "MOMBASA" }));

        txtnewground.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbground, 0, 210, Short.MAX_VALUE)
                            .addComponent(txtprice)
                            .addComponent(txtmeala)
                            .addComponent(txtmealb)
                            .addComponent(txtconvoyp)
                            .addComponent(txtconvoyh)
                            .addComponent(txtdiscount)
                            .addComponent(txtnewground))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnsaveprice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnnewiground)
                        .addGap(37, 37, 37))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtmeala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtmealb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtconvoyp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtconvoyh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addComponent(txtdiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtnewground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsaveprice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnewiground, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(68, 68, 68)
                .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Admin().setVisible(true);
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnsavepriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsavepriceActionPerformed
        // TODO add your handling code here:
        try{
        conn = DriverManager.getConnection(url,username,password);
        st = conn.createStatement();
        String sqlsaveprice = "INSERT INTO tblweddingpricing (GROUD,MEALCLASSA,MEALCLASSB,PRESIDENTIALCONVOY,HOTELCONVOY,NETPRICE,DISCOUNT) VALUES ('"+cmbground.getSelectedItem()+"'"
                + ",'"+txtmeala.getText()+"','"+txtmealb.getText()+"','"+txtconvoyp.getText()+"','"+txtconvoyh.getText()+"',"
                + ",'"+txtprice.getText()+"','"+txtdiscount.getText()+"',)";
        if(!"".equals(txtprice.getText()) && !"".equals(txtmeala.getText())&& !"".equals(txtmealb.getText())&& !"".equals(txtconvoyp.getText())&&
                !"".equals(txtconvoyh.getText())&& !"".equals(txtdiscount.getText())){
       st.execute(sqlsaveprice);
       JOptionPane.showMessageDialog(null, "NEW PRICE SAVED");
       cmbground.setSelectedItem("");
       txtprice.setText("");
       txtmeala.setText("");
       txtmealb.setText("");
       txtconvoyp.setText("");
       txtconvoyh.setText("");
       txtdiscount.setText("");
       
        }else{
         JOptionPane.showMessageDialog(null, "ENTER ALL THE DETAILS !!!");
        }
        }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, ex);
        }
        
    }//GEN-LAST:event_btnsavepriceActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:
        try{
        conn = DriverManager.getConnection(url,username,password);
        st = conn.createStatement();
        String sqlsearch = "SELECT * FROM tblweddingpricing WHERE GROUD = ?";
        pst=conn.prepareStatement(sqlsearch);
        pst.setString(1,(String) cmbground.getSelectedItem());
        rs=pst.executeQuery();
        
        if(rs.next()){
            JOptionPane.showMessageDialog(null, "REQUISTING DATA...");
           String ground = rs.getString("GROUD");
           cmbground.setSelectedItem(ground);
           String price = rs.getString("NETPRICE");
           txtprice.setText(price);
           String meala = rs.getString("MEALCLASSA");
           txtmeala.setText(meala);
           String mealb = rs.getString("MEALCLASSB");
           txtmealb.setText(mealb);
           String convoyp = rs.getString("PRESIDENTIALCONVOY");
           txtconvoyp.setText(convoyp);
           String convoyh = rs.getString("HOTELCONVOY");
           txtconvoyh.setText(convoyh);
           String discount = rs.getString("DISCOUNT");
           txtdiscount.setText(discount);
           btnupdate.setEnabled(true);
           btndelete.setEnabled(true);
           btnsaveprice.setEnabled(false);
        
        }else{
        JOptionPane.showMessageDialog(null, "NO RECORD FOUND");
        txtprice.setText("");
       txtmeala.setText("");
       txtmealb.setText("");
       txtconvoyp.setText("");
       txtconvoyh.setText("");
       txtdiscount.setText("");
       
        }
        }catch(HeadlessException | SQLException ex){
        JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnsearchActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        try{
        conn = DriverManager.getConnection(url,username,password);
        st= conn.createStatement();
        String sqlupdate = "UPDATE tblweddingpricing set MEALCLASSA ='"+txtmeala.getText()+"',MEALCLASSB ='"+txtmealb.getText()+"',PRESIDENTIALCONVOY='"+txtconvoyp.getText()+"',"
                + "HOTELCONVOY='"+txtconvoyh.getText()+"',NETPRICE='"+txtprice.getText()+"',DISCOUNT='"+txtdiscount.getText()+"' WHERE GROUD = ?";
        pst=conn.prepareStatement(sqlupdate);
        pst.setString(1,(String)cmbground.getSelectedItem() );
        
         pst.executeUpdate();
        
        String updatedgroung = (String) cmbground.getSelectedItem();
        JOptionPane.showMessageDialog(null," "+updatedgroung+"  "+"GROUNDS UPDATED");
        
        btnupdate.setEnabled(false);
        btndelete.setEnabled(false);
         btnsaveprice.setEnabled(true);
        }catch(HeadlessException | SQLException ex){
        JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_btnupdateActionPerformed

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
            java.util.logging.Logger.getLogger(Wedding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Wedding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Wedding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Wedding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Wedding().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnnewiground;
    private javax.swing.JButton btnsaveprice;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton btnupdate;
    private javax.swing.JComboBox<String> cmbground;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtconvoyh;
    private javax.swing.JTextField txtconvoyp;
    private javax.swing.JTextField txtdiscount;
    private javax.swing.JTextField txtmeala;
    private javax.swing.JTextField txtmealb;
    private javax.swing.JTextField txtnewground;
    private javax.swing.JTextField txtprice;
    // End of variables declaration//GEN-END:variables
}