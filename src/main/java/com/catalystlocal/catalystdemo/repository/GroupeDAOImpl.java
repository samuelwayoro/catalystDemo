package com.catalystlocal.catalystdemo.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.catalystlocal.catalystdemo.models.Groupe;

public class GroupeDAOImpl implements IDao<Groupe> {

	@Autowired
	private JdbcTemplate jdbcTemp;

	@Override
	public List<Groupe> findAll() {
		return jdbcTemp.query("select idg,nomg,description from groupe",
				(rs,Rownum)->new Groupe(rs.getLong("idg"),rs.getString("nomg"),rs.getString("description")));
	}

	@Override
	public Groupe create(Groupe grp) {
		KeyHolder kh = new GeneratedKeyHolder();
		jdbcTemp.update(connection -> {PreparedStatement ps = connection.prepareStatement("insert into groupe (nomg,description) values (?,?)",
				Statement.RETURN_GENERATED_KEYS);
			ps.setNString(1,grp.getNomg());
			ps.setString(2,grp.getDescription());
			return ps;
		}, kh);
		grp.setIdg((Long) kh.getKey());
		return grp;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Optional<Groupe> getById(Long id) {
		Groupe grp;
		grp =  jdbcTemp.queryForObject("select idg,nomg,description from groupe where idg = ? ",
				new Object[] {id},
				((rs,rowNum)->new Groupe(rs.getLong("idg"),
						rs.getString("nomg"),
						rs.getString("description"))));
		return Optional.ofNullable(grp);
	}
	
	@SuppressWarnings("deprecation")
	public Optional<Groupe> getByName(String nomg){
		Groupe g = new Groupe();
		g = jdbcTemp.queryForObject("select idg,nomg,description from groupe where nomg = ? ",
				new Object[] {nomg},
				((rs,rowNum)-> new Groupe(rs.getLong("idg"),rs.getString("nomg"),rs.getString("description"))));
		return Optional.ofNullable(g);
	}

	@Override
	public int update(Groupe grp) {
		String sql ="update groupe set nomg=?,description=? where idg =?";
		return jdbcTemp.update(sql, new Object[] {grp.getNomg(),grp.getDescription(),grp.getIdg()});
	}

	@Override
	public int delete(Long id) {
	//suppression en cascade
			String deleteOne = "delete from personne_groupe where groupe_id=?";
			jdbcTemp.update(deleteOne, id);
			
			String deleteTwo = "delete from groupe where idg=?";
			jdbcTemp.update(deleteTwo, id);
			
			return 1;
	}

}
