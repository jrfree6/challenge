package br.com.challenge.helper;

import java.util.ArrayList;
import java.util.List;

import br.com.challenge.model.ITrainModel;
import br.com.challenge.model.UberOnRailsModel;
import br.com.challenge.storage.Storage;

public class Heuristic {
	
	private Storage storage;
	
	public List findTripOptions(String origin, String destiny) {
		
		storage = Storage.getInstance();
		
		List<UberOnRailsModel> listUber =(List<UberOnRailsModel>) storage.findAll("uberOnRails");
		List<ITrainModel>  listItrain = (List<ITrainModel> ) storage.findAll("iTrain");
		Object path = new Object();
		List lista = new ArrayList<>();
		for (ITrainModel itrain : listItrain) {
			if(itrain.getOrigin().equalsIgnoreCase(origin) && itrain.getDestiny().equalsIgnoreCase(destiny)) {
				lista.add(itrain);
			}
		}
		for(UberOnRailsModel uberOnRails : listUber) {
			if(uberOnRails.getOrigin().equalsIgnoreCase(origin) && uberOnRails.getDestiny().equalsIgnoreCase(destiny)) {
				lista.add(uberOnRails);
			}
		}
		
		return lista;
	}

}
