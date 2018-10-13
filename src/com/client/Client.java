package com.client;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

class Client
{
	private static Socket socket = null;
	private static ObjectInputStream ois = null;
	private static ObjectOutputStream oos = null;
	
	public static void main(String args[]) throws ClassNotFoundException,IOException
	{
		InetAddress host = InetAddress.getLocalHost();
		for(int i=0; i<=5; i++)
		{
			socket = new Socket("127.0.0.1",9876);
			
			oos = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("Sending request to Server");
			if(i==5)
			{
				oos.writeObject("exit");
				
			}
			else
			{
				oos.writeObject("  " + i);
			}
			ois = new ObjectInputStream(socket.getInputStream());
			String message = (String)ois.readObject();
			System.out.println("Message recieved " + message);
			ois.close();
			oos.close();
			socket.close();
		}
			
			
	}
}