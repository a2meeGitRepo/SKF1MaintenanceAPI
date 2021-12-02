package com.maintenance.dto;

public class ImageCode {
 
	

@Override
	public String toString() {
		return "ImageCode [imageSelected=" + imageSelected + "]";
	}

private String base64Code;
 
 private boolean imageSelected;

public String getBase64Code() {
	return base64Code;
}

public void setBase64Code(String base64Code) {
	this.base64Code = base64Code;
}

public boolean isImageSelected() {
	return imageSelected;
}

public void setImageSelected(boolean imageSelected) {
	this.imageSelected = imageSelected;
}




}
