package com.catalystlocal.catalystdemo.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.catalystlocal.catalystdemo.models.Pays;

public class PaysDAOImpl implements IDao<Pays> {
	
	@Autowired
	private JdbcTemplate jdbcTemp;

	@Override
	public List<Pays> findAll() {
		return jdbcTemp.query("select idpays,nompays,capitale from pays",
				(rs,Rownum)->new Pays(rs.getLong("idpays"),rs.getString("nompays"),rs.getString("capitale")));
	}

	@Override
	public Pays create(Pays p) {
		KeyHolder kh = new GeneratedKeyHolder();
		jdbcTemp.update(connection -> {PreparedStatement ps = connection.prepareStatement("insert into pays (nompays,capitale) values (?,?)",
				Statement.RETURN_GENERATED_KEYS);
			ps.setNString(1,p.getNompays());
			ps.setString(2,p.getCapitale());
			return ps;
		}, kh);
		p.setIdpays((Long) kh.getKey());
		return p;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Optional<Pays> getById(Long id) {
		Pays p;
		p =  jdbcTemp.queryForObject("select idpays,nompays,capitale from pays where idpays = ? ",
				new Object[] {id},
				((rs,rowNum)->new Pays(rs.getLong("idpays"),
						rs.getString("nompays"),
						rs.getString("capitale"))));
		return Optional.ofNullable(p);
	}
	
	@SuppressWarnings("deprecation")
	public Optional<Pays> getByName(String nomPays){
		Pays p = new Pays();
		p = jdbcTemp.queryForObject("select idpays,nompays,capitale from pays where nompays = ? ",
				new Object[] {nomPays},
				((rs,rowNum)-> new Pays(rs.getLong("idpays"),rs.getString("nompays"),rs.getString("capitale"))));
		return Optional.ofNullable(p);
	}
	

	@Override
	public int update(Pays p) {
		String sql ="update pays set nompays=?,capitale=? where idpays =?";
		return jdbcTemp.update(sql, new Object[] {p.getNompays(),p.getCapitale(),p.getIdpays()});
	}

	@Override
public int delete(Long idPays) {
	
		//suppression en cascade
		String deleteOne = "delete from pays where idpays=?";
		jdbcTemp.update(deleteOne,idPays);
		
		String deleteTwo = "update personne set id_pays=null where id_pays=?";
		jdbcTemp.update(deleteTwo, idPays);
	
		return 1;
	}

}
