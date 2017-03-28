package dao.pg;
import dao.*;
import models.Comment;
import models.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @author BenAfonso
 */
public class PgCommentDAO extends CommentDAO {

    /**
     * Default constructor
     */
	public PgCommentDAO(Connection conn) {
		super(conn);
	}

	
	/**
	 * Create a Comment
	 * @param Comment
	 * @return boolean
	 */
	public boolean create(Comment obj) {
		try {
			int result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Comment (requestappointment_id, datepost, title, content,rate) VALUES ('"+obj.getAppointment_id()+"','"+obj.getDatePost()+"','"+obj.getTitle()+"','"+obj.getContent()+"','"+obj.getRate()+"')");
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}