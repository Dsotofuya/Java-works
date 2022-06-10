package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Figura.Pelota;
import Figura.RaquetaAbajo;
import Figura.RaquetaArriba;

public class PanelObjects extends JPanel {
	private static final long serialVersionUID = 1L;

	private Pelota pelota;
	private RaquetaAbajo raquetaAbajo;
	private RaquetaArriba raquetaArriba;
	private int puntos = 0;

	private String Score1 = null, Score2 = null, Score3 = null, Score4 = null, Score5 = null;

	private int[] scores = new int[5];

	public PanelObjects() {
		pelota = new Pelota(this);
		raquetaAbajo = new RaquetaAbajo(this);
		raquetaArriba = new RaquetaArriba(this);
		setBackground(Color.GRAY);
	}

	public void move() {
		pelota.mover();
		raquetaAbajo.mover();
		raquetaArriba.mover();
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.DARK_GRAY);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString("Puntuación: " + String.valueOf(puntos), 150, 35);
		pelota.paint(g);
		raquetaAbajo.paint(g);
		raquetaArriba.paint(g);
	}

	public void gameOver() {
		savescores();
		organizeScores();
		invertirScores();
		JOptionPane.showMessageDialog(this,"Puntaje de esta partida: " + puntos +
											"\n Puntajes mas altos: " + Arrays.toString(scores), "Juego terminado", JOptionPane.YES_NO_OPTION);
		// removeAll();
		pelota.setX(50);
		pelota.setY(50);
		pelota.setxA(1);
		pelota.setyA(1);
		raquetaArriba.setX(0);
		raquetaAbajo.setX(0);
		pelota.setPoints(-1);
		// revalidate();
		repaint();
	}

	public void savescores() {
		if (Score1 == null) {
			Score1 = String.valueOf(puntos);
			scores[0] = Integer.parseInt(Score1);
		} else if (Score1 != null && Score2 == null) {
			Score2 = String.valueOf(puntos);
			scores[1] = Integer.parseInt(Score2);
		} else if (Score2 != null && Score3 == null) {
			Score3 = String.valueOf(puntos);
			scores[2] = Integer.parseInt(Score3);
		} else if (Score3 != null && Score4 == null) {
			Score4 = String.valueOf(puntos);
			scores[3] = Integer.parseInt(Score4);
		} else if (Score4 != null && Score5 == null) {
			Score5 = String.valueOf(puntos);
			scores[4] = Integer.parseInt(Score4);
		}

	}

	public void organizeScores() {
		int buffer;
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < i; j++) {
				if (scores[i] < scores[j]) {
					buffer = scores[j];
					scores[j] = scores[i];
					scores[i] = buffer;
				}
			}
		}
	}
	
	public void invertirScores() {
		int b = 5;
		for (int i = 0; i <= b/2; i++) {
			int aux = scores[i];
			scores[i] = scores[b-1];
			scores[b-1] = aux;
			b--;
		}
	}

	public Pelota getPelota() {
		return pelota;
	}

	public RaquetaAbajo getRaquetaAbajo() {
		return raquetaAbajo;
	}

	public RaquetaArriba getRaquetaArriba() {
		return raquetaArriba;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

}
