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

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

public class PhieuDatPhongImpl implements PhieuDatPhongDAO {
    private EntityManager em;
    private EntityTransaction tx;

    public PhieuDatPhongImpl() {
        em = Persistence.createEntityManagerFactory("mssql").createEntityManager();
    }

    @Override
    public boolean bookKaraokeRoom(String maKhachHang, String maNhanVien, String maPhong, Time thoiGianBatDau, Date ngayThanhToan) {
        tx = em.getTransaction();
        try {
            tx.begin();
            em.createNativeQuery("CALL BookKaraokeRoom(:maKhachHang, :maNhanVien, :maPhong, :thoiGianBatDau, :ngayThanhToan)")
                    .setParameter("maKhachHang", maKhachHang)
                    .setParameter("maNhanVien", maNhanVien)
                    .setParameter("maPhong", maPhong)
                    .setParameter("thoiGianBatDau", thoiGianBatDau)
                    .setParameter("ngayThanhToan", ngayThanhToan)
                    .executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<PhieuDatPhong> getPhieuDatPhongByMaHoaDon(String maHoaDon) {
        return null;
    }

    @Override
    public boolean updatePaymentDetails(HoaDon hoaDon) {
        return false;
    }

    @Override
    public boolean bookRoomBefore(String maKhachHang, String maNhanVien, String maPhong, Time thoiGianBatDau, Date ngayThanhToan) {
        return false;
    }

    @Override
    public boolean changeRoom(PhieuDatPhong phieuDatPhong) {
        return false;
    }

    @Override
    public List<String[]> getDanhSachPhieu() {
        return null;
    }

    @Override
    public void xoaPhieuDatPhongCho(String maHoaDon) {

    }

    @Override
    public List<String[]> timKiemPhieuDatPhong(String sdt) {
        return null;
    }

    @Override
    public List<HoaDon> getHoaDonBySDTAndTime(String soDienThoaiKhachHang) {
        return null;
    }
}
