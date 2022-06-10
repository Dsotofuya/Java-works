package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PeanutFrame extends JFrame{
	private static final long serialVersionUID = -6055824919055012884L;

	private static final String ICON_PATH = "src/data/icon.png";
	
	private ContenPanel imagePanel;
	private ContenPanel image2Panel;
	private CanvasPanel canvasPanel;
	private BarsPanel barsPanel;
	private String textToPaint;
	
	public PeanutFrame(ActionListener control, String text, int percentOne, int percentTwo) {
		super("Process app");
		this.textToPaint = text;
		setIconImage(new ImageIcon(ICON_PATH).getImage());
		setSize(860, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		canvasPanel = new CanvasPanel(textToPaint);
		imagePanel = new ContenPanel(canvasPanel, control);
		add(imagePanel, BorderLayout.WEST);

		barsPanel = new BarsPanel(percentOne, percentTwo);
		image2Panel = new ContenPanel(barsPanel, control);
		add(image2Panel, BorderLayout.EAST);

		setVisible(true);
	}
	
	public CanvasPanel getCanvasPanel() {
		return canvasPanel;
	}
	
	public void setTextToPaint(String textToPaint) {
		this.textToPaint = textToPaint;
	}
	
	public String getTextToPaint() {
		return textToPaint;
	}
	
}