package TACS.marketing;

import TACS.marketing.MarketingDTO;
import TACS.marketing.MarketingService;
import TACS.common.Api;
import TACS.aplicacao.SerializadorJson;
import static spark.Spark.*;


public class MarketingAPI implements Api {
	
	private static final SerializadorJson JSON = new SerializadorJson();
	
	/**
	 * Classe de serviço que contém todas as dependências necessárias
	 * para as operações com a entidade task.
	 */
	private static final MarketingService SERVICO = new MarketingService();
        
        private static final String PATH = "/marketing";
        private static final String CONTENT_TYPE = "application/json";
	
	/**
	 * @param args - Args do programa principal.
	 * Metodo com todas as APIs que este view define.
	 */
	public static void api(String[] args) {
		get(PATH + "/espalhamento", CONTENT_TYPE, (request, response) -> {
			return SERVICO.espalhamento(JSON.getGson().fromJson(
                                request.body(), 
                                MarketingDTO.class));
		}, JSON);
		
                get(PATH + "/aderencia", CONTENT_TYPE, (request, response) -> {
			return SERVICO.aderencia(JSON.getGson().fromJson(
                                request.body(), 
                                MarketingDTO.class));
		}, JSON);
		
                get(PATH + "/marketing", CONTENT_TYPE, (request, response) -> {
			return SERVICO.marketing(JSON.getGson().fromJson(
                                request.body(), 
                                MarketingDTO.class));
		}, JSON);
		
	}
}
