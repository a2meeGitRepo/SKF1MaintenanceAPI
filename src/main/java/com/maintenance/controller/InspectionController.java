/**
 * Dattatray Bodhale
	13-May-2021
 */
package com.maintenance.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maintenance.dto.InspectionDTO;
import com.maintenance.dto.ResponceObj;
import com.maintenance.model.Customer;
import com.maintenance.model.InspectionCheckPoint;
import com.maintenance.model.InspectionStage;
import com.maintenance.model.InspectionStagesCheckpoint;
import com.maintenance.service.InspectionService;

/**
 * @author Dattatray Bodhale
 *
 */
@RestController
@RequestMapping("/inspection")
@CrossOrigin("*")
public class InspectionController {
	
	
	
	
	@Autowired
	InspectionService inspectionService;
	
//********************************************************* INSPECTION STAGE *************************************//	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  14-05-2021
	 *  
	 *    Add new Inspection Stage with Check  Point
	 * 
	 * */
	
	
	@RequestMapping(value = "/addNewInspectionStageCheckPoint", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addNewInspectionStageCheckPoint(@RequestBody InspectionDTO  inspectionDTO) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<InspectionStage> optional= inspectionService.getInspectionStageByName(inspectionDTO.getInspectionStage().getStageName(),inspectionDTO.getInspectionStage().getSpindleModel());
			if(optional.isPresent()){
				responceDTO.setCode(500);
				responceDTO.setMessage("Inspection Stage   is  already .....Exits");
			}else{
				inspectionDTO.getInspectionStage().setActive(1);
				inspectionDTO.getInspectionStage().setAddedDate(new Date());
				inspectionDTO.getInspectionStage().setAddedBy(inspectionDTO.getAddedBy());
				InspectionStage  inspectionStage= inspectionService.saveInspectionStaege(inspectionDTO.getInspectionStage());
				
				for(InspectionCheckPoint  inspectionCheckPoint:inspectionDTO.getCheckpoints()){
					InspectionStagesCheckpoint inspectionStageCheckPoint= new InspectionStagesCheckpoint();
					inspectionStageCheckPoint.setActive(1);
					inspectionStageCheckPoint.setAddedDate(new Date());
					inspectionStageCheckPoint.setInspectionStage(inspectionStage);
					inspectionStageCheckPoint.setInspectionCheckPoint(inspectionCheckPoint);
					inspectionStageCheckPoint.setAddedBy(inspectionDTO.getAddedBy());
					inspectionService.addInspectionStageCheckPoint(inspectionStageCheckPoint);
				}
				
				
				
				
				responceDTO.setCode(200);
				responceDTO.setMessage("Inspection CheckPoint Added Successfully");
			}
				
		
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  14-05-2021
	 *  
	 *    Update Inspection Stage with Check  Point
	 * 
	 * */
	
	
	@RequestMapping(value = "/updatenspectionStageCheckPoint", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> updatenspectionStageCheckPoint(@RequestBody InspectionDTO  inspectionDTO) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			
				inspectionDTO.getInspectionStage().setActive(1);
				inspectionDTO.getInspectionStage().setAddedDate(new Date());
				InspectionStage  inspectionStage= inspectionService.saveInspectionStaege(inspectionDTO.getInspectionStage());
				
				for(InspectionCheckPoint  inspectionCheckPoint:inspectionDTO.getCheckpoints()){
					
					Optional<InspectionStagesCheckpoint> optional= inspectionService.getInspeacctionStageCheckPointByInspectionStageAndCheckPoint(inspectionStage.getInspectionStageId(),inspectionCheckPoint.getInspectionCheckpointId());
					
					System.out.println("CheckPoint :: "+inspectionCheckPoint.getCheckPointName());
					if(!optional.isPresent()){
						
						InspectionStagesCheckpoint inspectionStageCheckPoint= new InspectionStagesCheckpoint();
						inspectionStageCheckPoint.setActive(1);
						inspectionStageCheckPoint.setAddedDate(new Date());
						inspectionStageCheckPoint.setInspectionStage(inspectionStage);
						inspectionStageCheckPoint.setInspectionCheckPoint(inspectionCheckPoint);
						inspectionService.addInspectionStageCheckPoint(inspectionStageCheckPoint);
					}
					
				}
				
				
				
				
				responceDTO.setCode(200);
				responceDTO.setMessage("Inspection CheckPoint Added Successfully");
			
				
		
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}	

/*
 *  Dattatray Bodhale
 *  
 *  14-05-2021
 *  
 *    List Of  Inspection Stage By Pagination
 * 
 * */
@RequestMapping(value = "/getInspectionStageByPagination", method = RequestMethod.GET)
public @ResponseBody List<InspectionStage> getInspectionStageByPagination(@RequestParam("page_no") int page_no,@RequestParam("item_per_page") int item_per_page) {
	List<InspectionStage> list= new  ArrayList<InspectionStage>();
	try {	
		list=inspectionService.getInspectionStageByPagination(page_no,item_per_page);
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}



/*
 *  Dattatray Bodhale
 *  
 *  14-05-2021
 *  
 *   Count Of  InspectionStage
 * 
 * */
@RequestMapping(value = "/getInspectionStageCount", method = RequestMethod.GET)
public @ResponseBody int  getInspectionStageCount() {
	int  count= 0;
	try {
		count= inspectionService.getInspectionStageCount();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return count;
}	
	
/*
 *  Dattatray Bodhale
 *  
 *  14-05-2021
 *  
 *    List Of  Inspection Stage By Pagination
 * 
 * */
@RequestMapping(value = "/getInspectionStageByPaginationAndSerach", method = RequestMethod.GET)
public @ResponseBody List<InspectionStage> getInspectionStageByPaginationAndSerach(@RequestParam("page_no") int page_no,@RequestParam("item_per_page") int item_per_page,@RequestParam("search") String search) {
	List<InspectionStage> list= new  ArrayList<InspectionStage>();
	try {	
		list=inspectionService.getInspectionStageByPaginationAndSerach(page_no,item_per_page,search);
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}



/*
 *  Dattatray Bodhale
 *  
 *  14-05-2021
 *  
 *   Count Of  InspectionStage
 * 
 * */
@RequestMapping(value = "/getInspectionStageCountBySearch", method = RequestMethod.GET)
public @ResponseBody int  getInspectionStageCountBySeach(String search) {
	int  count= 0;
	try {
		count= inspectionService.getInspectionStageCountBySeach(search);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return count;
}	
	
	
/*
 *  Dattatray Bodhale
 *  
 *  14-05-2021
 *  
 *    Get New Stage No by Model
 * 
 * */
@RequestMapping(value = "/getNewStageNoByModel", method = RequestMethod.GET)
public @ResponseBody int getNewStageNoByModel(@RequestParam("model") String model) {
	int stageno = 0;
	try {	
		stageno=inspectionService.getNewStageNoByModel(model);
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return stageno;
}	
	

/*
 *  Dattatray Bodhale
 *  
 *  14-05-2021
 *  
 *    Change Status  Inspection Stages 
 * 
 * */



@RequestMapping(value = "/changeStatusInspecationStage", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<ResponceObj> changeStatusInspecationStage(@RequestBody InspectionStage  inspectionStage) {
	ResponceObj responceDTO= new ResponceObj();

	try {
		
		
		
			
			inspectionService.saveInspectionStaege(inspectionStage);
			responceDTO.setCode(200);
			responceDTO.setMessage("Inspection Stage status updated successfully");
		
			
		return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		
	} catch (Exception e) {
		// TODO: handle exception
		responceDTO.setCode(500);
		responceDTO.setMessage(e.getMessage());
		return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
	}
	
		
	}
	
/*
 *  Dattatray Bodhale
 *  
 *  14-05-2021
 *  
 *    List Of  Inspection Stage By Pagination
 * 
 * */
@RequestMapping(value = "/getInspeactionStagesMappedCheckPoint", method = RequestMethod.GET)
public @ResponseBody List<InspectionStagesCheckpoint> getInspeactionStagesMappedCheckPoint(@RequestParam("inspectionStage") int inspectionStage) {
	List<InspectionStagesCheckpoint> list= new  ArrayList<InspectionStagesCheckpoint>();
	try {	
		list=inspectionService.getInspeactionStagesMappedCheckPoint(inspectionStage);
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}


/*
*  Dattatray Bodhale
*  
*  05-05-2021
*  
//*    Delete  Inspection CheckPoint
* 
* */



@RequestMapping(value = "/deleteInspectionStage", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<ResponceObj> deleteCustomer(@RequestBody InspectionStage  inspectionStage) {
ResponceObj responceDTO= new ResponceObj();

try {
	
	List<InspectionStagesCheckpoint> stagesCheckpoints=inspectionService.getInspeactionStagesMappedCheckPoint(inspectionStage.getInspectionStageId());
	for(InspectionStagesCheckpoint checkpoint:stagesCheckpoints){
		checkpoint.setDelBit(1);
		inspectionService.addInspectionStageCheckPoint(checkpoint);
		
	}
	
	inspectionStage.setDelBit(1);
		inspectionService.saveInspectionStaege(inspectionStage);
		responceDTO.setCode(200);
		responceDTO.setMessage("Inspection Stage  Deleted successfully");
	
		
	return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
	
} catch (Exception e) {
	// TODO: handle exception
	responceDTO.setCode(500);
	responceDTO.setMessage(e.getMessage());
	return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
}

	
}
/*
 *  Dattatray Bodhale
 *  
 *  14-05-2021
 *  
 *    List Of  Inspection Stage By Pagination
 * 
 * */
@RequestMapping(value = "/getAllInspectionStage", method = RequestMethod.GET)
public @ResponseBody List<InspectionStage> getAllInspectionStage() {
	List<InspectionStage> list= new  ArrayList<InspectionStage>();
	try {	
		list=inspectionService.getAllInspectionStage();
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}

	
//********************************************************* INSPECTION CHECK POINT *************************************//	


/*
 *  Dattatray Bodhale
 *  
 *  13-05-2021
 *  
 *    List Of  Inspection CheckPoint By Pagination
 * 
 * */
@RequestMapping(value = "/getInspectionCheckPointByPagination", method = RequestMethod.GET)
public @ResponseBody List<InspectionCheckPoint> getInspectionCheckPointByPagination(@RequestParam("page_no") int page_no,@RequestParam("item_per_page") int item_per_page) {
	List<InspectionCheckPoint> list= new  ArrayList<InspectionCheckPoint>();
	try {	
		list=inspectionService.getInspectionCheckPointByPagination(page_no,item_per_page);
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}


/*
 *  Dattatray Bodhale
 *  
 *  13-05-2021
 *  
 *   Count Of  InspectionCheckPoint
 * 
 * */
@RequestMapping(value = "/getInspectionCheckPointCount", method = RequestMethod.GET)
public @ResponseBody int  getInspectionCheckPointCount() {
	int  count= 0;
	try {
		count= inspectionService.getInspectionCheckPointCount();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return count;
}


/*
 *  Dattatray Bodhale
 *  
 *  13-05-2021
 *  
 *    List Of  InspectionCheckPoint  By Pagination And Search
 * 
 * */
@RequestMapping(value = "/getInspectionCheckPointByPaginationAndSerach", method = RequestMethod.GET)
public @ResponseBody List<InspectionCheckPoint> getInspectionCheckPointByPaginationAndSerach(@RequestParam("page_no") int page_no,@RequestParam("item_per_page") int item_per_page,@RequestParam("search") String search) {
	List<InspectionCheckPoint> list= new  ArrayList<InspectionCheckPoint>();
	try {	
		list=inspectionService.getInspectionCheckPointByPaginationAndSerach(page_no,item_per_page,search);
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}


/*
 *  Dattatray Bodhale
 *  
 *  13-05-2021
 *  
 *   Count Of  InspectionCheckPoint by Search
 * 
 * */
@RequestMapping(value = "/getInspectionCheckPointCountBySearch", method = RequestMethod.GET)
public @ResponseBody int  getInspectionCheckPointCountBySearch(@RequestParam("search") String search) {
	int  count= 0;
	try {
		count= inspectionService.getInspectionCheckPointCountBySearch(search);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return count;
}



	/*
	 *  Dattatray Bodhale
	 *  
	 *  13-05-2021
	 *  
	 *   Get List Of All InspectionCheckPoint
	 * 
	 * */
	
	
	@RequestMapping(value = "/getAllInspectionCheckPointList", method = RequestMethod.GET)
	public @ResponseBody List<InspectionCheckPoint> getAllInspectionCheckPointList() {
		List<InspectionCheckPoint> list = null;

		list= inspectionService.getAllInspectionCheckPointList();

		return list;
	}
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  13-05-2021
	 *  
	 *   Get List Of Active InspectionCheckPoint
	 * 
	 * */
	
	
	@RequestMapping(value = "/getActiveInspectionCheckPointList", method = RequestMethod.GET)
	public @ResponseBody List<InspectionCheckPoint> getActiveInspectionCheckPointList() {
		List<InspectionCheckPoint> list = null;

		list= inspectionService.getActiveInspectionCheckPointList();

		return list;
	}
	
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  13-05-2021
	 *  
	 *    Add New  InspectionCheckPoint 
	 * 
	 * */
	
	

	@RequestMapping(value = "/addNewInspectionCheckPoint", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addNewInspectionCheckPoint(@RequestBody InspectionCheckPoint  inspectionCheckPoint) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<InspectionCheckPoint> optional= inspectionService.getInspectionCheckPointByName(inspectionCheckPoint.getCheckPointName());
			if(optional.isPresent()){
				responceDTO.setCode(500);
				responceDTO.setMessage("Inspection CheckPoint  is  already .....Exits");
			}else{
				inspectionCheckPoint.setActive(1);
				inspectionCheckPoint.setAddedDate(new Date());
				inspectionService.addInspectionCheckPoint(inspectionCheckPoint);
				responceDTO.setCode(200);
				responceDTO.setMessage("Inspection CheckPoint Added Successfully");
			}
				
		
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}

	/*
	 *  Dattatray Bodhale
	 *  
	 *  05-05-2021
	 *  
	 *    Change Status  InspectionCheckPoint 
	 * 
	 * */
	
	

	@RequestMapping(value = "/changeStatus", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> changeStatus(@RequestBody InspectionCheckPoint  inspectionCheckPoint) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			
			
			
				
				inspectionService.addInspectionCheckPoint(inspectionCheckPoint);
				responceDTO.setCode(200);
				responceDTO.setMessage("InspectionCheckPoint status updated successfully");
			
				
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	/*
	 *  Dattatray Bodhale
	 *  
	 *  05-05-2021
	 *  
//	 *    Delete  Inspection CheckPoint
	 * 
	 * */
	
	

	@RequestMapping(value = "/deleteInspectionCheckPoint", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> deleteCustomer(@RequestBody InspectionCheckPoint  inspectionCheckPoint) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			
			
			
			inspectionCheckPoint.setDelBit(1);
				inspectionService.addInspectionCheckPoint(inspectionCheckPoint);
				responceDTO.setCode(200);
				responceDTO.setMessage("Inspection CheckPoint updated successfully");
			
				
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}

	/*
	 *  Dattatray Bodhale
	 *  
	 *  05-05-2021
	 *  
	 *  Update  Inspection CheckPoint 
	 * 
	 * */
	
	

	@RequestMapping(value = "/updateInspectionCheckPoint", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> UpdateEmployee(@RequestBody InspectionCheckPoint  inspectionCheckPoint) {
		ResponceObj responceDTO= new ResponceObj();

		try {
		
			
		
			
				inspectionCheckPoint.setUpdDatetime(new Date());
				inspectionService.addInspectionCheckPoint(inspectionCheckPoint);
				responceDTO.setCode(200);
				responceDTO.setMessage("Inspection CheckPoint Update Successfully");
			
				
		
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}	

}



