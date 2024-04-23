package dao.Impl;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import dao.NhanVienDAO;
import entity.NhanVien;
import enums.TrangThaiNhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.io.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDaoImpl implements NhanVienDAO {
    private EntityManager em;
    EntityTransaction tx;

    public NhanVienDaoImpl() {
        em = Persistence.createEntityManagerFactory("mssql").createEntityManager();
    }

    @Override
    public List<NhanVien> getAllNhanVien() throws RemoteException {
        String query = "Select nv from NhanVien nv";
        List<NhanVien> listNv = new ArrayList<NhanVien>();
        listNv = em.createQuery(query).getResultList();
        return listNv;
    }

    @Override
    public boolean createNhanVien(NhanVien nv) {
        tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(nv);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean updateNhanVien(NhanVien nv, String maNV) {
        tx = em.getTransaction();
        try {
            tx.begin();
            NhanVien nhanVien = em.find(NhanVien.class, maNV);
            nhanVien.setMaNhanVien(nv.getMaNhanVien());
            nhanVien.setTen(nv.getTen());
            nhanVien.setChucVu(nv.getChucVu());
            nhanVien.setEmail(nv.getEmail());
            nhanVien.setDiaChi(nv.getDiaChi());
            nhanVien.setHoaDon(nv.getHoaDon());
            nhanVien.setTaiKhoan(nv.getTaiKhoan());
            nhanVien.setTrangThai(nv.getTrangThai());
            em.merge(nhanVien);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<NhanVien> getNhanVienTheoMa(String maNV) throws RemoteException {
        List<NhanVien> list = new ArrayList<NhanVien>();
        String query = "Select nv from NhanVien nv where nv.id like :maNV";
        list = em.createQuery(query).setParameter("maNV", "%" + maNV + "%").getResultList();
        return list;
    }

    @Override
    public List<NhanVien> getNhanVienTheoTen(String tenNV) throws RemoteException {
        List<NhanVien> list = new ArrayList<NhanVien>();
        String query = "Select nv from NhanVien nv where nv.ten like :tenNV";
        list = em.createQuery(query).setParameter("tenNV", "%" + tenNV + "%").getResultList();
        return list;
    }

    @Override
    public List<NhanVien> getNhanVienTheoChucVu(String chucVu) throws RemoteException {
        List<NhanVien> list = new ArrayList<NhanVien>();
        String query = "Select nv from NhanVien nv where nv.chucVu like :chucVu";
        list = em.createQuery(query).setParameter("chucVu", "%" + chucVu + "%").getResultList();
        return list;
    }

    @Override
    public List<NhanVien> getNhanVienTheoSDT(String sdt) throws RemoteException {
        List<NhanVien> list = new ArrayList<NhanVien>();
        String query = "Select nv from NhanVien nv where nv.sdt like :SDT";
        list = em.createQuery(query).setParameter("SDT", "%" + sdt + "%").getResultList();
        return list;
    }

    @Override
    public List<NhanVien> getNhanVienTheoEmail(String email) throws RemoteException {
        List<NhanVien> list = new ArrayList<NhanVien>();
        String query = "Select nv from NhanVien nv where nv.email like :email";
        list = em.createQuery(query).setParameter("email", "%" + email + "%").getResultList();
        return list;
    }

    @Override
    public List<NhanVien> getNhanVienTheoDiaChi(String diaChi) throws RemoteException {
        List<NhanVien> list = new ArrayList<NhanVien>();
        String query = "Select nv from NhanVien nv where nv.diaChi like :diaChi";
        list = em.createQuery(query).setParameter("diaChi", "%" + diaChi + "%").getResultList();
        return list;
    }

    @Override
    public List<NhanVien> getTheoTrangThai(String trangThai) throws RemoteException {
        List<NhanVien> list = new ArrayList<NhanVien>();
        String query = "Select nv from NhanVien nv where nv.trangThai =:trangThai";
        list = em.createQuery(query).setParameter("trangThai", trangThai).getResultList();
        return list;
    }

    @Override
    public List<NhanVien> TimKiemTatCa(String giaTriTimKiem) throws RemoteException {
        List<NhanVien> list = new ArrayList<NhanVien>();
        String query = "Select nv from NhanVien nv where nv.ten like :giaTriTimKiem or nv.chucVu like :giaTriTimKiem or nv.sdt like :giaTriTimKiem or nv.email like :giaTriTimKiem or nv.diaChi like :giaTriTimKiem or nv.maNhanVien like :giaTriTimKiem";
        list = em.createQuery(query).setParameter("giaTriTimKiem", giaTriTimKiem).getResultList();
        return list;
    }

    @Override
    public List<NhanVien> pushFileExcel(String path) throws IOException, CsvValidationException {
        List<NhanVien> list = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(path),"UTF-8"))) {
            String[] headers = reader.readNext(); // Đọc hàng đầu tiên để lấy tên cột
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                NhanVien nv = new NhanVien();
                for (int i = 0; i < headers.length; i++) {
                    // Gán giá trị cho các thuộc tính của đối tượng từ dữ liệu trong hàng CSV
                    switch (headers[i]) {
                        case "ma":
                            nv.setMaNhanVien(nextLine[i].toString());
                            break;
                        case "chucVu":
                            nv.setChucVu(nextLine[i].toString());
                            break;
                        case "ten":
                            nv.setTen(nextLine[i].toString());
                            break;
                        case "sdt":
                            nv.setSdt(nextLine[i].toString());
                            break;
                        case "email":
                            nv.setEmail(nextLine[i].toString());
                            break;
                        case "diaChi":
                            nv.setDiaChi(nextLine[i].toString());
                            break;
                        case "trangThai":
                            TrangThaiNhanVien tt = TrangThaiNhanVien.valueOf(nextLine[i]);
                            nv.setTrangThai(tt);
                            break;
                    }
                }
                list.add(nv);
            }
        }
        return list;
    }

    @Override
    public NhanVien getNhanVienTheoMaNV(String maNV) throws RemoteException {
        String query = "Select nv from NhanVien nv where nv.maNhanVien =:maNV";
        NhanVien nv = em.createQuery(query, NhanVien.class).setParameter("maNV", maNV).getSingleResult();
        return nv;
    }
}
