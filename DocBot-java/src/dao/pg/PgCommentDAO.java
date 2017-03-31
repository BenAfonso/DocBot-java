package dao.pg;

import dao.CommentDAO;
import models.Comment;
import models.Doctor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author BenAfonso
 */
public class PgCommentDAO extends CommentDAO {

    private static PgCommentDAO pgCommentDAO;

    /**
     * Default constructor
     */
    private PgCommentDAO() {
    }

    public static PgCommentDAO getPgCommentDAO() {
        if (pgCommentDAO == null) {
            pgCommentDAO = new PgCommentDAO();
        }
        return pgCommentDAO;
    }


    /**
     * Create a comment in the DB
     * @param comment the comment to create
     */
    public boolean create(Comment obj) {
        try {
            ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Comment (doctor_id,patient_id,datepost, title, content,rate) VALUES ('" + obj.getDoctor_id() + "','" + obj.getPatient_id() + "','" + obj.getDatePost() + "','" + obj.getTitle() + "','" + obj.getContent() + "','" + obj.getRate() + "')");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * Update an comment in the DB
     * @param comment the comment to Update
     */
    @Override
    public void update(Comment comment) {
        // TODO Auto-generated method stub

    }

    /**
     * delete a comment from the DB
     * @param comment the comment to delete
     */
    @Override
    public void delete(Comment comment) {
        // TODO Auto-generated method stub

    }

    /**
     * find an appointment with the id
     * @param id the id of the comment
     */
    @Override
    public void find(int id) {
        // TODO Auto-generated method stub

    }

    /**
     * Check if a patient can add a comment on the doctor
     * @param doctor_id the doctor to add the comment
     * @param patient_id the patient that could post the comment
     * @return true if the patient can post the comment on the doctor, false otherwise
     */
    public boolean canAddAComment(int doctor_id, int patient_id) {
        boolean getARequest = false;
        try {
            ResultSet result = ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT r.id "
                    + "FROM requestappointment r, disponibility d, schedule s WHERE "
                    + "r.disponibility_id = d.id AND d.schedule_id = s.id "
                    + "AND s.doctor_id = " + doctor_id + " AND r.patient_id =" + patient_id);

            while (result.next()) {
                getARequest = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getARequest;
    }

    /**
     * Find all the comment of a given doctor
     * @param doctor the doctor which we want the comment from
     * @return the list of comment
     */
    public List<Comment> findAll(Doctor doctor) {
        System.out.println(doctor.getId());
        // TODO Auto-generated method stub
        List<Comment> comments = new ArrayList<Comment>();
        try {
            ResultSet result = ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * "
                    + "FROM comment c "
                    + "WHERE c.doctor_id = " + doctor.getId());

            while (result.next()) {
                Comment comment = new Comment(result.getInt("id"), result.getString("content"), result.getString("title"), result.getInt("rate"), result.getDate("datepost"), result.getInt("doctor_id"), result.getInt("patient_id"));

                comments.add(comment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comments;
    }
}