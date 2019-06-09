package hu.ordersystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hu.ordersystem.mapper.DinnerMapper;
import hu.ordersystem.poji.Dining;
import hu.ordersystem.service.DinnerService;

@Service
public class DinnerServiceImpl implements DinnerService {

	@Resource
	private DinnerMapper dinnerMapper;

	//查找最后一个订单单号
	@Override
	public Dining selLastOneOrderNumber() {
		
		return dinnerMapper.selLastOneOrderNumber();
	}

	//新增一条点餐信息
	@Override
	public int insDining(Dining dinner) {
		return dinnerMapper.insDinner(dinner);
	}

	//分页查询一页的数据
	@Override
	public List<Dining> selPageDinner(int startId, int pageSize) {
		return dinnerMapper.selPageDinner(startId, pageSize);
	}

	//查询表中数据的数量
	@Override
	public int selDinnerCount() {
		return dinnerMapper.setDinnerCount();
	}

	//根据派餐日期查询数据
	@Override
	public List<Dining> selPageDinnerByDinnerDate(int StartId, int pageSize, String dinnerStartDate,
			String dinnerEndDate) {
		return dinnerMapper.selPageDinnerByDinnerDate(StartId, pageSize, dinnerStartDate, dinnerEndDate);
	}

	//根据派餐日期计算符合条件的数据数量
	@Override
	public int selDinnerCountByDinnerDate(String dinnerStartDate, String dinnerEndDate) {
		return dinnerMapper.selDinnerCountByDinnerDate(dinnerStartDate, dinnerEndDate);
	}
	
	
}
