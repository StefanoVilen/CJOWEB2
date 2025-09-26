package br.edu.ifspcjo.ads.web2.tasks.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.ifspcjo.ads.web2.tasks.model.Task;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/tasks")
public class TaskServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  // Lista em memória (ArrayList) e um gerador simples de IDs
  private static final List<Task> TASKS =
      Collections.synchronizedList(new ArrayList<>()); // ainda é ArrayList por baixo

  private static long SEQ = 1L;

  // GET: exibe a lista
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setAttribute("tasks", TASKS);
    RequestDispatcher rd = req.getRequestDispatcher("/task-list.jsp");
    rd.forward(req, resp);
  }

  // POST: recebe o formulário, adiciona e encaminha para a lista
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String description = req.getParameter("description");
    String dateStr = req.getParameter("date");

    // Validação simples (campos obrigatórios)
    if (description == null || description.isBlank() ||
        dateStr == null || dateStr.isBlank()) {
      req.setAttribute("error", "Descrição e Data são obrigatórias.");
      RequestDispatcher rd = req.getRequestDispatcher("/task-form.jsp");
      rd.forward(req, resp);
      return;
    }

    Task t = new Task();
    t.setId(SEQ++);
    t.setDescription(description.trim());
    t.setDate(LocalDate.parse(dateStr)); // formato yyyy-MM-dd do input type="date"

    TASKS.add(t);

    // Encaminha (forward) para a JSP que lista (requisito do enunciado)
    req.setAttribute("tasks", TASKS);
    RequestDispatcher rd = req.getRequestDispatcher("/task-list.jsp");
    rd.forward(req, resp);
  }
}
