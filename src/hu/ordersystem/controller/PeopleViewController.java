package hu.ordersystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import hu.ordersystem.poji.PageInfo;
import hu.ordersystem.poji.Personnel;
import hu.ordersystem.service.PersonnelService;

@Controller
@RequestMapping("/peoView")
public class PeopleViewController {
	
	@Resource
	private PersonnelService personnelServiceImpl;
	
	@RequestMapping("/peopleView")
	public String peoView(HttpServletRequest req) {
		int count=personnelServiceImpl.selAllPersonnelCount();
		 
		PageInfo pageInfo=new PageInfo();
		pageInfo.setDataTotal(count);
		pageInfo.setOnePageCount(7);
		pageInfo.setStartId(1);
		int endId=pageInfo.getStartId()+pageInfo.getOnePageCount()-1;
		//List<Personnel> personnelList=personnelServiceImpl.selPersonnelPage(pageInfo.getStartId(), endId);
		 
		//req.setAttribute("pageInfo", pageInfo);
		req.getSession().setAttribute("pageInfo", pageInfo);
		//req.setAttribute("personnelList", personnelList);
		req.getSession().setAttribute("isQuery", false);
		//获取所有数据
		List<Personnel> allList=personnelServiceImpl.selAllPersonnel();
		
		//获取本页数据
		List<Personnel> personnelList=getPageList(pageInfo.getStartId(), endId, allList);
		
		req.setAttribute("personnelList", personnelList);
		return "peoView/peopleView";
	}
	
	/**
	 * 上下页跳转
	 * @param pageStartId	该页的第一条数据id
	 * @param pageEndId		该页的最后一条数据id
	 * @param req			HttpServletRequest
	 * @return
	 */
	@RequestMapping("/jumpPage")
	public String jumpPage(int pageStartId,int pageEndId,HttpServletRequest req) {
		PageInfo pageInfo=(PageInfo) req.getSession().getAttribute("pageInfo");
		pageInfo.setStartId(pageStartId);
		req.getSession().setAttribute("pageInfo", pageInfo);
		
		boolean isQuery=(boolean) req.getSession().getAttribute("isQuery");
		List<Personnel> allList=null;
		//获取所有数据
		if(isQuery!=true) {
			allList=personnelServiceImpl.selAllPersonnel();
		}else {
			allList=(List<Personnel>) req.getSession().getAttribute("allQueryData");
			
		}
		//获取本页数据
		List<Personnel> personnelList=getPageList(pageStartId, pageEndId, allList);
		
		//List<Personnel> personnelList=personnelServiceImpl.selPersonnelPage(pageInfo.getStartId(), pageEndId);
		req.setAttribute("personnelList", personnelList);
		
		return "peoView/peopleView";
	}
	
	/**
	 * 根据条件查找数据
	 * @param personnelName
	 * @param personnelIdnum
	 * @param departName
	 * @param restaurantName
	 * @return
	 */
	@RequestMapping("/selPersonnelByCondition")
	public String selPersonnelByCondition(String personnelName, String personnelIdnum, String departName,String restaurantName,HttpServletRequest req) {
		req.getSession().setAttribute("isQuery", true);
		//获取数据总数
		int count=personnelServiceImpl.selPersonnelByConditionCount(personnelName, personnelIdnum, departName, restaurantName);
		int startId=1;
		int onePageCount=8;
		PageInfo pageInfo=new PageInfo(startId,onePageCount,count);
		int endId=pageInfo.getStartId()+pageInfo.getOnePageCount()-1;
		
		req.getSession().setAttribute("pageInfo", pageInfo);
		
		//获取符合条件的所有数据
		List<Personnel> allList=personnelServiceImpl.selPersonnelByCondition(personnelName, personnelIdnum, departName, restaurantName);
		
		req.getSession().setAttribute("allQueryData", allList);
		
		//获取本页数据
		List<Personnel> personnelList=getPageList(pageInfo.getStartId(), endId, allList);
		
		
		req.setAttribute("personnelList", personnelList);
		return "peoView/peopleView";
	}
	
	/**
	 * 获取该页数据
	 * @param pageStartId	本页第一条数据的id
	 * @param pageEndId		本页最后一条数据的id	
	 * @param list			所有数据
	 * @return				本页数据
	 */
	private List<Personnel> getPageList(int pageStartId,int pageEndId,List<Personnel> list){
		List<Personnel> personnelList=new ArrayList<Personnel>();
		for(int i=pageStartId-1;i<pageEndId;i++) {
			if(i<list.size()) {
				personnelList.add(list.get(i));	
			}
		}
		return personnelList;
	}
	
	
	
}
