package br.edu.ufersa.sd;

import java.io.File;
import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FileServer extends UnicastRemoteObject implements FileServerInterface {

	private String file = "";
	
	protected FileServer() throws RemoteException{
		super();
	}
	
	public void setFile(String fileName) {
		
		this.file = fileName;
	}
	
	public boolean login(FileClientInterface client) throws RemoteException {
		/* enviando o arquivo*/
		try {
			
			File fileData = new File(file);
			FileInputStream in = new FileInputStream(fileData);
			byte[] myData = new byte[1204*1024];
			
			int fileLen = in.read(myData);
			while (fileLen > 0) {
				client.sendData(fileData.getName(), myData, fileLen);
				fileLen = in.read(myData);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
}
