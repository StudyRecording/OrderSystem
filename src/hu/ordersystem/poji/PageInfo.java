package hu.ordersystem.poji;

import java.io.Serializable;

public class PageInfo implements Serializable {
	//每页开始id
	private int startId;
	//一页的数据条数
	private int onePageCount;
	//数据总数
	private int dataTotal;
	public int getStartId() {
		return startId;
	}
	public void setStartId(int startId) {
		this.startId = startId;
	}
	public int getOnePageCount() {
		return onePageCount;
	}
	public void setOnePageCount(int onePageCount) {
		this.onePageCount = onePageCount;
	}
	public int getDataTotal() {
		return dataTotal;
	}
	public void setDataTotal(int dataTotal) {
		this.dataTotal = dataTotal;
	}
	@Override
	public String toString() {
		return "PageInfo [startId=" + startId + ", onePageCount=" + onePageCount + ", dataTotal=" + dataTotal + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dataTotal;
		result = prime * result + onePageCount;
		result = prime * result + startId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PageInfo other = (PageInfo) obj;
		if (dataTotal != other.dataTotal)
			return false;
		if (onePageCount != other.onePageCount)
			return false;
		if (startId != other.startId)
			return false;
		return true;
	}
	public PageInfo(int startId, int onePageCount, int dataTotal) {
		super();
		this.startId = startId;
		this.onePageCount = onePageCount;
		this.dataTotal = dataTotal;
	}
	public PageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
