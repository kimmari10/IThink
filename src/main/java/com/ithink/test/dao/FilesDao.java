package com.ithink.test.dao;

import java.sql.SQLException;
import java.util.List;

import com.ithink.test.vo.Files;

public interface FilesDao {

	public List<Files> getFilesList() throws SQLException, ClassNotFoundException;
	public int insert(Files f, String fname, String path) throws SQLException, ClassNotFoundException;
	public int getCount() throws SQLException, ClassNotFoundException;
}
