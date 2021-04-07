package br.com.challenge.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.challenge.helper.Heuristic;
import br.com.challenge.model.ITrainModel;
import br.com.challenge.model.TrainStationsModel;
import br.com.challenge.model.UberOnRailsModel;
import br.com.challenge.storage.Storage;

@Controller
public class HelloController {
	
	private Storage storage;
	
	@RequestMapping("/")
	@ResponseBody 
	public String Info() {
//		 new ChangeUberOnRails();
//		 new ChangeItrain();
		StringBuffer message = new StringBuffer();
		message.append("<h3>Sejam Bem Vindo Metodos Possiveis: </h3> ");
		message.append("<br/>Metodos Possiveis:  ");
		message.append("<br/><label style='color:red'>Lista todas as estacoes</label> | Get: /getTrainStationsAll");
		message.append("<br/><label style='color:red'>Lista todas as UbertOnRails | </label>Get: /getUberOnRailsAll ");
		message.append("<br/><label style='color:red'>Lista todas as iTrain | </label>Get: /getiTrainAll ");
		message.append("<br/><label style='color:red'>Busca da estacao por nome | </label>Get: /getFindTrainStations/{partName} ");
		message.append("<br/><label style='color:red'>Busca por itinerário | </label>Get: /getFindTripOptions?origin=bsb&destiny=fln ");
		return message.toString();
	}
	
	@RequestMapping(value = "/getTrainStationsAll", method = RequestMethod.GET)
	@ResponseBody
	public List<TrainStationsModel> getTrainStationsAll() {
		storage = Storage.getInstance();
		List<TrainStationsModel> lista =(List<TrainStationsModel>) storage.findAll("trainStations");	
		return lista;	
	}
	
	@RequestMapping(value = "/getFindTrainStations/{partName}", method = RequestMethod.GET)
	@ResponseBody
	public List<TrainStationsModel> getFindTrainStations(@PathVariable(value = "partName") String partName) {
		System.out.println("Nome a ser procurado:"+ partName);
		storage = Storage.getInstance();
		List lista = storage.findOne("trainStations", partName);	
		return lista;	
	}
	
	@RequestMapping(value = "/getUberOnRailsAll", method = RequestMethod.GET)
	@ResponseBody
	public List<UberOnRailsModel> getUberOnRailsAll() {
		storage = Storage.getInstance();
		List<UberOnRailsModel> lista =(List<UberOnRailsModel>) storage.findAll("uberOnRails");	
		return lista;	
	}
	
	@RequestMapping(value = "/getiTrainAll", method = RequestMethod.GET)
	@ResponseBody
	public List<ITrainModel> getiTrainAll() {
		storage = Storage.getInstance();
		List<ITrainModel> lista =(List<ITrainModel>) storage.findAll("iTrain");	
		return lista;	
	}
	
	@RequestMapping(value = "/getFindTripOptions", method = RequestMethod.GET)
	@ResponseBody
	public List getFindTripOptions(@RequestParam(required = true) String origin, @RequestParam(required = true) String destiny ) {
		System.out.println("Origem:"+ origin + " - destino:"+ destiny);
		storage = Storage.getInstance();
		Heuristic heuristic = new Heuristic();
		List lista = heuristic.findTripOptions(origin, destiny);	
		return lista;	
	}
	
	
	

}


