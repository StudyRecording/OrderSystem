package hu.ordersystem.poji;

import java.io.Serializable;

public class Restaurant implements Serializable {
	private int id;
	private String restaurantName;
	private String restaurantAddr;
	private String restaurantManager;
	private String restaurantManagerphone;
	private boolean isShow;
	public Restaurant(int id, String restaurantName, String restaurantAddr, String restaurantManager,
			String restaurantManagerphone, boolean isShow) {
		super();
		this.id = id;
		this.restaurantName = restaurantName;
		this.restaurantAddr = restaurantAddr;
		this.restaurantManager = restaurantManager;
		this.restaurantManagerphone = restaurantManagerphone;
		this.isShow = isShow;
	}
	public boolean isShow() {
		return isShow;
	}
	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantAddr() {
		return restaurantAddr;
	}
	public void setRestaurantAddr(String restaurantAddr) {
		this.restaurantAddr = restaurantAddr;
	}
	public String getRestaurantManager() {
		return restaurantManager;
	}
	public void setRestaurantManager(String restaurantManager) {
		this.restaurantManager = restaurantManager;
	}
	public String getRestaurantManagerphone() {
		return restaurantManagerphone;
	}
	public void setRestaurantManagerphone(String restaurantManagerphone) {
		this.restaurantManagerphone = restaurantManagerphone;
	}
	public Restaurant(int id, String restaurantName, String restaurantAddr, String restaurantManager,
			String restaurantManagerphone) {
		super();
		this.id = id;
		this.restaurantName = restaurantName;
		this.restaurantAddr = restaurantAddr;
		this.restaurantManager = restaurantManager;
		this.restaurantManagerphone = restaurantManagerphone;
	}
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", restaurantName=" + restaurantName + ", restaurantAddr=" + restaurantAddr
				+ ", restaurantManager=" + restaurantManager + ", restaurantManagerphone=" + restaurantManagerphone
				+ ", isShow=" + isShow + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + (isShow ? 1231 : 1237);
		result = prime * result + ((restaurantAddr == null) ? 0 : restaurantAddr.hashCode());
		result = prime * result + ((restaurantManager == null) ? 0 : restaurantManager.hashCode());
		result = prime * result + ((restaurantManagerphone == null) ? 0 : restaurantManagerphone.hashCode());
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
		Restaurant other = (Restaurant) obj;
		if (id != other.id)
			return false;
		if (isShow != other.isShow)
			return false;
		if (restaurantAddr == null) {
			if (other.restaurantAddr != null)
				return false;
		} else if (!restaurantAddr.equals(other.restaurantAddr))
			return false;
		if (restaurantManager == null) {
			if (other.restaurantManager != null)
				return false;
		} else if (!restaurantManager.equals(other.restaurantManager))
			return false;
		if (restaurantManagerphone == null) {
			if (other.restaurantManagerphone != null)
				return false;
		} else if (!restaurantManagerphone.equals(other.restaurantManagerphone))
			return false;
		if (restaurantName == null) {
			if (other.restaurantName != null)
				return false;
		} else if (!restaurantName.equals(other.restaurantName))
			return false;
		return true;
	}
	
}
