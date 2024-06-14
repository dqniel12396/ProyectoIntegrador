package dh.backend.clinicaMVC.dao.impl;

import dh.backend.clinicaMVC.dao.IDao;
import dh.backend.clinicaMVC.db.H2Connection;
import dh.backend.clinicaMVC.models.Odontologo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class OdontologoDaoH2 implements IDao<Odontologo> {

    public static final Logger LOGGER = LoggerFactory.getLogger(OdontologoDaoH2.class);
    public static final String SQL_INSERT = "INSERT INTO ODONTOLOGO (NUMERODEMATRICULA, NOMBRE, APELLIDO) VALUES (?, ?, ?)";
    public static final String SQL_SELECT_BY_ID = "SELECT * FROM ODONTOLOGO WHERE ID=?";
    public static final String SQL_SELECT_ALL = "SELECT * FROM ODONTOLOGO";

    @Override
    public Odontologo registrar(Odontologo odontologo) {
        Connection connection = null;
        Odontologo odontologoRegistrado = null;
        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, odontologo.getNumero_matricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                odontologoRegistrado = new Odontologo(id, odontologo.getNumero_matricula(), odontologo.getNombre(), odontologo.getApellido());
            }
            LOGGER.info("Odontólogo registrado: " + odontologoRegistrado);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (Exception e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    LOGGER.error(ex.getMessage());
                }
            }
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return odontologoRegistrado;
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        Connection connection = null;
        Odontologo odontologo = null;
        try {
            connection = H2Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                odontologo = new Odontologo(resultSet.getInt("id"), resultSet.getInt("NUMERODEMATRICULA"),
                        resultSet.getString("nombre"), resultSet.getString("apellido"));
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        Connection connection = null;
        List<Odontologo> odontologos = new ArrayList<>();
        try {
            connection = H2Connection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()) {
                Odontologo odontologo = new Odontologo(resultSet.getInt("id"), resultSet.getInt("NUMERODEMATRICULA"),
                        resultSet.getString("nombre"), resultSet.getString("apellido"));
                odontologos.add(odontologo);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return odontologos;
    }
}
