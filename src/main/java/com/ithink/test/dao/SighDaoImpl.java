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

import com.ithink.test.vo.Sigh;
import com.ithink.test.vo.Todo;

public class SighDaoImpl implements SighDao{

	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
	@Override
	public List<Sigh> getSighList() throws SQLException, ClassNotFoundException {

		String sql = "SELECT * FROM SIGH ORDER BY REGDATE DESC";
		
		return template.query(sql, new BeanPropertyRowMapper<Sigh>(Sigh.class));
	}

	@Override
	public int insert(Sigh sigh) throws SQLException, ClassNotFoundException {
		
		String sql = "INSERT INTO SIGH VALUES(?, ?, ?, SYSDATE)";
		String q = "SELECT MAX(SEQ)+1 C FROM SIGH";
		
		int a = template.queryForInt(q);
		return template.update(sql, a, sigh.getTitle(), sigh.getContent());
	}

	@Override
	public int getCount() throws SQLException, ClassNotFoundException {

		String sql = "SELECT COUNT(SEQ) C FROM SIGH";
		
		return template.queryForInt(sql);
	}

}
