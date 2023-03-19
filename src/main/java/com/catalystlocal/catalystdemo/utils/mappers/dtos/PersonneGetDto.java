package com.catalystlocal.catalystdemo.utils.mappers.dtos;

import java.sql.Date;

public class PersonneGetDto {
	
	private Long idp;
	private String nomp;
	private String prenoms;
	private Date dateNaissance;
	private String sexe;
	private Long idPays;
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
	public String getPrenoms() {
		return prenoms;
	}
	public void setPrenoms(String prenoms) {
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
	public PersonneGetDto(Long idp, String nomp, String prenoms, Date dateNaissance, String sexe, Long idPays) {
		super();
		this.idp = idp;
		this.nomp = nomp;
		this.prenoms = prenoms;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
		this.idPays = idPays;
	}
	public PersonneGetDto() {
		super();
	}
	
	
	

}
