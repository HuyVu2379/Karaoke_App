package dao.Impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dao.KhachHangDAO;
import entity.KhachHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class KhachHangDaoImpl implements KhachHangDAO {
	private EntityManager em;
	EntityTransaction tx;

	public KhachHangDaoImpl() {
		em = Persistence.createEntityManagerFactory("ssql").createEntityManager();
	}
	
	@Override
	// lấy danh sách khách hàng
	public List<KhachHang> getAllKhachHang() throws RemoteException {
		String query = "Select kh from KhachHang kh";
		List<KhachHang> listKh = new ArrayList<KhachHang>();
		listKh = em.createQuery(query).getResultList();
		return listKh;
	}
	@Override
	//lấy  khách hàng theo số phone
	public KhachHang getKhachHangByPhone(String phone) throws RemoteException {
		String query = "Select kh from KhachHang kh where kh.sdt = :phone";
		KhachHang kh = (KhachHang) em.createQuery(query).setParameter("phone", phone).getSingleResult();
		return kh;
	}
	@Override
    //tạo khách hàng
	public boolean createKhachHang(KhachHang kh) {
		tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(kh);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return true;
	}
	@Override
	//cập nhật khách hàng
	public boolean updateKhachHang(KhachHang kh, String phone) {
        tx = em.getTransaction();
        try {
            tx.begin();
            KhachHang khachHang = em.find(KhachHang.class, phone);
            khachHang.setMaKhachHang(kh.getMaKhachHang());
            khachHang.setTenKhachHang(kh.getTenKhachHang());
            khachHang.setSdt(kh.getSdt());
            em.merge(khachHang);
            tx.commit();
            } catch (Exception e) {
            	tx.rollback();
            	e.printStackTrace();
            }
           return true;
	}
	@Override
	//Tìm kiếm khách hàng theo têm khách hàng
	public List<KhachHang> searchKhachHang(String tenKh) throws RemoteException {
		String query = "Select kh from KhachHang kh where kh.tenKhachHang = :tenKh";
		List<KhachHang> listKh = new ArrayList<KhachHang>();
		listKh = em.createQuery(query).setParameter("tenKh", tenKh).getResultList();
		return listKh;
	}

	@Override
	public boolean deleteKhachHang(String phone) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
