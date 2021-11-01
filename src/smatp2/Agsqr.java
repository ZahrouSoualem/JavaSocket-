package smatp2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Agsqr  {


	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		try {
		Socket socket = new Socket ("localhost", 9090);
		
		int n=0;
		OutputStream output = socket.getOutputStream();
		DataOutputStream stream = new DataOutputStream(output);
		//OutputStreamWriter stream2 = new OutputStreamWriter(output);
		while(true) {
			
			int result = n*n;
			//stream2.write(1);
			
			stream.writeInt(result);
			stream.writeUTF("agsqr");
			//System.out.println(result);
			n++;
			Thread.sleep(1000);
		}
	}catch(Exception e) {
		
	}
		
	}
	
}