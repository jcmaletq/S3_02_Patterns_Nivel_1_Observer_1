package app;

import Bolsa.*;
import agencias.*;
/*
 * Observer
 * Dissenya un sistema en el qual un Agent de Borsa (Observable) notifica a diverses agències de Borsa (Observers) 
 * canvis quan la Borsa puja o baixa.
 * Serà necessari que l'objecte Observable mantingui referències als Observers.
 * Encara que ha estat deprecada a partir de Java 9, pot utilitzar la interfície java.util.Observer si ho desitges
 */
public class app_main {

	public static void main(String[] args) {
		
// el registro lo hago en el main, pues registro 
		//	distintas agencias en distintos agentes.

	// inicializa agentes y agencias	
		
		Agente_Bolsa_observable agente1 = new Agente_Bolsa_observable("agente1","A1");
	    	agente1.registra(new agencia_bolsa_Observadores("agencia1","Ag1"));
		    agente1.registra(new agencia_bolsa_Observadores("agencia2","Ag2"));
		    agente1.registra(new agen_banca_bolsa_Observadores("banco1","Ba1"));
		Agente_Bolsa_observable agente2 = new Agente_Bolsa_observable("agente2","A2");
		    agente2.registra(new agencia_bolsa_Observadores("agencia3","Ag3"));
		    agente2.registra(new agencia_bolsa_Observadores("agencia4","Ag4"));
  // notificaciones
	  
	 for (int i=1 ; i<11; i++) {
		 System.out.println();
		 System.out.println("bucle eventos: "+ i);
		  agente1.notifica();
		  agente2.notifica();
	 }
	}

}
