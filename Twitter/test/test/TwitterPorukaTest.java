package test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterPorukaTest {
	private TwitterPoruka p;
	
	@Before
	public void setUp() throws Exception {
		p = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		p = null;
	}

	@Test
	public void testSetKorisnik() {
		p.setKorisnik("Milos");
		
		assertEquals("Milos", p.getKorisnik());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		p.setKorisnik(null);
		
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		p.setKorisnik("");
		
	}

	@Test
	public void testSetPoruka() {
		p.setPoruka("Ovo je poruka");
		
		assertEquals("Ovo je poruka", p.getPoruka());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		p.setPoruka(null);
		
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaPrazanString() {
		p.setPoruka("");

	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaPrekoracenje() {
		String poruka = "";
		for (int i = 0; i < 141; i++) {
			poruka += "a";
		}
		p.setPoruka(poruka);

	}
	@Test
	public void testToString() {
		p.setKorisnik("Milos");
		p.setPoruka("Ovo je poruka");
		
		assertEquals("KORISNIK:Milos PORUKA:Ovo je poruka", p.toString());
	}

}
