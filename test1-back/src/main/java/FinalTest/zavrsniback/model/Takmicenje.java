package FinalTest.zavrsniback.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Takmicenje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String naziv = "";

	@Column(nullable = false)
	private String mestoOdrzavanja = "";

	@Column(nullable = false)
	private LocalDate datumPocetka;

	@Column(nullable = false)
	private LocalDate datumZavrsetka;

	@ManyToOne
	private Format format;

	@OneToMany(mappedBy = "takmicenje", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Prijava> prijave = new ArrayList<>();

	public Takmicenje() {
	}

	public Takmicenje(String naziv, String mestoOdrzavanja, LocalDate datumPocetka, LocalDate datumZavrsetka,
			Format format, List<Prijava> prijave) {
		this.naziv = naziv;
		this.mestoOdrzavanja = mestoOdrzavanja;
		this.datumPocetka = datumPocetka;
		this.datumZavrsetka = datumZavrsetka;
		this.format = format;
		this.prijave = prijave;
	}

	public Takmicenje(Long id, String naziv, String mestoOdrzavanja, LocalDate datumPocetka, LocalDate datumZavrsetka,
			Format format, List<Prijava> prijave) {
		this.id = id;
		this.naziv = naziv;
		this.mestoOdrzavanja = mestoOdrzavanja;
		this.datumPocetka = datumPocetka;
		this.datumZavrsetka = datumZavrsetka;
		this.format = format;
		this.prijave = prijave;
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
	public LocalDate getDatumPocetka() {
		return datumPocetka;
	}

	/**
	 * @param datumPocetka the datumPocetka to set
	 */
	public void setDatumPocetka(LocalDate datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	/**
	 * @return the datumZavrsetka
	 */
	public LocalDate getDatumZavrsetka() {
		return datumZavrsetka;
	}

	/**
	 * @param datumZavrsetka the datumZavrsetka to set
	 */
	public void setDatumZavrsetka(LocalDate datumZavrsetka) {
		this.datumZavrsetka = datumZavrsetka;
	}

	/**
	 * @return the format
	 */
	public Format getFormat() {
		return format;
	}

	/**
	 * @param format the format to set
	 */
	public void setFormat(Format format) {
		this.format = format;
	}

	/**
	 * @return the prijave
	 */
	public List<Prijava> getPrijave() {
		return prijave;
	}

	/**
	 * @param prijave the prijave to set
	 */
	public void setPrijave(List<Prijava> prijave) {
		this.prijave = prijave;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Takmicenje)) {
			return false;
		}
		Takmicenje other = (Takmicenje) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Takmicenje [id=" + id + ", naziv=" + naziv + ", mestoOdrzavanja=" + mestoOdrzavanja + ", datumPocetka="
				+ datumPocetka + ", datumZavrsetka=" + datumZavrsetka + ", format=" + format + ", prijave=" + prijave
				+ "]";
	}

}
