package Bolsa;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import agencias.*;
public class Bolsa_sujeto_observado implements sujeto_observado{
	private String bolsa;
	private double valor_actual;
	private double valor_anterior;
	private String tendencia;
	private ThreadLocalRandom delta = ThreadLocalRandom.current();
	public List<Abs_Observadores> agencias = new ArrayList<>();	
	public Bolsa_sujeto_observado (String bolsa) {
		valor_actual = delta.nextInt(0,100);
		valor_anterior = 0;
		tendencia = "inicial";
		this.setBolsa(bolsa);
	}
	  @Override
	  public void registra(Abs_Observadores agen) {
		  agencias.add(agen);
		  System.out.println("agencia: "+ agen 
				  + " bolsa: " + getBolsa() 
				  + " valor inicial : " + getValor_actual());
	  }	
@Override
	public void bolsa_actualiza() {
		int r_delta ;
	//	ThreadLocalRandom delta = ThreadLocalRandom.current();
		r_delta = delta.nextInt(0,10);
		if(getValor_actual()==getValor_anterior()) {setTendencia("igual");}
		else if((r_delta % 2)== 0) {
			setValor_anterior(getValor_actual());
			setValor_actual(getValor_actual()+(getValor_actual()*r_delta/100));
			setTendencia("sube");
		}
		else {
			setValor_anterior(getValor_actual());
			setValor_actual(getValor_actual()-(getValor_actual()*r_delta/100));
			setTendencia("baja");
		}
	}
@Override
	public double getValor_actual() {
		return valor_actual;
	}
@Override
	public String getTendencia() {
		return tendencia;
	}
@Override	
	public String getBolsa() {
		return bolsa;
	}
//  metodos internos
    void setBolsa(String bolsa) {
		this.bolsa = bolsa;
	}
	void setValor_actual(double valor_actual) {
		this.valor_actual = valor_actual;
	}
	 double getValor_anterior() {
		return valor_anterior;
	}
	void setValor_anterior(double valor_anterior) {
		this.valor_anterior = valor_anterior;
	}
	void setTendencia(String tendencia) {
		this.tendencia = tendencia;
	}	
}
