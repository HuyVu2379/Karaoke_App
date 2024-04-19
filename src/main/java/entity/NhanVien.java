package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import enums.TrangThaiNhanVien;
import jakarta.persistence.*;

@Entity
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    private String maNhanVien;
    @Column(unique = true, nullable = false)
    private String ten;
    @Column(unique = true, nullable = false)
    private String chucVu;
    @Column(unique = true, nullable = false)
    private String sdt;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true, nullable = false)
    private String diaChi;
    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private TrangThaiNhanVien trangThai;

    @OneToMany(mappedBy = "nhanVien", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<TaiKhoan> taiKhoan;

    @OneToMany(mappedBy = "nhanVien", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<HoaDon> hoaDon;

    public NhanVien() {
    }

    public NhanVien(String maNhanVien, String ten, String chucVu, String sdt, String email, String diaChi,
                    TrangThaiNhanVien trangThai) {
        this.maNhanVien = maNhanVien;
        this.ten = ten;
        this.chucVu = chucVu;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
    }

    public NhanVien(ResultSet rs) throws SQLException {
        this.maNhanVien = rs.getString("NhanVien_MaNhanVien");
        this.ten = rs.getString("NhanVien_Ten");
        this.chucVu = rs.getString("NhanVien_ChucVu");
        this.sdt = rs.getString("NhanVien_SDT");
        this.email = rs.getString("NhanVien_Email");
        this.diaChi = rs.getString("NhanVien_DiaChi");
        this.trangThai = TrangThaiNhanVien.values()[rs.getInt("NhanVien_TrangThai")];
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public TrangThaiNhanVien getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TrangThaiNhanVien trangThai) {
        this.trangThai = trangThai;
    }

    public Set<TaiKhoan> getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(Set<TaiKhoan> taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public Set<HoaDon> getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(Set<HoaDon> hoaDon) {
        this.hoaDon = hoaDon;
    }

    @Override
    public String toString() {
        return "NhanVien [maNhanVien=" + maNhanVien + ", ten=" + ten + ", chucVu=" + chucVu + ", sdt=" + sdt
                + ", email=" + email + ", diaChi=" + diaChi + ", trangThai=" + trangThai + "]";
    }
}
