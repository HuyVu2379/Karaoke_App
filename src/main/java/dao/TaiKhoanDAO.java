package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.TaiKhoan;

public interface TaiKhoanDAO extends Remote {

	public List<TaiKhoan> getAllTaiKhoan() throws RemoteException;

	public TaiKhoan getTaiKhoan(String tenDangNhap, String matKhau) throws RemoteException;
}
