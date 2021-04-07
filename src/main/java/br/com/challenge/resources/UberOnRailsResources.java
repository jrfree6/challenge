package br.com.challenge.resources;



import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import br.com.challenge.helper.Helper;
import br.com.challenge.model.UberOnRailsModel;

public class UberOnRailsResources {
	
	private List<UberOnRailsModel> listUberModel = new ArrayList<>();
	
	public List<UberOnRailsModel> getListUberModel() {
		return listUberModel;
	}
	
	public UberOnRailsResources() {
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void init() throws Exception  {
		
		URL url = new URL("https://raw.githubusercontent.com/JoaoSouza982/backend-challenge/main/uberOnRails.json");
		
		InputStreamReader is = new InputStreamReader(url.openStream());
		
		 int data = is.read();
		 String tmp = new String("");
         while (data != -1) {
        	 
        	 tmp +=(char) data;
//        	 System.out.println((char) data);

             data = is.read();
         }
         
     //    System.out.println(tmp);
    
		JsonParser parser = new JsonParser();
//		
		JsonArray array = parser.parse(tmp).getAsJsonArray();
		UberOnRailsModel uberModel = new UberOnRailsModel();
		List<UberOnRailsModel> listUberOnRailsModel = new ArrayList<>();
		for( JsonElement valor : array) {
			
			uberModel.setTrip(valor.getAsJsonObject().get("trip").getAsString());
			uberModel.setOrigin(valor.getAsJsonObject().get("origin").getAsString());
			uberModel.setDestiny(valor.getAsJsonObject().get("destiny").getAsString());
			uberModel.setDeparture(Helper.stringToTime(valor.getAsJsonObject().get("departure").getAsString()) );
			uberModel.setDepartureDate(Helper.stringToDate(valor.getAsJsonObject().get("departureDate").getAsString()));
			uberModel.setArrival(Helper.stringToTime(valor.getAsJsonObject().get("arrival").getAsString()));
			uberModel.setValue(new Double(valor.getAsJsonObject().get("value").getAsString()));
			
			listUberOnRailsModel.add(uberModel);
		}
		listUberModel = listUberOnRailsModel;
		
	}
	
	public Object jsonToObject(String json, Class<?> classe) {
		
		//Converte String JSON para objeto Java
		Gson gson = new Gson();
//		JsonReader.setLenient(true)
		Object obj = gson.fromJson(json, classe);
		
		return obj;
	}

}
