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
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import model.Post;
import network.Services;
import view.Peanut;
import view.add.AddDialog;

public class Control implements ActionListener {

	private static final String PNG = "png";
	
	private ArrayList<Post> postList;
	private Peanut peanut;
	private Services conection;
	private AddDialog dialog;

	public Control() {
		conection = new Services();
		postList = new ArrayList<Post>();
		peanut = new Peanut(this, postList);
		dialog = new AddDialog(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case ADD:
			showAddDialog();
			break;
		case UPDATE:
			updateList();
			break;
		case CONTACT:
			contact();
			break;
		case FIND:
			processPost(e);
			break;
		case CREATE:
			createPost();
			break;
		default:
		}
	}

	private void showAddDialog() {
		dialog.clean();
		dialog.setVisible(true);
	}

	private void updateList() {
		try {
			postList = conection.requestList();
			updateGUI(postList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void updateGUI(ArrayList<Post> postList) {
		peanut.getLeft().getListPanel().updateList(postList);
	}
	
	private void contact() {
		try {
			conection.contact();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void processPost(ActionEvent e) {
		Post post = findPost(Integer.valueOf(((JComponent) e.getSource()).getName()));
		peanut.getRight().getPostPanel().fillPost(post.getTitle(), post.getPhotoPath(), post.getDescription(),
				post.getPhone());
	}

	private Post findPost(int id) {
		Post auxPost = null;
		for (Post post : postList) {
			if (id == post.getId()) {
				auxPost = post;
			}
		}
		return auxPost;
	}


	private void createPost() {
		try {
			conection.addPost(dialog.getTittleText(), processImage(), dialog.getDescriptionText(),
					dialog.getPhoneText());
			dialog.setVisible(false);
			updateList();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private byte[] processImage() {
		byte[] image = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ImageIO.write(getScaledImage(ImageIO.read(new File(dialog.getphtoText())), 270, 120), PNG, bos);
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

	public static void main(String[] args) {
		new Control();
	}
}
