package dao;

import dao.DAOFactory;
import models.User;
import pg_dao.DAO;
public abstract class AbstractDAOFactory {
  public static final int DAO_FACTORY = 0;
  public static final int OTHER_DAO_FACTORY = 1;


  //Retourne un objet Classe interagissant avec la BDD
  public abstract DAO<User> getUserDAO();

   
  //Méthode permettant de récupérer les Factory 
  public static AbstractDAOFactory getFactory(int type){
	  System.out.println("getFactory");

    switch(type){
      case DAO_FACTORY:
        return new DAOFactory();
      case OTHER_DAO_FACTORY: 
        return new OtherDAOFactory();
      default:
        return null;
    }
  }
}