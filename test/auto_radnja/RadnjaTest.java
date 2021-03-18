package auto_radnja;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;

import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {

	protected Radnja radnja;

	@Test
	void testDodajGumu() {
		AutoGuma ag1 = new AutoGuma();
		ag1.setMarkaModel("Kingstar");
		ag1.setPrecnik(16);
		ag1.setSirina(200);
		ag1.setVisina(60);
		radnja.dodajGumu(ag1);

		assertEquals(1, radnja.getGume().size());
		assertEquals(ag1, radnja.getGume().get(0));

	}

	@Test
	void testDodajGumuNull() {
		assertThrows(java.lang.NullPointerException.class, () -> radnja.dodajGumu(null));

	}

	@Test
	void testDodajGumuDuplikat() {

		AutoGuma ag1 = new AutoGuma();
		ag1.setMarkaModel("Kingstar");
		ag1.setPrecnik(16);
		ag1.setSirina(200);
		ag1.setVisina(60);

		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Kingstar");
		ag2.setPrecnik(16);
		ag2.setSirina(200);
		ag2.setVisina(60);

		radnja.dodajGumu(ag1);

		RuntimeException ex = assertThrows(java.lang.RuntimeException.class, () -> radnja.dodajGumu(ag2));

		assertEquals("Guma vec postoji", ex.getMessage());

	}

	@Test
	void testPronadjiGumu() {

		AutoGuma ag1 = new AutoGuma();
		ag1.setMarkaModel("Kingstar");
		ag1.setPrecnik(16);
		ag1.setSirina(200);
		ag1.setVisina(60);

		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("King");
		ag2.setPrecnik(16);
		ag2.setSirina(200);
		ag2.setVisina(60);

		AutoGuma ag3 = new AutoGuma();
		ag3.setMarkaModel("King");
		ag3.setPrecnik(15);
		ag3.setSirina(199);
		ag3.setVisina(59);

		radnja.dodajGumu(ag1);
		radnja.dodajGumu(ag2);
		radnja.dodajGumu(ag3);

		List<AutoGuma> rez = radnja.pronadjiGumu("Kingstar");

		assertEquals(1, rez.size());
		assertTrue(rez.contains(ag1));

	}

	@Test
	void testPronadjiGumuMarkaModelNull() {
		assertEquals(null, radnja.pronadjiGumu(null));

	}

	@Test
	void testPronadjiGumuNePostoji() {
		AutoGuma ag1 = new AutoGuma();
		ag1.setMarkaModel("Kingstar");
		ag1.setPrecnik(16);
		ag1.setSirina(200);
		ag1.setVisina(60);

		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("King");
		ag2.setPrecnik(16);
		ag2.setSirina(200);
		ag2.setVisina(60);

		AutoGuma ag3 = new AutoGuma();
		ag3.setMarkaModel("King");
		ag3.setPrecnik(15);
		ag3.setSirina(199);
		ag3.setVisina(59);

		radnja.dodajGumu(ag1);
		radnja.dodajGumu(ag2);
		radnja.dodajGumu(ag3);

		List<AutoGuma> rez = radnja.pronadjiGumu("Nista");

		assertEquals(0, rez.size());

	}

	@Test
	void testPronadjiGumuIstaMarkaModelRazliciteDimenzije() {
		AutoGuma ag1 = new AutoGuma();
		ag1.setMarkaModel("Kingstar");
		ag1.setPrecnik(16);
		ag1.setSirina(200);
		ag1.setVisina(60);

		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("King");
		ag2.setPrecnik(16);
		ag2.setSirina(200);
		ag2.setVisina(60);

		AutoGuma ag3 = new AutoGuma();
		ag3.setMarkaModel("King");
		ag3.setPrecnik(15);
		ag3.setSirina(199);
		ag3.setVisina(59);

		radnja.dodajGumu(ag1);
		radnja.dodajGumu(ag2);
		radnja.dodajGumu(ag3);

		List<AutoGuma> rez = radnja.pronadjiGumu("King");

		assertEquals(2, rez.size());
		assertTrue(rez.contains(ag2));
		assertTrue(rez.contains(ag3));

	}

}
