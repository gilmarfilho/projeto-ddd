package TACS.model.dao;

import static TACS.util.UtilArgs.getParametros;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import TACS.util.UtilArgs.Args;

/**
 * 
 * @author gabriel
 * @version 1.0.0
 * 
 *          Implementacao de transacao unsando framework Hibernate.
 */
public final class TransacaoHibernate extends ProvedorTransacao {

	/*
	 * Entity manager referente a base dados mapeada em nosso arquivo de
	 * configuração persistence.xml.
	 */
	private static EntityManagerFactory emf = getManager();

	/**
	 * 
	 * @return EntityManagerFactory configurado. Configura o entity Manager do
	 *         Hibernate de maneira dinamica caso os argumentos tenham sido
	 *         passador
	 */
	private static EntityManagerFactory getManager() {
		Map<Args, String> parametros = getParametros();

		return Persistence.createEntityManagerFactory("db");
	}

	public void tx(final BlocoTransacao b) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		b.exc(em);
		em.getTransaction().commit();
		em.close();
	}

	public Object txr(BlocoTransacaoRetorno b) {
		final Object o;
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		o = b.exc(em);
		em.getTransaction().commit();
		em.close();
		return o;
	}
}