package Bolsa;

import java.util.*;
import javax.swing.JOptionPane;
import agencias.*;
public class Agente_Bolsa_observable  extends Bolsa_sujeto_observado 
          implements observable {
  private String nombre;
  private String codigo;
  public Agente_Bolsa_observable(String nombre,String codigo) {
	super(JOptionPane.showInputDialog
			("introudce la bolsa para "+ nombre,"Ibex, Nasdac").toUpperCase());
  	this.nombre = nombre;
  	this.codigo = codigo;
  	
  }

  @Override
  public void notifica() {
	  System.out.println("informe de : "+this); 
	bolsa_actualiza();
	// solo envia si hay cambios
	for (Abs_Observadores agen : agencias) {
		if (!getTendencia().equals("igual")) {
		agen.recibido(getValor_actual(),getTendencia());}	
		else {System.out.println("bolsa estable");}
	}
	
}
@Override
public String toString() {
	return "nombre= " + nombre 
			+ ", codigo= " + codigo 
			+ ", bolsa= " + getBolsa()
			;
}

}
