package com.ob.tests;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ob.basetest.baseTest;

public class CreatingMultipleUser extends baseTest {
	File file;
	XSSFWorkbook book;
	XSSFSheet sheet;
	
	public void excel() throws InvalidFormatException, IOException {
		
		 file = new File("D:\\excel\\Data.xlsx");
		 book = new XSSFWorkbook(file);
		 sheet= book.createSheet("TestData");
		
		
		XSSFRow row= sheet.createRow(0);
	    row.createCell(0).setCellValue("12345");
	    
	    
	    
	    FileOutputStream fos = new FileOutputStream(file);
	            
	  
	        book.write(fos);
	        fos.close();
		
	}
	
	
	
	 public void WriteData( int row,String accNo, String fname,String lname,String midName,String emailId,String passwrd,String pinNum,String begBalance) {
		 
		 
	 }
	 public static void main(String[] args) throws InvalidFormatException, IOException {
		 
		 
		 CreatingMultipleUser e=new CreatingMultipleUser();
		 
		 
		 e.excel();
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	 }

}
