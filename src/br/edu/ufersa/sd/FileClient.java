package br.edu.ufersa.sd;

import java.io.File;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FileClient extends UnicastRemoteObject implements FileClientInterface{
	
	private static final long serialVersionUID = 1L;
	
	public String name;
	
	public FileClient(String name) throws RemoteException{
		super();
		this.name = name;
	}
	
	public String getName() throws RemoteException {
		return name;
	}
	
	public boolean sendData(String fileName, byte[] data, int len) throws RemoteException {
		
		try {
			
			File file = new File(fileName);
			file.createNewFile();
			FileOutputStream out = new FileOutputStream(file, true);
			out.write(data, 0, len);
			out.flush();
			out.close();
			
			System.out.println("Fechando escrita de dados...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
}

