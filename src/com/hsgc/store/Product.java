package com.hsgc.store;
/**
 * 
 * @author hamid
 *
 */
public class Product {
	private Integer id;
	private String name;
	private String brand;
	private String sku;
	private Integer quantity;
	private Float price;

	public Product(Integer id, String name, String brand, String sku,
			Float price, Integer quantity) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.sku = sku;
		this.quantity = quantity;
		this.price = price;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

}
