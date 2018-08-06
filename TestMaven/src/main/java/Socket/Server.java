package Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Server extends Thread{

	@Override
	public void run() {
		try {
			ServerSocket server = new ServerSocket(47777);
			while(true){
				Socket clntSocket = server.accept();
				SocketAddress clntAddress = clntSocket.getRemoteSocketAddress();
				System.out.println("Client Adress:" + clntAddress);
				InputStream input = clntSocket.getInputStream();
				OutputStream output = clntSocket.getOutputStream();
				
				int recvMsgSize;
				byte[] receveBuf = new byte[32];
				StringBuffer sb = new StringBuffer();
				while((recvMsgSize = input.read(receveBuf)) != -1){
					String temp = new String(receveBuf);
					sb.append(temp);
					output.write(receveBuf);
				}
				
				System.out.println(sb);
				clntSocket.close();
				
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server();
		server.start();
	}

}
