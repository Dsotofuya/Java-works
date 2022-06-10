package algoritmo;

public class Bytes_Ints {

	
	public byte[] toByteArray(int value) {
	    return new byte[] { 
	            (byte)(value >> 24),
	            (byte)(value >> 16),
	            (byte)(value >> 8),
	            (byte)value };
	    }
	
	public int byteToBin(byte[] numero) {
		 return numero[0] << 24 | (numero[1] & 0xFF) << 16 | (numero[2] & 0xFF) << 8 | (numero[3] & 0xFF);
	}
}
