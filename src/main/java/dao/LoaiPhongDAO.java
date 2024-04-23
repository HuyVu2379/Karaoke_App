package dao;

import entity.LichSuGiaPhong;
import entity.LoaiPhong;

import java.rmi.RemoteException;
import java.util.List;

public interface LoaiPhongDAO {
    public List<LoaiPhong> getAllLoaiPhong() throws RemoteException;
    public LoaiPhong getLoaiPhongByTen(String tenLoaiPhong) throws RemoteException;
    public List<LichSuGiaPhong> getLichSuGiaPhongByMaLoaiPhong(String maLoaiPhong) throws RemoteException;
}
