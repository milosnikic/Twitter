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
		
		
		
	}

	@Test
	public void testUnesi() {
		TwitterPoruka p = new TwitterPoruka();
		p.setKorisnik("Milos");
		p.setPoruka("Poruka");
		
		LinkedList<TwitterPoruka> poruke = new LinkedList<>();
		poruke.add(p);
		
		
	}

	@Test
	public void testVratiPoruke() {
		fail("Not yet implemented");
	}

}
