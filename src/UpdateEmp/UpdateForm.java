/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UpdateEmp;

import static ConnectionClass.ConnectionClass.entityManager;
import ConnectionClass.Department;
import ConnectionClass.Nhanvien;
import ConnectionClass.Positions;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.persistence.Query;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author msinp
 */
public class UpdateForm extends javax.swing.JFrame {

    /**
     * Creates new form UpdateForm
     */
    Nhanvien nvNhanvien=null;
    public UpdateForm() throws IOException {
        initComponents();
        load();
    }
    public UpdateForm(int id) throws IOException {
        Query query=entityManager.createQuery("SELECT n FROM Nhanvien n WHERE n.id = :id");
        query.setParameter("id", id);
        nvNhanvien=(Nhanvien) query.getSingleResult();
        initComponents();
        load();
        departmentComboBox1.setSelectedItem(nvNhanvien.getDepartmentid().getName());
                postComboBox.setSelectedItem(nvNhanvien.getPostid().getName());

    }
    public void load() throws IOException{
        IDLabel.setText(String.valueOf(nvNhanvien.getId()));
        DefaultComboBoxModel<String> postModel = new DefaultComboBoxModel<>();
        Query query = entityManager.createQuery("SELECT p.name FROM Positions p");
        List<String> positions = query.getResultList();
        for (String position : positions) {
        postModel.addElement(position);
}
postComboBox.setModel(postModel);
DefaultComboBoxModel<String> departModel=new DefaultComboBoxModel<>();
Query query1=entityManager.createQuery("SELECT d.name FROM Department d");
List<String> departmentList= query1.getResultList();
    for (String position : departmentList) {
        departModel.addElement(position);
}
    departmentComboBox1.setModel(departModel);
    //
    nameField.setText(nvNhanvien.getName());
    emailField.setText(nvNhanvien.getEmail());
    phoneField.setText(nvNhanvien.getPhone());
    addressField.setText(nvNhanvien.getAddress());
    dobDateChooser.setDate(nvNhanvien.getDob());
    if(nvNhanvien.getGender()){
        maleRadioButton.setSelected(true);
    }
    else{
        femaleRadioButton.setSelected(true);
    }
    salaryField.setText(String.valueOf(nvNhanvien.getSalary()));
    startdateDateChooser.setDate(nvNhanvien.getStartDate());
    // Tạo một đối tượng ImageIcon từ hình ảnh
// Chuyển đổi mảng byte thành đối tượng Image
// Chuyển đổi mảng byte thành đối tượng Image
if(nvNhanvien.getImage()!=null){
ByteArrayInputStream inputStream = new ByteArrayInputStream(nvNhanvien.getImage());
Image image = ImageIO.read(inputStream);

// Thiết lập kích thước mong muốn
int desiredWidth = 291; // Kích thước chiều rộng mong muốn
int desiredHeight = 234; // Kích thước chiều cao mong muốn
Image scaledImage = image.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);

// Tạo một đối tượng ImageIcon từ đối tượng Image đã được thay đổi kích thước
ImageIcon imageIcon = new ImageIcon(scaledImage);

// Đặt biểu tượng hình ảnh cho nhãn
pictureLabel.setIcon(imageIcon);

}
else{
   String imagePath = "C:/Users/msinp/Downloads/HR-Management-System-in-Java-using-swing-framework/src/gamemarkstudio/images/blank-profile-head-hi.png";
File file = new File(imagePath);
URI uri = file.toURI();
ImageIcon imageIcon = new ImageIcon(uri.toURL());
pictureLabel.setIcon(imageIcon);

    }
    }
  public Department phongBanSet(String pb){
        Query query = entityManager.createQuery("SELECT a FROM Department a");
      List<Department> dpList =  query.getResultList();
    for(Department dpDepartment : dpList){
    if(pb.equals(dpDepartment.getName()))
        return dpDepartment;
}
        return null;}
