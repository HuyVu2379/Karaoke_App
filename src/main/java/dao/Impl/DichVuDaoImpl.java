package dao.Impl;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dao.DichVuDAO;
import entity.DichVu;
import enums.TrangThaiDichVu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DichVuDaoImpl implements DichVuDAO {
	private EntityManager em;
	EntityTransaction tx;

	public DichVuDaoImpl() {
		em = Persistence.createEntityManagerFactory("ssql").createEntityManager();
	}
	@Override
	public List<DichVu> getAllDichVu() throws RemoteException {
		String query = "Select dv from DichVu dv";
		List<DichVu> listDv = new ArrayList<DichVu>();
		listDv = em.createQuery(query).getResultList();
		return listDv;
	}
	@Override
	//Lấy  dịch vụ theo mã
	public DichVu getDichVuTheoMa(String maDv) throws RemoteException {
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
	//  Lấy kích thước trang dịch vụ
	@Override
	public List<DichVu> executeGetDichVuPage(int page, int size) throws RemoteException {
		String query = "Select dv from DichVu dv";
		List<DichVu> listDv = new ArrayList<DichVu>();
		listDv = em.createQuery(query).setFirstResult(page).setMaxResults(size).getResultList();
		return listDv;
	}

	@Override
	//Lấy dịch vụ theo tên
	public List<DichVu> searchDichVu(String tenDv) throws RemoteException {
		String query = "Select dv from DichVu dv where dv.tenDichVu = :tenDv";
		List<DichVu> listDv = new ArrayList<DichVu>();
		listDv = em.createQuery(query).setParameter("tenDv", tenDv).getResultList();
		return listDv;
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
	public boolean deleteDichVu(String maDv) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public DichVu getDichVuByMa(String maDv) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public DichVu getDichVuByLoai(String loaiDv) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
