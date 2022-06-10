package util;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import controller.Constants;

public class Utilities {
	public Icon resizeIcon(String path, int widht, int height) {
		ImageIcon fot = new ImageIcon(getClass().getResource(Constants.ICON_PATH + path));
		Icon icon = new ImageIcon(fot.getImage().getScaledInstance(widht, height, Image.SCALE_DEFAULT));
		return icon;
	}

}
