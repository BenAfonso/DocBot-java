package dao;

import dao.PG_DAOFactory;
import models.Person;
public abstract class AbstractDAOFactory {
  public static final int PG_DAOFACTORY = 0;
  public static final int OTHER_DAOFACTORY = 1;


  //Retourne un objet Classe interagissant avec la BDD
  public abstract PersonDAO getUserDAO();

   
  //Méthode permettant de récupérer les Factory 
  public static AbstractDAOFactory getFactory(int type){
	  System.out.println("getFactory");

    switch(type){
      case PG_DAOFACTORY:
        return new PG_DAOFactory();
      case OTHER_DAOFACTORY: 
        return new OtherDAOFactory();
      default:
        return null;
    }
  }
}