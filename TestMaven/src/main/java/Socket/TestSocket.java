package Socket;

public class TestSocket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread client = new Client();
		Thread server = new Server();
		server.start();
		client.start();
	}

}
