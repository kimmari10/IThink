package com.ithink.test.dao;

import java.sql.SQLException;
import java.util.List;

import com.ithink.test.vo.Sigh;

public interface SighDao {

	public List<Sigh> getSighList() throws SQLException, ClassNotFoundException;
	public int insert(Sigh sigh) throws SQLException, ClassNotFoundException;
	public int getCount() throws SQLException, ClassNotFoundException;
}
