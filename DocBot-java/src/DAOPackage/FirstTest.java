package DAOPackage;

import ModelPackage.User;

public class FirstTest { 
  public static void main(String[] args) {
      
	    System.out.println("");
	    AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	    //On récupère un objet faisant le lien entre la base et nos objets 
	    DAO<User> userDao = adf.getUserDAO();
	      
	    for(int i = 1; i < 2; i++){
	      //On fait notre recherche
	      User user = userDao.find(i);
	      System.out.println("\tUser N°" + user.getId() + " - NOM : " + user.getLname() + " - PRENOM : " + user.getFname());
	    }      
	      
	    System.out.println("\n\t************************************");  
  }
}