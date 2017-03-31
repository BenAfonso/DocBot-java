package dao;

import models.Person;


public abstract class PersonDAO {


    /**
     * Méthode de création
     *
     * @param Person
     * @return boolean
     */
    public abstract boolean create(Person person);

    /**
     * Méthode pour effacer
     *
     * @param Person
     * @return boolean
     */
    public abstract boolean delete(Person person);

    /**
     * Méthode de mise à jour
     *
     * @param Person
     * @return boolean
     */
    public abstract boolean update(Person person);

    /**
     * Méthode de recherche des informations
     *
     * @param id
     * @return User
     */
    public abstract Person find(int id);

    /**
     * find a person with his given mail
     * @param mail the mail of the person
     * @return the Person
     */
    public abstract Person find(String mail);

    /**
     * update the password of a person
     * @param mail the mail of the person
     * @param newPassword the  new pass word
     * @return true if the updated went right, false otherwise
     */
    public abstract boolean updatePassword(String mail, String newPassword);
}