package it.polito.tdp.librettovoti.model;

import java.util.*;

public class Libretto {		// svolge il ruolo di Modello, tranne il TestLibretto che dovrbbe fa at d na classe a sè, ma sono minuzie

	private List<Voto> voti;
	private Map <String, Voto> votiMap; //identityMap per i database

	public Libretto() {
		this.voti = new ArrayList<>();
		this.votiMap= new HashMap <>();
		

	}

	public void add(Voto v) {
		this.voti.add(v);
		this.votiMap.put(v.getNome(), v);
	}
	
/*	public String votiUguali (int punteggio) {
	
		//calcola una stringa che continene i voti, sarà poi il chiamante a stamparli
		
	}*/
	
	public List <Voto> listaVotiUguali (int punteggio){
		//restituisce solo i voti uguali al criterio
		List <Voto> risultato = new ArrayList <>();
		for(Voto v: this.voti)
			if(v.getVoto()==punteggio)
				risultato.add(v);
		return risultato;
	}
	
	public Libretto votiUguali(int punteggio) {
		Libretto risultato = new Libretto();
		for(Voto v: voti)
			if(v.getVoto()==punteggio)
			{
				risultato.add(v);
			//	risultato.voti.add(v); --> uguale
			}
		return risultato;
		
		
	}
	
	public boolean esisteDuplicato (Voto v) {
	/*	boolean trovato =false;
		for (Voto voto:this.voti)
			if(voto.getNome().equals(v.getNome()) && voto.getVoto()== v.getVoto())
			{
				trovato = true;
				break;
			}
		return trovato;*/
		
		Voto trovato = this.votiMap.get(v.getNome());
		if(trovato == null)
			return false;
		if(trovato.getVoto()==v.getVoto())
			return true;
		else 
			return false;
		
		
		
	}
	
	public boolean esisteConflitto (Voto v) {
		boolean trovato =false;
		for (Voto voto:this.voti)
			if(voto.getNome().equals(v.getNome()) && voto.getVoto()!= v.getVoto())
			{
				trovato = true;
				break;
			}
	
		return trovato;
		

		
	}
	
	
	/**
	 * Ricerca un voto corrispondente del corso di cui ho specificato il nome
	 * Se il corso non esiste restituisce null
	 * @param nomeCorso
	 * @return
	 */
	
	public Voto ricercaCorso (String nomeCorso) {
	/*	Voto risultato =null;
		for(Voto v: voti) 
			if(v.getNome().equals(nomeCorso))
				//non compareTo perchè mi dice prima o dopo --> va bene per gli ordinamenti
			{
				risultato = v;
				break;
			}
		return risultato;*/
		
		return this.votiMap.get(nomeCorso);
		
	}

	
	
	public String toString() {
		String s = "";
		for (Voto v : this.voti) {
			s += v.toString() + "\n";
		}
		return s;

	}

}
