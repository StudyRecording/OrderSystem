package hu.ordersystem.service;

import java.util.List;

import hu.ordersystem.poji.Dining;

public interface DinnerService {
	
	Dining selLastOneOrderNumber();
	
	int insDining(Dining dinner);
	
	List<Dining> selPageDinner(int startId,int pageSize);
	
	int selDinnerCount();
	
	List<Dining> selPageDinnerByDinnerDate(int StartId,int pageSize,String dinnerStartDate,String dinnerEndDate);

	int selDinnerCountByDinnerDate(String dinnerStartDate,String dinnerEndDate);
}
