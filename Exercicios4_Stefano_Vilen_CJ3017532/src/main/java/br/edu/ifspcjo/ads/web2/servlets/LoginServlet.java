package br.edu.ifspcjo.ads.web2.servlets;

import java.io.IOException;
import java.util.Optional;

import br.edu.ifspcjo.ads.web2.dao.UserDao;
import br.edu.ifspcjo.ads.web2.model.User;
import br.edu.ifspcjo.ads.web2.utils.DataSourceSearcher;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String email = req.getParameter("email");
    String password = req.getParameter("password");

    UserDao userDao = new UserDao(
        DataSourceSearcher.getInstance().getDataSource()
    );

    Optional<User> opt = userDao.authenticate(email, password);

    if (opt.isPresent()) {
      HttpSession session = req.getSession(true);
      session.setAttribute("loggedUser", opt.get());
      RequestDispatcher rd = req.getRequestDispatcher("/welcome.jsp");
      rd.forward(req, resp);
    } else {
      req.setAttribute("result", "loginError");
      RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
      rd.forward(req, resp);
    }
  }
}