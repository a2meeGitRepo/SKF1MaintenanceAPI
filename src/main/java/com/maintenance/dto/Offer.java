/**
 * Dattatray Bodhale
	25-Jul-2021
 */
package com.maintenance.dto;

import java.util.List;

import com.maintenance.model.Quotation;
import com.maintenance.model.QuotationWorkPoint;

/**
 * @author Dattatray Bodhale
 *
 */
public class Offer {
	
	private Quotation quotation;
	private List<QuotationWorkPoint> points;
	public Quotation getQuotation() {
		return quotation;
	}
	public void setQuotation(Quotation quotation) {
		this.quotation = quotation;
	}
	public List<QuotationWorkPoint> getPoints() {
		return points;
	}
	public void setPoints(List<QuotationWorkPoint> points) {
		this.points = points;
	}
	
	
	

}



