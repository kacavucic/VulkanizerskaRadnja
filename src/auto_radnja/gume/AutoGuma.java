package auto_radnja.gume;

/**
 * Klasa koja predstavlja auto gumu.
 * 
 * Auto guma ima marku i model kao String vrednost i precnik, sirinu i visinu kao int vrednosti.
 * 
 * @author Lenovo Yoga
 * @version 0.1
 *
 */
public class AutoGuma {
	
	/**
	 * Marka i model auto gume kao String.
	 */
	private String markaModel = null;
	
	/**
	 * Precnik auto gume kao int.
	 * 
	 * Default: -1
	 */
	private int precnik = -1;
	
	/**
	 * Sirina auto gume kao int.
	 * 
	 * Default: -1
	 */
	private int sirina = -1;
	
	/**
	 * Visina auto gume kao int.
	 * 
	 * Default: -1
	 */
	private int visina = -1;

	/**
	 * Konstruktor koji inicijalizuje objekat.
	 */
	public AutoGuma() {
	}

	/**
	 * Konstuktor koji inicijalizuje objekat i postavlja vrednosti za marku i model, precnik, sirinu i visinu.
	 * 
	 * @param markaModel Marka i model auto gume kao String
	 * @param precnik Precnik auto gume kao int
	 * @param sirina Sirina auto gume kao int
	 * @param visina Visina auto gume kao int
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}

	/**
	 * Vraca marku i model auto gume.
	 * 
	 * @return Marka i model auto gume kao String
	 */
	public String getMarkaModel() {
		return markaModel;
	}

	/**
	 * Postavlja atribut marka i model auto gume na novu vrednost. 
	 * 
	 * @param markaModel Marka i model auto gume kao String
	 * 
	 * @throws java.lang.NullPointerException ako je uneta marka i model null
	 * @throws java.lang.RuntimeException ako je uneta marka i model koja ima manje od 3 znaka
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length() < 3)
			throw new RuntimeException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}

	/**
	 * Vraca precnik auto gume.
	 * 
	 * @return Precnik auto gume kao int
	 */
	public int getPrecnik() {
		return precnik;
	}

	/**
	 * Postavlja precnik auto gume na novu vrednost.
	 * 
	 * @param precnik Precnik auto gume kao int
	 * 
	 * @throws java.lang.RuntimeException ako je unet precnik manji od 13 i veci od 22
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 || precnik > 22)
			throw new RuntimeException("Precnik van opsega");
		this.precnik = precnik;
	}

	/**
	 * Vraca sirinu auto gume.
	 * 
	 * @return Sirina auto gume kao int
	 */
	public int getSirina() {
		return sirina;
	}

	/**
	 * Postavlja sirinu auto gume na novu vrednost.
	 * 
	 * @param sirina Sirina auto gume kao int
	 * 
	 * @throws java.lang.RuntimeException ako je uneta sirina manja od 135 i veca od 355
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 || sirina > 355)
			throw new RuntimeException("Sirina van opsega");
		this.sirina = sirina;
	}

	/**
	 * Vraca visinu auto gume.
	 * 
	 * @return Visina auto gume kao int
	 */
	public int getVisina() {
		return visina;
	}

	/**
	 * Postavlja visnu auto gume na novu vrednost.
	 * 
	 * @param visina Visina auto gume kao int
	 * 
	 * @throws java.lang.RuntimeException ako je uneta visina manja od 25 ili veca od 95
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new RuntimeException("Visina van opsega");
		this.visina = visina;
	}

	/**
	 * @return Vraca String sa svim podacima o auto gumi
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="
				+ visina + "]";
	}

	/**
	 * Poredi dve auto gume i vraca true ako su iste, a false ako nisu.
	 * 
	 * Auto gume se porede po marki i modelu, precniku, sirini i visini i svi atributi moraju da budu isti.
	 * 
	 * @return 
	 * <ul>
	 * 		<li>true ako su oba objekta klase AutoGuma i imaju istu marku i model, precnik, sirinu i visinu</li>
	 * 		<li>false u svim ostalim slucajevima</li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}
}
