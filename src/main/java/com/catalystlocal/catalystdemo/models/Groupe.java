package com.catalystlocal.catalystdemo.models;

public class Groupe {
	private Long idg;
	private String nomg;
	private String description;
	
	
	public Long getIdg() {
		return idg;
	}


	public void setIdg(Long idg) {
		this.idg = idg;
	}


	public String getNomg() {
		return nomg;
	}


	public void setNomg(String nomg) {
		this.nomg = nomg;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Groupe(Long idg, String nomg, String description) {
		super();
		this.idg = idg;
		this.nomg = nomg;
		this.description = description;
	}


	public Groupe() {
		super();
	}
	
	

}
