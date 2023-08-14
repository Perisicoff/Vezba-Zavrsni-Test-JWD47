package FinalTest.zavrsniback.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class FormatDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
	private Long id;

	@NotBlank
	private String tip = "";

	private int brojUcesnika;

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
	 * @return the tip
	 */
	public String getTip() {
		return tip;
	}

	/**
	 * @param tip the tip to set
	 */
	public void setTip(String tip) {
		this.tip = tip;
	}

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

}
