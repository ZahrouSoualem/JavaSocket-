package smatp2;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.*;



public class agclassserver {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ArrayList<Integer> array  = new ArrayList<Integer>();
		ArrayList<Integer> arraySQR  = new ArrayList<Integer>();
		ArrayList<Integer> arrayFibo  = new ArrayList<Integer>();
		ArrayList<ClassesHandler> classes_handler  = new ArrayList<ClassesHandler>();
		ExecutorService service= Executors.newFixedThreadPool(10);
		
        boolean var=true;
        int message;
        
			try {	
				ServerSocket server = new ServerSocket(9090);
                while(true) {
                	
            		System.out.println("I waiting for the client ");
            		Socket socket = server.accept();// waiting for client to connect with server
            		String hostName = socket.getInetAddress().getHostName();
            		ClassesHandler client = new ClassesHandler(socket,array,arraySQR,arrayFibo,hostName);
            		classes_handler.add(client);
            		service.execute(client);
            		
				}
			}catch (Exception e) {
				
				
			}	
				


	}

}
