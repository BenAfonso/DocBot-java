package dao;

import models.Administrator;

public abstract class AdministratorDAO {

    public abstract void find(Administrator admin);

    public abstract Administrator find(int id);

    public abstract Administrator find(String mail);
}
