
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
     
   JSONArray jsonArrayparameters = (JSONArray) mainJsonObject.get("processing_elements");
   System.out.println("parameters are" + jsonArrayparameters);
  
   
   for (int i = 0; i<jsonArrayparameters.size(); i++){
       
         JSONObject jsonentries = (JSONObject) jsonArrayparameters.get(i);
       System.out.println("entries" + jsonentries);
       
       JSONObject jsonsplit = (JSONObject) jsonArrayparameters.get(i);
       System.out.println("split" + jsonsplit);

       String name = (String) jsonsplit.get("value");
     System.out.println("name :" + name);
          String number = (String) jsonsplit.get("value");
     System.out.println("value :" + number);
     
     
 
    
   }
 }
catch (Exception e) {
         e.printStackTrace();
 }
 
}}
