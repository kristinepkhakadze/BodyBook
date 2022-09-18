package com.example.BodyBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAccess {
    private Connection connection;
    public UserAccess() {
        connection = DBConnection.getConnection();
    }

    public void putUser (User user ) throws SQLException {
        String q = "insert into Person(name, surname, username, password, email, profession)" +
                " values(?,?,?,?,?,?)";
        PreparedStatement st = connection.prepareStatement(q);
        st.setString(1, user.getName());
        st.setString(2, user.getSurname());
        st.setString(3, user.getUsername());
        st.setString(4, user.getPassword());
        st.setString(5, user.getEmail());
        st.setString(6, user.getProfession());
        st.executeUpdate();
    }
    public void updateUser (User user) throws SQLException {
        String q = "update db.Person" +
                " Set username = ?, password = ?, email = ?, name = ?, surname = ?, profession = ? " +
                " where id = ?";
        PreparedStatement st = connection.prepareStatement(q);
        st.setString(1, user.getUsername());
        st.setString(2, user.getPassword());
        st.setString(3, user.getEmail());
        st.setString(4, user.getName());
        st.setString(5, user.getSurname());
        st.setString(6, user.getProfession());
        st.setString(7, user.getId());
        st.executeUpdate();


    }
    public User getUserByUsernameOrEmail(String username) throws SQLException {
        String q = "select * from  db.Person where username = ?";
        if(username.contains("@"))
            q = "select * from  db.Person where email = ?";
        PreparedStatement st = connection.prepareStatement(q);
        st.setString(1, username);
        ResultSet rs = st.executeQuery();
        if(!rs.next())
            return null;
        User user = new User(
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("id"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getString("profession"));
        return user;

    }
}
