package fr.esiea.web.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.esiea.web.bean.AdressBean;
import fr.esiea.web.bean.ContactBean;
/**
 * Le dataStoreSingleton est un singleton qui permet de persister les donn�es et d'avoir acc�s � cette m�me et unique instance de n'importe quelle
 * autre class de l'application. Cette Classe jouera le roles d'une base de donn�es 
 */

public class DataStoreSingleton implements Serializable
{	
	private Map<Integer,ContactBean> contactBeanMap;
	private Map<Integer,AdressBean> adressBeanMap;
	/**
	 * 
	 */
	private static final long serialVersionUID = 679337344871924638L;

	/** Constructeur priv� */
	private DataStoreSingleton()
	{
		this.contactBeanMap=new HashMap<Integer,ContactBean>();
		this.adressBeanMap=new HashMap<Integer,AdressBean>();
		
	}
 
	/** Instance unique pr�-initialis�e */
	private static DataStoreSingleton INSTANCE = new DataStoreSingleton();
 
	/** Point d'acc�s pour l'instance unique du singleton */
	public static DataStoreSingleton getInstance()
	{	
		if (INSTANCE == null)
		{ 	
			synchronized(DataStoreSingleton.class)
			{
				if (INSTANCE == null)
				{	
					INSTANCE = new DataStoreSingleton();
				}
			}
		}
		return INSTANCE;
	}
 
	/**
	 * 	
	 * @return
	 */
	public Map<Integer, ContactBean> getContactBeanMap() {
		return contactBeanMap;
	}


	/**
	 * 	
	 * @return
	 */
	public Map<Integer, AdressBean> getAdressBeanMap() {
		return adressBeanMap;
	}



	/** S�curit� anti-d�s�rialisation */
	private Object readResolve() {
		return INSTANCE;
	}
}