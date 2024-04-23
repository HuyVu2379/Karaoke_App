package dao.Impl;

import dao.LichSuGiaDichVuDao;
import entity.LichSuGiaDichVu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LichSuGiaDichVuDAO implements LichSuGiaDichVuDao {
    private EntityManager em;

    public LichSuGiaDichVuDAO() {
        em = Persistence.createEntityManagerFactory("mssql").createEntityManager();
    }

    @Override
    public List<LichSuGiaDichVu> getLichSuGiaDichVuByMaDichVu(String maDichVu) {
        List<LichSuGiaDichVu> list = new ArrayList<LichSuGiaDichVu>();
        String query = "Select lsgdv from LichSuGiaDichVu lsgdv where lsgdv.dichVu.maDichVu = :maDichVu";
        list = em.createQuery(query).setParameter("maDichVu", maDichVu).getResultList();
        return list;
    }

}
