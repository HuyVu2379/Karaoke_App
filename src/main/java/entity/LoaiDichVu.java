package entity;

import enums.TrangThaiLoaiDichVu;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

@Entity
@Table(name = "LoaiDichVu")
public class LoaiDichVu {
    @Id
    private String maLoaiDichVu;
    private String tenLoaiDichVu;
    private TrangThaiLoaiDichVu trangThai;

    @OneToMany(mappedBy = "loaiDichVu")
    private Set<DichVu> dichVu;

    public Set<DichVu> getDichVu() {
        return dichVu;
    }

    public void setDichVu(Set<DichVu> dichVu) {
        this.dichVu = dichVu;
    }

    public LoaiDichVu() {
    }

    public LoaiDichVu(String maLoaiDichVu, String tenLoaiDichVu, TrangThaiLoaiDichVu trangThai) {
        this.maLoaiDichVu = maLoaiDichVu;
        this.tenLoaiDichVu = tenLoaiDichVu;
        this.trangThai = trangThai;
    }

    public LoaiDichVu(ResultSet rs) throws SQLException {
        this.maLoaiDichVu = rs.getString("LoaiDichVu_MaLoaiDichVu");
        this.tenLoaiDichVu = rs.getString("LoaiDichVu_TenLoaiDichVu");
        this.trangThai = TrangThaiLoaiDichVu.values()[rs.getInt("LoaiDichVu_TrangThai")];
    }

    public String getMaLoaiDichVu() {
        return maLoaiDichVu;
    }

    public void setMaLoaiDichVu(String maLoaiDichVu) {
        this.maLoaiDichVu = maLoaiDichVu;
    }

    public String getTenLoaiDichVu() {
        return tenLoaiDichVu;
    }

    public void setTenLoaiDichVu(String tenLoaiDichVu) {
        this.tenLoaiDichVu = tenLoaiDichVu;
    }

    public TrangThaiLoaiDichVu getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TrangThaiLoaiDichVu trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return tenLoaiDichVu;
    }
}
