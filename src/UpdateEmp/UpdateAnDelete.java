/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UpdateEmp;

import ConnectionClass.ConnectionClass;
import static ConnectionClass.ConnectionClass.entityManager;
import ConnectionClass.Nhanvien;
import EmployeeDisplay.Display;
import FindEmp.FindEmployee;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author msinp
 */
public class UpdateAnDelete extends javax.swing.JPanel {

    /**
     * Creates new form UpdateAnDelete
     */
   public static FindEmployee dpDisplay=null;
    public UpdateAnDelete() {
        initComponents();
        dpDisplay=new FindEmployee();
        backPanel.add(dpDisplay);
        dpDisplay.setVisible(true);
        dpDisplay.setSize(1395,675);
        dpDisplay.dpDisplay.updateForm=true;
    }
public void deleteNhanVienById( int id) {
    // Tìm nhân viên dựa trên ID
    Nhanvien nhanVien = entityManager.find(Nhanvien.class, id);
    
    // Kiểm tra xem nhân viên có tồn tại hay không
    if (nhanVien != null) {
        // Bắt đầu một giao dịch
        entityManager.getTransaction().begin();

        // Xóa nhân viên
        entityManager.remove(nhanVien);

        // Commit giao dịch
        entityManager.getTransaction().commit();

      JOptionPane.showMessageDialog(null, "Thao tác thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
      dpDisplay.dpDisplay.displayNhanvienData();
    } else {
        JOptionPane.showMessageDialog(null, "Lỗi, xin thử lại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backPanel = new javax.swing.JPanel();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        javax.swing.GroupLayout backPanelLayout = new javax.swing.GroupLayout(backPanel);
        backPanel.setLayout(backPanelLayout);
        backPanelLayout.setHorizontalGroup(
            backPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        backPanelLayout.setVerticalGroup(
            backPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
        );

        updateButton.setText("Sửa");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Xóa");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 455, Short.MAX_VALUE)
                        .addComponent(deleteButton)
                        .addGap(65, 65, 65))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(deleteButton))
                .addGap(18, 18, 18)
                .addComponent(backPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
       UpdateForm updateForm = null;
        try {
            updateForm = new UpdateForm(dpDisplay.dpDisplay.selectedNhanvien.getId());
        } catch (IOException ex) {
            Logger.getLogger(UpdateAnDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateForm.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        deleteNhanVienById(dpDisplay.dpDisplay.selectedNhanvien.getId());        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backPanel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
