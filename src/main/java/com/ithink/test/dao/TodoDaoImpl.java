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
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import com.ithink.test.vo.Todo;

public class TodoDaoImpl implements TodoDao{

	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
	@Override
	public List<Todo> getTodoList() throws SQLException, ClassNotFoundException {

		String sql = "SELECT * FROM TODO ORDER BY SUCCESS DESC, REGDATE DESC";
		
		return template.query(sql, new BeanPropertyRowMapper<Todo>(Todo.class));
	}

	@Override
	public int insert(Todo todo) throws SQLException, ClassNotFoundException {
		
		String sql = "INSERT INTO TODO VALUES(?, ?, ?, 'YET', SYSDATE, ?, null)";
		String q = "SELECT MAX(SEQ)+1 C FROM TODO";
		
		int a = template.queryForInt(q);
		return template.update(sql, a, todo.getTitle(), todo.getContent(), todo.getDueday());
	}


	@Override
	public int update(String seq) throws SQLException, ClassNotFoundException {
		
		String sql = "UPDATE TODO SET SUCCESS ='DONE', SUCCDAY=SYSDATE WHERE SEQ =?";
		
		return template.update(sql, seq);
	}

	@Override
	public int getCount() throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT COUNT(SEQ) C FROM TODO WHERE SUCCESS='YET'";
		
		return template.queryForInt(sql);
	}


	@Override
	public int delete(String seq) throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}
}
