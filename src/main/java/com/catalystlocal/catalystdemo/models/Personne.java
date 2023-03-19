package com.catalystlocal.catalystdemo.models;


import java.sql.Date;


public class Personne {
	
	private Long idp;
	private String nomp;
	private String prenoms;
	private Date dateNaissance;
	private String sexe;
	private Long idPays;
	
	public Personne() {
		super();
	}

	public Personne(Long idp, String nomp, String prenoms, Date dateNaissance, String sexe, Long idPays) {
		this.idp = idp;
		this.nomp = nomp;
		this.prenoms = prenoms;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
		this.idPays = idPays;
	}

	

	public Personne(long idp, String nomp, String prenoms) {
		this.idp = idp;
		this.nomp = nomp;
		this.prenoms = prenoms;
	}

	public Long getIdp() {
		return idp;
	}

	public void setIdp(Long idp) {
		this.idp = idp;
	}

	public String getNomp() {
		return nomp;
	}

	public void setNomp(String nomp) {
		this.nomp = nomp;
	}

	public String getprenoms() {
		return prenoms;
	}

	public void setprenoms(String prenoms) {
		this.prenoms = prenoms;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Long getIdPays() {
		return idPays;
	}

	public void setIdPays(Long idPays) {
		this.idPays = idPays;
	}
	
	
	
	
}
