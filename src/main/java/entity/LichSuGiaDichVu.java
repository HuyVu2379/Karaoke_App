package entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

@Entity
@Table(name = "LichSuGiaDichVu")
public class LichSuGiaDichVu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String maLichSuGiaDichVu;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private Time thoiDiemBatDau;
    private Time thoiDiemKetThuc;
    private Double gia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maDichVu")
    private DichVu dichVu;

    public DichVu getDichVu() {
        return dichVu;
    }

    public void setDichVu(DichVu dichVu) {
        this.dichVu = dichVu;
    }

    public LichSuGiaDichVu() {
    }

    public LichSuGiaDichVu(String maLichSuGiaDichVu, Date ngayBatDau, Date ngayKetThuc, Time thoiDiemBatDau,
                           Time thoiDiemKetThuc, Double gia) {
        this.maLichSuGiaDichVu = maLichSuGiaDichVu;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.thoiDiemBatDau = thoiDiemBatDau;
        this.thoiDiemKetThuc = thoiDiemKetThuc;
        this.gia = gia;
    }

    public LichSuGiaDichVu(ResultSet rs) throws SQLException {
        this.maLichSuGiaDichVu = rs.getString("LichSuGiaDichVu_MaLichSuGiaDichVu");
        this.ngayBatDau = rs.getDate("LichSuGiaDichVu_NgayBatDau");
        this.ngayKetThuc = rs.getDate("LichSuGiaDichVu_NgayKetThuc");
        this.thoiDiemBatDau = rs.getTime("LichSuGiaDichVu_ThoiDiemBatDau");
        this.thoiDiemKetThuc = rs.getTime("LichSuGiaDichVu_ThoiDiemKetThuc");
        this.gia = rs.getDouble("LichSuGiaDichVu_Gia");
    }

    public String getMaLichSuGiaDichVu() {
        return maLichSuGiaDichVu;
    }

    public void setMaLichSuGiaDichVu(String maLichSuGiaDichVu) {
        this.maLichSuGiaDichVu = maLichSuGiaDichVu;
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

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

}