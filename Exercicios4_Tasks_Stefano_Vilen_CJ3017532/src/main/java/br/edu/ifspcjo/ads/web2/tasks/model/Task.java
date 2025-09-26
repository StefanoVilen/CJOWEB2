package br.edu.ifspcjo.ads.web2.tasks.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Task implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;
  private String description;
  private LocalDate date;

  public Task() {}

  public Task(Long id, String description, LocalDate date) {
    this.id = id;
    this.description = description;
    this.date = date;
  }

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }

  public LocalDate getDate() { return date; }
  public void setDate(LocalDate date) { this.date = date; }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Task task = (Task) o;
    return Objects.equals(id, task.id);
  }
  @Override public int hashCode() { return Objects.hash(id); }
}
