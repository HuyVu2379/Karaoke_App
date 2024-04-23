package dao;

import com.opencsv.exceptions.CsvValidationException;
import entity.NhanVien;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public interface NhanVienDao {
    public List<NhanVien> getAllNhanVien() throws RemoteException;
    public boolean createNhanVien(NhanVien nv) throws RemoteException;
    public boolean updateNhanVien(NhanVien nv, String maNV) throws RemoteException;
    public List<NhanVien> getNhanVienTheoMa(String maNV) throws RemoteException;
    public List<NhanVien> getNhanVienTheoTen(String tenNV) throws RemoteException;
    public List<NhanVien> getNhanVienTheoChucVu(String chucVu) throws RemoteException;
    public List<NhanVien> getNhanVienTheoSDT(String sdt) throws RemoteException;
    public List<NhanVien> getNhanVienTheoEmail(String tenNV) throws RemoteException;
    public List<NhanVien> getNhanVienTheoDiaChi(String giaTriTimKiem) throws RemoteException;
    public List<NhanVien> getTheoTrangThai(String giaTriTimKiem) throws RemoteException;
    public List<NhanVien> TimKiemTatCa(String giaTriTimKiem) throws RemoteException;
    public List<NhanVien> pushFileExcel(String path) throws IOException, CsvValidationException;
    public NhanVien getNhanVienTheoMaNV(String maNV) throws RemoteException;
}
