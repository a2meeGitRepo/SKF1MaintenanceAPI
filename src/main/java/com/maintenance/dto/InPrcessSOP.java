/**
 * Dattatray Bodhale
	14-Jun-2021
 */
package com.maintenance.dto;

import com.maintenance.model.Customer;
import com.maintenance.model.Spindle;

/**
 * @author Dattatray Bodhale
 *
 */
public class InPrcessSOP {
private Customer customer;
private Spindle spindle;
private String issue;
private int total_complate_stage;
private double per_of_complate;
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public Spindle getSpindle() {
	return spindle;
}
public void setSpindle(Spindle spindle) {
	this.spindle = spindle;
}
public String getIssue() {
	return issue;
}
public void setIssue(String issue) {
	this.issue = issue;
}
public int getTotal_complate_stage() {
	return total_complate_stage;
}
public void setTotal_complate_stage(int total_complate_stage) {
	this.total_complate_stage = total_complate_stage;
}
public double getPer_of_complate() {
	return per_of_complate;
}
public void setPer_of_complate(double per_of_complate) {
	this.per_of_complate = per_of_complate;
}




}



