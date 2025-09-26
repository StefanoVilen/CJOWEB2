package br.edu.ifspcjo.ads.web2.model;

public enum Gender {
	  MASCULINO("Masculino"),
	  FEMININO("Feminino"),
	  OUTRO("Outro"),
	  PREFIRO_NAO_DIZER("Prefiro não dizer");

	  private final String description;
	  private Gender(String description){ this.description = description; }
	  public String getDescription(){ return description; }
	}