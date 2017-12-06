package TACS.pessoa;

import static spark.Spark.*;

import TACS.common.Api;
import TACS.aplicacao.SerializadorJson;

public class PessoaAPI implements Api {
	
	private static final SerializadorJson JSON = new SerializadorJson();
	
	/**
	 * Classe de serviço que contém todas as dependências necessárias
	 * para as operações com a entidade task.
	 */
	private static final PessoaService SERVICO = new PessoaService();
        
        private static final String PATH = "/pessoa";
        private static final String CONTENT_TYPE = "application/json";
	
	/**
	 * @param args - Args do programa principal.
	 * Metodo com todas as APIs que este view define.
	 */
	public static void api(String[] args) {
		post(PATH, CONTENT_TYPE, (request, response) -> {
			return SERVICO.criar(JSON.getGson().fromJson(
                                request.body(), 
                                PessoaDTO.class));
						
		}, JSON);
		
		get(PATH, CONTENT_TYPE, (request, response) -> {
			return SERVICO.listar();
		}, JSON);
		
		delete(PATH, CONTENT_TYPE, (request, response) -> {
			return SERVICO.remover(JSON.getGson().fromJson(
                                request.body(), 
                                PessoaDTO.class));
		});
		
		put(PATH, CONTENT_TYPE, (request, response) -> {
			return SERVICO.atualizar(JSON.getGson().fromJson(
                                request.body(), 
                                PessoaDTO.class));
		}, JSON);
	}
}
