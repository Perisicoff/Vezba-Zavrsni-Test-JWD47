package FinalTest.zavrsniback.web.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public class PrijavaDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
	private Long id;

	@Length(min = 3, max = 3)
	private String drzava = "";

	@NotBlank
	@Email
	private String email = "";

	private String datumPrijave;

	private Long takmicenjeId;

	private String nazivTakmicenja;

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
	public String getDatumPrijave() {
		return datumPrijave;
	}

	/**
	 * @param datumPrijave the datumPrijave to set
	 */
	public void setDatumPrijave(String datumPrijave) {
		this.datumPrijave = datumPrijave;
	}

	/**
	 * @return the takmicenjeId
	 */
	public Long getTakmicenjeId() {
		return takmicenjeId;
	}

	/**
	 * @param takmicenjeId the takmicenjeId to set
	 */
	public void setTakmicenjeId(Long takmicenjeId) {
		this.takmicenjeId = takmicenjeId;
	}

	/**
	 * @return the nazivTakmicenja
	 */
	public String getNazivTakmicenja() {
		return nazivTakmicenja;
	}

	/**
	 * @param nazivTakmicenja the nazivTakmicenja to set
	 */
	public void setNazivTakmicenja(String nazivTakmicenja) {
		this.nazivTakmicenja = nazivTakmicenja;
	}

}
