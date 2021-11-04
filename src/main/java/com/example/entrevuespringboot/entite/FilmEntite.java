package com.example.entrevuespringboot.entite;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class FilmEntite {

  @Id
  @GeneratedValue
  private Long id;

  private String titre;
  private String description;

  @OneToMany(targetEntity = ActeurEntite.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private List<ActeurEntite> acteurs = new ArrayList<ActeurEntite>();

  public FilmEntite() {
  }

  public FilmEntite(String titre, String description, List<ActeurEntite> acteurs) {
    this.titre = titre;
    this.description = description;
    this.acteurs = acteurs;
  }

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

  public List<ActeurEntite> getActeurs() {
    return acteurs;
  }

  public void setActeurs(List<ActeurEntite> acteurs) {
    this.acteurs = acteurs;
  }

}
