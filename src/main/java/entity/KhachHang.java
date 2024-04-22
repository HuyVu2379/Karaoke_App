package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "KhachHang")
public class KhachHang {
    @Id
    private String maKhachHang;
    private String tenKhachHang;
    private String sdt;

    @OneToMany(mappedBy = "khachHang")
    private List<HoaDon> hoaDon;


    public KhachHang() {
    }

    public KhachHang(String maKhachHang, String tenKhachHang, String sdt) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.sdt = sdt;
    }

    public KhachHang(ResultSet rs) throws SQLException {
        this.maKhachHang = rs.getString("KhachHang_MaKhachHang");
        this.tenKhachHang = rs.getString("KhachHang_TenKhachHang");
        this.sdt = rs.getString("KhachHang_SDT");
    }


    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public List<HoaDon> getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(List<HoaDon> hoaDon) {
        this.hoaDon = hoaDon;
    }
}