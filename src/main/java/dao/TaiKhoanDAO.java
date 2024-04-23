package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.TaiKhoan;

public interface TaiKhoanDAO {

	public List<TaiKhoan> getAllTaiKhoan();

	public TaiKhoan getTaiKhoan(String tenDangNhap, String matKhau);
}
