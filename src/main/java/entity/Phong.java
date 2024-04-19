package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import enums.TrangThaiPhong;
import jakarta.persistence.*;

@Entity
@Table(name = "Phong")
public class Phong {
    @Id
    private String maPhong;
    private String tenPhong;
    private int sucChua;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maLoaiPhong")
    private LoaiPhong loaiPhong;
    @Enumerated(EnumType.STRING)
    private TrangThaiPhong trangThai;

    @OneToMany(mappedBy = "phong", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PhieuDatPhong> phieuDatPhong;

    public Phong() {
    }


    public Phong(String maPhong, LoaiPhong loaiPhong, String tenPhong, int sucChua, TrangThaiPhong trangThai) {
        this.maPhong = maPhong;
        this.loaiPhong = loaiPhong;
        this.tenPhong = tenPhong;
        this.sucChua = sucChua;
        this.trangThai = trangThai;
    }

    public Phong(ResultSet rs) throws SQLException {
        this.maPhong = rs.getString("Phong_MaPhong");
        this.loaiPhong = new LoaiPhong(rs);
        this.tenPhong = rs.getString("Phong_TenPhong");
        this.sucChua = rs.getInt("Phong_SucChua");
        this.trangThai = TrangThaiPhong.values()[rs.getInt("Phong_TrangThai")];
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public LoaiPhong getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(LoaiPhong loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    public TrangThaiPhong getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TrangThaiPhong trangThai) {
        this.trangThai = trangThai;
    }


    public Set<PhieuDatPhong> getPhieuDatPhong() {
        return phieuDatPhong;
    }

    public void setPhieuDatPhong(Set<PhieuDatPhong> phieuDatPhong) {
        this.phieuDatPhong = phieuDatPhong;
    }
}