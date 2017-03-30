package dao;

import dao.pg.PgDAOFactory;
import models.Person;
public abstract class AbstractDAOFactory {
	
  public static final int PG_DAOFACTORY = 0;
  public static final int OTHER_DAOFACTORY = 1;

  /**
   * @return
   */
  public abstract PersonDAO getPersonDAO();

  /**
   * @return
   */
  public abstract DoctorDAO getDoctorDAO();
  /**
   * @return
   */
  public abstract PatientDAO getPatientDAO();
  /**
   * @return
   */
  public abstract ScheduleDAO getScheduleDAO();


  /**
   * @return
   */
  public abstract DisponibilityDAO getDisponibilityDAO();

  /**
   * @return
   */
  public abstract RequestAppointmentDAO getRequestAppointmentDAO();
  /**
   * @return
   */
  public abstract AnswerRequestDAO getAnswerRequestDAO();
  /**
   * @return
   */
  public abstract AppointmentDAO getAppointmentDAO();
  /**
   * @return
   */
  public abstract CommentDAO getCommentDAO();


   
  //Méthode permettant de récupérer les Factory 
  public static AbstractDAOFactory getFactory(int type){

    switch(type){
      case PG_DAOFACTORY:
        return PgDAOFactory.getPgDAOFactory();
      case OTHER_DAOFACTORY: 
        return null;
      default:
        return null;
    }
  }
}