package dao;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.HoaDon;
import entity.KhachHang;

public interface KhachHangDAO extends Remote {
	public List<KhachHang> getAllKhachHang() throws RemoteException;
	public KhachHang getCustomerByPhoneNumber(String phone) throws RemoteException;
	public boolean createKhachHang(KhachHang kh) throws RemoteException;
	public boolean updateKhachHang(KhachHang kh, String phone) throws RemoteException;
	public boolean deleteKhachHang(String phone) throws RemoteException;
	public List<KhachHang> searchKhachHang(String tenKh) throws RemoteException;

}