package com.twitter.poruke;
/**<h1> Twitter poruka </h1>
 * 
 * Ova klasa se koristi kako bi se odredjena poruka povezala
 * sa odgovarajucim korisnikom.
 * 
 * @author Milos Nikic
 * @version %I% %G%
 * @since 07.04.2017.
 */
public class TwitterPoruka {
	/**
	 * Atributi klase su: 
	 * <ul>
	 * <li>String korisnik (naziv korisnika)</li>
	 * <li>String poruka (tekst poruke)</li>
	 * </ul>
	 */
	private String korisnik;
	private String poruka;

	/**
	 * Metoda koja vraca naziv korisnika
	 * @return korisnik naziv korisnika
	 */
	public String getKorisnik() {
		return korisnik;
	}

	/**
	 * Metoda koja kao ulazni parametar prima naziv korisnika
	 * i postavlja ga kao vrednost atributa korisnik.
	 * @param korisnik naziv korisnika koji zelimo da postavimo
	 * @throws java.lang.RuntimeException ako je ime korisnika null ili prazan string
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik.isEmpty())
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	/**
	 * Metoda vraca poruku za odgovarajuceg korisnika.
	 * @return poruka poruka odgovarajuceg korisnika
	 */
	public String getPoruka() {
		return poruka;
	}

	/**
	 * Metoda koja kao ulazni parametar prima tekst poruke i postavlja 
	 * je kao vrednost atributa. 
	 * @param poruka tekst poruke koji zelimo da postavimo
	 * @throws java.lang.RuntimeException ako je poruka null, prazan string 
	 * 		   ili sadrzi vise od 140 karaktera 
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.equals(new String("")) || poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	/**
	 * Redefinisana metoda toString koja vraca podatke za klasu TwitterPoruka.
	 */

	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
}
