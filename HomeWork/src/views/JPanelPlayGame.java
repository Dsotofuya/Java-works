package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import models.Enemy;
import models.Node;
import models.Ovni;
import models.RunEnum;

public class JPanelPlayGame extends JPanel {

	private static final long serialVersionUID = 1L;
	private final Image IMG_OVNI = new ImageIcon(getClass().getResource("/img/Ovni.gif")).getImage();
	private final Image IMG_UNIVERSE = new ImageIcon(getClass().getResource("/img/Universe.jpg")).getImage();
	
	
	private Ovni ovni;
	private Enemy enemy;
	private ArrayList<Node> levels;

	public JPanelPlayGame(Ovni ovni, Enemy enemy) {
		this.ovni = ovni;
		this.enemy = enemy;
	}

	public void moveFigure(RunEnum runEnum) {
		ovni.moveOvni(runEnum);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(IMG_UNIVERSE, 0, 0, getWidth(), getHeight(), this);
		paintOvni(g);
		paintLevels(g);
		paintEnemy(g);
	}

	private void paintOvni(Graphics g) {
		g.setColor(Color.RED);
		g.drawString(String.valueOf(ovni.getHealt()), ovni.x, ovni.y - 5);
		g.drawImage(IMG_OVNI, ovni.getPointX(), ovni.getPointY(), Ovni.SIZE, Ovni.SIZE, this);
	}

	private void paintLevels(Graphics g) {
		if (levels != null) {
			for (Node node : levels) {
				g.drawImage(image("/img/ast.png"),node.getLevel().x, node.getLevel().y, node.getLevel().width, node.getLevel().height, this);
			}
		}
	}

	private void paintEnemy(Graphics g) {
		g.drawImage(image("/img/Enemy.gif"), enemy.x, enemy.y, enemy.width, enemy.height, this);
	}

	private Image image(String pathName) {
		return new ImageIcon(getClass().getResource(pathName)).getImage();
	}

	public void updateGame(Ovni ovni, Enemy enemy) {
		this.ovni = ovni;
		this.enemy = enemy;
		repaint();
	}

	public void paintLevels(ArrayList<Node> levels) {
		this.levels = levels;
		repaint();
	}
}
