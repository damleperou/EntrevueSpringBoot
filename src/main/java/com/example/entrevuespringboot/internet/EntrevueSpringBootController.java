package com.example.entrevuespringboot.internet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entrevuespringboot.modele.Film;
import com.example.entrevuespringboot.service.EntrevueSpringBootService;

/**
 * 
 * @author dleperou
 * 
 *         Point d'entré de l'application
 * 
 *         J'ai essayé de crée des nom de package en Français mais ne
 *         connaissant pas vos conventions, il se peut que cela soit un peu ...
 *         inexact.
 * 
 *         Par ailleurs comme cela n'était pas demandé, je n'ai pas non plus
 *         implémenté de systeme de configuration par environement ni de log
 * 
 *
 */
@RestController
@RequestMapping(value = "/api")
public class EntrevueSpringBootController {

  @Autowired
  EntrevueSpringBootService entrevueSpringBootService;

  /**
   * 
   * Utiliser pour récuperer un fiml via son id
   * 
   * @param id
   * @return Film
   */
  @RequestMapping(method = RequestMethod.GET, value = "/film/{id}")
  public ResponseEntity<Film> obtenirFilm(@PathVariable Long id) {
    // appelle le service pour recuperer le film
    Film film = entrevueSpringBootService.chercheFilmParId(id);

    // si le film est null on retourne un 404
    if (film == null) {
      return new ResponseEntity<Film>(new Film(), HttpStatus.NOT_FOUND);
    } else {
      // sinon on retourne le film trouvé
      return new ResponseEntity<Film>(film, HttpStatus.OK);
    }
  }

  /**
   * 
   * Utiliser pour enregistrer un film
   * 
   * @param nouveauFilm
   * @return Film
   */
  @RequestMapping(method = RequestMethod.POST, value = "/film")
  public ResponseEntity<Film> enregistrerFilm(@RequestBody Film film) {
    // appelle le service pour sauvegarder le film en base de données
    film = entrevueSpringBootService.sauvegardeFilm(film);

    // retourne le film sauvegardé avec ses id créés
    return new ResponseEntity<Film>(film, HttpStatus.CREATED);
  }
}
