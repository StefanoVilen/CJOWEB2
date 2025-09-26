package br.edu.ifspcjo.ads.web2.servlets;

import java.io.IOException;
import java.time.LocalDate;

import br.edu.ifspcjo.ads.web2.dao.UserDao;
import br.edu.ifspcjo.ads.web2.model.Gender;
import br.edu.ifspcjo.ads.web2.model.User;
import br.edu.ifspcjo.ads.web2.utils.DataSourceSearcher;
import br.edu.ifspcjo.ads.web2.utils.PasswordEncoder;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/userRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String name = req.getParameter("name");
    String email = req.getParameter("email");
    String password = req.getParameter("password");
    String dateOfBirth = req.getParameter("dateOfBirth");
    String gender = req.getParameter("gender");

    User user = new User();
    user.setName(name);
    user.setEmail(email);
    user.setPassword(PasswordEncoder.encode(password));
    user.setDateOfBirth(LocalDate.parse(dateOfBirth));
    user.setGender(Gender.valueOf(gender));

    UserDao userDao = new UserDao(
        DataSourceSearcher.getInstance().getDataSource()
    );

    RequestDispatcher dispatcher;
    if (userDao.save(user)) {
      req.setAttribute("result", "registered");
      dispatcher = req.getRequestDispatcher("/login.jsp");
    } else {
      req.setAttribute("result", "notRegistered");
      dispatcher = req.getRequestDispatcher("/user-register.jsp");
    }
    dispatcher.forward(req, resp);
  }
}