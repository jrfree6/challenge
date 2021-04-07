package br.com.challenge.resources;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import br.com.challenge.helper.Helper;
import br.com.challenge.model.ITrainModel;

public class ItrainResources {
	
	private List<ITrainModel> listITrainModel = new ArrayList<>();
	
	public List<ITrainModel> getListITrainModel() {
		return listITrainModel;
	}
	
	public ItrainResources() {
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void init() throws Exception  {
		
		URL url = new URL("https://raw.githubusercontent.com/JoaoSouza982/backend-challenge/main/iTrain.csv");
		
		InputStreamReader is = new InputStreamReader(url.openStream());
		
		BufferedReader buffRead = new BufferedReader(is);
		String linha = "";
		while ( (linha = buffRead.readLine()) != null ) {
			
			if(linha.startsWith("trip_number")) continue;
//				0				1			2				3	4				5			6
//		linha:trip_number, origin_station,destiny_station,date,departure_time,arrival_time,price
//		linha:B13F30,BSB,FLN,2021/02/10,19:00,23:30,369.19
				ITrainModel iTrainModel = new ITrainModel();
				String[] attrib = linha.split(",");
				
				iTrainModel.setTrip(attrib[0].toString());
				iTrainModel.setOrigin(attrib[1].toString());
				iTrainModel.setDestiny(attrib[2].toString());
				iTrainModel.setDeparture(Helper.stringToTime(attrib[4].toString()) );
				iTrainModel.setDepartureDate(Helper.stringToDate(attrib[3].toString().replace("/", "-")));
				iTrainModel.setArrival(Helper.stringToTime(attrib[5].toString()));
				iTrainModel.setValue(new Double(attrib[6].toString()));
				
				listITrainModel.add(iTrainModel);
				
		}
		buffRead.close();
		
	}
	

}
