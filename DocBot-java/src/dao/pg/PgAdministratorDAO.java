package dao.pg;

import dao.AdministratorDAO;
import models.Administrator;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PgAdministratorDAO extends AdministratorDAO {

    private static PgAdministratorDAO pgAdministratorDAO;

    /**
     * Default constructor
     */
    private PgAdministratorDAO() {
    }

    public static PgAdministratorDAO getPgAdministratorDAO() {
        if (pgAdministratorDAO == null) {
            pgAdministratorDAO = new PgAdministratorDAO();
        }
        return pgAdministratorDAO;
    }


    @Override
    public Administrator find(int id) {
        Administrator admin = null;
        try {
            ResultSet result = ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM administrator a, person p WHERE a.id=p.id AND p.id='" + id + "'");

            if (result.first())
                admin = new Administrator(result.getInt(id), result.getString("firstname"), result.getString("lastname"), result.getString("password"), result.getDate("birthday"), result.getString("phone"), result.getString("email"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

}
