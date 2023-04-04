
import java.io.BufferedReader;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Jsonparser {
 public static String getJSONFromFile(String filename)    {
     String jsonText = "";
     try {
         BufferedReader bufferedReader = 
                 new BufferedReader(new FileReader(filename));
         String line;
         while((line = bufferedReader.readLine()) !=null) {
             jsonText += line + "\n";
         }
         bufferedReader.close();
        
     }
     catch (Exception e) {
         e.printStackTrace();
     }
     return jsonText;
 }
 public static void main(String[] args) {
     String strJson = getJSONFromFile("C:/Users/smpat/Downloads/Test Scenario.json");
    // System.out.println(strJson);
 try {
     JSONParser parser = new JSONParser();
     Object object = parser.parse(strJson);
     JSONObject mainJsonObject = (JSONObject) object;
     
        //String name = (String) mainJsonObject.get("name");
    // System.out.println("name :" + name);
     
     JSONArray jsonArrayelements = (JSONArray) mainJsonObject.get("processing_elements");
     System.out.println("elements :");
     
       JSONArray jsonArrayentries = (JSONArray) mainJsonObject.get("input_entries");
     System.out.println("entries :");
     
          JSONArray jsonArrayparameters = (JSONArray) mainJsonObject.get("parameters");
     System.out.println("parameters");
     
     
    
     
     for (int i = 0; i<jsonArrayelements.size();i++){
         for (int j = 0; j<jsonArrayentries.size();j++){
             for (int h = 0; h<jsonArrayparameters.size();h++){
     
           
         
           JSONObject jsonelement = (JSONObject) jsonArrayelements.get(i);
        System.out.println("elements: " + (i+1));
     
            String type = (String) jsonelement.get("type");
    System.out.println("Type: " + type);
     
        JSONObject jsonentrie = (JSONObject) jsonArrayentries.get(j);
         System.out.println("Entries: " + (j+1));
         
                    String path = (String) jsonentrie.get("path");
     System.out.println("Path: " + path);
     
        JSONObject jsonparameter = (JSONObject) jsonArrayparameters.get(h);
         System.out.println("Parameters: " + (h+1));
         
                         String name = (String) jsonparameter.get("name");
     System.out.println("Name: " + name);
     
                     String value = (String) jsonparameter.get("value");
     System.out.println("Value: " + value);
         
         
         
         

     
     



             
             }
         }
         
     
     } 

 }
catch (Exception e) {
         e.printStackTrace();
 }
 }
 }

