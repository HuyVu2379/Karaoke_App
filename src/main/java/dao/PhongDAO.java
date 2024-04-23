package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.*;
import enums.TrangThaiPhong;

public interface PhongDAO extends Remote {
   public boolean addRoom(Phong phong) throws RemoteException;
   public boolean updateRoom(Phong phong) throws RemoteException;
   public List<Phong> getAllRoom() throws RemoteException;
   public List<Phong> getAllVacantRoom() throws RemoteException;
   public List<Phong> getRoomByNameAndType(String name, LoaiPhong type) throws RemoteException;
   public List<Phong> getRoomByStatus(String status) throws RemoteException;
   public List<Phong> getRoomByType(LoaiPhong type) throws RemoteException;
   public List<Phong> getRoomByName(String name) throws RemoteException;
   public List<Phong> getRoomLoaiPhongLichSuaGiaByConditionTime() throws RemoteException;
    public List<Phong> getRoomByCondition(String trangThai, String maLoaiPhong, String tenPhong) throws RemoteException;
    public List<Phong> getNewHoaDonByTenKhachHang(String tenKhachHang) throws RemoteException;
    public boolean updateRoomStatus(String maHoaDon, String maPhong) throws RemoteException;
}
