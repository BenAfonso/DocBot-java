package dao;

import java.sql.Connection;
import models.AnswerRequest;
import java.util.*;

/**
 * @author BenAfonso
 */
public abstract class AnswerRequestDAO {


    /**
     * @param answerRequest
     */
    public abstract void create(AnswerRequest answerRequest);

    /**
     * @param answerRequest
     */
    public abstract void update(AnswerRequest answerRequest) ;

    /**
     * @param answerRequest
     */
    public abstract void find(AnswerRequest answerRequest);

    /**
     * @param answerRequest
     */
    public abstract void delete(AnswerRequest answerRequest);
}