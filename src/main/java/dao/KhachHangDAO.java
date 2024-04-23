package dao;


import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.opencsv.exceptions.CsvValidationException;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public interface KhachHangDAO extends Remote {
    public List<KhachHang> getAllKhachHang() throws RemoteException;

    public boolean createKhachHang(KhachHang kh) throws RemoteException;

    public boolean updateKhachHang(KhachHang kh, String phone) throws RemoteException;

    public List<KhachHang> getKhachHangByTen(String tenKH) throws RemoteException;

    public List<KhachHang> pushFileExcel(String path) throws IOException, CsvValidationException;

    public List<KhachHang> getKhachHangByMa(String maKhachHang) throws RemoteException;

}