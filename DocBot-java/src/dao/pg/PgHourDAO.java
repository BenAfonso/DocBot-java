package dao.pg;
import dao.HourDAO;
import models.Hour;
import java.sql.Connection;

import java.util.*;

/**
 * @author BenAfonso
 */
public class PgHourDAO extends HourDAO {

	private static PgHourDAO pgHourDao;
    /**
     * Default constructor
     */
    private PgHourDAO() {
    }
    
	public static PgHourDAO getPgHourDAO(){
		if( pgHourDao == null ){
			pgHourDao  = new PgHourDAO();
		}
		return pgHourDao;
	}

	@Override
	public void create(Hour hour) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Hour hour) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void find(Hour hour) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Hour hour) {
		// TODO Auto-generated method stub
		
	}

}