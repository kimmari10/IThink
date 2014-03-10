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

import com.ithink.test.vo.Files;
import com.ithink.test.vo.Todo;

public class FilesDaoImpl implements FilesDao{

	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
	@Override
	public List<Files> getFilesList() throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT * FROM FILES ORDER BY FILENAME";
		
		return template.query(sql, new BeanPropertyRowMapper<Files>(Files.class));
	}

	@Override
	public int insert(Files f, String fname, String path) throws SQLException, ClassNotFoundException {
		
		String sql = "INSERT INTO FILES VALUES(?, ?, ?, ?, ?)";
		String q = "SELECT MAX(SEQ)+1 C FROM FILES";
		
		int a = template.queryForInt(q);
		return template.update(sql, a, f.getTitle(), f.getContent(), path, fname);
	}

	@Override
	public int getCount() throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT COUNT(SEQ) C FROM FILES";
		
		return template.queryForInt(sql);
	}



}
