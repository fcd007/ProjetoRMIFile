package br.edu.ufersa.sd;

import java.net.InetAddress;
import java.rmi.Naming;

public class StartFileServer {

	public static void main(String[] args) {
		
		try {
			
			java.rmi.registry.LocateRegistry.createRegistry(1099);
			
			FileServer fs = new FileServer();
			
			fs.setFile("/home/dantas007/eclipse-workspace/ProjetoRMIFile/src/br/edu/ufersa/sd/temp/arquivo.txt");
			
			Naming.rebind("rmi://192.168.1.10/abc", fs);
			
			System.out.println("O Servidor de arquivos está pronto no endereço e porta: : "
					+ InetAddress.getLocalHost().getHostName()+ " / "
					+ InetAddress.getLocalHost().getHostAddress() );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
