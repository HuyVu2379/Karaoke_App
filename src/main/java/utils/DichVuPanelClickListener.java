package utils;

import entity.DichVu;

import java.rmi.RemoteException;

public interface DichVuPanelClickListener {
	void onDichVuPanelClicked(DichVu dichVu) throws RemoteException;
}