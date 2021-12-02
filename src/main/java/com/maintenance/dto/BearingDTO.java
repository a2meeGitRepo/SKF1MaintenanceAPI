/**
 * Dattatray Bodhale
	14-May-2021
 */
package com.maintenance.dto;

import java.util.List;

import com.maintenance.model.BearringAccessory;

/**
 * @author Dattatray Bodhale
 *
 */
public class BearingDTO {
	
	List<BearringAccessory> frontBearing;
	List<BearringAccessory> rearBearing;
	public List<BearringAccessory> getFrontBearing() {
		return frontBearing;
	}
	public void setFrontBearing(List<BearringAccessory> frontBearing) {
		this.frontBearing = frontBearing;
	}
	public List<BearringAccessory> getRearBearing() {
		return rearBearing;
	}
	public void setRearBearing(List<BearringAccessory> rearBearing) {
		this.rearBearing = rearBearing;
	}
	
	

}



