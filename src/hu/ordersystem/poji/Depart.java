package hu.ordersystem.poji;

import java.io.Serializable;

public class Depart implements Serializable{
	private int id;
	private String departName;
	private boolean isShow;
	public Depart(int id, String departName, boolean isShow) {
		super();
		this.id = id;
		this.departName = departName;
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
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	@Override
	public String toString() {
		return "Depart [id=" + id + ", departName=" + departName + ", isShow=" + isShow + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departName == null) ? 0 : departName.hashCode());
		result = prime * result + id;
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
		Depart other = (Depart) obj;
		if (departName == null) {
			if (other.departName != null)
				return false;
		} else if (!departName.equals(other.departName))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	public Depart(int id, String departName) {
		super();
		this.id = id;
		this.departName = departName;
	}
	public Depart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
