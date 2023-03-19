package com.catalystlocal.catalystdemo.models;

public class PersonneGroupe {
	
	private Long personneId;
	private Long groupeId ;
	
	public PersonneGroupe() {
		super();
	}
	public PersonneGroupe(Long personneId, Long groupeId) {
		super();
		this.personneId = personneId;
		this.groupeId = groupeId;
	}
	public Long getPersonneId() {
		return personneId;
	}
	public void setPersonneId(Long personneId) {
		this.personneId = personneId;
	}
	public Long getgroupeId() {
		return groupeId;
	}
	public void setgroupeId(Long groupeId) {
		this.groupeId = groupeId;
	}
	
}
