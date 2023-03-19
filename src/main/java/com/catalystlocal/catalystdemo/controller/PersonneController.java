package com.catalystlocal.catalystdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalystlocal.catalystdemo.business.service.PersonneService;
import com.catalystlocal.catalystdemo.models.Personne;
import com.catalystlocal.catalystdemo.utils.mappers.MapStructMapper;

@RestController
@RequestMapping("/personnes")
public class PersonneController {
	
	@Autowired
	private PersonneService ps;
	
	

	/**
	 * retourne la liste 
	 * de toutes les personnes 
	 */
	@GetMapping("")
	public List<Personne> allPersons(){
		return ps.findAll();
	}
	
	
	/**
	 * supprimer une personne en bd
	 */
	@DeleteMapping("/{id}")
	public void deletePerson(@PathVariable(value ="id" ) Long idPerson) {
		 ps.delete(idPerson);
	}
	
	/**
	 * ajouter une personne 
	 */
	@PostMapping
	public void addPerson(@RequestBody Personne p) {
		ps.create(p);
	}
	
	/**
	 * retourner une personne a partir de son id
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Personne getPerson(@PathVariable("id") Long id) {
		
		Optional<Personne> perso = ps.getById(id);
		if(perso.isPresent()) {
			return perso.get();
		}else {
			return null;
		}
	}
	
	@PutMapping("/")
	public int updatePerson(@RequestBody Personne p) {
		return ps.update(p);
	}
	
}
