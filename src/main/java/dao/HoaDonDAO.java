package implDao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import entity.HoaDon;

public interface HoaDonDAO extends Remote {

	public List<HoaDon> getHoaDonPaged(int page, int pageSize) throws RemoteException;

	public  List<HoaDon> getAllHoaDon() throws RemoteException;

	public  List<HoaDon> getHoaDonPagedByMaHoaDon(int page, int pageSize, String maHd) throws RemoteException;

	public  List<HoaDon> getHoaDonPagedByTenKhachHang(int page, int pageSize, String tenKh) throws RemoteException;

	public  List<HoaDon> getHoaDonPagedByDateRange(int page, int pageSize, Date ngayBatDau, Date ngayKetThuc)
			throws RemoteException;

	public HoaDon getHoaDonByMaPhong(String maPhong) throws RemoteException;

	public HoaDon getHoaDonByMaHoaDon(String maHd) throws RemoteException;
	
	
}
