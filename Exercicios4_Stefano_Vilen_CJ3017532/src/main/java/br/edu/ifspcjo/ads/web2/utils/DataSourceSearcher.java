package br.edu.ifspcjo.ads.web2.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceSearcher {
  private static DataSourceSearcher instance = new DataSourceSearcher();
  private DataSource dataSource;

  private DataSourceSearcher() {
    try {
      Context context = new InitialContext();
      context = (Context) context.lookup("java:comp/env");
      dataSource = (DataSource) context.lookup("jdbc/Exercicios4DB"); // <-- alterado
    } catch (NamingException e) {
      throw new RuntimeException("Erro durante o lookup do DataSource", e);
    }
  }

  public static DataSourceSearcher getInstance() { return instance; }
  public DataSource getDataSource() { return dataSource; }
}