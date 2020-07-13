package br.edu.ufersa.sd;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FileClientInterface extends Remote {
	
	public boolean sendData(String fileName, byte[] data, int len) throws RemoteException;

	public String getName() throws RemoteException;
	
}