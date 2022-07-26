package com.ob.utilities;

		


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.Test;

public class Utilities {
	
	public static String getProperty(String key) throws IOException {
		FileInputStream fis = new FileInputStream("src/test/resources/ENV.PROPERTIES");
		Properties p =new Properties();
		p.load(fis);
		
		return p.getProperty(key);
		
		
	}
	
   public static Long getaccountnum() {
	   Random random=new Random();
	   Long num=random.nextLong(1234567891);
	   return num;
	   
   }
   
		
		
		public void randomNum() {
			Random random = new Random();
			Long num = random.nextLong(10000000000L);
			System.out.println(num);
			
			
		}

	}


		
		
		
	

		
		
	


