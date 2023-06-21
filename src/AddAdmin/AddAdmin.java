/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author msinp
 */
package AddAdmin;
        
import ConnectionClass.Account;
import ConnectionClass.ConnectionClass;
import static ConnectionClass.ConnectionClass.entityManager;
import java.util.Arrays;
import javax.swing.JOptionPane;
import thegioidochoi.login.LoginHandling;

public class AddAdmin extends javax.swing.JPanel {

    /**
     * Creates new form AddAdmin
     */
    public AddAdmin() {
    try {
        initComponents();
    } catch (Exception e) {
        // Xử lý lỗi khi khởi tạo giao diện
        e.printStackTrace();
    }
}

public void insert() {
    try {
        Account sAccount = acc();
        if (sAccount != null) {
            entityManager.getTransaction().begin();
            entityManager.persist(acc());
            entityManager.getTransaction().commit();
            LoginHandling.load();
            JOptionPane.showMessageDialog(null, "Thao tác thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (Exception e) {
        // Xử lý lỗi khi thực hiện thêm dữ liệu
        e.printStackTrace();
        entityManager.getTransaction().rollback();
        JOptionPane.showMessageDialog(null, "Thao tác thất bại: " + e.getMessage(), "Thông báo", JOptionPane.ERROR_MESSAGE);
    }
}

Account acc() {
    try {
        Account ac1 = new Account();
        ac1.setUsername(usernameTextField1.getText());
        if (isEqual(PasswordField.getPassword(), rePasswordField.getPassword())) {
            ac1.setPassword(rePasswordField.getPassword());
            return ac1;
        }
    } catch (Exception e) {
        // Xử lý lỗi khi truy cập dữ liệu nhập vào
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage(), "Thông báo", JOptionPane.ERROR_MESSAGE);
    }
    return null;
}

public static boolean isEqual(char[] password1, char[] password2) {
    try {
        if (password1.length != password2.length) {
            return false;
        }

        for (int i = 0; i < password1.length; i++) {
            if (password1[i] != password2[i]) {
                return false;
            }
        }
        return true;
    } catch (Exception e) {
        // Xử lý lỗi khi so sánh mật khẩu
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage(), "Thông báo", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked");
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        usernameTextField1 = new javax.swing.JTextField();
        PasswordField = new javax.swing.JPasswordField();
        rePasswordField = new javax.swing.JPasswordField();
        confirmButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Thêm tài khoản admin");

        jLabel2.setText("Tài khoản");

        jLabel3.setText("Mật khẩu");

        jLabel4.setText("Nhập lại mật khẩu");

        confirmButton1.setText("Xác nhận");
        confirmButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(170, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(165, 165, 165))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernameTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(PasswordField)
                            .addComponent(rePasswordField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(confirmButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(usernameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rePasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(confirmButton1)
                .addContainerGap(81, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void confirmButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButton1ActionPerformed
        insert();        // TODO add your handling code here:
    }//GEN-LAST:event_confirmButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JButton confirmButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField rePasswordField;
    private javax.swing.JTextField usernameTextField1;
    // End of variables declaration//GEN-END:variables
}
