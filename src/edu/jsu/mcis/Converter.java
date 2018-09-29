package edu.jsu.mcis;

import java.io.*;
import java.util.*;
import com.opencsv.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class Converter {
    
    /*
    
        Consider the following CSV data:
        
        "ID","Total","Assignment 1","Assignment 2","Exam 1"
        "111278","611","146","128","337"
        "111352","867","227","228","412"
        "111373","461","96","90","275"
        "111305","835","220","217","398"
        "111399","898","226","229","443"
        "111160","454","77","125","252"
        "111276","579","130","111","338"
        "111241","973","236","237","500"
        
        The corresponding JSON data would be similar to the following (tabs and
        other whitespace have been added for clarity).  Note the curly braces,
        square brackets, and double-quotes!  These indicate which values should
        be encoded as strings, and which values should be encoded as integers!
        
        {
            "colHeaders":["ID","Total","Assignment 1","Assignment 2","Exam 1"],
            "rowHeaders":["111278","111352","111373","111305","111399","111160",
            "111276","111241"],
            "data":[[611,146,128,337],
                    [867,227,228,412],
                    [461,96,90,275],
                    [835,220,217,398],
                    [898,226,229,443],
                    [454,77,125,252],
                    [579,130,111,338],
                    [973,236,237,500]
            ]
        }
    
        Your task for this program is to complete the two conversion methods in
        this class, "csvToJson()" and "jsonToCsv()", so that the CSV data shown
        above can be converted to JSON format, and vice-versa.  Both methods
        should return the converted data as strings, but the strings do not need
        to include the newlines and whitespace shown in the examples; again,
        this whitespace has been added only for clarity.
    
        NOTE: YOU SHOULD NOT WRITE ANY CODE WHICH MANUALLY COMPOSES THE OUTPUT
        STRINGS!!!  Leave ALL string conversion to the two data conversion
        libraries we have discussed, OpenCSV and json-simple.  See the "Data
        Exchange" lecture notes for more details, including example code.
    
    */
    
    @SuppressWarnings("unchecked")
    public static String csvToJson(String csvString) {
        
        String results = "";
        
        try {
            
            CSVReader reader = new CSVReader(new StringReader(csvString));
            
            List<String[]> full = reader.readAll();
            Iterator<String[]> iterator = full.iterator();
            
            // INSERT YOUR CODE HERE
            
/*
            // Create Array of First line by get method
            // ex. csvData = ["", "", ""...]
            //gets first data in array
            String[] colHeader = new String[full.get(0).size()];
            
            // Creates json array for headers and data
            ArrayList<String> jsonRowHeader = new ArrayList<>();
            ArrayList<Int[]> jsonData = new ArrayList<>();
            
            ArrayList<String> jsonColHeader = new ArrayList<>();
            //Loop through colHeaders and add to jsonColheader
            for(String e : colHeader){
                jsonColHeader.add(e);
            }
            
            //loop through csvData starting with index 1
            for(int = 1; i < csvData.size(); ++i){
            
                //start with data adding to row
                String[] row = csvData.add(i);
                
                //add first element of the row as row header
                jsonRowHeader.add(row(0));
                
                // now add the data of the row to a list
                Int[] rowData = new int[row.length - 1];
                
                //loop through row starting at index 1 then convert to int
                for(int = j; j < row.length; ++j){
                    rowData[j-1] = Interger.parseInt(row(j));
                }
                
                //add row of data ints into json data
                jsonData.add(rowData);
        
            }   
*/

            JSONObject jsonObject = new JSONObject(); // Map

            JSONArray rowHeaders = new JSONArray();   // List
            JSONArray mainData = new JSONArray();     // List
            JSONArray colHeaders = new JSONArray();   // List

            for (String string : iterator.next()) {              
                colHeaders.add(string);            
            }
               
            while (iterator.hasNext()) {                
                JSONArray rowData = new JSONArray(); // Create "rowData" list
                
                String[] rows = iterator.next();     // Get next row as string array
                rowHeaders.add(rows[0]);             // Add first element to "rowHeaders"
                
                // INSERT CODE HERE (convert elements; add to "mainData")
                for(int i = 1; i < rows.length; i++){                
                    rowData.add(Integer.parseInt(rows[i]));                           
                }
         
                mainData.add(rowData);          
            }
            
            jsonObject.put("colHeaders", colHeaders); // Add column headers
            jsonObject.put("data", mainData);         // Add row data
            jsonObject.put("rowHeaders", rowHeaders); // Add row headers
                       
            results = JSONValue.toJSONString(jsonObject); // Parse JSON string
            
        }        
        catch(Exception e) { return e.toString(); }
        
        return results.trim();
        
    }
    
    public static String jsonToCsv(String jsonString) {
        
        String results = "";
        
        try {

            StringWriter writer = new StringWriter();
            CSVWriter csvWriter = new CSVWriter(writer, ',', '"', '\n');
            
            // INSERT YOUR CODE HERE
            
            //parse data to map
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject)parser.parse(jsonString);
            
            //get data from json object
            JSONArray colHeaders = (JSONArray)jsonObject.get("colHeaders");
            JSONArray rowHeaders = (JSONArray)jsonObject.get("rowHeaders");
            JSONArray data = (JSONArray)jsonObject.get("data");
            
            //create empty array of strings
            String[] colStringArray = new String[colHeaders.size()];
            String[] rowStringArray = new String[rowHeaders.size()];
            String[] dataStringArray = new String[data.size()];
            
            //copy colHeaders into array
            for (int i = 0; i < colHeaders.size(); i++){
                colStringArray[i] = colHeaders.get(i).toString();
            }
            
            //output colHeaders to csvwriter
            csvWriter.writeNext(colStringArray);
            
            //store rowHeader and rowData into seprate arrays
            for (int i = 0; i < rowHeaders.size(); i++){
                // Get next row header 
                rowStringArray[i] = rowHeaders.get(i).toString(); 
                // Get next set of row data  
                dataStringArray[i] = data.get(i).toString();             
            }
            
            //loop through row arrays and combine
             for (int i = 0; i < dataStringArray.length; i++) {
                //parse string into data
                JSONArray dataValues = (JSONArray)parser.parse(dataStringArray[i]);
                //create row array sized for data
                String[] row = new String[dataValues.size() + 1];
                
                //add next header to row
                row[0] = rowStringArray[i];
                
                // INSERT CODE HERE
                for(int j = 1; j < dataValues.size(); j++){
                    //add data to row
                    row[j] = dataValues.get(j).toString();//convert to string
                }
                
                //output to writer
                csvWriter.writeNext(row);
                
            }
            
            // Output the completed CSV data to a string
            
            results = writer.toString();
        }
        
        catch(Exception e) { return e.toString(); }
        
        return results.trim();
        
    }

}