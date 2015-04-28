package com.epam.fw.object;

public class MyElement {
	
	private String xpath;
	private String type;
	private String name;
	
	public MyElement() {}
	
	public MyElement(String name, String xpath, String type) {
		this.xpath = xpath;
		this.type = type;
		this.name = name;
	}

	public String getXpath() {
		return xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
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
