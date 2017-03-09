package DAOPackage;


public abstract class AbstractDAOFactory {
  public static final int DAO_FACTORY = 0;
  public static final int OTHER_DAO_FACTORY = 1;


  //Retourne un objet Classe interagissant avec la BDD
  public abstract DAO getUserDAO();

   
  //Méthode permettant de récupérer les Factory 
  public static AbstractDAOFactory getFactory(int type){
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