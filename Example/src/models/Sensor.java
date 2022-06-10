package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JOptionPane;

public class Sensor implements Runnable{

	private Thread thread;
	private boolean sensorOn;

	public Sensor() {
		thread = new Thread(this);
		thread.start();
		sensorOn = true;
	}

	@Override
	public void run() {
		try {
			while (sensorOn) {
				Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.73", 8080));
				URLConnection conn = new URL("https://store.steampowered.com/stats/?l=spanish").openConnection(proxy);
				BufferedReader in = new BufferedReader(
						new InputStreamReader(conn.getInputStream()));
				String line;
				while ((line = in.readLine()) != null) {
					int start = line.indexOf("currentServers");
					if (start != -1) {
						String value = line.substring(start + 16);
						value = value.substring(0, value.indexOf("<"));
						System.out.println(value);
					}
				}
				in.close();
				System.out.println("------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void stop() {
		sensorOn = false;
	}

	public static void main(String[] args) {
		Sensor sensor = new Sensor();
		int option = JOptionPane.showConfirmDialog(null, "¿Detener?");
		if (option == JOptionPane.OK_OPTION) {
			sensor.stop();
		}
	}
}
