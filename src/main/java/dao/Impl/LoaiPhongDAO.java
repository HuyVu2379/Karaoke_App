package dao.Impl;

import dao.LoaiPhongDao;
import entity.LichSuGiaPhong;
import entity.LoaiPhong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiPhongDAO implements LoaiPhongDao {
    EntityManager em;

    public LoaiPhongDAO() throws RemoteException {
		em = Persistence.createEntityManagerFactory("mssql").createEntityManager();
    }

    public List<LoaiPhong> getAllLoaiPhong() throws RemoteException{
      String query = "Select lp from LoaiPhong lp";
            List<LoaiPhong> listLP = new ArrayList<LoaiPhong>();
            listLP = em.createQuery(query).getResultList();
            return listLP;
    }

    public LoaiPhong getLoaiPhongByTen(String tenLoaiPhong) throws RemoteException{
       LoaiPhong loaiPhong;
       tenLoaiPhong = tenLoaiPhong.toLowerCase();
       String query = "Select lp from LoaiPhong lp where lower(lp.tenLoaiPhong) =:tenLoaiPhong";
       return  loaiPhong = (LoaiPhong) em.createQuery(query).setParameter("tenLoaiPhong", tenLoaiPhong).getSingleResult();
    }

    public List<LichSuGiaPhong> getLichSuGiaPhongByMaLoaiPhong(String maLoaiPhong) throws RemoteException{
        String query = "Select lsgp from LichSuGiaPhong lsgp where lsgp.loaiPhong.maLoaiPhong =:maLoaiPhong";
        List<LichSuGiaPhong> listLsgp = new ArrayList<LichSuGiaPhong>();
        listLsgp = em.createQuery(query).setParameter("maLoaiPhong", maLoaiPhong).getResultList();
        return listLsgp;
    }
}
