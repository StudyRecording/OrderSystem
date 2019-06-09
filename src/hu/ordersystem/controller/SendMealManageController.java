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
	 * ��Ӷ�����Ϣ
	 * @param dinner
	 * @param personnel
	 */
	@RequestMapping("/addSendMeal")
	@ResponseBody
	public void addSendMeal(Dining dinner,Personnel personnel) {
		//��������Ϊ��00000000-0000	 �Ͳͷ�ʽ��0	�������ڣ�
		//form�ύ������Ϣ{dinnerDate,dinnerTime,dinnerNumber,dinnerInstructions}	
		//form�ύ��������Ϣ{personnelName,personnelPhone,restaurantId}
		
		//���ɶ�������
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String orderDate=dateFormat.format(new Date());
		dinner.setOrderDate(orderDate);
		
		//���ɶ�������
		dateFormat=new SimpleDateFormat("yyyyMMdd");
		String prefixOrderNumber=dateFormat.format(new Date());
		String thisOrderNumber=null;
		//��ȡdinning�������һ����Ϣ��select * from table order by id DESC limit 1��
		//ȡ���ж�������(lastNumber)����ǰ8λ�Ƿ���prefixOrderNumber��ͬ�������ͬ��ȥlastNumber����λ+1��
		//����prefixOrderNumber+0000
		Dining din=dinnerServiceImpl.selLastOneOrderNumber();
		
		if(din!=null) {
			String lastOrderNumber=din.getOrderNumber();
			System.out.println("��һ�������ţ�"+lastOrderNumber);
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
		
		//�Ͳͷ�ʽ��������
		dinner.setDinnerWay(0);
		
		//���ƶ�������Ϣ
		Personnel person=personnelServiceImpl.selPersonnelByPhoneLimitOne(personnel.getPersonnelPhone());
		if(person!=null) {
			//System.out.println("��ѯ��"+person);
			person.setRestaurantId(personnel.getRestaurantId());	
			person.setPersonnelDate(orderDate);
			personnel=person;	
		}else {
			personnel.setPersonnelDate(orderDate);
			personnel.setDepartId(26);
			personnel.setPersonnelSex(3);
		}
		//���붩���˱�
		int personnelNum=personnelServiceImpl.insPersonnel(personnel);
		
		//��øող���personnel��id
		personnel=personnelServiceImpl.selPersonnelByPhoneAndDate(personnel);
		
		//���ƶ��ͱ��ж����˵�id
		dinner.setPersonnelId(personnel.getId());
		
		//System.out.println("�ύ:"+personnel);
		//System.out.println("�ύ"+dinner);
		
		
		
		//���붩�ͱ�
		if(personnelNum>0) {
			int dinnerNum=dinnerServiceImpl.insDining(dinner);
			if(dinnerNum>0) {
				System.out.println("����ɹ�");
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
				dta.setDinnerWay("����");
			}else if(din.getDinnerWay()==1){
				dta.setDinnerWay("�����Ͳ�");
			}else {
				dta.setDinnerWay("error");
			}
			
			dta.setDinnerDate(din.getDinnerDate());
			dta.setDinnerInstructions(din.getDinnerInstructions());
			dta.setDinnerNumber(din.getDinnerNumber());
			String dinnerTime="error";
			if(din.getDinnerTime()==0) {
				dinnerTime="���";
			}else if(din.getDinnerTime()==1) {
				dinnerTime="���";
			}else if(din.getDinnerTime()==2) {
				dinnerTime="���";
			}
			dta.setDinnerTime(dinnerTime);
			dta.setOrderNumber(din.getOrderNumber());
			dta.setPersonnelName(din.getPersonnel().getPersonnelName());
			dta.setPersonnelPhone(din.getPersonnel().getPersonnelPhone());
			dta.setRestaurantName(din.getPersonnel().getRestaurant().getRestaurantName());
			
			dtaList.add(dta);	
		}
		
		int total=dinnerServiceImpl.selDinnerCount();
		
		System.out.println("��������������"+total);
		System.out.println("��Ϣ"+dtaList);
		
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
					dta.setDinnerWay("����");
				}else if(din.getDinnerWay()==1){
					dta.setDinnerWay("�����Ͳ�");
				}else {
					dta.setDinnerWay("error");
				}
				dta.setDinnerDate(din.getDinnerDate());
				dta.setDinnerInstructions(din.getDinnerInstructions());
				dta.setDinnerNumber(din.getDinnerNumber());
				String dinnerTime="error";
				if(din.getDinnerTime()==0) {
					dinnerTime="���";
				}else if(din.getDinnerTime()==1) {
					dinnerTime="���";
				}else if(din.getDinnerTime()==2) {
					dinnerTime="���";
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
