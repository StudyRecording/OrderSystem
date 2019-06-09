package hu.ordersystem.service;

import java.util.List;

import hu.ordersystem.poji.Depart;

public interface DepartService {

	
	List<Depart> selAllDepart();
	
	int selAllDepartCount();
	
	List<Depart> selDepartByIdRange(int startId,int endId);
	 
	int updDepartById(String name,int id);
	
	List<Depart> selDepartPaging(int startId,int pageSize);
	
	int delDepartById(int id);
	
	int insDepart(String name);
}
