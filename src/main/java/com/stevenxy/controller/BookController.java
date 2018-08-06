package com.stevenxy.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stevenxy.dao.BookDao;
import com.stevenxy.entity.Book;

/**
* @author stevenxy E-mail:random_xy@163.com
* @Date 2018年8月4日
* @Description 图书控制器
*/

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Resource
	private BookDao bookDao;
	
	/**
	 * 查询所有图书
	 * @return
	 */
	@RequestMapping(value="/list")
	public ModelAndView list() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("bookList",bookDao.findAll());
		mav.setViewName("bookList");
		return mav;
	}
	
	/**
	 * 添加图书
	 * @param book
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Book book) {
		bookDao.save(book);
		return "forward:/book/list";
	}
	
	/**
	 * 根据id查询book实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/preUpdate/{id}")
	public ModelAndView preUpdate(@PathVariable("id")Integer id) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("book",bookDao.getOne(id));
		mav.setViewName("bookUpdate");
		return mav;
	}
	
	/**
	 * 修改图书
	 * @param book
	 * @return
	 */
	@PostMapping(value="/update")
	public String update(Book book) {
		bookDao.save(book);
		return "forward:/book/list";
	}
	
	/**
	 * 根据id删除book
	 * @param id
	 * @return
	 */
	@GetMapping("/delete")
	public String delete(Integer id) {
		bookDao.deleteById(id);
		return "forward:/book/list";
	}
	
}
