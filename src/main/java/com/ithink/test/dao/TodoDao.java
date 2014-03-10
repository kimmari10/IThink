package com.ithink.test.dao;

import java.sql.SQLException;
import java.util.List;

import com.ithink.test.vo.Todo;

public interface TodoDao {

	
	public List<Todo> getTodoList() throws SQLException, ClassNotFoundException;
	public int insert(Todo todo) throws SQLException, ClassNotFoundException;
	public int delete(String seq) throws SQLException, ClassNotFoundException;
	public int update(String seq) throws SQLException, ClassNotFoundException;
	public int getCount() throws SQLException, ClassNotFoundException;
}
