package dao;

import java.sql.Connection;
import models.AnswerRequest;
import java.util.*;

/**
 * @author BenAfonso
 */
public abstract class AnswerRequestDAO {

    /**
     * Default constructor
     */
    public AnswerRequestDAO() {
    }

    /**
     * 
     */
    public Connection connect;

    /**
     * @param answerRequest
     */
    public void create(AnswerRequest answerRequest) {
        // TODO implement here
    }

    /**
     * @param answerRequest
     */
    public void update(AnswerRequest answerRequest) {
        // TODO implement here
    }

    /**
     * @param answerRequest
     */
    public void find(AnswerRequest answerRequest) {
        // TODO implement here
    }

    /**
     * @param answerRequest
     */
    public void delete(AnswerRequest answerRequest) {
        // TODO implement here
    }

}