package hu.ordersystem.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hu.ordersystem.poji.Dining;
import hu.ordersystem.poji.DinnerTableAuxiliary;
import hu.ordersystem.poji.Personnel;
import hu.ordersystem.poji.Restaurant;
import hu.ordersystem.poji.TableReturn;
import hu.ordersystem.service.DinnerService;
import hu.ordersystem.service.PersonnelService;
import hu.ordersystem.service.RestaurantService;

@Controller
@RequestMapping("/sendMealManage")
public class SendMealManageController {

	@Resource
	private RestaurantService restaurantServiceImpl;
	
	@Resource
	private PersonnelService personnelServiceImpl;
	
	@Resource
	private DinnerService dinnerServiceImpl;
	
	@RequestMapping("/sendMealManage")
	public String sendMealManage() {
		return "sendMealManage/sendMealManage";
	}
	
	@RequestMapping("/sendMealAdd")
	public String sendMealAdd() {
		return "sendMealManage/sendMealAdd";
	}
	
	@RequestMapping("/selRestaurant")
	public String selRestaurant(HttpServletRequest req) {
		
		List<Restaurant> restaurantList=restaurantServiceImpl.selRestaurantByIsShow();
		System.out.println(restaurantList);
		if(restaurantList!=null) {
			req.setAttribute("restaurantList", restaurantList);
		}
		
		return "forward:sendMealAdd";
	}
	
	
	
	/**
	 * 添加订餐信息
	 * @param dinner
	 * @param personnel
	 */
	@RequestMapping("/addSendMeal")
	@ResponseBody
	public void addSendMeal(Dining dinner,Personnel personnel) {
		//订单单号为：00000000-0000	 就餐方式：0	订单日期：
		//form提交订餐信息{dinnerDate,dinnerTime,dinnerNumber,dinnerInstructions}	
		//form提交订餐人信息{personnelName,personnelPhone,restaurantId}
		
		//生成订单日期
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String orderDate=dateFormat.format(new Date());
		dinner.setOrderDate(orderDate);
		
		//生成订单单号
		dateFormat=new SimpleDateFormat("yyyyMMdd");
		String prefixOrderNumber=dateFormat.format(new Date());
		String thisOrderNumber=null;
		//读取dinning表中最后一条信息（select * from table order by id DESC limit 1）
		//取其中订单单号(lastNumber)擦看前8位是否与prefixOrderNumber相同，如果相同：去lastNumber后四位+1，
		//否则：prefixOrderNumber+0000
		Dining din=dinnerServiceImpl.selLastOneOrderNumber();
		
		if(din!=null) {
			String lastOrderNumber=din.getOrderNumber();
			System.out.println("上一条订单号："+lastOrderNumber);
			String lastOrderNumberPrefix=lastOrderNumber.substring(0, 8);
			if(lastOrderNumberPrefix.equals(prefixOrderNumber)) {
				String suffixOrderNumber=Integer.parseInt(lastOrderNumber.substring(9))+1+"";
				thisOrderNumber=prefixOrderNumber+"-"+suffixOrderNumber;
			}else {
				thisOrderNumber=prefixOrderNumber+"-1";
			}
		}else {
			thisOrderNumber=prefixOrderNumber+"-1";
		}
		dinner.setOrderNumber(thisOrderNumber);
		
		//就餐方式——派送
		dinner.setDinnerWay(0);
		
		//完善订餐人信息
		Personnel person=personnelServiceImpl.selPersonnelByPhoneLimitOne(personnel.getPersonnelPhone());
		if(person!=null) {
			//System.out.println("查询："+person);
			person.setRestaurantId(personnel.getRestaurantId());	
			person.setPersonnelDate(orderDate);
			personnel=person;	
		}else {
			personnel.setPersonnelDate(orderDate);
			personnel.setDepartId(26);
			personnel.setPersonnelSex(3);
		}
		//插入订餐人表
		int personnelNum=personnelServiceImpl.insPersonnel(personnel);
		
		//获得刚刚插入personnel的id
		personnel=personnelServiceImpl.selPersonnelByPhoneAndDate(personnel);
		
		//完善订餐表中订餐人的id
		dinner.setPersonnelId(personnel.getId());
		
		//System.out.println("提交:"+personnel);
		//System.out.println("提交"+dinner);
		
		
		
		//插入订餐表
		if(personnelNum>0) {
			int dinnerNum=dinnerServiceImpl.insDining(dinner);
			if(dinnerNum>0) {
				System.out.println("插入成功");
			}
		}
		
		
	}
	
