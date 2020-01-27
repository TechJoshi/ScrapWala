package com.app.pojos;

public class OdrDtls {
	Integer itemId;
	Integer ordId;
	int quantity;
	public OdrDtls() {
		// TODO Auto-generated constructor stub
	}
	public OdrDtls(Integer itemId, Integer ordId, int quantity) {
		super();
		this.itemId = itemId;
		this.ordId = ordId;
		this.quantity = quantity;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getOrdId() {
		return ordId;
	}
	public void setOrdId(Integer ordId) {
		this.ordId = ordId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OdrDtls [itemId=" + itemId + ", ordId=" + ordId + ", quantity=" + quantity + "]";
	}
	
}
