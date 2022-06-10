package co.edu.uptc.views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.border.Border;


public class JFMainWindow extends JFrame {

	private PanelSillas sillas;
	private PanelUsuario usuario;
	private PanelSur panelSur;
	private PanelWest west;
	private PanelNorte norte;
	private PanelCentro centro;
	private Eventos eventos;
	
	

	public PanelCentro getCentro() {
		return centro;
	}

	public void setCentro(PanelCentro centro) {
		this.centro = centro;
	}

	public JFMainWindow() {
		// titulo
		setTitle("SALA DE CINE");
		// tamaño
		setSize(500,400);
		// pOsiscion
		setResizable(false);
		this.setLocationRelativeTo(null);
		// color
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.BLACK);
		// layouts
		setLayout(new BorderLayout());
		eventos = new Eventos(this);
		this.initComponents();
		this.setVisible(true);
	}

	public void initComponents() {
		centro = new PanelCentro(this);
		centro.setBackground(Color.red);
		add(centro, BorderLayout.CENTER);
		west = new PanelWest(this);
		west.setBackground(Color.red);
		add(west,BorderLayout.WEST);
		panelSur = new PanelSur(this);
		panelSur.setBackground(Color.red);
		add(panelSur,BorderLayout.SOUTH);
		norte = new PanelNorte(this);
		norte.setBackground(Color.red);
		add(norte, BorderLayout.NORTH);

	}

//	public Person hacerPersona(){
//		return west.hacerPersona();
//		 } 
	
	public PanelSillas getSillas() {
		return sillas;
	}

	public void setSillas(PanelSillas sillas) {
		this.sillas = sillas;
	}

	public PanelUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(PanelUsuario usuario) {
		this.usuario = usuario;
	}

	public Eventos getEventos() {
		return eventos;
	}

	public void setEventos(Eventos eventos) {
		this.eventos = eventos;
	}

	
	
	
	
}
