package com.example.entrevuespringboot.modele;

import java.util.ArrayList;
import java.util.List;

public class Film {
  private Long id;
  private String titre;
  private String description;
  private List<Acteur> acteurs = new ArrayList<Acteur>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitre() {
    return titre;
  }

  public void setTitre(String titre) {
    this.titre = titre;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Acteur> getActeurs() {
    return acteurs;
  }

  public void setActeurs(List<Acteur> acteurs) {
    this.acteurs = acteurs;
  }

}
