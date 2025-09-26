package br.edu.ifspcjo.ads.web2.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import javax.sql.DataSource;

import br.edu.ifspcjo.ads.web2.model.Gender;
import br.edu.ifspcjo.ads.web2.model.User;
import br.edu.ifspcjo.ads.web2.utils.PasswordEncoder;

public class UserDao {
  private final DataSource dataSource;

  public UserDao(DataSource dataSource) { this.dataSource = dataSource; }

  // ---- Cadastro (respeita e-mail único) ----
  public Boolean save(User user){
    Optional<User> optional = getUserByEmail(user.getEmail());
    if(optional.isPresent()) return false;

    String sql = "INSERT INTO `user` (name, email, password, birth_date, gender, active) VALUES (?,?,?,?,?,?)";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, user.getName());
      ps.setString(2, user.getEmail());
      ps.setString(3, user.getPassword());
      ps.setDate(4, Date.valueOf(user.getDateOfBirth()));
      ps.setString(5, user.getGender().toString());
      ps.setBoolean(6, true);
      ps.executeUpdate();
      return true;
    } catch (SQLException e) {
      throw new RuntimeException("Erro durante a escrita no BD", e);
    }
  }

  // ---- Busca por e-mail ----
  public Optional<User> getUserByEmail(String email){
    String sql = "SELECT id, name, email, password, birth_date, gender, active FROM `user` WHERE email = ?";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, email);
      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) return Optional.of(mapUser(rs));
      }
    } catch (SQLException e) {
      throw new RuntimeException("Erro ao buscar usuário por e-mail", e);
    }
    return Optional.empty();
  }

  // ---- Autenticação (login) ----
  public Optional<User> authenticate(String email, String rawPassword){
    String passwordHash = PasswordEncoder.encode(rawPassword); // MD5 HEX MAIÚSCULO
    String sql = "SELECT id, name, email, password, birth_date, gender, active " +
                 "FROM `user` WHERE email = ? AND password = ? AND active = TRUE";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, email);
      ps.setString(2, passwordHash);
      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) return Optional.of(mapUser(rs));
      }
    } catch (SQLException e) {
      throw new RuntimeException("Erro ao autenticar usuário", e);
    }
    return Optional.empty();
  }

  // ---- Mapper ----
  private User mapUser(ResultSet rs) throws SQLException{
    User u = new User();
    u.setId(rs.getLong("id"));
    u.setName(rs.getString("name"));
    u.setEmail(rs.getString("email"));
    u.setPassword(rs.getString("password")); // cuidado: não exibir isso em JSP!
    Date bd = rs.getDate("birth_date");
    if (bd != null) u.setDateOfBirth(bd.toLocalDate());
    String g = rs.getString("gender");
    if (g != null) u.setGender(Gender.valueOf(g));
    return u;
  }
}