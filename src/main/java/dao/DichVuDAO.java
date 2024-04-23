package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.DichVu;
import entity.LoaiDichVu;
import enums.TrangThaiDichVu;

public interface DichVuDAO extends Remote  {
	public boolean createDichVu(DichVu dv) throws RemoteException;
	public boolean updateDichVu(DichVu dv, String maDv) throws RemoteException;
	public List<DichVu> getDichVuByTrangThai(TrangThaiDichVu trangThai) throws RemoteException;
	public List<DichVu> getDichVuByLoai(String loaiDv) throws RemoteException;
	public DichVu getDichVuByMa(String maDv) throws RemoteException;
	public List<DichVu> getDichVuByTen(String tenDV) throws RemoteException;
	public List<DichVu> getDichVuByGia(double gia) throws RemoteException;
    public List<DichVu> getDichVuSoLuong(int soLuong) throws RemoteException;
	public List<DichVu> getAllDichVu() throws RemoteException;
	public List<LoaiDichVu> getLoaiDichVu() throws RemoteException;


}
