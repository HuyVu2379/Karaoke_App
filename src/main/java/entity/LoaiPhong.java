package entity;

import enums.TrangThaiLoaiPhong;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "LoaiPhong")
public class LoaiPhong implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String maLoaiPhong;
	private String tenLoaiPhong;
	@Enumerated(EnumType.STRING)
	private TrangThaiLoaiPhong trangThai;

	@OneToMany(mappedBy = "loaiPhong", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Phong> phong;

	@OneToMany(mappedBy = "loaiPhong", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LichSuGiaPhong> lichSuGiaPhongList;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LoaiPhong loaiPhong = (LoaiPhong) o;
		return Objects.equals(maLoaiPhong, loaiPhong.maLoaiPhong);
	}

	@Override
	public int hashCode() {
		return Objects.hash(maLoaiPhong);
	}

	public LoaiPhong() {
	}

	public LoaiPhong(String maLoaiPhong, String tenLoaiPhong, TrangThaiLoaiPhong trangThai) {
		this.maLoaiPhong = maLoaiPhong;
		this.tenLoaiPhong = tenLoaiPhong;
		this.trangThai = trangThai;
	}

	public LoaiPhong(ResultSet rs) throws SQLException {
		this.maLoaiPhong = rs.getString("LoaiPhong_MaLoaiPhong");
		this.tenLoaiPhong = rs.getString("LoaiPhong_TenLoaiPhong");
		this.trangThai = TrangThaiLoaiPhong.values()[rs.getInt("LoaiPhong_TrangThai")];
		lichSuGiaPhongList = new ArrayList<>();
	}

	public LoaiPhong(String maLoaiPhong, String tenLoaiPhong, TrangThaiLoaiPhong trangThai, List<LichSuGiaPhong> lichSuGiaPhongList) {
		this.maLoaiPhong = maLoaiPhong;
		this.tenLoaiPhong = tenLoaiPhong;
		this.trangThai = trangThai;
		this.lichSuGiaPhongList = lichSuGiaPhongList;
	}

	public String getMaLoaiPhong() {
		return maLoaiPhong;
	}

	public void setMaLoaiPhong(String maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}

	public String getTenLoaiPhong() {
		return tenLoaiPhong;
	}

	public void setTenLoaiPhong(String tenLoaiPhong) {
		this.tenLoaiPhong = tenLoaiPhong;
	}

	public TrangThaiLoaiPhong getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(TrangThaiLoaiPhong trangThai) {
		this.trangThai = trangThai;
	}

	public List<LichSuGiaPhong> getLichSuGiaPhongList() {
		return lichSuGiaPhongList;
	}

	public void setLichSuGiaPhongList(List<LichSuGiaPhong> lichSuGiaPhongList) {
		this.lichSuGiaPhongList = lichSuGiaPhongList;
	}

	public double getGia(){
		int lichSuGiaPhongLastIndex=lichSuGiaPhongList.size() - 1;
		return lichSuGiaPhongList.get(lichSuGiaPhongLastIndex).getGia();
	}

	@Override
	public String toString() {
		return tenLoaiPhong;
	}
}
