package tn.enig.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Projet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titre;
	private String etat;
	@ManyToOne
	private Departement dp;

	public Projet() {
		super();
	}

	public Projet(String titre, String etat, Departement dp) {
		super();

		this.titre = titre;
		this.etat = etat;
		this.dp = dp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Departement getDp() {
		return dp;
	}

	public void setDp(Departement dp) {
		this.dp = dp;
	}

}
