package FinalTest.zavrsniback.web.dto;


import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class TakmicenjeDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
	private Long id;

	private String naziv = "";

	@Size(max = 50)
	private String mestoOdrzavanja = "";

	private String datumPocetka;

	private String datumZavrsetka;

	private Long formatId;

	private String NazivFormata;
	
	private int brojUcesnika;

	
	/**
	 * @return the brojUcesnika
	 */
	public int getBrojUcesnika() {
		return brojUcesnika;
	}

	/**
	 * @param brojUcesnika the brojUcesnika to set
	 */
	public void setBrojUcesnika(int brojUcesnika) {
		this.brojUcesnika = brojUcesnika;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the naziv
	 */
	public String getNaziv() {
		return naziv;
	}

	/**
	 * @param naziv the naziv to set
	 */
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	/**
	 * @return the mestoOdrzavanja
	 */
	public String getMestoOdrzavanja() {
		return mestoOdrzavanja;
	}

	/**
	 * @param mestoOdrzavanja the mestoOdrzavanja to set
	 */
	public void setMestoOdrzavanja(String mestoOdrzavanja) {
		this.mestoOdrzavanja = mestoOdrzavanja;
	}

	/**
	 * @return the datumPocetka
	 */
	public String getDatumPocetka() {
		return datumPocetka;
	}

	/**
	 * @param datumPocetka the datumPocetka to set
	 */
	public void setDatumPocetka(String datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	/**
	 * @return the datumZavrsetka
	 */
	public String getDatumZavrsetka() {
		return datumZavrsetka;
	}

	/**
	 * @param datumZavrsetka the datumZavrsetka to set
	 */
	public void setDatumZavrsetka(String datumZavrsetka) {
		this.datumZavrsetka = datumZavrsetka;
	}

	/**
	 * @return the formatId
	 */
	public Long getFormatId() {
		return formatId;
	}

	/**
	 * @param formatId the formatId to set
	 */
	public void setFormatId(Long formatId) {
		this.formatId = formatId;
	}

	/**
	 * @return the nazivFormata
	 */
	public String getNazivFormata() {
		return NazivFormata;
	}

	/**
	 * @param nazivFormata the nazivFormata to set
	 */
	public void setNazivFormata(String nazivFormata) {
		NazivFormata = nazivFormata;
	}

}
