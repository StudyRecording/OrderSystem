package hu.ordersystem.poji;

import java.io.Serializable;

public class Personnel implements Serializable{
	private int id;
	private String personnelName;
	private int personnelSex;
	private String personnelPhone;
	private String personnelIdnum;
	private int departId;//²¿ÃÅµÄid
	private int restaurantId;//²ÍÌüid
	private String personnelDate;
	private Restaurant restaurant;
	private Depart depart;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPersonnelName() {
		return personnelName;
	}
	public void setPersonnelName(String personnelName) {
		this.personnelName = personnelName;
	}
	public int getPersonnelSex() {
		return personnelSex;
	}
	public void setPersonnelSex(int personnelSex) {
		this.personnelSex = personnelSex;
	}
	public String getPersonnelPhone() {
		return personnelPhone;
	}
	public void setPersonnelPhone(String personnelPhone) {
		this.personnelPhone = personnelPhone;
	}
	public String getPersonnelIdnum() {
		return personnelIdnum;
	}
	public void setPersonnelIdnum(String personnelIdnum) {
		this.personnelIdnum = personnelIdnum;
	}
	public int getDepartId() {
		return departId;
	}
	public void setDepartId(int departId) {
		this.departId = departId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getPersonnelDate() {
		return personnelDate;
	}
	public void setPersonnelDate(String personnelDate) {
		this.personnelDate = personnelDate;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public Depart getDepart() {
		return depart;
	}
	public void setDepart(Depart depart) {
		this.depart = depart;
	}
	public Personnel(int id, String personnelName, int personnelSex, String personnelPhone, String personnelIdnum,
			int departId, int restaurantId, String personnelDate, Restaurant restaurant, Depart depart) {
		super();
		this.id = id;
		this.personnelName = personnelName;
		this.personnelSex = personnelSex;
		this.personnelPhone = personnelPhone;
		this.personnelIdnum = personnelIdnum;
		this.departId = departId;
		this.restaurantId = restaurantId;
		this.personnelDate = personnelDate;
		this.restaurant = restaurant;
		this.depart = depart;
	}
	public Personnel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Personnel [id=" + id + ", personnelName=" + personnelName + ", personnelSex=" + personnelSex
				+ ", personnelPhone=" + personnelPhone + ", personnelIdnum=" + personnelIdnum + ", departId=" + departId
				+ ", restaurantId=" + restaurantId + ", personnelDate=" + personnelDate + ", restaurant=" + restaurant
				+ ", depart=" + depart + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((depart == null) ? 0 : depart.hashCode());
		result = prime * result + departId;
		result = prime * result + id;
		result = prime * result + ((personnelDate == null) ? 0 : personnelDate.hashCode());
		result = prime * result + ((personnelIdnum == null) ? 0 : personnelIdnum.hashCode());
		result = prime * result + ((personnelName == null) ? 0 : personnelName.hashCode());
		result = prime * result + ((personnelPhone == null) ? 0 : personnelPhone.hashCode());
		result = prime * result + personnelSex;
		result = prime * result + ((restaurant == null) ? 0 : restaurant.hashCode());
		result = prime * result + restaurantId;
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
		Personnel other = (Personnel) obj;
		if (depart == null) {
			if (other.depart != null)
				return false;
		} else if (!depart.equals(other.depart))
			return false;
		if (departId != other.departId)
			return false;
		if (id != other.id)
			return false;
		if (personnelDate == null) {
			if (other.personnelDate != null)
				return false;
		} else if (!personnelDate.equals(other.personnelDate))
			return false;
		if (personnelIdnum == null) {
			if (other.personnelIdnum != null)
				return false;
		} else if (!personnelIdnum.equals(other.personnelIdnum))
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
		if (personnelSex != other.personnelSex)
			return false;
		if (restaurant == null) {
			if (other.restaurant != null)
				return false;
		} else if (!restaurant.equals(other.restaurant))
			return false;
		if (restaurantId != other.restaurantId)
			return false;
		return true;
	}
	
	
	
}
