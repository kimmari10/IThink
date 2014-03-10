package com.ithink.test.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ithink.test.dao.FilesDao;
import com.ithink.test.dao.SighDao;
import com.ithink.test.dao.SongDao;
import com.ithink.test.dao.ToFixDao;
import com.ithink.test.dao.TodoDao;
import com.ithink.test.vo.Files;
import com.ithink.test.vo.Sigh;
import com.ithink.test.vo.Song;
import com.ithink.test.vo.ToFix;
import com.ithink.test.vo.Todo;

@Controller
public class MainController {

	@Autowired
	private SqlSession sqlSession;
	

	@Autowired
	private ToFixDao toFixDao;
	@Autowired
	private SighDao sighDao;
	@Autowired
	private SongDao songDao;
	@Autowired
	private FilesDao filesDao;
	

	@RequestMapping("/home")
	public String home()
	{
		
		return "home";
	}
	
	@RequestMapping("/portfolio")
	public String portfolio()
	{
		
		return "portfolio";
	}
	
	
	@RequestMapping("/list")
	public String list(Model m) throws ClassNotFoundException, SQLException
	{
		TodoDao todoDao = sqlSession.getMapper(TodoDao.class);
		List<Todo> tab1 = todoDao.getTodoList();
		int tab1cnt = todoDao.getCount();

		List<ToFix> tab2 = toFixDao.getToFixList();
		int tab2cnt = toFixDao.getCount();

		List<Sigh> tab3 = sighDao.getSighList();
		int tab3cnt = sighDao.getCount();
		
		List<Song> tab4 = songDao.getSongList();
		int tab4cnt = songDao.getCount();
		
		List<Files> tab5 = filesDao.getFilesList();
		int tab5cnt = filesDao.getCount();
		
		
		m.addAttribute("tab1", tab1);
		m.addAttribute("tab1cnt", tab1cnt);
		
		m.addAttribute("tab2", tab2);
		m.addAttribute("tab2cnt", tab2cnt);
		
		m.addAttribute("tab3", tab3);
		m.addAttribute("tab3cnt", tab3cnt);
		
		m.addAttribute("tab4", tab4);
		m.addAttribute("tab4cnt", tab4cnt);
		
		m.addAttribute("tab5", tab5);
		m.addAttribute("tab5cnt", tab5cnt);
		
		return "list";
	}
	
	@RequestMapping("/addTab1Proc")
	public String insertTab1(Todo todo) throws ClassNotFoundException, SQLException
	{
		//할일
		TodoDao todoDao = sqlSession.getMapper(TodoDao.class);
		todoDao.insert(todo);
		
		return "redirect:/list";
	}
	
	@RequestMapping("/addTab2Proc")
	public String insertTab2(ToFix toFix) throws ClassNotFoundException, SQLException
	{
		//할일
		toFixDao.insert(toFix);
		
		return "redirect:/list#tabs-2";
	}

	@RequestMapping("/addTab3Proc")
	public String insertTab3(Sigh sigh) throws ClassNotFoundException, SQLException
	{
		//푸념
		sighDao.insert(sigh);
		
		return "redirect:/list#tabs-3";
	}
	
	@RequestMapping("/addTab4Proc")
	public String insertTab4(Song song) throws ClassNotFoundException, SQLException
	{
		//노래
		songDao.insert(song);
		
		return "redirect:/list#tabs-4";
	}
	
	
	@RequestMapping("/delProc")
	public String delete(String seq, String tab)throws ClassNotFoundException, SQLException
	{
		if(tab.equals("1"))
		{
			TodoDao todoDao = sqlSession.getMapper(TodoDao.class);
			todoDao.delete(seq);
			return "redirect:/list#tabs-1";
		}
		
		return "redirect:/list#tabs-1";
		
	}
	
	
	
	
	
	@RequestMapping("/addTab5Proc")
	public String upload(Files f, HttpServletRequest req) throws ClassNotFoundException, SQLException, IOException
	{
		if(!f.getFile().isEmpty()){
			//자료실(파일)
			String fname = f.getFile().getOriginalFilename(); //파일이름
			String path =req.getRealPath("/upload");
			String fpath = path+"\\"+fname;
			
			//파일을 path에 fname으로 저장
			//upload구현
			FileOutputStream fos = new FileOutputStream(fpath);
			fos.write(f.getFile().getBytes());
			fos.close();
			
			filesDao.insert(f, fname, path);
		}
		return "redirect:/list#tabs-5";
	}
	
	@RequestMapping("/download")
	public void download(String path, String fname, HttpServletRequest req, HttpServletResponse res) throws ClassNotFoundException, SQLException, IOException
	{
			res.setHeader("Content-Disposition", "attachment; filename="+fname);
			
			String fullPath = req.getRealPath(path+"\\"+fname);
			
			FileInputStream fis = new FileInputStream(fullPath);
			ServletOutputStream sout = res.getOutputStream();
			
			byte[] buf = new byte[1024];
			int size = 0;
			
			while((size = fis.read(buf, 0, 1024)) != -1)
			{
				sout.write(buf, 0, size);
			}
			
			fis.close();
			sout.close();
	}
	
	
	
	
	
	@RequestMapping("/tab1DoneProc")
	public String tab1Done(String seq) throws ClassNotFoundException, SQLException, IOException
	{
		TodoDao todoDao = sqlSession.getMapper(TodoDao.class);
		todoDao.update(seq);
		return "redirect:/list#tabs-1";
	}

	@RequestMapping("/tab2DoneProc")
	public String tab2Done(String seq) throws ClassNotFoundException, SQLException, IOException
	{
		toFixDao.update(seq);
		return "redirect:/list#tabs-2";
	}

}
