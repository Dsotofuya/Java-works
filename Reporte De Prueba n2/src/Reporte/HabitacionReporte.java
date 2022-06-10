package Reporte;

public class HabitacionReporte implements GenericReporte, Imprimir{

	@Override
	public void generarReporte() {
		System.out.println("Se ha generado el reporte de la casa");
	}

	@Override
	public void imprimirExcel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void imprimirWord() {
		// TODO Auto-generated method stub
		
	}

}
