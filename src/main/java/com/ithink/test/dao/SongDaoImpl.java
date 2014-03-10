package com.ithink.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ithink.test.vo.Song;
import com.ithink.test.vo.Todo;

public class SongDaoImpl implements SongDao{

	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
	@Override
	public List<Song> getSongList() throws SQLException, ClassNotFoundException {

		String sql = "SELECT * FROM SONG";
		
		return template.query(sql, new BeanPropertyRowMapper<Song>(Song.class));
	}

	@Override
	public int insert(Song song) throws SQLException,
			ClassNotFoundException {
		
		String sql = "INSERT INTO SONG VALUES(?, ?, ?, ?)";
		String q = "SELECT MAX(SEQ)+1 C FROM SONG";
		
		int a = template.queryForInt(q);
		return template.update(sql, a, song.getTitle(), song.getSinger(), song.getMemo());
	}

	@Override
	public int getCount() throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT COUNT(SEQ) C FROM SONG";
		
		return template.queryForInt(sql);
	}

}
