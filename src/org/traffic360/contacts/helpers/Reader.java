package org.traffic360.contacts.helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
	public static void leer() throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader("/data/data.txt");
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            System.out.println(cadena);
        }
        b.close();
    }
}
