package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {

	AutoGuma ag;

	@BeforeEach
	void setUp() throws Exception {
		ag = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		ag = null;
	}

	@Test
	void testAutoGuma() {
		ag = new AutoGuma();
		
		assertNotNull(ag);
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		ag = new AutoGuma("Kingstar", 14, 175, 70);
		
		assertNotNull(ag);
		assertEquals("Kingstar", ag.getMarkaModel());
		assertEquals(14, ag.getPrecnik());
		assertEquals(175, ag.getSirina());
		assertEquals(70, ag.getVisina());

	}

	@Test
	void testSetMarkaModel() {
		ag.setMarkaModel("Kingstar");
		
		assertEquals("Kingstar", ag.getMarkaModel());
	}

	@Test
	@DisplayName("Testira ako je uneto null umesto marke i modela")
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class, () -> ag.setMarkaModel(null));
	}

	@Test
	@DisplayName("Testira ako je duzina unetog Stringa za marku i model manja od 3")
	void testSetMarkaModelKratakString() {
		assertThrows(java.lang.RuntimeException.class, () -> ag.setMarkaModel("Ki"));
	}

	@ParameterizedTest
	@CsvSource({ "13", "17", "22" })
	void testSetPrecnik(int p) {
		ag.setPrecnik(p);
		assertEquals(p, ag.getPrecnik());
	}

	@Test
	@DisplayName("Testira ako je uneti precnik ispod opsega")
	void testSetPrecnikIspodOpsega() {
		assertThrows(java.lang.RuntimeException.class, () -> ag.setPrecnik(12));
	}

	@Test
	@DisplayName("Testira ako je uneti precnik iznad opsega")
	void testSetPrecnikIznadOpsega() {
		assertThrows(java.lang.RuntimeException.class, () -> ag.setPrecnik(23));
	}

	@ParameterizedTest
	@CsvSource({ "135", "200", "355" })
	void testSetSirina(int s) {
		ag.setSirina(s);
		assertEquals(s, ag.getSirina());
	}

	@Test
	@DisplayName("Testira ako je uneta sirina ispod opsega")
	void testSetSirinaIspodOpsega() {
		assertThrows(java.lang.RuntimeException.class, () -> ag.setSirina(134));
	}

	@Test
	@DisplayName("Testira ako je uneta sirina iznad opsega")
	void testSetSirinaIznadOpsega() {
		assertThrows(java.lang.RuntimeException.class, () -> ag.setSirina(356));
	}

	@ParameterizedTest
	@CsvSource({ "25", "50", "95" })
	void testSetVisina(int v) {
		ag.setVisina(v);
		assertEquals(v, ag.getVisina());
	}

	@Test
	@DisplayName("Testira ako je uneta visina ispod opsega")
	void testSetVisinaIspodOpsega() {
		assertThrows(java.lang.RuntimeException.class, () -> ag.setVisina(24));
	}

	@Test
	@DisplayName("Testira ako je uneta visina iznad opsega")
	void testSetVisinaIznadOpsega() {
		assertThrows(java.lang.RuntimeException.class, () -> ag.setVisina(96));
	}

	@Test
	void testToString() {
		ag.setMarkaModel("Kingstar");
		ag.setPrecnik(16);
		ag.setSirina(200);
		ag.setVisina(60);

		String s = ag.toString();

		assertTrue(s.contains("Kingstar"));
		assertTrue(s.contains("16"));
		assertTrue(s.contains("200"));
		assertTrue(s.contains("60"));
	}

	@ParameterizedTest
	@CsvSource({ 	
		"Kingstar, 16, 200, 60, Kingstar, 16, 200, 60, true",
		
		"Kingstar, 16, 200, 60, Kingstar, 16, 200, 59, false",
		"Kingstar, 16, 200, 60, Kingstar, 16, 199, 60, false",
		"Kingstar, 16, 200, 60, Kingstar, 15, 200, 60, false",
		"Kingstar, 16, 200, 60, King, 16, 200, 60, false",
		
		"Kingstar, 16, 200, 60, King, 15, 200, 60, false",
		"Kingstar, 16, 200, 60, King, 16, 199, 60, false",
		"Kingstar, 16, 200, 60, King, 16, 200, 59, false",
		"Kingstar, 16, 200, 60, Kingstar, 15, 199, 60, false",
		"Kingstar, 16, 200, 60, Kingstar, 15, 200, 59, false",
		"Kingstar, 16, 200, 60, Kingstar, 16, 199, 59, false",
		
		"Kingstar, 16, 200, 60, King, 15, 199, 60, false",
		"Kingstar, 16, 200, 60, King, 15, 200, 59, false",
		"Kingstar, 16, 200, 60, King, 16, 199, 59, false",
		"Kingstar, 16, 200, 60, Kingstar, 15, 199, 59, false",
		
		"Kingstar, 16, 200, 60, King, 15, 199, 59, false" 
		})
	void testEqualsObject(String m1, int p1, int s1, int v1, String m2, int p2, int s2, int v2, boolean eq) {
		ag.setMarkaModel(m1);
		ag.setPrecnik(p1);
		ag.setSirina(s1);
		ag.setVisina(v1);

		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel(m2);
		ag2.setPrecnik(p2);
		ag2.setSirina(s2);
		ag2.setVisina(v2);

		assertEquals(eq, ag.equals(ag2));
	}

}
