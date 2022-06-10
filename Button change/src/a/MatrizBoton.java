package a;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class MatrizBoton extends JFrame implements ActionListener {

	public MatrizBoton() {
		JToolBar barraHerramientas = new JToolBar();
		JLabel lblFilas = new JLabel();
		JLabel lblColumnas = new JLabel();
		txtColumnas = new JTextField();
		txtFilas = new JTextField();
		btnCrear = new JButton();
		panel = new JPanel( null );

		//Para que el JFrame cierre la aplicacion
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lblFilas.setText("Filas");
		barraHerramientas.add(lblFilas);

		txtFilas.setPreferredSize(new Dimension(50, 25));
		barraHerramientas.add(txtFilas);

		lblColumnas.setText("Columnas");
		barraHerramientas.add(lblColumnas);

		txtColumnas.setPreferredSize(new Dimension(50, 25));
		barraHerramientas.add(txtColumnas);

		btnCrear.setText("Crear");
		btnCrear.addActionListener(this);
		barraHerramientas.add(btnCrear);

		//Colocamos el JToolBar en la parte de arriba del JFrame
		this.add(barraHerramientas, BorderLayout.PAGE_START);

		//Se agrega el panel a boton
        this.add(panel, BorderLayout.CENTER);

		this.setSize(410, 330);
		//Permite que la ventana se coloque al centro de la pantalla
		this.setLocationRelativeTo(null);

	}

	public void actionPerformed( ActionEvent evt ) {
		//Se obtiene la cantidad de filas a crear como una cadena de caracter
		String f = txtFilas.getText();

		//Se obtiene la cantidad de columnas a crear como una cadena de caracter
        String c = txtColumnas.getText();
        
        //Se cambia de cadena de caracteres a numeros
        int filas = Integer.parseInt(f);
        int columnas = Integer.parseInt(c);
		
		//Eliminamos los anteriores botones
        panel.removeAll();

        //Se crea una matriz de botones segun las filas y columnas entrantes
        Boton [][] botones = new Boton[ filas ][ columnas ];
        
        //Se recorren las filas
        for( int fila = 0 ; fila < filas; fila++ )
        {
            //Estando en la fila se recorrer las columnas
            for( int columna = 0 ; columna < columnas; columna++ )
            {
                //Se crea el boton y se agrega a las celda de la matriz
                botones[fila][columna] = new Boton( 75 * columna, 30 * fila, 75, 30 );
                
                //Se da el nombre en forma de coordenada enviando la fila y columna
                botones[fila][columna].setNombre(fila, columna);
                
                //Se agrega el boton al panel
                panel.add( botones[fila][columna] );
            }
        }
        
        //Se actualiza el panel para que se vean los botones
		panel.updateUI();
	}                                        

	public static void main(String args[]) {
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
			ex.printStackTrace();
        }
		new MatrizBoton().setVisible(true);
    }

	JButton btnCrear;
	JTextField txtColumnas;
	JTextField txtFilas;
	JPanel panel;
}