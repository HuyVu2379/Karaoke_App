package dao;

import entity.HoaDon;
import entity.PhieuDatPhong;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface PhieuDatPhongDAO {
    public boolean bookKaraokeRoom(String maKhachHang, String maNhanVien, String maPhong, Time thoiGianBatDau,
                                   Date ngayThanhToan);

    public List<PhieuDatPhong> getPhieuDatPhongByMaHoaDon(String maHoaDon);

    public boolean updatePaymentDetails(HoaDon hoaDon);

    public boolean bookRoomBefore(String maKhachHang, String maNhanVien, String maPhong, Time thoiGianBatDau,
                                  Date ngayThanhToan);
    public boolean changeRoom(PhieuDatPhong phieuDatPhong);
    public List<String[]> getDanhSachPhieu();
    public void xoaPhieuDatPhongCho(String maHoaDon);
    public List<String[]> timKiemPhieuDatPhong(String sdt);
    public List<HoaDon> getHoaDonBySDTAndTime(String soDienThoaiKhachHang);
}
