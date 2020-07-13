package br.edu.ufersa.sd;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FileServerInterface extends Remote {
	
	public boolean login(FileClientInterface client) throws RemoteException;
}