public Positions vitriSet(String pb){
        Query query = entityManager.createQuery("SELECT a FROM Positions a");
      List<Positions> dpList =  query.getResultList();
    for(Positions dpDepartment : dpList){
    if(pb.equals(dpDepartment.getName()))
        return dpDepartment;
}
return null;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IDLabel = new javax.swing.JLabel();
        salaryLabel = new javax.swing.JLabel();
        salaryField = new javax.swing.JTextField();
        startdateLabel = new javax.swing.JLabel();
        positionLabel = new javax.swing.JLabel();
        browseButton = new javax.swing.JButton();
        pictureLabel = new javax.swing.JLabel();
        departmentComboBox1 = new javax.swing.JComboBox<>();
        postComboBox = new javax.swing.JComboBox<>();
        maleRadioButton = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        femaleRadioButton = new javax.swing.JRadioButton();
        nameLabel = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        departmentLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        phoneField = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        dobLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        dobDateChooser = new com.toedter.calendar.JDateChooser();
        startdateDateChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        IDLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        IDLabel.setText("jLabel8");

        salaryLabel.setText("Lương");

        startdateLabel.setText("Ngày bắt đầu làm việc");

        positionLabel.setText("Vị trí làm việc");

        browseButton.setText("Duyệt");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        pictureLabel.setText("jLabel2");

        departmentComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        postComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        maleRadioButton.setText("Nam");
        maleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRadioButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        femaleRadioButton.setText("Nữ");
        femaleRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                femaleRadioButtonStateChanged(evt);
            }
        });
        femaleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRadioButtonActionPerformed(evt);
            }
        });

        nameLabel.setText("Tên");

        SaveButton.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        SaveButton.setForeground(new java.awt.Color(0, 153, 0));
        SaveButton.setText("Lưu");
        SaveButton.setActionCommand("save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        emailLabel.setText("Email");

        departmentLabel.setText("Phòng ban");

        phoneLabel.setText("Số điện thoại");

        addressLabel.setText("Địa chỉ");

        dobLabel.setText("Ngày sinh");

        genderLabel.setText("Giới tính");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(positionLabel)
                    .addComponent(startdateLabel)
                    .addComponent(genderLabel)
                    .addComponent(dobLabel)
                    .addComponent(addressLabel)
                    .addComponent(phoneLabel)
                    .addComponent(emailLabel)
                    .addComponent(jLabel1)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(startdateDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(dobDateChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emailField, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(departmentComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(phoneField)
                            .addComponent(addressField)
                            .addComponent(salaryField)
                            .addComponent(postComboBox, 0, 160, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(maleRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(femaleRadioButton)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(49, 49, 49)
                            .addComponent(IDLabel))))
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(176, 176, 176))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(browseButton)
                        .addGap(254, 254, 254))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(54, 54, 54)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(departmentLabel)
                        .addComponent(salaryLabel))
                    .addContainerGap(791, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(pictureLabel)
                        .addGap(49, 49, 49)
                        .addComponent(browseButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IDLabel)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLabel))
                        .addGap(18, 18, 18)
                        .addComponent(departmentComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailLabel))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dobDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(maleRadioButton)
                                    .addComponent(femaleRadioButton)
                                    .addComponent(genderLabel))
                                .addGap(12, 12, 12)
                                .addComponent(salaryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(startdateDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(postComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(positionLabel)))
                                    .addComponent(startdateLabel)))
                            .addComponent(dobLabel))))
                .addGap(18, 18, 18)
                .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(143, 143, 143)
                    .addComponent(departmentLabel)
                    .addGap(140, 140, 140)
                    .addComponent(salaryLabel)
                    .addContainerGap(335, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
byte[] imageBytes;
    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        browseButton.addActionListener((ActionEvent e) -> {
            JFileChooser fileChooser1 = new JFileChooser();
            int result = fileChooser1.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser1.getSelectedFile();
                // Đọc hình ảnh từ tệp được chọn
                ImageIcon originalImageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                // Thay đổi kích thước của hình ảnh để phù hợp với pictureLabel
                Image originalImage = originalImageIcon.getImage();
                Image scaledImage = originalImage.getScaledInstance(291, 234, Image.SCALE_SMOOTH);
                ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
                // Hiển thị hình ảnh đã được thay đổi kích thước trên pictureLabel
                pictureLabel.setIcon(scaledImageIcon);

                // Kiểm tra xem liệu người dùng đã chọn tệp hình ảnh từ JFileChooser hay không
                if (fileChooser1.getSelectedFile() != null) {
                    // Lấy đường dẫn tệp hình ảnh
                    String imagePath = fileChooser1.getSelectedFile().getAbsolutePath();

                    // Đọc dữ liệu hình ảnh từ tệp và lưu vào mảng byte[]
                    try {
                        Path path = Paths.get(imagePath);
                        imageBytes = Files.readAllBytes(path);
                    } catch (IOException x) {
                        x.printStackTrace();
                    }
                } else {
                    // Lấy dữ liệu hình ảnh từ JLabel
                    Icon icon = pictureLabel.getIcon();
                    if (icon instanceof ImageIcon) {
                        Image image = ((ImageIcon) icon).getImage();
                        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
                        Graphics2D g2d = bufferedImage.createGraphics();
                        g2d.drawImage(image, 0, 0, null);
                        g2d.dispose();

                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        try {
                            ImageIO.write(bufferedImage, "jpg", baos);
                            imageBytes = baos.toByteArray();
                        } catch (IOException z) {
                            z.printStackTrace();
                        }
                    }
                }
            }
        });
    }//GEN-LAST:event_browseButtonActionPerformed

    private void maleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRadioButtonActionPerformed
        femaleRadioButton.setSelected(false);        // TODO add your handling code here:
    }//GEN-LAST:event_maleRadioButtonActionPerformed

    private void femaleRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_femaleRadioButtonStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_femaleRadioButtonStateChanged

    private void femaleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRadioButtonActionPerformed
        maleRadioButton.setSelected(false);    // TODO add your handling code here:
    }//GEN-LAST:event_femaleRadioButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
