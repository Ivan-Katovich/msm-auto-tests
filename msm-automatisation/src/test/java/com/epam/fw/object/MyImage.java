package com.epam.fw.object;

public class MyImage {
	
	private String path;
	private String type;
	private String name;
	
	public MyImage() {}
	
	public MyImage(String name, String path, String type) {
		this.path = path;
		this.type = type;
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
