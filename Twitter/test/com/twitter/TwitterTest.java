package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.Twitter;
import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {

	private Twitter t;

	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void testVratiSvePoruke() {		
		t.unesi("Milos", "Poruka");
		t.unesi("Dragan", "Porukica");

		assertEquals("Milos", t.vratiSvePoruke().getFirst().getKorisnik());
		assertEquals("Poruka", t.vratiSvePoruke().getFirst().getPoruka());
		assertEquals("Dragan", t.vratiSvePoruke().getLast().getKorisnik());
		assertEquals("Porukica", t.vratiSvePoruke().getLast().getPoruka());
		
	}

	@Test
	public void testUnesi() {
		t.unesi("Milos", "Poruka");

		assertEquals("Milos", t.vratiSvePoruke().getLast().getKorisnik());
		assertEquals("Poruka", t.vratiSvePoruke().getLast().getPoruka());
	}

	@Test
	public void testVratiPoruke() {
		t.unesi("Milos", "Poruka");
		t.unesi("Dragan", "Porukica");
		
		
		TwitterPoruka[] poredba = t.vratiPoruke(2, "Poruk");
		
		assertEquals("Milos", poredba[0].getKorisnik());
		assertEquals("Poruka", poredba[0].getPoruka());
		assertEquals("Dragan", poredba[1].getKorisnik());
		assertEquals("Porukica", poredba[1].getPoruka());
	}
	
	@Test
	public void testVratiPorukeMaxManjeOdNula() {
		t.unesi("Milos", "Poruka");
		t.unesi("Dragan", "Porukica");
		
			
		TwitterPoruka[] poredba = t.vratiPoruke(-1, "Poruk");
		
		assertEquals("Milos", poredba[0].getKorisnik());
		assertEquals("Poruka", poredba[0].getPoruka());
		assertEquals("Dragan", poredba[1].getKorisnik());
		assertEquals("Porukica", poredba[1].getPoruka());

	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		t.vratiPoruke(100, null);

	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazan() {
		t.vratiPoruke(100, "");
	}

}
