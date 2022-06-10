package control;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import model.User;
import network.Connection;
import network.punto1.Services;
import view.Peanut;
import view.PeanutPunto2;

public class ControlPunto1 implements ActionListener {

	private Peanut peanut;
	private Services services;
	private ArrayList<User> userList;
	private PeanutPunto2 peanutPunto2;
	private Connection connection;

	public ControlPunto1() {
		peanut = new Peanut(this);
		peanutPunto2 = new PeanutPunto2(this);
		services = new Services();
		userList = new ArrayList<User>();
		try {
			connection = new Connection();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case GETLIST:
			getList();
			break;
		case REGISTER:
			register();
			break;
		default:
			break;
		}
	}

	private void register() {
		String name = peanutPunto2.getGenericPanel2().getNameText();
		String path = peanutPunto2.getGenericPanel2().getPhotoText();
		int number = Integer.parseInt(peanutPunto2.getGenericPanel2().getNumberText());
		connection.register(name, processImage(path), number);
	}

	private void getList() {
		try {
			userList = services.requestList();
			updateGUI();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void updateGUI() {
		try {
			peanut.getCards().fill(userList);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	private byte[] processImage(String path) {
		byte[] image = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ImageIO.write(getScaledImage(ImageIO.read(new File(path)), 270, 120), "png", bos);
			image = bos.toByteArray();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

	private BufferedImage getScaledImage(Image srcImg, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
		Graphics2D g2 = resizedImg.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();
		return resizedImg;
	}
	
	public Connection getConnection() {
		return connection;
	}

	public static void main(String[] args) {
		ControlPunto1 x = new ControlPunto1();
		x.getConnection().register("andres", x.processImage("src/data/icon.png"), 4);
	}

}
