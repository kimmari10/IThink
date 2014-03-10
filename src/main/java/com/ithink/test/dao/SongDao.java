package com.ithink.test.dao;

import java.sql.SQLException;
import java.util.List;

import com.ithink.test.vo.Song;

public interface SongDao {

	public List<Song> getSongList() throws SQLException, ClassNotFoundException;
	public int insert(Song song) throws SQLException, ClassNotFoundException;
	public int getCount() throws SQLException, ClassNotFoundException;
	
}
