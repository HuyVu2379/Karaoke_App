package dao;

import entity.LichSuGiaDichVu;

import java.rmi.RemoteException;
import java.util.List;

public interface LichSuGiaDichVuDao {
    public List<LichSuGiaDichVu> getLichSuGiaDichVuByMaDichVu(String maDichVu) throws RemoteException;
}
