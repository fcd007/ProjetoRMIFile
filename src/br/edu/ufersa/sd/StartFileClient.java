package br.edu.ufersa.sd;

import java.rmi.Naming;
import java.util.Scanner;

public class StartFileClient {
	
	public static void main(String[] args) {
		
		try {
			
			FileClient client = new FileClient("Dantass");
		
			FileServerInterface server = (FileServerInterface)Naming.lookup("rmi://192.168.1.10/abc");
			
			server.login(client);
			
			System.out.println("Escutando...");
			
			Scanner s = new Scanner(System.in);
			while (true) {
				
				String line = s.nextLine();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
