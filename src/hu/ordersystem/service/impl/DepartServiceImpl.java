package hu.ordersystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hu.ordersystem.mapper.DepartMapper;
import hu.ordersystem.poji.Depart;
import hu.ordersystem.service.DepartService;

@Service
public class DepartServiceImpl implements DepartService {

	@Resource
	private DepartMapper departMapper;
	
	//获取所有部门的数据
	@Override
	public List<Depart> selAllDepart() {
		
		return departMapper.selAllDepart();
	}

	//获取部门的总数
	@Override
	public int selAllDepartCount() {
		
		return departMapper.selAllDepartCount();
	}

	//查询特定id范围内的数据
	@Override 
	public List<Depart> selDepartByIdRange(int startId, int endId) {
	  
		 return departMapper.selDepartByIdRange(startId, endId); 
	}

	//修改部门名称
	@Override
	public int updDepartById(String name, int id) {
		return departMapper.updDepartById(name, id);
	}

	//分页查询
	@Override
	public List<Depart> selDepartPaging(int startId, int pageSize) {
		return departMapper.selDepartPaging(startId, pageSize);
	}

	//删除
	@Override
	public int delDepartById(int id) {
		return departMapper.delDepartById(id);
	}

	//添加部门
	@Override
	public int insDepart(String name) {
		return departMapper.insertDepart(name);
	}
	 
	
}
