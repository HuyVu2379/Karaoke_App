package dao.Impl;

import dao.PhongDAO;
import entity.LoaiPhong;
import entity.Phong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class PhongImpl extends UnicastRemoteObject implements PhongDAO {
    private static final long serialVersionUID = 1L;
    private EntityManager em;
    private EntityTransaction tx;

    public PhongImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("mssql").createEntityManager();
    }

    @Override
    public boolean addRoom(Phong phong) throws RemoteException{
        tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(phong);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateRoom(Phong phong) throws RemoteException{
        tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(phong);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Phong> getAllRoom() throws RemoteException{
        String query = "SELECT p FROM Phong p left join p.loaiPhong";
        return em.createQuery(query, Phong.class).getResultList();
    }

    @Override
    public List<Phong> getAllVacantRoom() throws RemoteException{
        String query = "SELECT p FROM Phong p WHERE p.trangThai = enums.TrangThaiPhong.PHONG_TRONG";
        return em.createQuery(query, Phong.class).getResultList();
    }

    @Override
    public List<Phong> getRoomByNameAndType(String name, LoaiPhong type) throws RemoteException {
        String query = "{call GetPhongByTenAndLoaiPhong(?, ?)}";
        List<Phong> phongList = new ArrayList<>();
        return em.createNativeQuery(query, Phong.class).setParameter(1, name).setParameter(2, type.getMaLoaiPhong()).getResultList();
    }

    @Override
    public List<Phong> getRoomByStatus(String status) throws RemoteException {
        String query = "SELECT * FROM PhongView WHERE trangThai = ?";
        return em.createNativeQuery(query, Phong.class)
                .setParameter(1, status)
                .getResultList();
    }

    @Override
    public List<Phong> getRoomByType(LoaiPhong type) throws RemoteException{
        String query = "SELECT * FROM PhongView WHERE LoaiPhong_MaLoaiPhong = ?";
        return em.createNativeQuery(query, LoaiPhong.class)
                .setParameter(1, type.getMaLoaiPhong())
                .getResultList();
    }

    @Override
    public List<Phong> getRoomByName(String name) throws RemoteException{
        String query = "SELECT * FROM PhongView WHERE tenPhong = ?";
        return em.createNativeQuery(query, Phong.class)
                .setParameter(1, name)
                .getResultList();
    }

    @Override
    public List<Phong> getRoomLoaiPhongLichSuaGiaByConditionTime() throws RemoteException{
        String query = "SELECT * FROM PhongLoaiPhongLichSuaGiaByConditionTimeView";
        return em.createNativeQuery(query, Phong.class).getResultList();
    }

    @Override
    public List<Phong> getRoomByCondition(String trangThai, String maLoaiPhong, String tenPhong) throws RemoteException{
        String storedProcedure = "{call GetPhongByCondition(?, ?, ?)}";
        return em.createNativeQuery(storedProcedure, Phong.class)
                .setParameter(1, trangThai)
                .setParameter(2, maLoaiPhong)
                .setParameter(3, tenPhong)
                .getResultList();
    }

    @Override
    public List<Phong> getNewHoaDonByTenKhachHang(String tenKhachHang) throws RemoteException{
        String query = "{call GetNewHoaDonByTenKhachHang(?)}";
        return em.createNativeQuery(query, Phong.class)
                .setParameter(1, tenKhachHang)
                .getResultList();
    }

    @Override
    public boolean updateRoomStatus(String maHoaDon, String maPhong) throws RemoteException{
        tx = em.getTransaction();
        return false;
    }
}
