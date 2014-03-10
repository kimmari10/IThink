package com.ithink.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.ithink.test.vo.ToFix;

public class ToFixDaoImpl extends JdbcDaoSupport implements ToFixDao {

/*	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}*/
	
	@Override
	public List<ToFix> getToFixList() throws SQLException,
			ClassNotFoundException {
		
		String sql = "SELECT * FROM TOFIX ORDER BY SUCCESS DESC, REGDATE DESC";
		
//		queryForObject - 단일
//		query - 목록
		
//		new BeanPropertyRowMapper - 목록반환
//
		
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<ToFix>(ToFix.class));
	}

	@Override
	public int insert(ToFix toFix) throws SQLException, ClassNotFoundException {
		
		String sql = "INSERT INTO TOFIX VALUES(?, ?, ?, 'YET', SYSDATE, null)";
		String q = "SELECT MAX(SEQ)+1 FROM TOFIX";
		
		int a = getJdbcTemplate().queryForInt(q);
		return getJdbcTemplate().update(sql, a, toFix.getTitle(), toFix.getContent());
		
	}

	@Override
	public int update(String seq) throws SQLException, ClassNotFoundException {
		
		String sql = "UPDATE TOFIX SET SUCCESS ='DONE', SUCCDAY=SYSDATE WHERE SEQ =?";
		
		//반환값 - 정수형
		return getJdbcTemplate().update(sql, seq);
	}

	@Override
	public int getCount() throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT COUNT(SEQ) C FROM TOFIX WHERE SUCCESS='YET'";
		
		return getJdbcTemplate().queryForInt(sql);
	}

}
