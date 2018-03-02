package com.rest.domain;

public class ProductAndModelRespone {
	private int ModelId;
	private String name;
	private int width;
	private int height;
	private int length;
	private String link;
	private String image;
	private double price;
	public ProductAndModelRespone() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductAndModelRespone(Integer modelId, String name, int width, int height, int length,
			String link, String image, double price) {
		super();
		ModelId = modelId;
		this.name = name;
		this.width = width;
		this.height = height;
		this.length = length;
		this.link = link;
		this.image = image;
		this.price = price;
	}
	public Integer getModelId() {
		return ModelId;
	}
	public void setModelId(Integer modelId) {
		ModelId = modelId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
