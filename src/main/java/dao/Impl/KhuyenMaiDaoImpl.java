package dao.Impl;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import dao.KhuyenMaiDAO;
import entity.KhuyenMai;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class KhuyenMaiDaoImpl extends UnicastRemoteObject implements KhuyenMaiDAO {
    EntityManager em;
    SimpleDateFormat originalFormat = new SimpleDateFormat("dd-MM-yyyy");

    // Tạo một đối tượng SimpleDateFormat với định dạng ngày tháng mong muốn
    SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
    Time time = null;
    Date date;
    public KhuyenMaiDaoImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("mssql")
                .createEntityManager();
    }

    public List<KhuyenMai> getAllKhuyenMai() throws RemoteException {
        String query = "Select km from KhuyenMai km";
        List<KhuyenMai> listKM = new ArrayList<KhuyenMai>();
        listKM = em.createQuery(query).getResultList();
        return listKM;
    }

    public boolean createKhuyenMai(KhuyenMai km) throws RemoteException {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(km);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return true;
    }

    public boolean updateKhuyenMai(KhuyenMai km, String maKhuyenMai) throws RemoteException {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            KhuyenMai khuyenMai = em.find(KhuyenMai.class, maKhuyenMai);
            khuyenMai.setMaKhuyenMai(km.getMaKhuyenMai());
            khuyenMai.setTenKhuyenMai(km.getTenKhuyenMai());
            khuyenMai.setNgayBatDau(km.getNgayBatDau());
            khuyenMai.setNgayKetThuc(km.getNgayKetThuc());
            khuyenMai.setGioiHan(km.getGioiHan());
            khuyenMai.setPhanTram(km.getPhanTram());
            khuyenMai.setThoiDiemBatDau(km.getThoiDiemBatDau());
            khuyenMai.setThoiDiemKetThuc(km.getThoiDiemKetThuc());
            em.merge(khuyenMai);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<KhuyenMai> TimKiemTheoMa(String ma) throws RemoteException {
        List<KhuyenMai> listkm = new ArrayList<>();
        String query = "Select km from KhuyenMai km where km.id like :ma";
        return em.createQuery(query).setParameter("ma", "%" + ma + "%").getResultList();
    }

    @Override
    public List<KhuyenMai> TimKiemTheoTheoThoiGian(Date NgayBatDau, Date NgayKetThuc) throws RemoteException {
        String query = "Select km from KhuyenMai km where km.ngayBatDau >=: NgayBatDau and km.ngayKetThuc <=: NgayKetThuc";
        return em.createQuery(query).setParameter("NgayBatDau", NgayBatDau).setParameter("NgayKetThuc", NgayKetThuc).getResultList();
    }

    @Override
    public List<KhuyenMai> pushFileExcel(String path) throws IOException, CsvValidationException, RemoteException {
        List<KhuyenMai> list = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {
            String[] headers = reader.readNext(); // Đọc hàng đầu tiên để lấy tên cột
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                KhuyenMai km = new KhuyenMai();
                for (int i = 0; i < headers.length; i++) {
                    // Gán giá trị cho các thuộc tính của đối tượng từ dữ liệu trong hàng CSV
                    switch (headers[i]) {
                        case "ma":
                            km.setMaKhuyenMai(nextLine[i].toString());
                            break;
                        case "phanTram":
                            km.setPhanTram(Double.parseDouble(nextLine[i].toString()));
                            break;
                        case "ten":
                            km.setTenKhuyenMai(nextLine[i].toString());
                            break;
                        case "gioiHan":
                            km.setGioiHan(Double.parseDouble(nextLine[i].toString()));
                            break;
                        case "ngayBatDau":
                            try {
                                String formattedDateString = targetFormat.format(originalFormat.parse(nextLine[i].toString()));
                                date = Date.valueOf(formattedDateString);
                            } catch (ParseException e) {
                                throw new RuntimeException(e);
                            }
                            km.setNgayBatDau(date);
                            break;
                        case "ngayKetThuc":
                            try {
                                String formattedDateString1 = targetFormat.format(originalFormat.parse(nextLine[i].toString()));
                                date = Date.valueOf(formattedDateString1);
                            } catch (ParseException e) {
                                throw new RuntimeException(e);
                            }
                            km.setNgayKetThuc(date);
                            break;
                        case "thoiDiemBatDau":
                            String formattedTimeString = null;
                            try {
                                formattedTimeString = formatter.format(formatter.parse(nextLine[i].toString()));
                            } catch (ParseException e) {
                                throw new RuntimeException(e);
                            }
                            time = Time.valueOf(formattedTimeString);
                            km.setThoiDiemBatDau(time);
                            break;
                        case "thoiDiemKetThuc":
                            String s;
                            try {
                                s = formatter.format(formatter.parse(nextLine[i].toString()));
                            } catch (ParseException e) {
                                throw new RuntimeException(e);
                            }
                            time = Time.valueOf(s);
                            km.setThoiDiemKetThuc(time);
                            break;
                    }
                }
                list.add(km);
            }
        }
        return list;
    }

}