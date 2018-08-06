package Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client extends Thread {

	public void run(){
		try {
			System.out.println(InetAddress.getLocalHost().getHostAddress());
			Socket client = new Socket("127.0.0.1", 47777);
			InputStream input = client.getInputStream();
			OutputStream output = client.getOutputStream();
			byte[] data = "Data1".getBytes();
			output.write(data);
			byte[] receive = new byte[10];
			int receivedNumberTotal = 0;
			int receivedNumber = 0;
			while(( receivedNumber = input.read(receive, receivedNumberTotal, 10-receivedNumberTotal ) ) > 0){
				receivedNumberTotal += receivedNumber;
			}
			System.out.println("Client Receive: " + receive.toString());
			client.close();
		} catch ( Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}
		
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		
		Client clnt = new Client();
		clnt.start();
	}

}
