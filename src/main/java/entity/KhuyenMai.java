package entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "KhuyenMai")
@NamedQueries(
        @NamedQuery(name = "findAll", query = "Select km from KhuyenMai km")
)
public class KhuyenMai implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String maKhuyenMai;
    private String tenKhuyenMai;
    private double phanTram;
    private double gioiHan;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private Time thoiDiemBatDau;
    private Time thoiDiemKetThuc;

    @OneToMany(mappedBy = "khuyenMai", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<HoaDon> hoaDon;

    public KhuyenMai() {
    }

    public KhuyenMai(String maKhuyenMai, String tenKhuyenMai, double phanTram, double gioiHan, Date ngayBatDau,
                     Date ngayKetThuc, Time thoiDiemBatDau, Time thoiDiemKetThuc) {
        this.maKhuyenMai = maKhuyenMai;
        this.tenKhuyenMai = tenKhuyenMai;
        this.phanTram = phanTram;
        this.gioiHan = gioiHan;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.thoiDiemBatDau = thoiDiemBatDau;
        this.thoiDiemKetThuc = thoiDiemKetThuc;
    }

    public KhuyenMai(ResultSet rs) throws SQLException {
        this.maKhuyenMai = rs.getString("KhuyenMai_MaKhuyenMai");
        this.tenKhuyenMai = rs.getString("KhuyenMai_TenKhuyenMai");
        this.phanTram = rs.getDouble("KhuyenMai_PhanTram");
        this.gioiHan = rs.getDouble("KhuyenMai_GioiHan");
        this.ngayBatDau = rs.getDate("KhuyenMai_NgayBatDau");
        this.ngayKetThuc = rs.getDate("KhuyenMai_NgayKetThuc");
        this.thoiDiemBatDau = rs.getTime("KhuyenMai_ThoiDiemBatDau");
        this.thoiDiemKetThuc = rs.getTime("KhuyenMai_ThoiDiemKetThuc");
    }

    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public double getPhanTram() {
        return phanTram;
    }

    public void setPhanTram(double phanTram) {
        this.phanTram = phanTram;
    }

    public double getGioiHan() {
        return gioiHan;
    }

    public void setGioiHan(double gioiHan) {
        this.gioiHan = gioiHan;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Time getThoiDiemBatDau() {
        return thoiDiemBatDau;
    }

    public void setThoiDiemBatDau(Time thoiDiemBatDau) {
        this.thoiDiemBatDau = thoiDiemBatDau;
    }

    public Time getThoiDiemKetThuc() {
        return thoiDiemKetThuc;
    }

    public void setThoiDiemKetThuc(Time thoiDiemKetThuc) {
        this.thoiDiemKetThuc = thoiDiemKetThuc;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" +
                "maKhuyenMai='" + maKhuyenMai + '\'' +
                ", tenKhuyenMai='" + tenKhuyenMai + '\'' +
                ", phanTram=" + phanTram +
                ", gioiHan=" + gioiHan +
                ", ngayBatDau=" + ngayBatDau +
                ", ngayKetThuc=" + ngayKetThuc +
                ", thoiDiemBatDau=" + thoiDiemBatDau +
                ", thoiDiemKetThuc=" + thoiDiemKetThuc +
                ", hoaDon=" + hoaDon +
                '}';
    }
}