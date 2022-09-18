package com.example.BodyBook;



import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserAccess userAccess = new UserAccess();
        try {
            User currUser = userAccess.getUserByUsernameOrEmail(username);
            if(currUser == null) {
                req.setAttribute("loginStatus", "wrong uname");
                req.getRequestDispatcher("index.jsp").forward(req,resp);
                return;
            }
            if(!currUser.getPassword().equals(password)){
                req.setAttribute("loginStatus", "incorrect pass");
                req.getRequestDispatcher("index.jsp").forward(req,resp);
                return;
            }
            req.getSession().setAttribute("user", currUser);
            req.setAttribute("user", currUser);
            req.getRequestDispatcher("UserPage.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
