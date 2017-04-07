package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * 
 * Ova klasa sluzi za manipulaciju porukama.
 * 
 * @author Milos Nikic
 * @version %I% %G%
 * @since 07.04.2017.
 */
public class Twitter {
	
	/**
	 * Atributi klase su: 
	 * <ul>
	 * <li>LinkedList<TwitterPoruka> poruke (lista poruka)</li>
	 * </ul>
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();

	/**
	 * Metoda vraca listu svih poruka.
	 * @return poruke lista poruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}

	/**
	 * Metoda za unos poruka u listu. Pravi se nova poruka i puni podacima. Poruka se unosi u listu na kraj.
	 * @param korisnik ime korisnika
	 * @param poruka poruka tog korisnika
	 */
	public void unesi(String korisnik, String poruka) {
		
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);
		
		poruke.addLast(tp);
	}
	/**
	 * Metoda koja vraca poruke koje sadrze odredjeni tag.
	 * Ako je maksmalni broj poruka manji ili jednak nuli, automatski se postavlja na 100 poruka.
	 * Kreira se pomocni niz u koji se smestaju poruke koje zadovoljavaju uslov(sadrze tag).
	 * Kada se prekoraci maksimalni broj poruka, pretraga se prekida.
	 * 
	 * @param maxBroj maksimalni broj poruka
	 * @param tag koji je potrebno da poruka sadrzi
	 * @return niz poruka koje sadrze trazeni tag
	 * @throws java.lang.RuntimeException ako je tag null ili prazan string
	 */

	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac + 1] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}
}