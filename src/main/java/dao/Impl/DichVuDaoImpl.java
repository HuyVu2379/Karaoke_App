package dao.Impl;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dao.DichVuDAO;
import entity.DichVu;
import entity.LoaiDichVu;
import enums.TrangThaiDichVu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DichVuDaoImpl implements DichVuDAO {
	private static final long serialVersionUID = 1L;
	private EntityManager em;
	EntityTransaction tx;

	public DichVuDaoImpl() {
		em = Persistence.createEntityManagerFactory("mssql").createEntityManager();
	}

	@Override
	public List<LoaiDichVu> getLoaiDichVu() throws RemoteException {
		String query = "Select ldv from LoaiDichVu ldv";
		List<LoaiDichVu> listLdv = new ArrayList<LoaiDichVu>();
		listLdv = em.createQuery(query).getResultList();
		return listLdv;
	}

	@Override
	public List<DichVu> getAllDichVu() throws RemoteException {
		String query = "Select dv from DichVu dv";
		List<DichVu> listDv = new ArrayList<DichVu>();
		listDv = em.createQuery(query).getResultList();
		return listDv;
	}
	@Override
	public DichVu getDichVuByMa(String maDv) throws RemoteException {
		String query = "Select dv from DichVu dv where dv.maDichVu = :maDv";
		DichVu dv = (DichVu) em.createQuery(query).setParameter("maDv", maDv).getSingleResult();
		return dv;
	}
	
	@Override
	//Thêm dịch vụ
	public boolean createDichVu(DichVu dv) {
		tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(dv);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return true;
	}
	@Override
	//update dịch vụ
	public boolean updateDichVu(DichVu dv, String maDv) {
		tx = em.getTransaction();
		try {
			tx.begin();
			DichVu dichVu = em.find(DichVu.class, maDv);
			dichVu.setTenDichVu(dv.getTenDichVu());
			dichVu.setSoLuong(dv.getSoLuong());
			dichVu.setLoaiDichVu(dv.getLoaiDichVu());
			dichVu.setTrangThai(dv.getTrangThai());
			dichVu.setMaDichVu(dv.getMaDichVu());
			em.merge(dichVu);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return true;
	}
	@Override
	// Lấy danh sách vụ theo trạng thái dịch vụ
	public List<DichVu> getDichVuByTrangThai(TrangThaiDichVu trangThai) throws RemoteException {
		String query = "Select dv from DichVu dv where dv.trangThai = :trangThai";
		List<DichVu> listDv = new ArrayList<DichVu>();
		listDv = em.createQuery(query).setParameter("trangThai", trangThai).getResultList();
		return listDv;
	}

	@Override
	public List<DichVu> getDichVuByLoai(String loaiDv) throws RemoteException {
		return null;
	}

	@Override
	public List<DichVu> getDichVuByTen(String tenDichVu) throws RemoteException {
		List<DichVu> listDv = new ArrayList<DichVu>();
		String query = "Select dv from DichVu dv where dv.tenDichVu = :tenDichVu";
		em.createQuery(query).setParameter("tenDichVu", tenDichVu).getResultList();
		return listDv;
	}

	@Override
	public List<DichVu> getDichVuByGia(double gia) throws RemoteException {
		String storedProcedure = "{call  GetDichVuByGia(?)}";
		return em.createNativeQuery(storedProcedure, DichVu.class)
				.setParameter(1, gia)
				.getResultList();
	}

	@Override
	public List<DichVu> getDichVuSoLuong(int soLuong) throws RemoteException {
		String query = "Select dv from DichVu dv where dv.soLuong = :soLuong";
		List<DichVu> listDv = new ArrayList<DichVu>();
		listDv = em.createQuery(query).setParameter("soLuong", soLuong).getResultList();
		return listDv;
	}


}
