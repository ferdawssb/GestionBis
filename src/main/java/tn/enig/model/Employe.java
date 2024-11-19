package tn.enig.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	@ManyToOne
	private Projet p;
	@ManyToOne
	private Departement dep;
	private String fonction;

	public Employe() {
		super();
	}

	public Employe(String nom, Projet p, Departement dep, String fonction) {
		super();
		this.nom = nom;
		this.p = p;
		this.dep = dep;
		this.fonction = fonction;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Projet getP() {
		return p;
	}

	public void setP(Projet p) {
		this.p = p;
	}

	public Departement getDep() {
		return dep;
	}

	public void setDep(Departement dep) {
		this.dep = dep;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

}
