/**
 * Dattatray Bodhale
	25-Jul-2021
 */
package com.maintenance.controller;

import java.util.Date;
import java.util.Optional;

import org.apache.poi.ss.formula.functions.Odd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maintenance.dto.InspectionDTO;
import com.maintenance.dto.Offer;
import com.maintenance.dto.ResponceObj;
import com.maintenance.model.InspectionCheckPoint;
import com.maintenance.model.InspectionStage;
import com.maintenance.model.InspectionStagesCheckpoint;
import com.maintenance.model.Quotation;
import com.maintenance.model.QuotationWorkPoint;
import com.maintenance.model.SOP;
import com.maintenance.model.SpindleServiceRequest;
import com.maintenance.repo.QuotationRepo;
import com.maintenance.repo.QuotationWorkPointRepo;
import com.maintenance.repo.SOPRepo;

/**
 * @author Dattatray Bodhale
 *
 */
@RestController
@RequestMapping("/offer")
@CrossOrigin("*")
public class OfferController {
	
	@Autowired
	QuotationRepo quotationRepo;
	@Autowired
	QuotationWorkPointRepo quotationWorkPointRepo;
	@Autowired
	SOPRepo sopRepo;

	@RequestMapping(value = "/addOffer", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addOffer(@RequestBody Offer offer ) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Quotation quotation=offer.getQuotation();
			SpindleServiceRequest serviceRequest= new SpindleServiceRequest();
			serviceRequest.setSprindleServiceRequestId(quotation.getSop().getSprindleServiceRequestId());
			quotation.setServiceRequest(serviceRequest);
			quotation.setCreatedDate(new Date());
			Quotation quotation2= quotationRepo.save(quotation);
			
			for(QuotationWorkPoint point:offer.getPoints()){
				QuotationWorkPoint point2= new QuotationWorkPoint();
				point2.setCreatedBy(quotation.getCreatedBy());
				point2.setCreatedDate(new Date());
				point2.setPointNo(point.getPointNo());
				point2.setQuotation(quotation2);
				point2.setScopeOfWork(point.getScopeOfWork());
				quotationWorkPointRepo.save(point2);
				
				}
			SOP sop=quotation.getSop();
			sop.setOfferSendBit(1);
			sopRepo.save(sop);
			
			responceDTO.setCode(200);
			responceDTO.setMessage("Offer Send Successfully");
		
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
	}	
			
		

}



