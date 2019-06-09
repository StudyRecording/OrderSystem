package hu.ordersystem.poji;

public class DinnerTableAuxiliary {
	private String orderNumber;
	private String dinnerTime;
	private String dinnerWay;
	
	public String getDinnerWay() {
		return dinnerWay;
	}
	public void setDinnerWay(String dinnerWay) {
		this.dinnerWay = dinnerWay;
	}
	public DinnerTableAuxiliary(String orderNumber, String dinnerTime, String dinnerNumber, String restaurantName,
			String personnelName, String personnelPhone, String dinnerDate, String dinnerInstructions) {
		super();
		this.orderNumber = orderNumber;
		this.dinnerTime = dinnerTime;
		this.dinnerNumber = dinnerNumber;
		this.restaurantName = restaurantName;
		this.personnelName = personnelName;
		this.personnelPhone = personnelPhone;
		this.dinnerDate = dinnerDate;
		this.dinnerInstructions = dinnerInstructions;
	}
	public String getDinnerTime() {
		return dinnerTime;
	}
	public void setDinnerTime(String dinnerTime) {
		this.dinnerTime = dinnerTime;
	}
	private String dinnerNumber;
	private String restaurantName;
	private String personnelName;
	private String personnelPhone;
	private String dinnerDate;
	private String dinnerInstructions;
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	

	public String getDinnerNumber() {
		return dinnerNumber;
	}
	public void setDinnerNumber(String dinnerNumber) {
		this.dinnerNumber = dinnerNumber;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getPersonnelName() {
		return personnelName;
	}
	public void setPersonnelName(String personnelName) {
		this.personnelName = personnelName;
	}
	public String getPersonnelPhone() {
		return personnelPhone;
	}
	public void setPersonnelPhone(String personnelPhone) {
		this.personnelPhone = personnelPhone;
	}
	public String getDinnerDate() {
		return dinnerDate;
	}
	public void setDinnerDate(String dinnerDate) {
		this.dinnerDate = dinnerDate;
	}
	public String getDinnerInstructions() {
		return dinnerInstructions;
	}
	public void setDinnerInstructions(String dinnerInstructions) {
		this.dinnerInstructions = dinnerInstructions;
	}
	public DinnerTableAuxiliary() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "DinnerTableAuxiliary [orderNumber=" + orderNumber + ", dinnerTime=" + dinnerTime + ", dinnerNumber="
				+ dinnerNumber + ", restaurantName=" + restaurantName + ", personnelName=" + personnelName
				+ ", personnelPhone=" + personnelPhone + ", dinnerDate=" + dinnerDate + ", dinnerInstructions="
				+ dinnerInstructions + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dinnerDate == null) ? 0 : dinnerDate.hashCode());
		result = prime * result + ((dinnerInstructions == null) ? 0 : dinnerInstructions.hashCode());
		result = prime * result + ((dinnerNumber == null) ? 0 : dinnerNumber.hashCode());
		result = prime * result + ((dinnerTime == null) ? 0 : dinnerTime.hashCode());
		result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
		result = prime * result + ((personnelName == null) ? 0 : personnelName.hashCode());
		result = prime * result + ((personnelPhone == null) ? 0 : personnelPhone.hashCode());
		result = prime * result + ((restaurantName == null) ? 0 : restaurantName.hashCode());
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
		DinnerTableAuxiliary other = (DinnerTableAuxiliary) obj;
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
		if (dinnerTime == null) {
			if (other.dinnerTime != null)
				return false;
		} else if (!dinnerTime.equals(other.dinnerTime))
			return false;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
			return false;
		if (personnelName == null) {
			if (other.personnelName != null)
				return false;
		} else if (!personnelName.equals(other.personnelName))
			return false;
		if (personnelPhone == null) {
			if (other.personnelPhone != null)
				return false;
		} else if (!personnelPhone.equals(other.personnelPhone))
			return false;
		if (restaurantName == null) {
			if (other.restaurantName != null)
				return false;
		} else if (!restaurantName.equals(other.restaurantName))
			return false;
		return true;
	}
	
	
	
}
