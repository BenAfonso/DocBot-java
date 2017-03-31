package dao;

import dao.pg.PgDAOFactory;

public abstract class AbstractDAOFactory {

    public static final int PG_DAOFACTORY = 0;
    public static final int OTHER_DAOFACTORY = 1;

    /**
     * Methode that allows us to get the different factory
     * @param type the type of the factory, 0 for pgDAOFactory, 1 for other
     * @return the factory
     */
    public static AbstractDAOFactory getFactory(int type) {

        switch (type) {
            case PG_DAOFACTORY:
                return PgDAOFactory.getPgDAOFactory();
            case OTHER_DAOFACTORY:
                return null;
            default:
                return null;
        }
    }

    /**
     * get the personDAO
     * @return the personDAO
     */
    public abstract PersonDAO getPersonDAO();

    /**
     * get the DoctorDAO
     * @return the DoctorDAO
     */
    public abstract DoctorDAO getDoctorDAO();

    /**
     * get the PatientDAO
     * @return the PatientDAO
     */
    public abstract PatientDAO getPatientDAO();

    /**
     * get the AdministratorDAO
     * @return the AdministratorDAO
     */
    public abstract AdministratorDAO getAdministratorDAO();

    /**
     * get the ScheduleDAO
     * @return the ScheduleDAO
     */
    public abstract ScheduleDAO getScheduleDAO();

    /**
     * get the DisponibilityDAO
     * @return the DisponibilityDAO
     */
    public abstract DisponibilityDAO getDisponibilityDAO();

    /**
     * get the RequestAppointmentDAO
     * @return the RequestAppointmentDAO
     */
    public abstract RequestAppointmentDAO getRequestAppointmentDAO();

    /**
     * get the AnswerRequestDAO
     * @return the AnswerRequestDAO
     */
    public abstract AnswerRequestDAO getAnswerRequestDAO();

    /**
     * get the AppointmentDAO
     * @return the AppointmentDAO
     */
    public abstract AppointmentDAO getAppointmentDAO();

    /**
     * get the CommentDAO
     * @return the CommentDAO
     */
    public abstract CommentDAO getCommentDAO();
}