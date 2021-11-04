package com.example.entrevuespringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entrevuespringboot.entite.FilmEntite;
import com.example.entrevuespringboot.mapper.FilmMapper;
import com.example.entrevuespringboot.modele.Film;
import com.example.entrevuespringboot.repository.FilmRepository;

/**
 * 
 * @author dleperou
 *
 *         Service utilisé par le controller pour s'interfacer avec la base de
 *         données
 *
 *
 */

@Service
public class EntrevueSpringBootService {

  @Autowired
  FilmRepository filmRepository;

  @Autowired
  FilmMapper filmMapper;

  /**
   * 
   * cherche un film par son id
   * 
   * @param id
   * @return
   */
  public Film chercheFilmParId(Long id) {

    // cherche le film en BD
    FilmEntite filmEntite = null;
    try {
      filmEntite = filmRepository.findById(id).get();
    } catch (Exception e) {
      // une erreur s'est produite, on retourne null
      return null;
    }

    // on converti le film entité trouvé en film et on le retourne
    return filmMapper.obtenirFilm(filmEntite);
  }

  /**
   * 
   * Sauvegarde le film en BD
   * 
   * @param film
   * @return
   */
  public Film sauvegardeFilm(Film film) {

    // on sauvegarde le film en BD et on récupère le film avec les id créés
    FilmEntite filmEntite = filmRepository.save(filmMapper.obtenirFilmEntite(film));

    // on converti le film entité en film et on le retourne
    return filmMapper.obtenirFilm(filmEntite);
  }
}
