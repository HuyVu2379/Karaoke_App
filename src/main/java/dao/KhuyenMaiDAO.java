package dao;

import com.opencsv.exceptions.CsvValidationException;
import entity.KhuyenMai;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.List;

public interface KhuyenMaiDAO extends Remote{
    public List<KhuyenMai> getAllKhuyenMai() throws RemoteException;
    public boolean createKhuyenMai(KhuyenMai km) throws RemoteException;
    public boolean updateKhuyenMai(KhuyenMai km, String maKhuyenMai) throws RemoteException;
    public List<KhuyenMai> TimKiemTheoMa(String ma) throws RemoteException;
    public List<KhuyenMai> TimKiemTheoTheoThoiGian(Date NgayBatDau, Date NgayKetThuc) throws RemoteException;
    public KhuyenMai getKhuyenMaiByTen(String khuyenMaiName) throws RemoteException;
    List<KhuyenMai> pushFileExcel(String path) throws IOException, CsvValidationException, RemoteException;

}
