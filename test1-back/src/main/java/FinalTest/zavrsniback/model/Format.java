package FinalTest.zavrsniback.model;

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
import javax.persistence.OneToMany;

@Entity
public class Format {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String tip = "";

	@Column
	private int brojUcesnika;

	@OneToMany(mappedBy = "format", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Takmicenje> takmicenja = new ArrayList<>();

	public Format() {
	}

	public Format(String tip, int brojUcesnika, List<Takmicenje> takmicenja) {
		this.tip = tip;
		this.brojUcesnika = brojUcesnika;
		this.takmicenja = takmicenja;
	}

	public Format(Long id, String tip, int brojUcesnika, List<Takmicenje> takmicenja) {
		this.id = id;
		this.tip = tip;
		this.brojUcesnika = brojUcesnika;
		this.takmicenja = takmicenja;
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

	/**
	 * @return the takmicenja
	 */
	public List<Takmicenje> getTakmicenja() {
		return takmicenja;
	}

	/**
	 * @param takmicenja the takmicenja to set
	 */
	public void setTakmicenja(List<Takmicenje> takmicenja) {
		this.takmicenja = takmicenja;
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
		if (!(obj instanceof Format)) {
			return false;
		}
		Format other = (Format) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Format [id=" + id + ", tip=" + tip + ", brojUcesnika=" + brojUcesnika + ", takmicenja=" + takmicenja
				+ "]";
	}

}
