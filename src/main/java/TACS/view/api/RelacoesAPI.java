package TACS.view.api;

import TACS.controller.dto.PessoaDTO;
import TACS.controller.dto.RelacaoDTO;
import TACS.controller.service.RelacionamentoService;
import static spark.Spark.*;


public class RelacoesAPI implements Api {
	
	private static final SerializadorJson JSON = new SerializadorJson();
	
	/**
	 * Classe de serviço que contém todas as dependências necessárias
	 * para as operações com a entidade task.
	 */
	private static final RelacionamentoService SERVICO = new RelacionamentoService();
        
        private static final String PATH = "/relacoes";
        private static final String CONTENT_TYPE = "application/json";
	
	/**
	 * @param args - Args do programa principal.
	 * Metodo com todas as APIs que este view define.
	 */
	public static void api(String[] args) {
		post(PATH, CONTENT_TYPE, (request, response) -> {
                        return SERVICO.relacionar(JSON.getGson().fromJson(
                                request.body(), 
                                RelacaoDTO.class));
						
		}, JSON);
		
		delete(PATH, CONTENT_TYPE, (request, response) -> {
                        return SERVICO.relacionar(JSON.getGson().fromJson(
                                request.body(), 
                                RelacaoDTO.class));
						
		}, JSON);
		
	}
}
