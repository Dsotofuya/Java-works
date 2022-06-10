package View.Panels;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class discount_Panel extends JPanel{

	private static final long serialVersionUID = 4985466960122109757L;
	private JCheckBox discount_Pay_Cb;
	private JCheckBox discount_Boyaca_Cb;
	private JCheckBox discount_Public_Cb;
	
	public discount_Panel() {
		super();
		init();
		TitledBorder title = BorderFactory.createTitledBorder("Descuentos");
		title.setTitleColor(Color.BLUE);
		setBorder(title);
		setLayout(new GridLayout(2,2));
		add(discount_Pay_Cb);
		add(discount_Boyaca_Cb);
		add(discount_Public_Cb);
	}
	
	private void init() {
		discount_Pay_Cb = new JCheckBox("Pronto pago");
		discount_Boyaca_Cb = new JCheckBox("Matricula en Boyaca");
		discount_Public_Cb = new JCheckBox("Servicio Publico");
	}
	
	public void clean() {
		discount_Pay_Cb.setSelected(false);
		discount_Boyaca_Cb.setSelected(false);
		discount_Public_Cb.setSelected(false);
	}
	
	public boolean getPaidDiscount() {
		return discount_Pay_Cb.isSelected();
	}
	public boolean getLocationDiscount() {
		return discount_Boyaca_Cb.isSelected();
	}
	public boolean getPublicDiscount() {
		return discount_Public_Cb.isSelected();
	}
}
