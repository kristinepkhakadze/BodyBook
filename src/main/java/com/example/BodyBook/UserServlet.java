package com.example.BodyBook;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String password = req.getParameter("password");
        String repeatedPassword = req.getParameter("repeatpassword");
        String profession = req.getParameter("profession");

        User user = (User) req.getSession().getAttribute("user");

        if(!username.isEmpty()){
            user.setUsername(username);
        }
        if(!name.isEmpty()){
            user.setName(name);
        }
        if(!surname.isEmpty()){
            user.setSurname(surname);
        }
        if(!email.isEmpty()){
            user.setEmail(email);
        }
        if(!profession.isEmpty()){
            user.setProfession(profession);
        }
        if(!password.isEmpty()){
            if(password.equals(repeatedPassword)) {
                user.setPassword(password);
            }else {
                req.setAttribute("updateStatus", "password does not same");
                req.getRequestDispatcher("UserPage.jsp").forward(req,resp);
            }
        }

        UserAccess userAccess = new UserAccess();
        try {
            userAccess.updateUser(user);
            req.getRequestDispatcher("UserPage.jsp").forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
