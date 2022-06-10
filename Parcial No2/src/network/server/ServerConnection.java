package network.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class ServerConnection implements Runnable{

	private Socket socket;
	private DataOutputStream output;
	private DataInputStream input;
	private Thread thread;
	private ServerLive server;
	
	public ServerConnection(Socket socket, ServerLive server) throws UnknownHostException, IOException {
		this.server = server;
		this.socket = socket;
		output = new DataOutputStream(this.socket.getOutputStream());
		input = new DataInputStream(socket.getInputStream());
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while(true) {
			try {
				senInfo();
				TimeUnit.SECONDS.sleep(3);
				if (input.available() > 0) {
//					genericMetoth();
				}
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void senInfo() throws IOException {
		output.writeUTF(LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond());
	}
}
