package com.revature_wk1.dataformat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class DataFormat {
    
    public static void main(String[] args) 
    {
        try
        {
            PrintWriter file = new PrintWriter("src/com/revature/dataformat/Data.txt", "UTF-8");
            file.println("Mickey:Mouse:35:Arizona");
            file.println("Hulk:Hogan:50:Virginia");
            file.println("Roger:Rabbit:22:California");
            file.print("Wonder:Woman:18:Montana");
            
            file.close();
            
        }
        catch(IOException e)
        {
            
        }
        
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("src/com/revature/dataformat/Data.txt"));
            String line = null; //current line place holder
             while((line = br.readLine()) != null)
             {
                 String[] curr = line.split(":");
                 System.out.println("Name: " + curr[0] + " " + curr[1]); 
                 System.out.println("Age: " + curr[2]);
                 System.out.println("State: "+ curr[3] + " State");
             }
             
             br.close();
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
    }
}