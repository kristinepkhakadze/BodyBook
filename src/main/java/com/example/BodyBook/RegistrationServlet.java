package com.example.BodyBook;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "registration-Servlet", value = "/registration-Servlet")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String repeatpassword = req.getParameter("repeatpassword");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String profession = req.getParameter("profession");

        try {
            UserAccess userAccess = new UserAccess();
            if( userAccess.getUserByUsernameOrEmail(username) != null){
                req.setAttribute("status", "username taken");
                req.getRequestDispatcher("Registration.jsp").forward(req, resp);
                return;
            }
            if(userAccess.getUserByUsernameOrEmail(email) != null){
                req.setAttribute("status", "password does not match");
                req.getRequestDispatcher("Registration.jsp").forward(req, resp);
                return;
            }
            if(!password.equals(repeatpassword)){
                req.setAttribute("status", "password does not match");
                req.getRequestDispatcher("Registration.jsp").forward(req, resp);
                return;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            UserAccess userAccess = new UserAccess();
            User newUser = new User(username, email, password, name, surname, profession);
            userAccess.putUser(newUser);
            req.getSession().setAttribute("user", newUser);
            req.getRequestDispatcher("UserPage.jsp").forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
