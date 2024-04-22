package entity;

import enums.TrangThaiTaiKhoan;
import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String maTaiKhoan;
    @Column(unique = true, nullable = false)
    private String tenTaiKhoan;
    private String matKhau;
    @Enumerated(EnumType.STRING)
    private TrangThaiTaiKhoan trangThai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maNhanVien")
    private NhanVien nhanVien;

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public TrangThaiTaiKhoan getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TrangThaiTaiKhoan trangThai) {
        this.trangThai = trangThai;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public TaiKhoan(String maTaiKhoan, String tenTaiKhoan, String matKhau, TrangThaiTaiKhoan trangThai) {
        this.maTaiKhoan = maTaiKhoan;
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
    }

    public TaiKhoan() {
    }

    @Override
    public String toString() {
        return "TaiKhoan{" +
                "maTaiKhoan='" + maTaiKhoan + '\'' +
                ", tenTaiKhoan='" + tenTaiKhoan + '\'' +
                ", matKhau='" + matKhau + '\'' +
                ", trangThai=" + trangThai +
                ", nhanVien=" + nhanVien +
                '}';
    }
}