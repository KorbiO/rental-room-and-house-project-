package com.example.demo.entity;





import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class ImageModel {
	 
	
	     private String id;
	     
	     private String mat ;
	
	  
	     
	     private String name;
	 
	     private String type;
	
	     private byte[] picByte;
	     
	     public ImageModel(String name, String type, byte[] picByte) {
	    	 
	    	         this.name = name;
	    	 
	    	         this.type = type;
	    	 
	    	         this.picByte = picByte;
	    	 
	    	     }
	     public ImageModel(String name, String type, byte[] picByte , String mat) {
	    	 
	         this.name = name;
	 
	         this.type = type;
	         this.mat=mat;
	         this.picByte = picByte;
	 
	     }
	 	public String getId( ) {
			return this.mat;
		}

}
