package TACS.view.api;

import TACS.controller.dto.HobbieDTO;
import TACS.controller.service.HobbieService;
import static spark.Spark.*;


public class HobbieAPI implements Api {
	
	private static final SerializadorJson JSON = new SerializadorJson();
	
	/**
	 * Classe de serviço que contém todas as dependências necessárias
	 * para as operações com a entidade task.
	 */
	private static final HobbieService SERVICO = new HobbieService();
        
        private static final String PATH = "/hobbie";
        private static final String CONTENT_TYPE = "application/json";
	
	/**
	 * @param args - Args do programa principal.
	 * Metodo com todas as APIs que este view define.
	 */
	public static void api(String[] args) {
		post(PATH, CONTENT_TYPE, (request, response) -> {
			return SERVICO.criar(JSON.getGson().fromJson(
                                request.body(), 
                                HobbieDTO.class));
						
		}, JSON);
		
		get(PATH, CONTENT_TYPE, (request, response) -> {
			return SERVICO.listar();
		}, JSON);
		
		delete(PATH, CONTENT_TYPE, (request, response) -> {
			return SERVICO.remover(JSON.getGson().fromJson(
                                request.body(), 
                                HobbieDTO.class));
		});
		
		put(PATH, CONTENT_TYPE, (request, response) -> {
			return SERVICO.atualizar(JSON.getGson().fromJson(
                                request.body(), 
                                HobbieDTO.class));
		}, JSON);
	}
}
