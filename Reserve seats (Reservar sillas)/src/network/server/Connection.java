package network.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class Connection implements Runnable{

	private Socket socket;
	private DataOutputStream output;
	private DataInputStream input;
	private Thread thread;
	private Server server;
	
	public Connection(Socket socket, Server server) throws UnknownHostException, IOException {
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
				sendSeats();
				TimeUnit.SECONDS.sleep(3);
				if (input.available() > 0) {
					server.getSeats()[input.readInt()][input.readInt()] = 1;
				}
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sendSeats() throws IOException {
		for (int i = 0; i < server.getSeats().length; i++) {
			for (int j = 0; j < server.getSeats().length; j++) {
				output.writeInt(server.getSeats()[i][j]);
			}
		}
		output.writeUTF(LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond());
	}
}
