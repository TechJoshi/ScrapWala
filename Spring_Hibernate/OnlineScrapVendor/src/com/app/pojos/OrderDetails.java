package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetails {

	private Integer id;
	private Order order;
	private Item item;
	private int quantity;
	
	public OrderDetails() { }

	public OrderDetails(int quantity) {
		super();
		this.quantity = quantity;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="order_id")
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="item_id")
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", quantity=" + quantity + "]";
	}

	
}
