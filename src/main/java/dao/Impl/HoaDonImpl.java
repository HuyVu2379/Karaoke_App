package dao.Impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.HoaDonDAO;
import entity.HoaDon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class HoaDonImpl implements HoaDonDAO {
	private EntityManager em;
	EntityTransaction tx;

	public HoaDonImpl() {
		em = Persistence.createEntityManagerFactory("ssql").createEntityManager();
	}
	@Override
	public List<HoaDon> getAllHoaDon() throws RemoteException {
		String query = "Select hd from HoaDon hd";
		List<HoaDon> listHd = new ArrayList<HoaDon>();
		listHd = em.createQuery(query).getResultList();
		return listHd;
	}
	@Override
	public List<HoaDon> getHoaDonPaged(int page, int pageSize) throws RemoteException {
		String query = "Select hd from HoaDon hd";
		List<HoaDon> listHd = new ArrayList<HoaDon>();
		listHd = em.createQuery(query).setFirstResult(page).setMaxResults(pageSize).getResultList();
		return listHd;
	}
	@Override
	public List<HoaDon> getHoaDonPagedByMaHoaDon(int page, int pageSize, String maHd) throws RemoteException {
		String query = "Select hd from HoaDon hd where hd.maHoaDon = :maHd";
		List<HoaDon> listHd = new ArrayList<HoaDon>();
		listHd = em.createQuery(query).setParameter("maHd", maHd).setFirstResult(page).setMaxResults(pageSize)
				.getResultList();
		return listHd;
	}
	@Override
	public List<HoaDon> getHoaDonPagedByTenKhachHang(int page, int pageSize, String tenKh) throws RemoteException {
		String query = "Select hd from HoaDon hd where hd.khachHang.tenKhachHang = :tenKh";
		List<HoaDon> listHd = new ArrayList<HoaDon>();
		listHd = em.createQuery(query).setParameter("tenKh", tenKh).setFirstResult(page).setMaxResults(pageSize)
				.getResultList();
		return listHd;
	}
	@Override
	public List<HoaDon> getHoaDonPagedByDateRange(int page, int pageSize, Date ngayBatDau, Date ngayKetThuc) throws	RemoteException {
	
		String query = "Select hd from HoaDon hd where hd.NgayThanhToan between :ngayBatDau and :ngayKetThuc";
		List<HoaDon> listHd = new ArrayList<HoaDon>();
		listHd = em.createQuery(query).setParameter("ngayBatDau", ngayBatDau).setParameter("ngayKetThuc", ngayKetThuc)
				.setFirstResult(page).setMaxResults(pageSize).getResultList();
		return listHd;
	}
	@Override
	public HoaDon getHoaDonByMaPhong(String maPhong) throws RemoteException {
		String query = "Select hd from HoaDon hd where hd.phong.maPhong = :maPhong";
		HoaDon hd = (HoaDon) em.createQuery(query).setParameter("maPhong", maPhong).getSingleResult();
		return hd;
	}
	@Override
	public HoaDon getHoaDonByMaHoaDon(String maHd) throws RemoteException {
		String query = "Select hd from HoaDon hd where hd.maHoaDon = :maHd";
		HoaDon hd = (HoaDon) em.createQuery(query).setParameter("maHd", maHd).getSingleResult();
		return hd;
	}
	
}
