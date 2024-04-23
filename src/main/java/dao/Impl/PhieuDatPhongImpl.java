/*
 * @ (#) PhieuDatPhongImpl.java       1.0     4/21/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package dao.Impl;
/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 4/21/2024
 */

import dao.PhieuDatPhongDAO;
import entity.HoaDon;
import entity.PhieuDatPhong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class PhieuDatPhongImpl extends UnicastRemoteObject implements PhieuDatPhongDAO {
    private static final long serialVersionUID = 1L;
    private EntityManager em;
    private EntityTransaction tx;

    public PhieuDatPhongImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("mssql").createEntityManager();
    }

    @Override
    public boolean bookKaraokeRoom(String maKhachHang, String maNhanVien, String maPhong, Time thoiGianBatDau, Date ngayThanhToan)throws RemoteException {
        tx = em.getTransaction();
        try {
            tx.begin();
            em.createNativeQuery("{CALL BookKaraokeRoom(?,?, ?, ?, ?)}")
                    .setParameter(1, maKhachHang)
                    .setParameter(2, maNhanVien)
                    .setParameter(3, maPhong)
                    .setParameter(4, thoiGianBatDau)
                    .setParameter(5, ngayThanhToan)
                    .executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<PhieuDatPhong> getPhieuDatPhongByMaHoaDon(String maHoaDon) throws RemoteException{
        String query = "{call GetPhieuDatPhongByMaHoaDon(?)}";
        return em.createNativeQuery(query, PhieuDatPhong.class)
                .setParameter(1, maHoaDon)
                .getResultList();
    }

    @Override
    public boolean updatePaymentDetails(HoaDon hoaDon) throws RemoteException{
        tx = em.getTransaction();
        String query = "{CALL UpdatePaymentDetails(?, ?, ?, ?, ?, ?)}";
        try {
            tx.begin();
            em.createNativeQuery(query, HoaDon.class)
                    .setParameter(1, hoaDon.getMaHoaDon())
                    .setParameter(2, hoaDon.getTongTien())
                    .setParameter(3, hoaDon.getThoiDiemThanhToan())
                    .setParameter(4, hoaDon.getPhieuDatPhongList().get(HoaDon.getPhieuDatPhongList().size() - 1).getMaPhieuDatPhong())
                    .setParameter(5, hoaDon.getPhieuDatPhongList().get(hoaDon.getPhieuDatPhongList().size() - 1).getThoiGianKetThuc())
                    .setParameter(6, hoaDon.getKhuyenMai().getMaKhuyenMai())
                    .executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean bookRoomBefore(String maKhachHang, String maNhanVien, String maPhong, Time thoiGianBatDau, Date ngayThanhToan) throws RemoteException{
        String query = "{CALL BookRoomBefore(?, ?, ?, ?, ?)}";
        tx = em.getTransaction();
        try {
            tx.begin();
            em.createNativeQuery(query)
                    .setParameter(1, maKhachHang)
                    .setParameter(2, maNhanVien)
                    .setParameter(3, maPhong)
                    .setParameter(4, thoiGianBatDau)
                    .setParameter(5, ngayThanhToan)
                    .executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean changeRoom(PhieuDatPhong phieuDatPhong) throws RemoteException{
        String query = "{CALL ChangeKarokeRoom(?, ?)}";
        tx = em.getTransaction();
        try {
            tx.begin();
            em.createNativeQuery(query)
                    .setParameter(1, phieuDatPhong.getMaPhieuDatPhong())
                    .setParameter(2, phieuDatPhong.getPhong().getMaPhong())
                    .executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<String[]> getDanhSachPhieu() throws RemoteException{
        String sql = "SELECT * FROM DanhSachPhieu_View";
        return em.createNativeQuery(sql).getResultList();
    }

    @Override
    public void xoaPhieuDatPhongCho(String maHoaDon) throws RemoteException{
        String query = "{CALL XoaPhieuDatPhongCho(?)}";
        tx = em.getTransaction();
        try {
            tx.begin();
            em.createNativeQuery(query)
                    .setParameter(1, maHoaDon)
                    .executeUpdate();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String[]> timKiemPhieuDatPhong(String sdt) throws RemoteException{
        String query = "SELECT * FROM DanhSachPhieu_View WHERE sdt LIKE ?";
        return em.createNativeQuery(query)
                .setParameter(1, sdt)
                .getResultList();
    }

    @Override
    public List<HoaDon> getHoaDonBySDTAndTime(String soDienThoaiKhachHang) throws RemoteException{
        String query = "{CALL GetHoaDonBySDTAndTime(?)}";
        return em.createNativeQuery(query, HoaDon.class)
                .setParameter(1, soDienThoaiKhachHang)
                .getResultList();
    }
}
