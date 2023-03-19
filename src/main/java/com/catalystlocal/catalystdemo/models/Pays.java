package com.catalystlocal.catalystdemo.models;

public class Pays {

	private Long idpays;
	private String nompays;
	private String capitale;
	
	public Pays(Long idpays, String nompays, String capitale) {
		super();
		this.idpays = idpays;
		this.nompays = nompays;
		this.capitale = capitale;
	}

	public Pays() {
		super();
	}

	public Long getIdpays() {
		return idpays;
	}

	public void setIdpays(Long idpays) {
		this.idpays = idpays;
	}

	public String getNompays() {
		return nompays;
	}

	public void setNompays(String nompays) {
		this.nompays = nompays;
	}

	public String getCapitale() {
		return capitale;
	}

	public void setCapitale(String capitale) {
		this.capitale = capitale;
	}
	
	
	
}
