package com.yesu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.sql.*;

import javax.swing.JOptionPane;

public class Text2SQLite
{
  public static void dump(String filepath,String dbname){
	  Connection c = null;
	  Statement stmt = null;
     try {    	
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:"+dbname);
      c.setAutoCommit(true);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      FileInputStream fstream = new FileInputStream(filepath);
      BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
      String strLine;      
      String command="";
      while ((strLine = br.readLine()) != null)   {
    	 if(strLine.length()!=0){
    	  	//System.out.println(strLine.length());
    	  	//System.out.println(strLine.substring(strLine.length()-1, strLine.length()));
       	    command+=strLine+"\n";    	
    	 } 
    	 else{
    		 System.out.println("Running Command\n==============================================\n"+command);
    		 int r=stmt.executeUpdate(command);
    		 if(r!=-1)
    			 System.out.println("Executed Successfully.");
    		 command="";
    	 }
      }

      //Close the input stream
      br.close();    
      
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
     
    System.out.println();
  }
  public static void main( String args[] )
  {  	  
    Text2SQLite ob=new Text2SQLite();
    String filepath="resources/db.txt";
    String dbname="MyDb";
    ob.dump(filepath,dbname);
  }
}