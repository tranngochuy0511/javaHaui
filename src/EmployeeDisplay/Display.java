/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package EmployeeDisplay;

import static ConnectionClass.ConnectionClass.entityManager;
import ConnectionClass.Nhanvien;
import SalarySlips.ExportForm;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author msinp
 */
public class Display extends javax.swing.JPanel {

    /**
     * Creates new form Display
     */
   public static boolean updateForm=false;
   public static boolean findForm=false;
    public static boolean salaryForm=false;

    public Display() {
        initComponents();
        try {
            displayNhanvienData();
            setupTableSelectionListener();
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
   static public void reset(){
        updateForm=false;
        findForm=false;
        salaryForm=false;
    }
  public void displayNhanvienData() {
        try {
            // Tạo model cho JTable
            Query query = entityManager.createQuery("SELECT n FROM Nhanvien n");
            List<Nhanvien> nhanVienList = query.getResultList();
            // Tạo EntityManager
            updateTableData(nhanVienList);
            // Đặt model cho JTable
        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý lỗi tại đây
        }
    }
  public void searchEmployees(JTextField searchField) {
    String searchKeyword = searchField.getText().trim();
    Query query = entityManager.createQuery("SELECT n FROM Nhanvien n WHERE n.name LIKE :keyword");
    query.setParameter("keyword", "%" + searchKeyword + "%");
    List<Nhanvien> nhanVienList = query.getResultList();
    updateTableData(nhanVienList);
}

private void updateTableData(List<Nhanvien> nhanVienList) {
        try {
            DefaultTableModel model = (DefaultTableModel) hienThiTable.getModel();

            model.setRowCount(0); // Xóa toàn bộ dữ liệu hiện tại trên bảng

            for (Nhanvien nhanVien : nhanVienList) {
                // Thêm dữ liệu của nhân viên vào bảng
                model.addRow(new Object[]{
                    nhanVien.getId(),
                    nhanVien.getName(),
                    nhanVien.getDepartmentid().getName(),
                    nhanVien.getPhone(),
                    nhanVien.getEmail(),
                    nhanVien.getAddress(),
                    nhanVien.getDob1(),
                    nhanVien.getGender() ? "Nam" : "Nữ",
                    nhanVien.getSalary(),
                    nhanVien.getStartDate1(),
                    nhanVien.getPostid().getName()
                    // Các cột khác tương ứng với dữ liệu cần hiển thị
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Không thể truy vấn!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            // Xử lý lỗi tại đây
        }
    }
public Nhanvien selectedNhanvien=null;
private void setupTableSelectionListener() {
        hienThiTable.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            try {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = hienThiTable.getSelectedRow();
                    if (selectedRow != -1) {
                        Object selectedValue = hienThiTable.getValueAt(selectedRow, 0);
                        Query query = entityManager.createQuery("SELECT n FROM Nhanvien n WHERE n.id= :id");
                        query.setParameter("id", (int) selectedValue);
                        Nhanvien nvList = (Nhanvien) query.getSingleResult();
                        this.selectedNhanvien = nvList;
                        //System.err.println(selectedNhanvien.getId());
                        openAnotherForm(selectedValue.toString());
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                // Xử lý lỗi tại đây
            }
        });
    }


private void openAnotherForm(String data) {
   try {
            if (salaryForm) {
                // Thực hiện xử lý dữ liệu và mở form khác
                ExportForm form = new ExportForm(data);
                form.setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý lỗi tại đây
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        hienThiTable = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Thông tin nhân viên");

        hienThiTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên", "Phòng ban", "Số điện thoại", "Email", "Địa chỉ", "Ngày sinh", "Giới tính", "Lương", "Ngày bắt đầu", "Vị trí"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(hienThiTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable hienThiTable;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
