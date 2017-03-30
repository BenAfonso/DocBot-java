package dao.pg;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectDB {
    /**
     * URL de connection
     */
    private static String url = "jdbc:postgresql://ec2-54-247-120-169.eu-west-1.compute.amazonaws.com/d8avcmrno12kvq?user=bagpcgtcztmwbu&password=e1d502edf668d94a0203aba461aa2a5a7df0c881eff37e96b8ffa238dc067c41&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";

    /**
     * Nom du user
     */
    private static String user = "bagpcgtcztmwbu";

    /**
     * Mot de passe du user
     */
    private static String passwd = "e1d502edf668d94a0203aba461aa2a5a7df0c881eff37e96b8ffa238dc067c41";

    /**
     * Objet Connection
     */
    private static Connection connect;

    /**
     * Méthode qui va retourner notre instance
     * et la créer si elle n'existe pas...
     *
     * @return
     */
    public static Connection getInstance() {
        if (connect == null) {
            try {
                Class.forName("org.postgresql.Driver");
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERREUR DE CONNEXION ! ", JOptionPane.ERROR_MESSAGE);
            }
        }
        return connect;
    }
}
