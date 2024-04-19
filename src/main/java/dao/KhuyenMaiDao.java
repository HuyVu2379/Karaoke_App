package dao;

import entity.KhuyenMai;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.rmi.Remote;

public interface KhuyenMaiDao extends Remote{
    public List<KhuyenMai> getAllKhuyenMai() throws RemoteException;
    public boolean createKhuyenMai(KhuyenMai km) throws RemoteException;
    public boolean updateKhuyenMai(KhuyenMai km, String maKhuyenMai) throws RemoteException;
    public KhuyenMai TimKiemTheoMa(String ma) throws RemoteException;
    public List<KhuyenMai> TimKiemTheoTheoThoiGian(Date NgayBatDau, Date NgayKetThuc) throws RemoteException;
}
