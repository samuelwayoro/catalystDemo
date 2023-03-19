package com.catalystlocal.catalystdemo.business.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalystlocal.catalystdemo.models.Personne;
import com.catalystlocal.catalystdemo.repository.PersonneDAOImpl;

@Service
public class PersonneService implements IBusinessMetier<Personne> {
	
	@Autowired
	private PersonneDAOImpl personneDAOImpl ;
	

	@Override
	public List<Personne> findAll() {
		return personneDAOImpl.findAll();
	}
	
	@Override
	public Personne create(Personne p) {
		if(!p.getSexe().equalsIgnoreCase("M") && !p.getSexe().equalsIgnoreCase("F")) {
			throw new RuntimeException("Erreur dans le type de sexe !");
		}
		return personneDAOImpl.create(p);	
	}

	@Override
	public Optional<Personne> getById(Long id) { //tester avec un id = 0L dans le service web 
		Optional<Personne> perso = Optional.empty() ;
		try {
			perso =  personneDAOImpl.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return perso;
	}

	@Override
	public int delete(Long id) {
		/**
		 * verifier que la personne renvoyee 
		 * par le service existe bel 
		 * et bien avant sa suppression... 
		 * 
		 */
		Optional<Personne> perso = getById(id);
		if (!perso.isEmpty()) {
			return personneDAOImpl.delete(id);	
		}else {
			return 0;
		}
	}

	@Override
	public int update(Personne p) {
		/**
		 * verifier que la personne renvoyee 
		 * par le service existe bel 
		 * et bien avant sa maj
		 */
		Optional<Personne> perso = getById(p.getIdp());
		if (!perso.isEmpty()) {
			return personneDAOImpl.update(p);
		}else {
			return 0;
		}
	}

}
