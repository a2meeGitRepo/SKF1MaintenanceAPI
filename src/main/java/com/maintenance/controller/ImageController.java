/**
 * Dattatray Bodhale
	22-Jun-2021
 */
package com.maintenance.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import sun.misc.BASE64Decoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maintenance.dto.ComplaintVisitImage;
import com.maintenance.dto.ImageCode;
import com.maintenance.dto.ResponceObj;
import com.maintenance.model.SOP;
import com.maintenance.model.SOPImage;
import com.maintenance.model.SpindleServiceRequest;
import com.maintenance.service.ImageService;
import com.maintenance.service.SOPService;
import com.maintenance.service.ServiceSer;

/**
 * @author Dattatray Bodhale
 *
 */
@CrossOrigin("*")
@Controller
@RequestMapping("/image")
public class ImageController {

	@Autowired
	SOPService sOPService;
	@Autowired
	ImageService imageService;
	@Autowired
	ServiceSer serviceSer;
	 String imagepath="SOPImages";
	@RequestMapping(value = "/addSOPImages", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponceObj addSOPImages(@RequestBody ComplaintVisitImage complaintImage) {
		ResponceObj status = new ResponceObj();
	
		
		try {
			System.out.println("Call Image Uplaod "); 
			   List<SOPImage> list = new ArrayList<SOPImage>();
			  
			   DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
			   DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
			   String lastBest64String="";
				if(complaintImage.getImages().size()!=0) {
					
					int i=0;
					 System.out.println("Image Size:: "+complaintImage.getImages().size());
					for(ImageCode code:complaintImage.getImages()) {
						
						if(lastBest64String.equalsIgnoreCase(code.getBase64Code())){
							System.out.println("SAME Bese 64 Code");
						}else{
							System.out.println("DIFF  Bese 64 Code");
						}
						
						//System.out.println("CODE DETIALS :: "+code.toString());
						i++;
						SOPImage sopImage= new SOPImage();
						 
						  byte[] imageByte;
							BufferedImage image = null;
						  	BASE64Decoder decoder = new BASE64Decoder();
							 imageByte = decoder.decodeBuffer(code.getBase64Code());
					            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
					            image = ImageIO.read(bis);
					          
					            Optional<SOP> optional= sOPService.getSopById(complaintImage.getSopId());
					            System.out.println("SOP :: "+optional.isPresent()+"  "+complaintImage.getSopId());
					            String stageNo="";
					            if(complaintImage.getStageNo()<=9){
					            	stageNo="0"+complaintImage.getStageNo();
					            }else{
					            	stageNo=String.valueOf(complaintImage.getStageNo());
					            }
					           SpindleServiceRequest  spindleServiceRequest= serviceSer.getSpindleServiceRequestId(optional.get().getSprindleServiceRequestId());
					            
					            System.out.println("SOP :: "+spindleServiceRequest.getSscNo());
					            
					            
					            
					            String imaageName=spindleServiceRequest.getSscNo()+"-"+stageNo+"-"+i;
					            sopImage.setImageName(imaageName+".jpeg");
					            sopImage.setAddedDate(new Date());
					            sopImage.setBase64Code(code.getBase64Code());
					            sopImage.setLocation(imagepath);
					            sopImage.setSopId(complaintImage.getSopId());
					            sopImage.setStageNo(complaintImage.getStageNo());
					            sopImage.setTechnicianId(complaintImage.getTechnicianId());
					            sopImage.setImageSelected(code.isImageSelected());
					            File outputfile = new File(imagepath+"/"+imaageName+".jpeg");
						          
					            //ImageIO.write(image, "jpeg", outputfile);
					            imageService.saveSOPImage(sopImage);
					           
								 
					  }
				}
				
			  status.setCode(200);
			  status.setMessage("Image Upload successfully ");
			  
		} catch (Exception e) {
			e.printStackTrace();
			  status.setCode(500);
			  status.setMessage(e.toString());
		}
		return status;
	}
	
	
	
	
	@GetMapping("/download/{fileName:.+}")
	public ResponseEntity<Resource> downloadFileFromLocal(@PathVariable String fileName) {
		String fileBasePath="/"+imagepath+"/";
		Path path = Paths.get(fileBasePath + fileName);
		Resource resource = null;
		try {
			resource = new UrlResource(path.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok()
			
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
	
	
	
	@RequestMapping(value = "/getSOPImage", method = RequestMethod.GET)
	public @ResponseBody List<SOPImage> getSOPImage(@RequestParam("sopId") int sopId,@RequestParam("stageNo") int stageNo) {
		List<SOPImage> list= new  ArrayList<SOPImage>();
		try {	
			list=imageService.getSOPImage(sopId,stageNo);
			String lastb64="";
			for(SOPImage image : list){
				if(image.getBase64Code().equalsIgnoreCase(lastb64)){
					
					System.out.println("SAME Base 64");
				}else{
					System.out.println("DIFF Base 64");
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}



