package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PartA {

	private static final String MUSIC_PATH = "src/data/music.wav";
	private Clip audio;
	private String text;
	private ConcurrentHashMap<Integer, BufferedImage> images;
	private int count;

	public PartA() {
		count = 0;
		images = new ConcurrentHashMap<Integer, BufferedImage>();
//		loadImages();
		text = "En el discurso inaugural de la Macworld Conference Expo en enero de 2007,"
				+ " Steve Jobs anunció un nuevo producto, el iPhone."
				+ " Un consultor de tecnología para una revista de consumidores quiere seleccionar 15"
				+ " dispositivos del lote piloto de 70 iPhones para inspeccionar la coordinación de funciones."
				+ "Use R para seleccionar una muestra de 15, registre para el taller los comandos R y la muestra resultado que obtuvo."
				+ "Describa un método para obtener una muestra aleatoria simple de 15 del lote de 70 iPhones."
				+ "En el discurso inaugural de la Macworld Conference Expo en enero de 2007,"
				+ " Steve Jobs anunció un nuevo producto, el iPhone."
				+ " Un consultor de tecnología para una revista de consumidores quiere seleccionar 15"
				+ " dispositivos del lote piloto de 70 iPhones para inspeccionar la coordinación de funciones.";
		startMusic();
	}

	public void startMusic() {
		Thread musicThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					audio = AudioSystem.getClip();
					File file = new File(MUSIC_PATH);
					audio.open(AudioSystem.getAudioInputStream(file));
					audio.start();
					audio.loop(Clip.LOOP_CONTINUOUSLY);
				} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
					e.printStackTrace();
				}
			}
		});
		musicThread.start();
	}

	public void pauseMusic() {
		audio.stop();
	}

	public void reanudeMusic() {
		audio.start();
	}

	private void loadImages() {
		for (int i = 1; i < 5; i++) {
			try {
				images.put(count, ImageIO.read(new File("src/data/" + i + ".png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String getText() {
		return text;
	}

	public ConcurrentHashMap<Integer, String> startProcess() {
		String[] paragraph = text.split(",");
		int count = 0;
		ConcurrentHashMap<Integer, String> partText = new ConcurrentHashMap<Integer, String>();
		for (String textxd : paragraph) {
			partText.put(count, textxd);
			count++;
		}
		return (ConcurrentHashMap<Integer, String>) partText;
	}
}
