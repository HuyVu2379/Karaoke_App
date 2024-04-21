package dao.Impl;


import dao.NhanVienDao;
import entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO implements NhanVienDao {
    private EntityManager em;
    EntityTransaction tx;

    public NhanVienDAO() {
        em = Persistence.createEntityManagerFactory("ssql").createEntityManager();
    }

    @Override
    public List<NhanVien> getAllNhanVien() throws RemoteException {
        String query = "Select nv from NhanVien nv";
        List<NhanVien> listNv = new ArrayList<NhanVien>();
        listNv = em.createQuery(query).getResultList();
        return listNv;
    }
    @Override
    public boolean createNhanVien(NhanVien nv) {
        tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(nv);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return true;
    }
    @Override
    public boolean updateNhanVien(NhanVien nv, String maNV) {
        tx = em.getTransaction();
        try {
            tx.begin();
            NhanVien nhanVien = em.find(NhanVien.class, maNV);
            nhanVien.setMaNhanVien(nv.getMaNhanVien());
            nhanVien.setTen(nv.getTen());
            nhanVien.setChucVu(nv.getChucVu());
            nhanVien.setEmail(nv.getEmail());
            nhanVien.setDiaChi(nv.getDiaChi());
            nhanVien.setHoaDon(nv.getHoaDon());
            nhanVien.setTaiKhoan(nv.getTaiKhoan());
            nhanVien.setTrangThai(nv.getTrangThai());
            em.merge(nhanVien);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public NhanVien getNhanVienTheoMa(String maNV) throws RemoteException {
        String query = "Select nv from NhanVien nv where nv.id =: maNV";
        return (NhanVien) em.createQuery(query).setParameter("maNV", maNV);
    }
    @Override
    public List<NhanVien> getNhanVienTheoTen(String tenNV) throws RemoteException {
        List<NhanVien> list = new ArrayList<NhanVien>();
        String query = "Select nv from NhanVien nv where nv.ten =: tenNV";
        list = em.createQuery(query).setParameter("tenNV", tenNV).getResultList();
        return list;
    }
    @Override
    public List<NhanVien> getNhanVienTheoChucVu(String chucVu) throws RemoteException {
        List<NhanVien> list = new ArrayList<NhanVien>();
        String query = "Select nv from NhanVien nv where nv.chucVu =: chucVu";
        list = em.createQuery(query).setParameter("chucVu", chucVu).getResultList();
        return list;
    }
    @Override
    public List<NhanVien> getNhanVienTheoSDT(String sdt) throws RemoteException {
        List<NhanVien> list = new ArrayList<NhanVien>();
        String query = "Select nv from NhanVien nv where nv.sdt =: SDT";
        list = em.createQuery(query).setParameter("SDT", sdt).getResultList();
        return list;
    }
    @Override
    public List<NhanVien> getNhanVienTheoEmail(String email) throws RemoteException {
        List<NhanVien> list = new ArrayList<NhanVien>();
        String query = "Select nv from NhanVien nv where nv.email =: email";
        list = em.createQuery(query).setParameter("email", email).getResultList();
        return list;
    }

    @Override
    public List<NhanVien> getNhanVienTheoDiaChi(String diaChi) throws RemoteException {
        List<NhanVien> list = new ArrayList<NhanVien>();
        String query = "Select nv from NhanVien nv where nv.diaChi =: diaChi";
        list = em.createQuery(query).setParameter("diaChi", diaChi).getResultList();
        return list;
    }

    @Override
    public List<NhanVien> getTheoTrangThai(String trangThai) throws RemoteException {
        List<NhanVien> list = new ArrayList<NhanVien>();
        String query = "Select nv from NhanVien nv where nv.trangThai =: trangThai";
        list = em.createQuery(query).setParameter("trangThai", trangThai).getResultList();
        return list;
    }

    @Override
    public List<NhanVien> TimKiemTatCa(String giaTriTimKiem) throws RemoteException {
        List<NhanVien> list = new ArrayList<NhanVien>();
        String query = "Select nv from NhanVien nv where nv.ten like :giaTriTimKiem or nv.chucVu like :giaTriTimKiem or nv.sdt like :giaTriTimKiem or nv.email like :giaTriTimKiem or nv.diaChi like :giaTriTimKiem or nv.maNhanVien like :giaTriTimKiem";
        list = em.createQuery(query).setParameter("giaTriTimKiem", giaTriTimKiem).getResultList();
        return list;
    }
}
