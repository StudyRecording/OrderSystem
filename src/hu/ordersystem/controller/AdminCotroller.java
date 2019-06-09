package hu.ordersystem.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hu.ordersystem.poji.Admin;
import hu.ordersystem.service.AdminService;

@Controller
public class AdminCotroller {
	
	@Resource
	private AdminService adminServiceImpl;
	
	private final Logger logger=Logger.getLogger(AdminCotroller.class);
	
	
	  @RequestMapping("login") 
	  public String login() { 
		  return "index"; 
	  }
	 

	@RequestMapping("checkAdmin")
	public String selAdmin(String adminUsername, String adminPwd, HttpServletRequest req) {
		System.out.println(adminUsername+":"+adminPwd);
		Admin admin=adminServiceImpl.selAdmin(adminUsername, adminPwd);
		logger.info(admin);
		if(admin!=null) {
			req.getSession().setAttribute("admin", admin);
			//req.getServletContext().setAttribute("id", admin.getId());
			return "main/main";
		}else {
			return "index";
		}
	}
	

}
