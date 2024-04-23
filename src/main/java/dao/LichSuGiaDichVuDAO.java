package dao;

import entity.LichSuGiaDichVu;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface LichSuGiaDichVuDAO extends Remote {
    public List<LichSuGiaDichVu> getLichSuGiaDichVuByMaDichVu(String maDichVu) throws RemoteException;
}
