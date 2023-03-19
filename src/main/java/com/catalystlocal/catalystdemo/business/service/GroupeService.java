package com.catalystlocal.catalystdemo.business.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.catalystlocal.catalystdemo.models.Groupe;
import com.catalystlocal.catalystdemo.repository.GroupeDAOImpl;

public class GroupeService implements IBusinessMetier<Groupe> {
	
	@Autowired
	private GroupeDAOImpl groupeDAOImpl;

	@Override
	public List<Groupe> findAll() {
		return groupeDAOImpl.findAll();
	}

	@Override
	public Groupe create(Groupe g) {
				Optional<Groupe> leGroupe = groupeDAOImpl.getByName(g.getNomg());
				if (!leGroupe.isEmpty()) {
					throw new RuntimeException("le groupe existe ");
				}else {
					return groupeDAOImpl.create(g);
				}
	}

	@Override
	public Optional<Groupe> getById(Long id) {
		Optional<Groupe> groupe = Optional.empty() ;
		try {
			groupe =  groupeDAOImpl.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return groupe;
	}

	@Override
	public int delete(Long id) {
		/**
		 * verifier  bien avant sa suppression... 
		 * 
		 */
		Optional<Groupe> grp = getById(id);
		if (!grp.isEmpty()) {
			return groupeDAOImpl.delete(id);	
		}else {
			return 0;
		}
	}

	@Override
	public int update(Groupe g) {
		/**
		 * verifier que la personne renvoyee
		 * par le service existe bel 
		 * et bien avant sa maj 
		 * 
		 */
		Optional<Groupe> grp = getById(g.getIdg());
		if (!grp.isEmpty()) {
			return groupeDAOImpl.update(g);
		}else {
			return 0;
		}
	}

}
