package com.ithink.test.dao;

import java.sql.SQLException;
import java.util.List;

import com.ithink.test.vo.ToFix;

public interface ToFixDao{

	public List<ToFix> getToFixList() throws SQLException, ClassNotFoundException;
	public int insert(ToFix toFix) throws SQLException, ClassNotFoundException;
	public int update(String seq) throws SQLException, ClassNotFoundException;
	public int getCount() throws SQLException, ClassNotFoundException;
}
