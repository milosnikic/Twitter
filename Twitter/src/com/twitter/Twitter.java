package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * <h1>Twitter</h1> Ova klasa sluzi za manipulaciju porukama.
 * 
 * @author Milos Nikic
 * @version 1.1
 * @since 07.04.2017.
 */
public class Twitter {

	/**
	 * Lista poruka.
	 */

	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();

	/**
	 * Metoda koja vraca listu svih poruka.
	 * 
	 * @return listu poruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}

	/**
	 * Metoda za unos poruka u listu. Pravi se nova poruka i puni podacima.
	 * Poruka se unosi u listu na kraj.
	 * 
	 * @param korisnik
	 *            ime korisnika
	 * @param poruka
	 *            poruka tog korisnika
	 */
	public void unesi(String korisnik, String poruka) {

		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);

		poruke.addLast(tp);
	}

	/**
	 * Metoda koja vraca poruke koje sadrze odredjeni tag. Ako je maksmalni broj
	 * poruka manji ili jednak nuli, automatski se postavlja na 100 poruka.
	 * Kreira se pomocni niz u koji se smestaju poruke koje zadovoljavaju
	 * uslov(sadrze tag). Kada se prekoraci maksimalni broj poruka, pretraga se
	 * prekida.
	 * 
	 * @param maxBroj
	 *            maksimalni broj poruka
	 * @param tag
	 *            koji je potrebno da poruka sadrzi
	 * @return niz poruka koje sadrze trazeni tag
	 * @throws java.lang.RuntimeException
	 *             ako je tag null ili prazan string
	 */

	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");

		if (maxBroj <= 0)
			maxBroj = 100;

		int brojac = 0;

		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];

		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}
}