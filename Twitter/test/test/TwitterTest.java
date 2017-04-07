package test;

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
		TwitterPoruka p = new TwitterPoruka();
		TwitterPoruka p1 = new TwitterPoruka();

		p.setKorisnik("Milos");
		p.setPoruka("Poruka");

		p1.setKorisnik("Dragan");
		p1.setPoruka("Porukica");

		LinkedList<TwitterPoruka> poruke = new LinkedList<>();

		poruke.add(p);
		poruke.add(p1);

		t.setPoruke(poruke);

		assertEquals(poruke, t.vratiSvePoruke());

	}

	@Test
	public void testUnesi() {
		t.unesi("Milos", "Poruka");

		assertEquals("Milos", t.getPoruke().getLast().getKorisnik());
		assertEquals("Poruka", t.getPoruke().getLast().getPoruka());
	}

	@Test
	public void testVratiPoruke() {
		TwitterPoruka p = new TwitterPoruka();
		TwitterPoruka p1 = new TwitterPoruka();

		p.setKorisnik("Milos");
		p.setPoruka("Poruka");

		p1.setKorisnik("Dragan");
		p1.setPoruka("Porukica");

		LinkedList<TwitterPoruka> poruke = new LinkedList<>();

		poruke.add(p);
		poruke.add(p1);

		t.setPoruke(poruke);
		
		TwitterPoruka[] niz = new TwitterPoruka[2];
		niz[0] = p;
		niz[1] = p1;
		TwitterPoruka[] poredba = t.vratiPoruke(2, "Poruk");
		
		assertArrayEquals(niz, poredba);

	}
	
	@Test
	public void testVratiPorukeMaxManjeOdNula() {
		TwitterPoruka p = new TwitterPoruka();
		TwitterPoruka p1 = new TwitterPoruka();

		p.setKorisnik("Milos");
		p.setPoruka("Poruka");

		p1.setKorisnik("Dragan");
		p1.setPoruka("Porukica");

		LinkedList<TwitterPoruka> poruke = new LinkedList<>();

		poruke.add(p);
		poruke.add(p1);

		t.setPoruke(poruke);
		
		TwitterPoruka[] niz = new TwitterPoruka[100];
		//Postavljena je vrednost na sto, jer je tako odredjeno u metodi
		//da se maks broj postavlja na 100, sto je dimenzija niza.
		niz[0] = p;
		niz[1] = p1;
		TwitterPoruka[] poredba = t.vratiPoruke(-1, "Poruk");
		
		assertArrayEquals(niz, poredba);

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
