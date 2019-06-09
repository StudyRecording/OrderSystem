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
	
	//��ȡ���в��ŵ�����
	@Override
	public List<Depart> selAllDepart() {
		
		return departMapper.selAllDepart();
	}

	//��ȡ���ŵ�����
	@Override
	public int selAllDepartCount() {
		
		return departMapper.selAllDepartCount();
	}

	//��ѯ�ض�id��Χ�ڵ�����
	@Override 
	public List<Depart> selDepartByIdRange(int startId, int endId) {
	  
		 return departMapper.selDepartByIdRange(startId, endId); 
	}

	//�޸Ĳ�������
	@Override
	public int updDepartById(String name, int id) {
		return departMapper.updDepartById(name, id);
	}

	//��ҳ��ѯ
	@Override
	public List<Depart> selDepartPaging(int startId, int pageSize) {
		return departMapper.selDepartPaging(startId, pageSize);
	}

	//ɾ��
	@Override
	public int delDepartById(int id) {
		return departMapper.delDepartById(id);
	}

	//��Ӳ���
	@Override
	public int insDepart(String name) {
		return departMapper.insertDepart(name);
	}
	 
	
}
