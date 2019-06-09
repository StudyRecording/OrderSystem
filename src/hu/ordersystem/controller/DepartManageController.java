package hu.ordersystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hu.ordersystem.poji.Depart;
import hu.ordersystem.poji.TableReturn;
import hu.ordersystem.service.DepartService;

@Controller
@RequestMapping("/departManage")
public class DepartManageController {

	@Resource
	private DepartService departServiceImpl;

	@RequestMapping("/departManage")
	public String departManage() {

		return "departManage/departManage";
	}

	@RequestMapping("/departAdd")
	public String departAdd() {
		return "departManage/departAdd";
	}

	/**
	 * layUI的table后台响应数据程序
	 * 
	 * @param page  页码
	 * @param limit 每页的数据
	 * @return
	 */

	//TableReturn<List<Depart>>
	@RequestMapping("/getDepatDate")
	@ResponseBody
	public TableReturn<Depart> getDepartData(int page, int limit) {
		
		int thisPageStartId = (page - 1) * limit + 1;
		//int thisPageEndId = thisPageStartId + limit - 1;

		int pageSize=8;
		int count = departServiceImpl.selAllDepartCount();

		
		
		//List<Depart> departList = departServiceImpl.selDepartByIdRange(thisPageStartId, thisPageEndId);
		List<Depart> departList=departServiceImpl.selDepartPaging(thisPageStartId-1, pageSize);
		
		//System.out.println(departList);
		
		TableReturn tr=new TableReturn(count, 0, "", departList);
		
		//return new TableReturn<List<Depart>>(0,"", count, departList);
		return tr;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public int edit(String name,int id) {
		int num = departServiceImpl.updDepartById(name, id);
		//System.out.println(num);
		return num;
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public int delete(int id) {
		int num=departServiceImpl.delDepartById(id);
		System.out.println(num);
		return num;
	}
	
	@RequestMapping("/addDepart")
	public String addDepart(@RequestParam("departName") String departName,HttpServletRequest req) {
		int num=departServiceImpl.insDepart(departName);
		return "departManage/departManage";
	}

}
