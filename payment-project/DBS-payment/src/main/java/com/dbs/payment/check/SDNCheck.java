package com.dbs.payment.check;


import java.io.*;
import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class SDNCheck {

	
	public static boolean checkSDN(String str)
		    throws java.lang.Exception, IOException {
		   
		    String[] a = str.toUpperCase().split("[\\s,]+");
		    try {
		      List<String> lines = Files.readAllLines(Paths.get("documents/sdn_modified.csv"));
		      Arrays.sort(a);
		      for (String line : lines) {
		        String[] b = line.replaceAll("\"", "").toUpperCase().split("[\\s,]+");
		        Arrays.sort(b);
		        if ((Arrays.equals(a, b))) {
		        	return true;
		        }
		      }
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
			return false;
		  }

}
