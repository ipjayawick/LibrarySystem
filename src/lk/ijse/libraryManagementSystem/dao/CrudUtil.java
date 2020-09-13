package lk.ijse.libraryManagementSystem.dao;
import lk.ijse.libraryManagementSystem.db.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudUtil {
    public static <T> T execute(String sql,Object... params) throws SQLException, ClassNotFoundException {
        PreparedStatement pst = DBConnection.getInstance().getConnection().prepareStatement(sql);
        for (int i = 0; i <params.length; i++) {
            pst.setObject((i+1),params[i]);
        }
        if (sql.startsWith("SELECT")){
            return (T) pst.executeQuery();
        }
        return (T)(Boolean)(pst.executeUpdate()>0);
    }
}
