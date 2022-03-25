package dataAccess;

import connection.DBConnection;
import model.Produs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

public class ProdusDA  extends AbstractDA<Produs> {
    public int setCantitate(int id, int cantitate){
        String s = "UPDATE PRODUS SET cantitate = " + cantitate + " WHERE id = " + id;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(s);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "UPDATE " + e.getMessage());
            return 0;
        } finally {
            DBConnection.close(statement);
            DBConnection.close(connection);
        }
        return 1;
    }

    }

