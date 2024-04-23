package dao.Impl;

import java.util.ArrayList;
import java.util.List;

import dao.ChiTietDatDichVuDAO;
import entity.ChiTietDatDichVu;
import entity.DichVu;
import entity.PhieuDatPhong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ChiTietDatDichVuDAOImpl implements ChiTietDatDichVuDAO {
	private EntityManager em;
	EntityTransaction tx;

	public ChiTietDatDichVuDAOImpl() {
		em = Persistence.createEntityManagerFactory("ssql").createEntityManager();
	}
	@Override
	public List<ChiTietDatDichVu> getChiTietDatDichVuByPhieuDatPhong(String maPhieuDatPhong) {
		String query = "Select ct from ChiTietDatDichVu ct where ct.phieuDatPhong.maPhieuDatPhong = :maPhieuDatPhong";
		List<ChiTietDatDichVu> listCt = new ArrayList<ChiTietDatDichVu>();
		listCt = em.createQuery(query).setParameter("maPhieuDatPhong", maPhieuDatPhong).getResultList();
		return listCt;
	}
	@Override
	public boolean insertChiTietDatDichVu(String maPhieuDatPhong, List<DichVu> selectedDichVuList) {
		tx = em.getTransaction();
		try {
			tx.begin();
			for (DichVu dv : selectedDichVuList) {
				ChiTietDatDichVu ct = new ChiTietDatDichVu();
				ct.setPhieuDatPhong(em.find(PhieuDatPhong.class, maPhieuDatPhong));
				ct.setDichVu(dv);
				ct.setSoLuong(1);
				em.persist(ct);
			}
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}
	
}
