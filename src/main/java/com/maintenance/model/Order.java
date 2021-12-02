/**
 * Dattatray Bodhale
	02-Jun-2021
 */
package com.maintenance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Dattatray Bodhale
 *
 */

@Entity
@Table(name="order_tr")
public class Order {
	
	@Id
	@GeneratedValue
	@Column(name="order_id")
	private int orderId;
	
	@ManyToOne
	@JoinColumn(name="sprindle_service_request_id")
	private SpindleServiceRequest spindleServiceRequest;
	
	
	
	@Column(name="order_no")
	private String orderNo;
	

	@Column(name="order_date")
	private Date orderDate;

	@Column(name="order_price")
	private double orderPrice;

	@Column(name="added_date")
	private Date addedDate;
	
	@Column(name="added_by")
	private String addedBy;

	@Column(name="upd_datetime")
	private Date updDatetime;
	
	@Column(name="active")
	private int active;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public SpindleServiceRequest getSpindleServiceRequest() {
		return spindleServiceRequest;
	}

	public void setSpindleServiceRequest(SpindleServiceRequest spindleServiceRequest) {
		this.spindleServiceRequest = spindleServiceRequest;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public Date getUpdDatetime() {
		return updDatetime;
	}

	public void setUpdDatetime(Date updDatetime) {
		this.updDatetime = updDatetime;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", spindleServiceRequest=" + spindleServiceRequest + ", orderNo=" + orderNo
				+ ", orderDate=" + orderDate + ", orderPrice=" + orderPrice + ", addedDate=" + addedDate + ", addedBy="
				+ addedBy + ", updDatetime=" + updDatetime + ", active=" + active + ", getOrderId()=" + getOrderId()
				+ ", getSpindleServiceRequest()=" + getSpindleServiceRequest() + ", getOrderNo()=" + getOrderNo()
				+ ", getOrderDate()=" + getOrderDate() + ", getOrderPrice()=" + getOrderPrice() + ", getAddedDate()="
				+ getAddedDate() + ", getAddedBy()=" + getAddedBy() + ", getUpdDatetime()=" + getUpdDatetime()
				+ ", getActive()=" + getActive() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}



