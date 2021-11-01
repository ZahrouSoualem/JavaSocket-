package smatp2;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;

public class ClassesHandler implements Runnable {
	
	
	
	private Socket socket;
	private int message;
	ArrayList<Integer> array  = new ArrayList<Integer>();
	ArrayList<Integer> arraySQR  = new ArrayList<Integer>();
	ArrayList<Integer> arrayFibo  = new ArrayList<Integer>();
	private String hostname;
	
    private DataInputStream dataInputStream;
	public ClassesHandler(Socket socket,ArrayList<Integer> array,ArrayList<Integer> arraySQR,ArrayList<Integer> arrayFibo, String hostname) throws IOException{
		this.socket = socket;
		dataInputStream = new DataInputStream(socket.getInputStream());
		this.array = array;
		this.arraySQR = arraySQR;
		this.arrayFibo = arrayFibo;
		this.hostname = hostname;
		
	}
	//InputStreamReader read= new InputStreamReader(socket.getInputStream());

	private int message2;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				message = dataInputStream.readInt();
				String s = dataInputStream.readUTF();
				if(s.equals("agsqr")) {
					arraySQR.add(message);
				}else if(s.equals("agfibo")) {
					arrayFibo.add(message);
				}
				array.add(message);// waiting for client to connect with server
				Collections.sort(array);
				System.out.println(s + "add number " +message);
				System.out.println("AgSqr = " + arraySQR);
				System.out.println("AgFib = " + arrayFibo);
				System.out.println("AgClass =" +array);
				System.out.println();
				Thread.sleep(500);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
