package implDao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import entity.HoaDon;

public interface HoaDonDAO extends Remote {

	List<HoaDon> getHoaDonPaged(int page, int pageSize) throws RemoteException;

	List<HoaDon> getAllHoaDon() throws RemoteException;

	List<HoaDon> getHoaDonPagedByMaHoaDon(int page, int pageSize, String maHd) throws RemoteException;

	List<HoaDon> getHoaDonPagedByTenKhachHang(int page, int pageSize, String tenKh) throws RemoteException;

	List<HoaDon> getHoaDonPagedByDateRange(int page, int pageSize, Date ngayBatDau, Date ngayKetThuc)
			throws RemoteException;

	HoaDon getHoaDonByMaPhong(String maPhong) throws RemoteException;

	HoaDon getHoaDonByMaHoaDon(String maHd) throws RemoteException;
	
	
}
