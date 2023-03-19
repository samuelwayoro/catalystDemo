package com.catalystlocal.catalystdemo.repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.catalystlocal.catalystdemo.models.Personne;

@Repository
public class PersonneDAOImpl implements IDao<Personne> {
	
	@Autowired
	private JdbcTemplate jdbcTemp;

	@Override
	public List<Personne> findAll() {
		return jdbcTemp.query("select idp,nomp,prenoms,dateNaissance,sexe,id_pays from personne",
				(rs,Rownum)->new Personne(rs.getLong("idp"),
						rs.getString("nomp"),
						rs.getString("prenoms"),
						rs.getDate("dateNaissance"),
						rs.getString("sexe"),
						rs.getLong("id_pays")));
	}


	@SuppressWarnings("deprecation")
	@Override
	public Optional<Personne> getById(Long id) {
		Personne perso ;
		perso =  jdbcTemp.queryForObject("select idp,nomp,prenoms,datenaissance,sexe,id_pays from personne where idp = ? ",
				new Object[] {id},
				((rs,rowNum)->new Personne(rs.getLong("idp"),
						rs.getString("nomp"),
						rs.getString("prenoms"),
						rs.getDate("datenaissance"),
						rs.getString("sexe"),
						rs.getLong("id_pays"))));
		return Optional.ofNullable(perso);
	}

	@Override
	public int update(Personne p) {
		String sql ="update personne set nomp=?,prenoms=?,dateNaissance=?,sexe=?,id_pays=? where idp =?";
		return jdbcTemp.update(sql, new Object[] {p.getNomp(),p.getprenoms(),p.getDateNaissance(),p.getSexe(),p.getIdp(),p.getIdp()});
	}

	@Override
	public int delete(Long id) {
		//suppression en cascade
		String deleteOne = "delete from personne_groupe where personne_id=?";
		jdbcTemp.update(deleteOne, id);
		
		String deleteTwo = "delete from personne where idp=?";
		jdbcTemp.update(deleteTwo, id);
		
		return 1;
	}


	@Override
	public Personne create(Personne p) {
		KeyHolder kh = new GeneratedKeyHolder();
		jdbcTemp.update(connection -> {PreparedStatement ps = connection.prepareStatement("insert into Personne (nomp,prenoms,dateNaissance,sexe,id_pays) values (?,?,?,?,?)",
				Statement.RETURN_GENERATED_KEYS);
			ps.setNString(1,p.getNomp());
			ps.setString(2,p.getprenoms());
			ps.setDate(3,(Date) p.getDateNaissance());
			ps.setString(4, p.getSexe());
			ps.setLong(5, p.getIdPays());
			return ps;
		}, kh);
		p.setIdp(kh.getKey().longValue());
		return p;
	}

}
