package dao.Impl;

import entity.LichSuGiaDichVu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class LichSuGiaDichVuImpl extends UnicastRemoteObject implements dao.LichSuGiaDichVuDAO {
    private static final long serialVersionUID = 1L;
    private EntityManager em;

    public LichSuGiaDichVuImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("mssql").createEntityManager();
    }

    @Override
    public List<LichSuGiaDichVu> getLichSuGiaDichVuByMaDichVu(String maDichVu) throws RemoteException{
        List<LichSuGiaDichVu> list = new ArrayList<LichSuGiaDichVu>();
        String query = "Select lsgdv from LichSuGiaDichVu lsgdv where lsgdv.dichVu.maDichVu = :maDichVu";
        list = em.createQuery(query).setParameter("maDichVu", maDichVu).getResultList();
        return list;
    }

}
