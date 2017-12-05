package TACS.view.api;

import TACS.controller.dto.InteresseDTO;
import TACS.controller.service.InteresseService;
import static spark.Spark.*;


public class InteresseAPI implements Api {
	
	private static final SerializadorJson JSON = new SerializadorJson();
	
	/**
	 * Classe de serviço que contém todas as dependências necessárias
	 * para as operações com a entidade task.
	 */
	private static final InteresseService SERVICO = new InteresseService();
        
        private static final String PATH = "/interesse";
        private static final String CONTENT_TYPE = "application/json";
	
	/**
	 * @param args - Args do programa principal.
	 * Metodo com todas as APIs que este view define.
	 */
	public static void api(String[] args) {
		post(PATH, CONTENT_TYPE, (request, response) -> {
                        return SERVICO.interessa(JSON.getGson().fromJson(
                                request.body(), 
                                InteresseDTO.class));
						
		}, JSON);
		
		delete(PATH, CONTENT_TYPE, (request, response) -> {
                        return SERVICO.desInteressa(JSON.getGson().fromJson(
                                request.body(), 
                                InteresseDTO.class));
						
		}, JSON);
		
	}
}
