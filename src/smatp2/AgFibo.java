package smatp2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;



public class AgFibo  {
	
	
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		try {
			int number ; 
			 int previousNumber = 0;
			 int nextNumber = 1;
			 boolean variable=false ;
			Socket socket = new Socket ("localhost", 9090);
			OutputStream output = socket.getOutputStream();
			DataOutputStream stream = new DataOutputStream(output);
			//OutputStreamWriter stream2 = new OutputStreamWriter(output);
				while(true){
					//stream2.write(2);
					stream.writeInt(previousNumber);
					stream.writeUTF("agfibo");
					//System.out.println(previousNumber);
		           int sum = previousNumber + nextNumber;
		           previousNumber = nextNumber;
		           nextNumber = sum;	
		           //System.out.println(previousNumber);
		           Thread.sleep(1000);
		       }
			
		}catch(Exception e) {
			
		}
	}

}