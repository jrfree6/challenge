package br.com.challenge.storage;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.challenge.helper.Helper;
import br.com.challenge.model.TrainStationsModel;

public class Storage {
	
	private static Storage instance;
	private static Hashtable<String, Object> routes = new Hashtable<String, Object>();
	
	public static Storage getInstance() {
		if (instance == null) instance = new Storage();
		
		return instance;
	}
	
	public Object findAll(String key) {
		return routes.get(key);
	}
	
	public void save(String key, Object value) {
		routes.put(key, value);
	}
	public List findOne(String key, String value) {
		List list = new ArrayList<>();
		Object object = routes.get(key);
		if(key.equalsIgnoreCase("trainStations")) {
			List<TrainStationsModel> lista =(List<TrainStationsModel>) object;
			for (TrainStationsModel trainStationsModel : lista) {
				String nome = Helper.removeAccents(trainStationsModel.getName());
				String partName = Helper.removeAccents(value);
				if(nome.toLowerCase().contains(partName.toLowerCase())) list.add(trainStationsModel);
			}
		}
		return list;
	}

}
