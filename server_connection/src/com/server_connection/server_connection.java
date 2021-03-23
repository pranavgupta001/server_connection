package com.server_connection;
import java.net.*;

//import server_connection.Server;

import java.io.*;
public class server_connection {
	private Socket socket =null;
	private ServerSocket server =null;
	private DataInputStream in = null;
	
	public server_connection(int port) {
		try
		{
		server = new ServerSocket(port);
		System.out.println("Server Started");
		System.out.println("Waiting for a client...");
		socket = server.accept();
		System.out.print("Client accepted ");
		in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		String line ="";
		while(!line.equals("Over")) {
			try {
				line = in.readUTF();
				System.out.println(line	);
			}
			catch(IOException i){
				System.out.println(i);
			}
		}
		}
			 
		catch(IOException i)
		{
			System.out.println(i);
			
		}
		
	}
	public static void main(String args[]) {
		server_connection server = new server_connection(8080);
	}
}
