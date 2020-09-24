package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Document(collection  = "ImageModel")
public class ImageModel {
	 
	@Id
	     private String id;
	
		private String mat ;
		
		
	
	     private String name;
	 
	     private String type;
	
	     private byte[] picByte;
	     
	     public ImageModel(String name, String type, byte[] picByte , String mat) {
	    	 
	    	         this.name = name;
	    	 
	    	         this.type = type;
	    	 
	    	         this.picByte = picByte;
	    	         this.mat = mat;
	    	 
	    	     }
	     public ImageModel(String name, String type, byte[] picByte) {
	    	 
	         this.name = name;
	 
	         this.type = type;
	 
	         this.picByte = picByte;
	       
	 
	     }
	     public String getId() {
	 		return this.mat;
	 	}

	 public void setMat(String mat) {
	 		
	 		this.mat=this.id;
	 	}

}