	@RequestMapping("/selSendMealDate")
	@ResponseBody
	public TableReturn<DinnerTableAuxiliary> selSendMealDate(int page,int limit){
		int startId=(page-1)*limit+1;
		int pageSize=limit;
		List<DinnerTableAuxiliary> dtaList=new ArrayList<DinnerTableAuxiliary>();
		List<Dining> dinnerList=dinnerServiceImpl.selPageDinner(startId-1, pageSize);
		for(Dining din:dinnerList) {
			DinnerTableAuxiliary dta=new DinnerTableAuxiliary();
			if(din.getDinnerWay()==0) {		
				dta.setDinnerWay("派送");
			}else if(din.getDinnerWay()==1){
				dta.setDinnerWay("餐厅就餐");
			}else {
				dta.setDinnerWay("error");
			}
			
			dta.setDinnerDate(din.getDinnerDate());
			dta.setDinnerInstructions(din.getDinnerInstructions());
			dta.setDinnerNumber(din.getDinnerNumber());
			String dinnerTime="error";
			if(din.getDinnerTime()==0) {
				dinnerTime="早餐";
			}else if(din.getDinnerTime()==1) {
				dinnerTime="午餐";
			}else if(din.getDinnerTime()==2) {
				dinnerTime="晚餐";
			}
			dta.setDinnerTime(dinnerTime);
			dta.setOrderNumber(din.getOrderNumber());
			dta.setPersonnelName(din.getPersonnel().getPersonnelName());
			dta.setPersonnelPhone(din.getPersonnel().getPersonnelPhone());
			dta.setRestaurantName(din.getPersonnel().getRestaurant().getRestaurantName());
			
			dtaList.add(dta);	
		}
		
		int total=dinnerServiceImpl.selDinnerCount();
		
		System.out.println("表中数据总数："+total);
		System.out.println("信息"+dtaList);
		
		TableReturn<DinnerTableAuxiliary> tr=new TableReturn<DinnerTableAuxiliary>(total, 0, "", dtaList);
		return tr;
	}
	
	@RequestMapping("/search")
	@ResponseBody
	public TableReturn<DinnerTableAuxiliary> search(int page,int limit,String dinnerStartDate,String dinnerEndDate){
		int startId=(page-1)*limit+1;
		int pageSize=limit;
		List<DinnerTableAuxiliary> dtaList=new ArrayList<DinnerTableAuxiliary>();
		List<Dining> dinnerList=dinnerServiceImpl.selPageDinnerByDinnerDate(startId, pageSize, dinnerStartDate, dinnerEndDate);
		TableReturn<DinnerTableAuxiliary> tr=null;
		if(dinnerList!=null) {
			for(Dining din:dinnerList) {
				DinnerTableAuxiliary dta=new DinnerTableAuxiliary();
				if(din.getDinnerWay()==0) {		
					dta.setDinnerWay("派送");
				}else if(din.getDinnerWay()==1){
					dta.setDinnerWay("餐厅就餐");
				}else {
					dta.setDinnerWay("error");
				}
				dta.setDinnerDate(din.getDinnerDate());
				dta.setDinnerInstructions(din.getDinnerInstructions());
				dta.setDinnerNumber(din.getDinnerNumber());
				String dinnerTime="error";
				if(din.getDinnerTime()==0) {
					dinnerTime="早餐";
				}else if(din.getDinnerTime()==1) {
					dinnerTime="午餐";
				}else if(din.getDinnerTime()==2) {
					dinnerTime="晚餐";
				}
				dta.setDinnerTime(dinnerTime);
				dta.setOrderNumber(din.getOrderNumber());
				dta.setPersonnelName(din.getPersonnel().getPersonnelName());
				dta.setPersonnelPhone(din.getPersonnel().getPersonnelPhone());
				dta.setRestaurantName(din.getPersonnel().getRestaurant().getRestaurantName());
				
				dtaList.add(dta);	
			}
			int total=dinnerServiceImpl.selDinnerCountByDinnerDate(dinnerStartDate, dinnerEndDate);
			tr=new TableReturn<DinnerTableAuxiliary>(total, 0, "", dtaList);
		}else {
			tr=new TableReturn<DinnerTableAuxiliary>(0, 0, "", null);
		}
		
		return tr;
	}
}
