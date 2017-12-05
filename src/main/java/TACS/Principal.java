package TACS;


import TACS.view.api.Api;
import org.apache.log4j.PropertyConfigurator;

import TACS.view.api.WebServiceConfiguracao;
import TACS.view.api.ApiTarefa;
import TACS.view.api.HobbieAPI;
import TACS.view.api.InteresseAPI;
import TACS.view.api.MarketingAPI;
import TACS.view.api.PessoaAPI;
import TACS.view.api.RelacoesAPI;

/**
 *
 * @author  gabriel
 * @version 1.0.0
 *
 */
public class Principal {

	public static void main(String[] args) {
		/**
		 * Configuração de log.
		 */
		PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));

		/**
		 * Configuração de funcionamento das APIs Spark.
		 */
		WebServiceConfiguracao.config(args);

		/**
		 * Controllers que estrão ativos.
		 */
                ApiTarefa.api(args);
                PessoaAPI.api(args);
                HobbieAPI.api(args);
                RelacoesAPI.api(args);
                InteresseAPI.api(args);
                MarketingAPI.api(args);
        }
}
