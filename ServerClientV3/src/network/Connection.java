package network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;

public class Connection implements Runnable{

	private Socket socket;
	private DataOutputStream output;
	private Thread thread;

	public Connection(Socket socket) throws UnknownHostException, IOException {
		this.socket = socket;
		output = new DataOutputStream(this.socket.getOutputStream());
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while(true) {
			try {
				sendMessageTime();
				TimeUnit.SECONDS.sleep(5);
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void sendMessageTime() throws IOException {
		output.writeUTF(Responses.INFO.toString());
		JSONObject timeData = new JSONObject();
		timeData.put("hour", LocalTime.now().getHour());
		timeData.put("second", LocalTime.now().getSecond());
		timeData.put("server", "Time UPTC");
		output.writeUTF(timeData.toJSONString());
	}
}
