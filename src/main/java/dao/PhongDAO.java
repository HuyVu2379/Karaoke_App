package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.*;
import enums.TrangThaiPhong;

public interface PhongDAO {
   public boolean addRoom(Phong phong);
   public boolean updateRoom(Phong phong);
   public List<Phong> getAllRoom();
   public List<Phong> getAllVacantRoom();
   public List<Phong> getRoomByNameAndType(String name, LoaiPhong type);
   public List<Phong> getRoomByStatus(String status);
   public List<Phong> getRoomByType(LoaiPhong type);
   public List<Phong> getRoomByName(String name);
   public List<Phong> getRoomLoaiPhongLichSuaGiaByConditionTime();
    public List<Phong> getRoomByCondition(String trangThai, String maLoaiPhong, String tenPhong);
    public List<Phong> getNewHoaDonByTenKhachHang(String tenKhachHang);
    public boolean updateRoomStatus(String maHoaDon, String maPhong);
}
