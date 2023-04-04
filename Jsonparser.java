
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
     
           String name = (String) mainJsonObject.get("name");
     System.out.println("name :" + name);
     
   JSONArray jsonArrayparameters = (JSONArray) mainJsonObject.get("processing_elements");
   System.out.println("parameters are" + jsonArrayparameters);
  
   
   for (int i = 0; i<jsonArrayparameters.size(); i++){
       
       
       
         JSONObject jsonentries = (JSONObject) jsonArrayparameters.get(i);
       System.out.println("entries" + (i+1));
       
            String type = (String) jsonentries.get("type");
     System.out.println("type :" + type);
   

       String Name = (String) jsonentries.get("Name");
     System.out.println("name :" + Name);
          String value = (String) jsonentries.get("value");
     System.out.println("value :" + value);
     
     
 
    
   }
 }
catch (Exception e) {
         e.printStackTrace();
 }
 
}}

