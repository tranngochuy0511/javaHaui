/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectionClass;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author msinp
 */
@Entity
@Table(name = "nhanvien")
@NamedQueries({
    @NamedQuery(name = "Nhanvien.findAll", query = "SELECT n FROM Nhanvien n"),
    @NamedQuery(name = "Nhanvien.findById", query = "SELECT n FROM Nhanvien n WHERE n.id = :id"),
    @NamedQuery(name = "Nhanvien.findByName", query = "SELECT n FROM Nhanvien n WHERE n.name = :name"),
    @NamedQuery(name = "Nhanvien.findByPhone", query = "SELECT n FROM Nhanvien n WHERE n.phone = :phone"),
    @NamedQuery(name = "Nhanvien.findByEmail", query = "SELECT n FROM Nhanvien n WHERE n.email = :email"),
    @NamedQuery(name = "Nhanvien.findByAddress", query = "SELECT n FROM Nhanvien n WHERE n.address = :address"),
    @NamedQuery(name = "Nhanvien.findByDob", query = "SELECT n FROM Nhanvien n WHERE n.dob = :dob"),
    @NamedQuery(name = "Nhanvien.findByGender", query = "SELECT n FROM Nhanvien n WHERE n.gender = :gender"),
    @NamedQuery(name = "Nhanvien.findBySalary", query = "SELECT n FROM Nhanvien n WHERE n.salary = :salary"),
    @NamedQuery(name = "Nhanvien.findByStartDate", query = "SELECT n FROM Nhanvien n WHERE n.startDate = :startDate")})
public class Nhanvien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name = "gender")
    private Boolean gender;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salary")
    private Double salary;
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @JoinColumn(name = "departmentid", referencedColumnName = "departmentID")
    @ManyToOne(optional = false)
    private Department departmentid;
    @JoinColumn(name = "postid", referencedColumnName = "postId")
    @ManyToOne
    private Positions postid;

    public Nhanvien() {
    }

    public Nhanvien(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getStartDate() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    try {
        String startDateString = dateFormat.format(startDate);
        return dateFormat.parse(startDateString);
    } catch (ParseException e) {
        return null;
    }
}

public String getStartDate1() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    String startDateString = dateFormat.format(startDate);
    return startDateString;
}

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Department getDepartmentid() {
        return departmentid;
    }
   

    public void setDepartmentid(Department departmentid) {
        this.departmentid = departmentid;
    }

    public Positions getPostid() {
        return postid;
    }

    public void setPostid(Positions postid) {
        this.postid = postid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nhanvien)) {
            return false;
        }
        Nhanvien other = (Nhanvien) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConnectionClass.Nhanvien[ id=" + id + " ]";
    }
    
}
