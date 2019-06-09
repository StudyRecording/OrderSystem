package hu.ordersystem.poji;

public class Dining {
	private int id;
	//订单单号
	private String orderNumber;
	//订餐人id
	private int personnelId;
	//就餐人数
	private String dinnerNumber;
	//订单日期
	private String orderDate;
	//就餐日期
	private String dinnerDate;
	//就餐段{0：早餐，1：午餐，2：晚餐}
	private int dinnerTime;
	//就餐方式{0：派送，1：餐厅就餐}
	private int dinnerWay;
	//就餐说明
	private String dinnerInstructions;
	
	//订餐人
	private Personnel personnel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getPersonnelId() {
		return personnelId;
	}

	public void setPersonnelId(int personnelId) {
		this.personnelId = personnelId;
	}

	public String getDinnerNumber() {
		return dinnerNumber;
	}

	public void setDinnerNumber(String dinnerNumber) {
		this.dinnerNumber = dinnerNumber;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getDinnerDate() {
		return dinnerDate;
	}

	public void setDinnerDate(String dinnerDate) {
		this.dinnerDate = dinnerDate;
	}

	public int getDinnerTime() {
		return dinnerTime;
	}

	public void setDinnerTime(int dinnerTime) {
		this.dinnerTime = dinnerTime;
	}

	public int getDinnerWay() {
		return dinnerWay;
	}

	public void setDinnerWay(int dinnerWay) {
		this.dinnerWay = dinnerWay;
	}

	public String getDinnerInstructions() {
		return dinnerInstructions;
	}

	public void setDinnerInstructions(String dinnerInstructions) {
		this.dinnerInstructions = dinnerInstructions;
	}

	public Personnel getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

	public Dining(int id, String orderNumber, int personnelId, String dinnerNumber, String orderDate, String dinnerDate,
			int dinnerTime, int dinnerWay, String dinnerInstructions, Personnel personnel) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.personnelId = personnelId;
		this.dinnerNumber = dinnerNumber;
		this.orderDate = orderDate;
		this.dinnerDate = dinnerDate;
		this.dinnerTime = dinnerTime;
		this.dinnerWay = dinnerWay;
		this.dinnerInstructions = dinnerInstructions;
		this.personnel = personnel;
	}

	public Dining() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Dining [id=" + id + ", orderNumber=" + orderNumber + ", personnelId=" + personnelId + ", dinnerNumber="
				+ dinnerNumber + ", orderDate=" + orderDate + ", dinnerDate=" + dinnerDate + ", dinnerTime="
				+ dinnerTime + ", dinnerWay=" + dinnerWay + ", dinnerInstructions=" + dinnerInstructions
				+ ", personnel=" + personnel + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dinnerDate == null) ? 0 : dinnerDate.hashCode());
		result = prime * result + ((dinnerInstructions == null) ? 0 : dinnerInstructions.hashCode());
		result = prime * result + ((dinnerNumber == null) ? 0 : dinnerNumber.hashCode());
		result = prime * result + dinnerTime;
		result = prime * result + dinnerWay;
		result = prime * result + id;
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
		result = prime * result + ((personnel == null) ? 0 : personnel.hashCode());
		result = prime * result + personnelId;
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
		Dining other = (Dining) obj;
		if (dinnerDate == null) {
			if (other.dinnerDate != null)
				return false;
		} else if (!dinnerDate.equals(other.dinnerDate))
			return false;
		if (dinnerInstructions == null) {
			if (other.dinnerInstructions != null)
				return false;
		} else if (!dinnerInstructions.equals(other.dinnerInstructions))
			return false;
		if (dinnerNumber == null) {
			if (other.dinnerNumber != null)
				return false;
		} else if (!dinnerNumber.equals(other.dinnerNumber))
			return false;
		if (dinnerTime != other.dinnerTime)
			return false;
		if (dinnerWay != other.dinnerWay)
			return false;
		if (id != other.id)
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
			return false;
		if (personnel == null) {
			if (other.personnel != null)
				return false;
		} else if (!personnel.equals(other.personnel))
			return false;
		if (personnelId != other.personnelId)
			return false;
		return true;
	}
	
	
}
