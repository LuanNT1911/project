package com.groupproject.adminweb.dto;

import java.util.Date;

public class ProductRespone {
	private Integer id;
	private String name;
	private double price;
	private int quantity;
	private String origin;
	private double weight;
	private String describe;
	private String image;
	private int status;
	private String createAt;
	private String updateAt;
	private Integer modelId;
	private Integer productId;
	private String rejectReason;

	public ProductRespone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductRespone(Integer id, String name, double price, int quantity, String origin, double weight,
			String describe, String image, int status, String createAt, String updateAt, Integer modelId, Integer productId,
			String rejectReason) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.origin = origin;
		this.weight = weight;
		this.describe = describe;
		this.image = image;
		this.status = status;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.modelId = modelId;
		this.productId = productId;
		this.rejectReason = rejectReason;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	public String getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(String updateAt) {
		this.updateAt = updateAt;
	}

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

}
