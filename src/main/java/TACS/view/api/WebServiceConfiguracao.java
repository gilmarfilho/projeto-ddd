package TACS.view.api;

import static spark.Spark.*;

import TACS.controller.dto.ExcecaoNegocioDTO;
import TACS.model.domain.ExcecaoNegocio;
import TACS.util.UtilArgs;
import org.eclipse.jetty.http.HttpStatus;

/**
 * 
 * @author gabriel
 * @version 1.0.0
 * 
 *          Classe para configuração de filtros de requisições, controle de
 *          exeções e demais aspectos que seja inerentes ao webservice.
 */
public final class WebServiceConfiguracao {
	
	private static final SerializadorJson json = new SerializadorJson();
	
	public static void config(String args[]) {
	    
		/**
		 * Passa os argumentos ao ultilitario para guarda-los
		 * em memoria.
		 */
		UtilArgs.configura(args);

		/**
		 * Cofigura porta caso porta passada
		 * na configuração senão mantém default.
		 */
		port(UtilArgs.getParametros().containsKey(UtilArgs.Args.PORTAWS)
				? Integer.valueOf(UtilArgs.getParametros().get(UtilArgs.Args.PORTAWS)) : 4567);

		/**
		 * Tratamento genérico de exceções.
		 */
		exception(ExcecaoNegocio.class, (excecao, requesicao, resposta) -> {			
			resposta.body(json.gson.toJson(ExcecaoNegocioDTO.converterDominio(excecao)));
			resposta.header("content-type", "application/json");
			
			resposta.status(HttpStatus.BAD_REQUEST_400);
		});

		/**
		 * Mapea pasta public dentro de resoruces para servir
		 * arquivos estáticos.
		 */
		staticFiles.location("/public");
	}
}
