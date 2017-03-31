package dao;

import models.Administrator;

public abstract class AdministratorDAO {


    /**
     * Return the administrator connected to the id given in parameters
     * @param id the id of the administrator
     * @return the administrator
     */
    public abstract Administrator find(int id);

}
