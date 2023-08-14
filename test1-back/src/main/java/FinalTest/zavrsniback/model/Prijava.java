package FinalTest.zavrsniback.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Prijava {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String drzava = "";

	@Column(unique = true, nullable = false)
	private String email = "";

	@Column(nullable = false)
	private LocalDate datumPrijave;

	@ManyToOne
	private Takmicenje takmicenje;

	public Prijava() {
	}

	public Prijava(String drzava, String email, LocalDate datumPrijave, Takmicenje takmicenje) {
		this.drzava = drzava;
		this.email = email;
		this.datumPrijave = datumPrijave;
		this.takmicenje = takmicenje;
	}

	public Prijava(Long id, String drzava, String email, LocalDate datumPrijave, Takmicenje takmicenje) {
		this.id = id;
		this.drzava = drzava;
		this.email = email;
		this.datumPrijave = datumPrijave;
		this.takmicenje = takmicenje;
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
	 * @return the drzava
	 */
	public String getDrzava() {
		return drzava;
	}

	/**
	 * @param drzava the drzava to set
	 */
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the datumPrijave
	 */
	public LocalDate getDatumPrijave() {
		return datumPrijave;
	}

	/**
	 * @param datumPrijave the datumPrijave to set
	 */
	public void setDatumPrijave(LocalDate datumPrijave) {
		this.datumPrijave = datumPrijave;
	}

	/**
	 * @return the takmicenje
	 */
	public Takmicenje getTakmicenje() {
		return takmicenje;
	}

	/**
	 * @param takmicenje the takmicenje to set
	 */
	public void setTakmicenje(Takmicenje takmicenje) {
		this.takmicenje = takmicenje;
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
		if (!(obj instanceof Prijava)) {
			return false;
		}
		Prijava other = (Prijava) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Prijava [id=" + id + ", drzava=" + drzava + ", email=" + email + ", datumPrijave=" + datumPrijave
				+ ", takmicenje=" + takmicenje + "]";
	}

}
