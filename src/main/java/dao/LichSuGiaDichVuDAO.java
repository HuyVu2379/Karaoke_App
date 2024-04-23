package dao;

import entity.LichSuGiaDichVu;

import java.rmi.RemoteException;
import java.util.List;

public interface LichSuGiaDichVuDAO {
    public List<LichSuGiaDichVu> getLichSuGiaDichVuByMaDichVu(String maDichVu) throws RemoteException;
}
