package br.com.challenge.resources;



import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import br.com.challenge.model.TrainStationsModel;

public class TrainStationsResources {
	
	private List<TrainStationsModel> listTrainStationModel = new ArrayList<>();
	
	public List<TrainStationsModel> getListTrainStations() {
		return listTrainStationModel;
	}
	
	public TrainStationsResources() {
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void init() throws Exception  {
		
		URL url = new URL("https://raw.githubusercontent.com/JoaoSouza982/backend-challenge/main/trainStations.json");
		
		InputStreamReader is = new InputStreamReader(url.openStream());
		
		 int data = is.read();
		 String tmp = new String("");
         while (data != -1) {
        	 tmp +=(char) data;
             data = is.read();
         }
    
		JsonParser parser = new JsonParser();
//		
		JsonArray array = parser.parse(tmp).getAsJsonArray();
		
		
		for( JsonElement valor : array) {
			
			TrainStationsModel trainStations = new TrainStationsModel();
			
			trainStations.setName(valor.getAsJsonObject().get("name").toString());
			trainStations.setStation(valor.getAsJsonObject().get("station").toString());
			trainStations.setCity(valor.getAsJsonObject().get("city").toString());
			
			listTrainStationModel.add(trainStations);
		}
	}
}
