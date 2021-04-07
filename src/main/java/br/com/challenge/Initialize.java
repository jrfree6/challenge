package br.com.challenge;

import br.com.challenge.resources.ItrainResources;
import br.com.challenge.resources.TrainStationsResources;
import br.com.challenge.resources.UberOnRailsResources;
import br.com.challenge.storage.Storage;

public class Initialize {
	
	public Initialize() {
		init();
	}
	
	private void init() {
		
		TrainStationsResources trainStations = new TrainStationsResources();
		
		ItrainResources iTrain = new ItrainResources();
		
		UberOnRailsResources uberOnRails = new UberOnRailsResources();
		
		Storage storage = Storage.getInstance();
		storage.save("iTrain", iTrain.getListITrainModel());
		storage.save("uberOnRails", uberOnRails.getListUberModel());
		storage.save("trainStations", trainStations.getListTrainStations());
		
		System.out.println("Loanding - Ok..");
	}

}
