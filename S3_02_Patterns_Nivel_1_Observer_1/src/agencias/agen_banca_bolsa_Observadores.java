package agencias;

import Bolsa.*;

//public class agencia_bolsa_Observadores implements Observadores {
public class agen_banca_bolsa_Observadores extends Abs_Observadores {
	private String nombre;
	private String codigo;
    public  agen_banca_bolsa_Observadores (String nombre,String codigo) {
    	this.nombre = nombre;
    	this.codigo = codigo;
    }
	@Override
	public void recibido (double valor_actual,String tendecia) {
		System.out.print("recibido: "+this.nombre);
		System.out.print(" valor actual : "+String.format("%.2f",valor_actual));
		System.out.println(" tendencia : "+ tendecia);
	}
	@Override
	public String toString() {
		return "nombre=" + nombre + ", codigo=" + codigo ;
	}

}
