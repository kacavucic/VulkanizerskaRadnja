package auto_radnja;

import java.util.LinkedList;

import auto_radnja.gume.AutoGuma;

/**
 * Interfejs koji predstavlja radnju.
 * 
 * @author Lenovo Yoga
 * @version 0.2
 */
public interface Radnja {

	/**
	 * Dodaje novu auto gumu u radnju.
	 * 
	 * @param a Auto guma koja se dodaje u radnju
	 * 
	 * <ul>
	 * 		<li>@throws java.lang.NullPointerException ako je uneta auto guma null</li>
	 * 		<li>@throws java.lang.RuntimeException ako uneta guma vec postoji u radnji</li>
	 * </ul>
	 */
	void dodajGumu(AutoGuma a);

	/**
	 * Pronalazi listu auto guma iz radnje na osnovu unete marke i modela.
	 * 
	 * @param markaModel Marka i model auto gume koja se pretrazuje
	 * <ul>
	 * 		<li>@return Lista auto guma koje zadovoljavaju kriterijum pretrage</li>
	 * 		<li>@return Null ako je uneta marka i model null</li>
	 * </ul>
	 */
	LinkedList<AutoGuma> pronadjiGumu(String markaModel);
}
