/**
 * Dattatray Bodhale
	18-May-2021
 */
package com.maintenance.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.maintenance.dto.ResponceObj;
import com.maintenance.model.SOP;
import com.maintenance.model.Spare;
import com.maintenance.model.Spindle;
import com.maintenance.repo.SOPRepo;
import com.maintenance.service.SpareService;

/**
 * @author Dattatray Bodhale
 *
 */
@CrossOrigin("*")
@Controller
@RequestMapping("/spare")
public class SpareController {
	
	@Autowired
	SpareService spareService;
	
	@Autowired
	SOPRepo sOPRepo;
	
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  18-05-2021
	 *  
	 *    List Of  Spare By Pagination
	 * 
	 * */
	@RequestMapping(value = "/getSpareByPagination", method = RequestMethod.GET)
	public @ResponseBody List<Spare> getSpareByPagination(@RequestParam("page_no") int page_no,@RequestParam("item_per_page") int item_per_page) {
		List<Spare> list= new  ArrayList<Spare>();
		try {	
			list=spareService.getSpareByPagination(page_no,item_per_page);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	/*
	 *  Dattatray Bodhale
	 *  
	 *  18-05-2021
	 *  
	 *   Count Of  Spare
	 * 
	 * */
	@RequestMapping(value = "/getSpareCount", method = RequestMethod.GET)
	public @ResponseBody int  getSpareCount() {
		int  count= 0;
		try {
			count= spareService.getSpareCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}


	/*
	 *  Dattatray Bodhale
	 *  
	 *  18-05-2021
	 *  
	 *    List Of  Spare By Pagination And Search
	 * 
	 * */
	@RequestMapping(value = "/getSpareByPaginationAndSerach", method = RequestMethod.GET)
	public @ResponseBody List<Spare> getSpareByPaginationAndSerach(@RequestParam("page_no") int page_no,@RequestParam("item_per_page") int item_per_page,@RequestParam("search") String search) {
		List<Spare> list= new  ArrayList<Spare>();
		try {	
			list=spareService.getSpareByPaginationAndSerach(page_no,item_per_page,search);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	/*
	 *  Dattatray Bodhale
	 *  
	 *  18-05-2021
	 *  
	 *   Count Of  Spare by Search
	 * 
	 * */
	@RequestMapping(value = "/getSpareCountBySearch", method = RequestMethod.GET)
	public @ResponseBody int  getSpareCountBySearch(@RequestParam("search") String search) {
		int  count= 0;
		try {
			count= spareService.getSpareCountBySearch(search);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	
	

/*
 *  Dattatray Bodhale
 *  
 *  18-05-2021
 *  
 *    List Of  Spare By Model
 * 
 * */
@RequestMapping(value = "/getSpareByModels", method = RequestMethod.GET)
public @ResponseBody List<Spare>  getSpareByModels(@RequestParam("model") String model) {
	List<Spare>  list = null;
	try {	
		list=spareService.getSpareByModels(model);
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}




/*
*  Dattatray Bodhale
*  
*  18-05-2021
*  
*    List Of  Spare By Model
* 
* */
@RequestMapping(value = "/getSpareBysopId", method = RequestMethod.GET)
public @ResponseBody List<Spare>  getSpareBysopId(@RequestParam("sopId") int sopId) {
List<Spare>  list = null;
try {
	
	Optional<SOP> sop=sOPRepo.findById(sopId);
	System.out.println("SOP IS Present "+sop.isPresent());
	if(sop.isPresent()){
		list=spareService.getSpareByModels(sop.get().getSpindle().getSpindleModel());
	}
	
	
	
	
} catch (Exception e) {
	e.printStackTrace();
}
return list;
}


	/*
	 *  Dattatray Bodhale
	 *  
	 *  18-05-2021
	 *  
	 *   Get List Of All Spare
	 * 
	 * */
	
	
	@RequestMapping(value = "/getAllSpareList", method = RequestMethod.GET)
	public @ResponseBody List<Spare> getAllSpareList() {
		List<Spare> list = null;

		list= spareService.getAllSpareList();

		return list;
	}
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  18-05-2021
	 *  
	 *   Get List Of All Active Spare
	 * 
	 * */
	
	
	@RequestMapping(value = "/getActiceSpareList", method = RequestMethod.GET)
	public @ResponseBody List<Spare> getActiceSpareList() {
		List<Spare> list = null;

		list= spareService.getActiceSpareList();

		return list;
	}
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  18-05-2021
	 *  
	 *   add New Spare
	 * 
	 * */
	@RequestMapping(value = "/addNewSpare", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addNewSpare(@RequestBody Spare  spare) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<Spare> optional= spareService.getSpareBySpareNameAndSpindleModel(spare.getSpareName(),spare.getSpindleModel());
			//System.out.println(" CODE IS PRESEN "+optional.isPresent()+"   "+spindle.getCustomerCode());
			if(optional.isPresent()){
				responceDTO.setCode(500);
				responceDTO.setMessage("Spare  is  already .....Exits");
			}else{
				spare.setActive(1);
				spare.setAddedDate(new Date());
				spareService.addSpare(spare);
				responceDTO.setCode(200);
				responceDTO.setMessage("spare Added Successfully");
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
	 *  18-05-2021
	 *  
	 *    Change Status
	 * 
	 * */
	
	

	@RequestMapping(value = "/changeStatus", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> changeStatus(@RequestBody Spare  spare) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			
			
			
				
				spareService.addSpare(spare);
				responceDTO.setCode(200);
				responceDTO.setMessage("Spare status updated successfully");
			
				
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
	 *  Update  Spindle 
	 * 
	 * */
	
	

	@RequestMapping(value = "/updateSpare", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> UpdateEmployee(@RequestBody Spare  spare) {
		ResponceObj responceDTO= new ResponceObj();

		try {
		
			
		
			
				spareService.addSpare(spare);
				responceDTO.setCode(200);
				responceDTO.setMessage("Spare Update Successfully");
			
				
		
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}	
	@RequestMapping(value = "/deletSpare", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> deletSpare(@RequestBody Spare  spare) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			
			
			
			spare.setDelBit(1);
				spareService.addSpare(spare);
				responceDTO.setCode(200);
				responceDTO.setMessage("Spare Deleted successfully");
			
				
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity postFile(@ModelAttribute(value = "file") MultipartFile file
		) throws ParseException {
		try {
			
		//	System.out.println("CALLL UPLOAD :::: "+file.getOriginalFilename());
			if (!(file == null)) {
				if (file.isEmpty()) {
				//	logger.info("File not found");
					System.out.println("File not found");
				} else {
					System.out.println(file.getOriginalFilename());
					try {
						File dir = new File(System.getProperty("catalina.base"), "uploads");
						File uplaodedFile = new File(dir + file.getOriginalFilename());
						file.transferTo(uplaodedFile);
						FileInputStream excelFile = new FileInputStream(uplaodedFile);
					//	logger.info("hiiii@  :: " + excelFile);
						Workbook workbook = new XSSFWorkbook(excelFile);
						Sheet datatypeSheet = workbook.getSheetAt(0); 
						int i = 1;
						
						while (i <= datatypeSheet.getLastRowNum()) { 

							XSSFRow row = null;
							row = (XSSFRow) datatypeSheet.getRow(i++);
							if(row.getCell(0)==null){
								continue;
							}
							/*String str = row.getCell(0).toString();
							
							if(str.length()==0 ||row.getCell(0)==null) {
								continue;
							}*/
							
							Optional<Spare>optional = spareService.getSpareBySpareNameAndSpindleModel(row.getCell(1).toString(), row.getCell(2).toString());
									Spare spare= new Spare();
							if(optional.isPresent()){
								spare= optional.get();
								
							}else{
								spare.setActive(1);
								spare.setAddedDate(new Date());
								
							}
							spare.setDescription(row.getCell(3).toString());
							spare.setPrice(Double.valueOf(row.getCell(4).toString()));
							spare.setSpareName(row.getCell(1).toString());
							spare.setSpindleModel(row.getCell(2).toString());
							spare.setUom(row.getCell(5).toString());
							
							
							spareService.addSpare(spare);
						}


					//	logger.info("Successfully imported");
						workbook.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}



