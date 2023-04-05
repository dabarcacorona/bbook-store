package com.jadm.model;

public class JsonDet {
	
	private String id;
	private String name;
	private String inactive;
	private String is_warehouse;
	
	public JsonDet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JsonDet(String id, String name, String inactive, String is_warehouse) {
		super();
		this.id = id;
		this.name = name;
		this.inactive = inactive;
		this.is_warehouse = is_warehouse;
	}

	@Override
	public String toString() {
		return "JsonDet [id=" + id + ", name=" + name + ", inactive=" + inactive + ", is_warehouse=" + is_warehouse
				+ "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInactive() {
		return inactive;
	}

	public void setInactive(String inactive) {
		this.inactive = inactive;
	}

	public String getIs_warehouse() {
		return is_warehouse;
	}

	public void setIs_warehouse(String is_warehouse) {
		this.is_warehouse = is_warehouse;
	}
	
	
	
}
