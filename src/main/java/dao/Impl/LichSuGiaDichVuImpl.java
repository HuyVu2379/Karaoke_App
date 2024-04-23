package dao.Impl;

import entity.LichSuGiaDichVu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class LichSuGiaDichVuImpl implements dao.LichSuGiaDichVuDAO {
    private static final long serialVersionUID = 1L;
    private EntityManager em;

    public LichSuGiaDichVuImpl() {
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
