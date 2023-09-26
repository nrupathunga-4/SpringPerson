package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException{
     private String resourcename;
     private String fieldname;
     private Object fieldvalue;
	public ResourceNotFoundException(String resourcename, String fieldname, Object fieldvalue) {
		super(String.format("%s is not Found %s:'%s'",resourcename,fieldname,fieldvalue));
		this.resourcename = resourcename;
		this.fieldname = fieldname;
		this.fieldvalue = fieldvalue;
	}
     public String getResource()
     {
    	 return resourcename;
     }
      public String getFieldname()
      {
    	  return fieldname;
      }
      public Object getFieldvalue()
      {
    	  return fieldvalue;
      }
}
