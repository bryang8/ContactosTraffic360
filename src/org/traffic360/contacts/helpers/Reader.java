package org.traffic360.contacts.helpers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Reader {	
	
	public static ArrayList<String> readDB(){
		ArrayList<String> userCredentials = new ArrayList<>();
        String line;        
        
        try {        	
        	InputStream archivo = Reader.class.getClass().getResourceAsStream("/org/traffic360/contacts/helpers/data/DBdata.txt");
        	BufferedReader reader = new BufferedReader(new InputStreamReader(archivo));
        	while ((line = reader.readLine()) != null) {
        		String [] list = splitLines(line);
				for(String s : list)
        			System.out.println(readData(s)[1]);
            }
        	for(String s : userCredentials) 
    	        System.out.println(s);
		} catch (Exception e) {
			// TODO: handle exception
		}
        return userCredentials;
    }
	
	public static ArrayList<String> readIpFilter(){
		ArrayList<String> ipList = new ArrayList<>();        
        String line;
        
        try {        	
        	InputStream archivo = Reader.class.getClass().getResourceAsStream("/org/traffic360/contacts/helpers/data/data.txt");
        	BufferedReader reader = new BufferedReader(new InputStreamReader(archivo));
        	while ((line = reader.readLine()) != null) {
        		String [] list = splitLines(line);
        	    for(String s : list) 
        	        ipList.add(s);
            }
        	for(String s : ipList) 
    	        System.out.println(s);
		} catch (Exception e) {
			// TODO: handle exception
		}
        return ipList;
    }
	
	private static String[] splitLines (String line) {
		return line.split("\\;");
		
	}
	
	private static String[] readData(String line) {
		if (line.contains("host")) {
			return line.split("host:");
		}
		if (line.contains("port")) {
			return line.split("port:");
		}
		if (line.contains("database_name")) {
			return line.split("database_name:");
		}
		if (line.contains("user")) {
			return line.split("user:");
		}
		if (line.contains("pass")) {
			return line.split("pass:");
		}
		return null;
	}
}
