package implDao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChiTietDatDichVu;
import entity.DichVu;

public interface ChiTietDatDichVuDAO extends Remote {
	public List<ChiTietDatDichVu> getChiTietDatDichVuByPhieuDatPhong(String maPhieuDatPhong) throws RemoteException;
	public boolean insertChiTietDatDichVu(String maPhieuDatPhong, List<DichVu> selectedDichVuList) throws RemoteException;
}
