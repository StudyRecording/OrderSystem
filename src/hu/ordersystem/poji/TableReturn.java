package hu.ordersystem.poji;

import java.util.List;

public class TableReturn<T> {
	
	private int total;
	private int status;
	private String msg;
	private List<T> data;
	public int getStatus() {
		return status;
	}
	public TableReturn(int total, int status, String msg, List<T> data) {
		super();
		this.total = total;
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getDate() {
		return data;
	}
	public void setDate(List<T> date) {
		this.data = date;
	}
	public TableReturn(int total, List<T> data) {
		super();
		this.total = total;
		this.data = data;
	}
	public TableReturn() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
