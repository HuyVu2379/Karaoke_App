package dao.Impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import dao.KhachHangDAO;
import entity.KhachHang;
import entity.KhuyenMai;
import entity.NhanVien;
import enums.TrangThaiNhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class KhachHangDaoImpl implements KhachHangDAO {
	private static final long serialVersionUID = 1L;
	private EntityManager em;
	EntityTransaction tx;

	public KhachHangDaoImpl() {
		em = Persistence.createEntityManagerFactory("mssql").createEntityManager();
	}
	
	@Override
	// lấy danh sách khách hàng
	public List<KhachHang> getAllKhachHang() throws RemoteException {
		String query = "Select kh from KhachHang kh";
		List<KhachHang> listKh = new ArrayList<KhachHang>();
		listKh = em.createQuery(query).getResultList();
		return listKh;
	}
	@Override
    //tạo khách hàng
	public boolean createKhachHang(KhachHang kh) {
		tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(kh);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return true;
	}
	@Override
	//cập nhật khách hàng
	public boolean updateKhachHang(KhachHang kh, String phone) {
        tx = em.getTransaction();
        try {
            tx.begin();
            KhachHang khachHang = em.find(KhachHang.class, phone);
            khachHang.setMaKhachHang(kh.getMaKhachHang());
            khachHang.setTenKhachHang(kh.getTenKhachHang());
            khachHang.setSdt(kh.getSdt());
            em.merge(khachHang);
            tx.commit();
            } catch (Exception e) {
            	tx.rollback();
            	e.printStackTrace();
            }
           return true;
	}

	@Override
	public List<KhachHang> getKhachHangByTen(String tenKH) throws RemoteException {
		String query = "Select kh from KhachHang kh where kh.tenKhachHang like :tenKhachHang";
		List<KhachHang> listKhachHang = em.createQuery(query).setParameter("tenKhachHang", tenKH).getResultList();
		return listKhachHang;
	}
	@Override
	public List<KhachHang> pushFileExcel(String path) throws IOException, CsvValidationException {
		List<KhachHang> list = new ArrayList<>();
		try (CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(path),"UTF-8"))) {
			String[] headers = reader.readNext(); // Đọc hàng đầu tiên để lấy tên cột
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				KhachHang nv = new KhachHang();
				for (int i = 0; i < headers.length; i++) {
					// Gán giá trị cho các thuộc tính của đối tượng từ dữ liệu trong hàng CSV
					switch (headers[i]) {
						case "ma":
							nv.setMaKhachHang(nextLine[i].toString());
							break;
						case "ten":
							nv.setTenKhachHang(nextLine[i].toString());
							break;
						case "sdt":
							nv.setSdt(nextLine[i].toString());
							break;
					}
				}
				list.add(nv);
			}
		}
		return list;
	}

	@Override
	public List<KhachHang> getKhachHangByMa(String maKhachHang) throws RemoteException {
		List<KhachHang> list = new ArrayList<KhachHang>();
		String query = "Select kh from KhachHang kh where kh.maKhachHang  =:maKhachHang";
		KhachHang khachHang = (KhachHang) em.createQuery(query).setParameter("maKhachHang", maKhachHang);
		list.add(khachHang);
		return list;
	}

}
