package dao.Impl;

import dao.KhuyenMaiDao;
import entity.KhuyenMai;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KhuyenMaiDAO extends UnicastRemoteObject implements KhuyenMaiDao {
//	private ConnectDB connectDB;

    //	public KhuyenMaiDAO() {
//		this.connectDB = ConnectDB.getInstance();
//	}
    EntityManager em;

    public KhuyenMaiDAO() throws RemoteException {
        em = Persistence.createEntityManagerFactory("mssql")
                .createEntityManager();
    }

    public List<KhuyenMai> getAllKhuyenMai() throws RemoteException {
        String query = "Select km from KhuyenMai km";
        List<KhuyenMai> listKM = new ArrayList<KhuyenMai>();
        listKM = em.createQuery(query).getResultList();
        return listKM;
    }

    public boolean createKhuyenMai(KhuyenMai km) throws RemoteException {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(km);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return true;
    }

    public boolean updateKhuyenMai(KhuyenMai km, String maKhuyenMai) throws RemoteException {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            KhuyenMai khuyenMai = em.find(KhuyenMai.class, maKhuyenMai);
            khuyenMai.setMaKhuyenMai(km.getMaKhuyenMai());
            khuyenMai.setTenKhuyenMai(km.getTenKhuyenMai());
            khuyenMai.setNgayBatDau(km.getNgayBatDau());
            khuyenMai.setNgayKetThuc(km.getNgayKetThuc());
            khuyenMai.setGioiHan(km.getGioiHan());
            khuyenMai.setPhanTram(km.getPhanTram());
            khuyenMai.setThoiDiemBatDau(km.getThoiDiemBatDau());
            khuyenMai.setThoiDiemKetThuc(km.getThoiDiemKetThuc());
            em.merge(khuyenMai);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return true;
    }
    @Override
    public KhuyenMai TimKiemTheoMa(String ma) throws RemoteException {
        return (KhuyenMai) em.find(KhuyenMai.class, ma);
    }

    @Override
    public List<KhuyenMai> TimKiemTheoTheoThoiGian(Date NgayBatDau, Date NgayKetThuc) throws RemoteException {
        String query = "Select km from KhuyenMai km where km.ngayBatDau >=: NgayBatDau and km.ngayKetThuc <=: NgayKetThuc";
        return  em.createQuery(query).setParameter("NgayBatDau", NgayBatDau).setParameter("NgayKetThuc", NgayKetThuc).getResultList();
    }


}