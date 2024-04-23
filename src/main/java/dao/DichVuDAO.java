package implDao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.DichVu;
import enums.TrangThaiDichVu;

public interface DichVuDAO extends Remote  {
	public List<DichVu> getAllDichVu() throws RemoteException;
	public DichVu getDichVuByMa(String maDv) throws RemoteException;
	public DichVu getDichVuByLoai(String loaiDv) throws RemoteException;
	public boolean createDichVu(DichVu dv) throws RemoteException;
	public boolean updateDichVu(DichVu dv, String maDv) throws RemoteException;
	public boolean deleteDichVu(String maDv) throws RemoteException;
	public List<DichVu> searchDichVu(String tenDv) throws RemoteException;
	public List<DichVu> executeGetDichVuPage(int page, int size) throws RemoteException;
	public DichVu getDichVuTheoMa(String maDv) throws RemoteException;
	public List<DichVu> getDichVuByTrangThai(TrangThaiDichVu trangThai) throws RemoteException;
	
}
