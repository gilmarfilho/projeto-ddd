package TACS;


import TACS.common.Api;
import org.apache.log4j.PropertyConfigurator;

import TACS.aplicacao.WebServiceConfiguracao;
import TACS.hobbies.HobbieAPI;
import TACS.interesse.InteresseAPI;
import TACS.marketing.MarketingAPI;
import TACS.pessoa.PessoaAPI;
import TACS.relacao.RelacoesAPI;

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
                PessoaAPI.api(args);
                HobbieAPI.api(args);
                RelacoesAPI.api(args);
                InteresseAPI.api(args);
                MarketingAPI.api(args);
        }
}
