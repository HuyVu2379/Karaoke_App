package dao.Impl;

import dao.TaiKhoanDAO;
import entity.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class TaiKhoanImpl implements TaiKhoanDAO {
    private EntityManager em;
    private EntityTransaction tx;

    public TaiKhoanImpl() {
        em = Persistence.createEntityManagerFactory("mssql").createEntityManager();
    }

    @Override
    public List<TaiKhoan> getAllTaiKhoan() {
        List<TaiKhoan> taiKhoanList = em.createQuery("SELECT tk FROM TaiKhoan tk", TaiKhoan.class).getResultList();
        return taiKhoanList;
    }

    @Override
    public TaiKhoan getTaiKhoan(String tenDangNhap, String matKhau) {
        String query = "SELECT tk FROM TaiKhoan tk WHERE tk.tenTaiKhoan = :tenDangNhap AND tk.matKhau = :matKhau";
        return em.createQuery(query, TaiKhoan.class).setParameter("tenDangNhap", tenDangNhap).setParameter("matKhau", matKhau).getSingleResult();
    }
}
