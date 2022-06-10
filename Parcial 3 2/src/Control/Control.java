package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.Timer;

import model.queue.ImageQueue;
import model.queue.Node;
import model.stack.StackService;
import view.Peanut;

public class Control implements ActionListener {

	private Peanut peanut;
	private File path;
	private ImageQueue queue;
	private ArrayList<StackService> stacks;
	private int count;

	public Control() {
		count = 0;
		stacks = new ArrayList<StackService>();
		path = null;
		queue = new ImageQueue();
		peanut = new Peanut(this);
		initTimer();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case ADD:
			addImage();
			break;
		case UNDO:
			undo(Integer.parseInt((((JComponent) e.getSource()).getName())));
			break;
		}
	}

	private void undo(int id) {
		try {
			stacks.get(id).pop();
			peanut.repaint();
			peanut.revalidate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addImage() {
		JFileChooser fileChooser = new JFileChooser();
		int seleccion = fileChooser.showOpenDialog(fileChooser);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			path = fileChooser.getSelectedFile();
			peanut.getLeftPanel().addElement(path.getName());
			try {
				queue.addNode(new Node(ImageIO.read(new File(path.getPath()))));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void initTimer() {
		Timer timer = new Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (queue.getFirst() != null) {
					processImage();
				}
			}

		});
		timer.start();
	}

	private void processImage() {
		BufferedImage actual = queue.getFirst().getImage();
		peanut.getCenterPanel().setImagePrincipal(actual, true);
//		peanut.getCenterPanel().getPrincipalImage().paintImages(actual);
		if (queue.getFirst() != null) {
			queue.deleteHead();
			peanut.getLeftPanel().deleteElement(0);
			try {
				if (stacks != null) {
					stacks.add(peanut.getCenterPanel().getPrincipalImage().getImageStack());
					peanut.getCenterPanel().getCenterSouth().addCard(stacks.get(count).peek(), String.valueOf(count));
					count++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void addBurned(String path) {
		try {
			peanut.getLeftPanel().addElement(path);
			queue.addNode(new Node(ImageIO.read(new File(path))));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Control xd = new Control();
		xd.addBurned("src/images/image1.jpg");
		xd.addBurned("src/images/image2.jpg");
		xd.addBurned("src/images/image1.jpg");
		xd.addBurned("src/images/image2.jpg");
		xd.addBurned("src/images/image1.jpg");
		xd.addBurned("src/images/image2.jpg");
		xd.addBurned("src/images/image1.jpg");
		xd.addBurned("src/images/image2.jpg");
	}
}
