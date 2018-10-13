package com.client;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class Server
{
	public static void main(String args[]) throws ClassNotFoundException,IOException
	{
		ServerSocket server = null;
		Socket socket = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		server = new ServerSocket(9876);
		while(true)
		{
			System.out.println("Server is waiting for connection");
			socket = server.accept();
			System.out.println("Connection accepted");
			ois = new ObjectInputStream(socket.getInputStream());
			String message = (String)ois.readObject();
			System.out.println("Message recieved " + message);
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject("Hi client");
			ois.close();
			oos.close();
			socket.close();
			
			if(message.equalsIgnoreCase("exit"))
			{
				break;
			}
		
		} 
		server.close();
	}
}