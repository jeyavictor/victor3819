package org.TestVagrand;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import junit.framework.Assert;
 
public class TestPlayers {
	JSONArray s;
        @org.testng.annotations.BeforeClass
		private void fileread() throws IOException, ParseException {
			FileReader f = new FileReader("E:\\java program\\DropDown\\TestVagrand\\src\\test\\resources\\players.json");
			JSONParser p = new JSONParser();
			Object obj = p.parse(f);
			JSONObject j = (JSONObject)obj;
			s = (JSONArray)j.get("player");
			System.out.println(s);

		}
        
        @Test(priority = 1)
        private void validatingForeginPlayer(){
            int count=0;
            for (int i=0;i<s.size();i++){
                JSONObject obj = (JSONObject) s.get(i);
                String country = (String) obj.get("country");
                if(!country.equals("India")){
                    count++;
                }
            }
            Assert.assertTrue(count==4);
            System.out.println("Team is containg 4  foreign players");
        }
        @Test(priority = 2)
        public void validatingWicketKeeper(){
            int count=0;
            for (int i=0;i<s.size(); i++){
                JSONObject obj = (JSONObject) s.get(i);
                String role = (String) obj.get("role");
                if(role.equals("Wicket-keeper")){
                    count++;
                }
            }
            Assert.assertTrue(count>=1);
            System.out.println("Team is containg at least one wicket keeper");
        }
        
        
}
    