if(addressField.getText().isEmpty()||phoneField.getText().isEmpty()||emailField.getText().isEmpty()|| nameField.getText().isEmpty()|| IDLabel.getText().isEmpty()
        ||dobDateChooser.getDate()==null||salaryField.getText().isEmpty()||startdateDateChooser.getDate()==null){
     JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
                       return;
}
if(!maleRadioButton.isSelected() && !femaleRadioButton.isSelected()){
    JOptionPane.showMessageDialog(null, "Vui lòng chọn giới tính!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    return;
}
if (dobDateChooser.getDate().after(startdateDateChooser.getDate())) {
    JOptionPane.showMessageDialog(null, "Ngày sinh phải nhỏ hơn ngày làm việc!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    return;
}
// bắt lỗi tên không hợp lệ 
String str = nameField.getText();
for (int i = 0; i < str.length(); i++) {
    if (!Character.isLetter(str.charAt(i))) {
        JOptionPane.showMessageDialog(null, "Trong tên không được có số ", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }
}
// bắt lỗi ngày tháng
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
dateFormat.setLenient(false);
try{
 Date dob =dobDateChooser.getDate();
 Date std =startdateDateChooser.getDate();
  dateFormat.parse(dateFormat.format(dob));
  dateFormat.parse(dateFormat.format(std));
     // Kiểm tra ngày sinh không được lớn hơn ngày hiện tại
            Calendar currentDate = Calendar.getInstance();
            Calendar dobCalendar = Calendar.getInstance();
            dobCalendar.setTime(dob);
            Calendar stdCalendar = Calendar.getInstance();
            stdCalendar.setTime(std);
            if (dobCalendar.after(currentDate)|| stdCalendar.after(currentDate)) {
                JOptionPane.showMessageDialog(null, "Ngày sinh hoặc ngày làm việc không được lớn hơn ngày hiện tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
          // Kiểm tra start date không được nhỏ hơn ngày sinh và ít nhất là 18 năm sau ngày sinh
Calendar minDob = Calendar.getInstance();
minDob.setTime(dob);
minDob.add(Calendar.YEAR, 18);
if (stdCalendar.before(minDob)) {
    JOptionPane.showMessageDialog(null, "Ngày s việc phải lớn hơn hoặc bằng ngày sinh và ít nhất là 18 năm sau ngày sinh", "Lỗi", JOptionPane.ERROR_MESSAGE);
    return;
}
 }
catch(Exception e){
 JOptionPane.showMessageDialog(null, "Ngày tháng không hợp lệ. Vui lòng kiểm tra định dạng dd/MM/yyyy");
}
// bắt lỗi số điện thoại
     String sdtString =phoneField.getText();
     String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
     if (!sdtString.matches(reg)) {
        JOptionPane.showMessageDialog(null,"số điện thoại sai định dạng");
        return;
     }
//bắt lỗi email
String emailString=emailField.getText();
String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
if(!emailString.matches(emailRegex)){
     JOptionPane.showMessageDialog(null,"Email sai định dạng");
     return;
}
        // Lấy hình ảnh từ JButton hoặc JLabel
        // Tạo một mảng byte[] để lưu dữ liệu hình ảnh
        try{

            Nhanvien nhanvien = new Nhanvien();
            nhanvien.setId(Integer.parseInt(IDLabel.getText()));
            nhanvien.setName(nameField.getText());
            nhanvien.setPhone(phoneField.getText());
            nhanvien.setEmail(emailField.getText());
            nhanvien.setAddress(addressField.getText());
            nhanvien.setDob(dobDateChooser.getDate());
            nhanvien.setSalary(Double.valueOf(salaryField.getText()));
            nhanvien.setGender(maleRadioButton.isSelected());
            nhanvien.setStartDate(startdateDateChooser.getDate());
            nhanvien.setDepartmentid(phongBanSet(departmentComboBox1.getSelectedItem().toString()));
            nhanvien.setPostid(vitriSet(postComboBox.getSelectedItem().toString()));
            nhanvien.setImage(imageBytes);
            entityManager.getTransaction().begin();

            // Thực hiện insert thông tin vào bảng nhanvien
            entityManager.merge(nhanvien);

            // Commit transaction
            entityManager.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Thao tác thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        // Đóng EntityManager
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
UpdateAnDelete.dpDisplay.dpDisplay.displayNhanvienData();     // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(UpdateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new UpdateForm().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(UpdateForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel IDLabel;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField addressField;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JButton browseButton;
    private javax.swing.JComboBox<String> departmentComboBox1;
    private javax.swing.JLabel departmentLabel;
    private com.toedter.calendar.JDateChooser dobDateChooser;
    private javax.swing.JLabel dobLabel;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JRadioButton femaleRadioButton;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton maleRadioButton;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField phoneField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel pictureLabel;
    private javax.swing.JLabel positionLabel;
    private javax.swing.JComboBox<String> postComboBox;
    private javax.swing.JTextField salaryField;
    private javax.swing.JLabel salaryLabel;
    private com.toedter.calendar.JDateChooser startdateDateChooser;
    private javax.swing.JLabel startdateLabel;
    // End of variables declaration//GEN-END:variables
}
