
Text2Sqlite Conversion:
======================

    This API will dump the commands written in a given text file to the specified sql3 database.
    copy and Place the Text2Sqlite.jar from dist directory to your classpath and build your     project.

Dependancies:
=============
    sqlite-jdbc-3.8.7.jar

How to use:
===========   
add these lines in your code: 

    Text2SQLite ob=new Text2SQLite();
    String filepath="D:\\ws1\\MyHistory\\resources\\db.txt";
    String dbname="BalaYesu";
    ob.dump(filepath,dbname);


Description:
============
    dump() takes two parameters as arguments, the declaration of this method is,
    
    public static void dump(String filepath,String dbname);
    
