package dao;

import models.AnswerRequest;

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
    public abstract void update(AnswerRequest answerRequest);

    /**
     * @param answerRequest
     */
    public abstract void find(AnswerRequest answerRequest);

    /**
     * @param answerRequest
     */
    public abstract void delete(AnswerRequest answerRequest);
}