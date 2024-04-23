package dao;

import entity.HoaDon;
import entity.PhieuDatPhong;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface PhieuDatPhongDAO extends Remote {
    public boolean bookKaraokeRoom(String maKhachHang, String maNhanVien, String maPhong, Time thoiGianBatDau,
                                   Date ngayThanhToan) throws RemoteException;

    public List<PhieuDatPhong> getPhieuDatPhongByMaHoaDon(String maHoaDon) throws RemoteException;

    public boolean updatePaymentDetails(HoaDon hoaDon) throws RemoteException;

    public boolean bookRoomBefore(String maKhachHang, String maNhanVien, String maPhong, Time thoiGianBatDau,
                                  Date ngayThanhToan) throws RemoteException;
    public boolean changeRoom(PhieuDatPhong phieuDatPhong) throws RemoteException;
    public List<String[]> getDanhSachPhieu() throws RemoteException;
    public void xoaPhieuDatPhongCho(String maHoaDon) throws RemoteException;
    public List<String[]> timKiemPhieuDatPhong(String sdt) throws RemoteException;
    public List<HoaDon> getHoaDonBySDTAndTime(String soDienThoaiKhachHang) throws RemoteException;
}
