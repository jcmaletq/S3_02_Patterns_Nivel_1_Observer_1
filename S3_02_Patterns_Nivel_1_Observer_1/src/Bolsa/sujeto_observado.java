package Bolsa;

import agencias.*;

public interface sujeto_observado {
	
	public void bolsa_actualiza();
	public double getValor_actual();
	public String getTendencia();
	public String getBolsa() ;
//	public void registra (agencia_bolsa_Observadores agen);
	public void registra (Abs_Observadores agen);

}
