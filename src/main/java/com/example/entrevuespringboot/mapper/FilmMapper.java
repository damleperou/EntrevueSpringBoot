package com.example.entrevuespringboot.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;

import com.example.entrevuespringboot.entite.ActeurEntite;
import com.example.entrevuespringboot.entite.FilmEntite;
import com.example.entrevuespringboot.modele.Acteur;
import com.example.entrevuespringboot.modele.Film;

@Mapper(componentModel = "spring")
public interface FilmMapper {

  public Film obtenirFilm(FilmEntite filmEntite);

  public FilmEntite obtenirFilmEntite(Film film);

  default List<Acteur> obtenirActeurs(List<ActeurEntite> acteurEntites) {
    List<Acteur> acteurs = new ArrayList<Acteur>(acteurEntites.size());
    acteurEntites.forEach(acteurEntite -> acteurs.add(obtenirActeur(acteurEntite)));
    return acteurs;
  }

  public Acteur obtenirActeur(ActeurEntite acteurEntite);

  default List<ActeurEntite> obtenirActeurEntites(List<Acteur> acteurs) {
    List<ActeurEntite> acteurEntites = new ArrayList<ActeurEntite>(acteurs.size());
    acteurs.forEach(acteur -> acteurEntites.add(obtenirActeurEntite(acteur)));
    return acteurEntites;
  }

  public ActeurEntite obtenirActeurEntite(Acteur acteur);
}
