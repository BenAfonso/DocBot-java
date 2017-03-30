package dao.pg;

import dao.AnswerRequestDAO;
import models.AnswerRequest;

/**
 * @author BenAfonso
 */
public class PgAnswerRequestDAO extends AnswerRequestDAO {

    private static PgAnswerRequestDAO pgAnswerRequestDAO;

    private PgAnswerRequestDAO() {
    }

    public static PgAnswerRequestDAO getPgAnswerRequestDAO() {
        if (pgAnswerRequestDAO == null) {
            pgAnswerRequestDAO = new PgAnswerRequestDAO();
        }
        return pgAnswerRequestDAO;
    }

    @Override
    public void create(AnswerRequest answerRequest) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(AnswerRequest answerRequest) {
        // TODO Auto-generated method stub

    }

    @Override
    public void find(AnswerRequest answerRequest) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(AnswerRequest answerRequest) {
        // TODO Auto-generated method stub

    }

}