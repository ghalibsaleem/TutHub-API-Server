package helper;


import models.Tutor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ghalib on 2/10/2016.
 */
public class TutorOperations {
    private Connection connection = null;

    public TutorOperations() {
        connection = DatabaseOperations.getConnection();
    }

    public boolean tutorLogin(String username, String password) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            if (username.contains("@"))
                rs = stmt.executeQuery("select * from tutors WHERE email=" + username + "AND password=" + password);
            else
                rs = stmt.executeQuery("select * from tutors WHERE tutor_id=" + username + "AND password=" + password);
            if (rs != null && rs.next())
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Tutor getTutor(String tutorId, String password) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            if (tutorId.contains("@"))
                rs = stmt.executeQuery("select * from tutors WHERE email=" + tutorId + "AND password=" + password);
            else
                rs = stmt.executeQuery("select * from tutors WHERE tutor_id=" + tutorId + "AND password=" + password);
            if (rs != null && rs.next()) {
                Tutor tutor = new Tutor();
                tutor.tutor_id = rs.getString(0);
                tutor.email = rs.getString(1);
                tutor.password = rs.getString(2);
                tutor.name = rs.getString(3);
                tutor.description = rs.getString(4);
                tutor.imageURL = rs.getString(5);
                tutor.address = rs.getString(6);
                return tutor;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean updateTutor(String tutorId, String password, String colName, String colData) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            String postString = "", preString = "UPDATE tutors ";
            if (tutorId.contains("@"))
                rs = stmt.executeQuery("select * from tutors WHERE email=" + tutorId + "AND password=" + password);
            else
                rs = stmt.executeQuery("select * from tutors WHERE tutor_id=" + tutorId + "AND password=" + password);
            if (rs != null && rs.next()) {
                rs.updateString(colName, colData);
                rs.updateRow();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insertTutor(Tutor tutor) {
        String sql = "INSERT INTO tutors VALUES(" + tutor.tutor_id + "," + tutor.email + "," + tutor.password
                + "," + tutor.name + "," + tutor.description + "," + tutor.imageURL + "," + tutor.address + ")";
        try {
            Statement stmt = connection.createStatement();
            return stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkTutor(String tutorId) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            if (tutorId.contains("@"))
                rs = stmt.executeQuery("select * from tutors WHERE email=" + tutorId);
            else
                rs = stmt.executeQuery("select * from tutors WHERE tutor_id=" + tutorId);
            if (rs != null && rs.next())
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteTutor(String tutorID, String password) {
        // TODO: 2/27/2016  
        return false;
    }
}
