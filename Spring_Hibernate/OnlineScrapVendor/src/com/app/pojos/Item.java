package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {
	private Integer id;
	private String itemName;
	private double itemPrice;
	private ItemCategory itemCategory;
	private String itemImage;
	
	public Item() { 	}

	public Item(String itemName, double itemPrice, ItemCategory itemCategory) {
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemCategory = itemCategory;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 30,name = "item_name")
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Column(name = "item_price")
	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "item_category")
	public ItemCategory getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(ItemCategory itemCategory) {
		this.itemCategory = itemCategory;
	}

	
	@Column(name = "item_image",length = 512)
	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemCategory="
				+ itemCategory + "]";
	}
	
	
}
