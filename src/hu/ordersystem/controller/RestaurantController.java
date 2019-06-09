package hu.ordersystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hu.ordersystem.poji.Restaurant;
import hu.ordersystem.poji.TableReturn;
import hu.ordersystem.service.RestaurantService;

@Controller
@RequestMapping("/restaurantManage")
public class RestaurantController {

	private final Logger logger=Logger.getLogger(RestaurantController.class);
	@Resource
	private RestaurantService restaurantServiceImpl;
	
	@RequestMapping("/restaurantManage")
	public String restaurantManage() {
		return "restaurantManage/restaurantManage";
	}
	
	@RequestMapping("/restaurantAdd")
	public String restaurantAdd() {
		
		return "restaurantManage/restaurantAdd";
	}
	
	/**
	 * 有关餐厅的分页查询
	 * @param page		页码
	 * @param limit		每页的数据
	 * @return
	 */
	@RequestMapping("/getRestaurantData")
	@ResponseBody
	public TableReturn<Restaurant> getRestaurantData(int page,int limit){
		
		int count=restaurantServiceImpl.selRestaurantShowCount();
		
		int startId=(page-1)*limit;
		
		List<Restaurant> restaurantList=restaurantServiceImpl.selRestaurantPaging(startId, limit);
		
		
		
		return new TableReturn<Restaurant>(count,0,"",restaurantList);
	}
	
	/**
	 * 修改表中信息
	 * @param restaurant	餐厅类（包含餐厅信息）
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public int edit(Restaurant restaurant) {
		
		//System.out.println(restaurant);
		int num=restaurantServiceImpl.updRestaurantById(restaurant);
		
		return num;
	}
	
	/**
	 * 查询负责人姓名——————不能用
	 * @param phone	负责人电话
	 * @return
	 * ,produces="application/json;charset=utf-8"
	 */
	@RequestMapping(value="/searchManager",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String searchManager(String phone,HttpServletRequest req) {
		String name=restaurantServiceImpl.selRestaurantManagerNameByManagerPhone(phone);
		System.out.println(name);
 
		
		/*
		 * ObjectMapper mapper=new ObjectMapper(); String jsonStr = null; try { jsonStr
		 * = mapper.writeValueAsString(name); } catch (JsonProcessingException e) {
		 * logger.debug("写出流错误"); }
		 * 
		 * PrintWriter writer = null; try { writer = resp.getWriter(); } catch
		 * (IOException e) { logger.debug("获取输出流失败"); } writer.write(jsonStr);
		 * writer.flush(); writer.close();
		 */

		Map<String,String> map=new HashMap<>();
		map.put("managerName", name);
		
		return name;
	}
	
	//添加餐厅
	@RequestMapping("/addRestaurant")
	public String addRestaurant(Restaurant restaurant,HttpServletRequest req) {
		int num=restaurantServiceImpl.insRestaurantInfo(restaurant);
		System.out.println("添加结果："+num);
		
		
		req.setAttribute("addNum", num);
		return "restaurantManage/restaurantManage";
	}
	
	//删除餐厅(伪删除)
	@RequestMapping("/del")
	@ResponseBody
	public int del(int id) {
		int num=restaurantServiceImpl.delRestaurantInfo(id);
		return num;
	}
	
}
