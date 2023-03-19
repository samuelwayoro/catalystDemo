package com.catalystlocal.catalystdemo.business.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.catalystlocal.catalystdemo.models.Pays;
import com.catalystlocal.catalystdemo.repository.PaysDAOImpl;

public class PaysService implements IBusinessMetier<Pays> {
	
	@Autowired
	private PaysDAOImpl paysDAOImpl;

	@Override
	public List<Pays> findAll() {
		return paysDAOImpl.findAll();
	}

	@Override
	public Pays create(Pays p) {
		//verifier si le pays n'existe pas encore...
		Optional<Pays> lePays = paysDAOImpl.getByName(p.getNompays());
		if (!lePays.isEmpty()) {
			//envoyer un msg d'erreur...
			throw new RuntimeException("le pays existe");
		}else {
			//creer le pays en question ...
			return paysDAOImpl.create(p);
		}
	}

	@Override
	public Optional<Pays> getById(Long id) {
		Optional<Pays> pays = Optional.empty() ;
		try {
			pays =  paysDAOImpl.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pays;
	}

	@Override
	public int delete(Long id) {
		/**
		 * verifier que la personne renvoyee 
		 * par le service existe bel 
		 * et bien avant sa suppression... 
		 * 
		 */
		Optional<Pays> pays = getById(id);
		if (!pays.isEmpty()) {
			return paysDAOImpl.delete(id);	
		}else {
			return 0;
		}
	}

	@Override
	public int update(Pays p) {
		/**
		 * verifier que le pays renvoyee 
		 * par le service existe bel 
		 * et bien avant sa maj 
		 * 
		 */
		Optional<Pays> pays = getById(p.getIdpays());
		if (!pays.isEmpty()) {
			return paysDAOImpl.update(p);
		}else {
			return 0;
		}
	}

}
