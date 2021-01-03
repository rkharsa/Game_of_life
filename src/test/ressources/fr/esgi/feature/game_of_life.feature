# language: fr
Fonctionnalité: Jouer au jeu de la vie

  Scénario:  une cellule vivante a 2 voisins
    Etant donné que  j'ai une génération contenant
      | | | |
      |x|x|x|
      | | | |
    Quand je passe à la génération suivante
    Alors la cellule au centre devrait être vivante

  Scénario:  une cellule vivante a 3 voisins
    Etant donné que  j'ai une génération contenant
      | |x| |
      |x|x|x|
      | | | |
    Quand je passe à la génération suivante
    Alors la cellule au centre devrait être vivante

  Scénario: une cellule vivante a moins de 2 voisins
    Etant donné que j'ai une génération contenant
      |x| | |
      | |x| |
      | | | |
    Quand je passe à la génération suivante
    Alors la cellule au centre devrait mourir

  Scénario: une cellule vivante a plus  de 3 voisins
    Etant donné que  j'ai une génération contenant
      | |x| |
      |x|x|x|
      | |x| |
    Quand je passe à la génération suivante
    Alors la cellule au centre devrait mourir


  Scénario:  une cellule morte a 3 voisins
    Etant donné que  j'ai une génération contenant
      | |x| |
      |x| |x|
      | | | |
    Quand je passe à la génération suivante
    Alors la cellule au centre devrait naitre

  Scénario:  une generation sans cellule vivante
    Etant donné que  j'ai une génération contenant
      | | | |
      | | | |
      | | | |
    Quand je passe à la génération suivante
    Alors toutes les cellules devraient être mortes


  Scénario: une generation avec aucun survivant
    Etant donné que  j'ai une génération contenant
      |x| | | |x|
      | | | | | |
      | | | | | |
      |x| | | |x|
    Quand je passe à la génération suivante
    Alors toutes les cellules devraient être mortes


  Scénario: l'evolution d'une generation en 4 tours
    Etant donné que  j'ai une génération contenant
      | | | | | |
      | |x|x|x| |
      | | |x| | |
      | | | | | |
    Quand je passe à la génération suivante
    Alors la génération suivante devrait contenir
      | | |x| | |
      | |x|x|x| |
      | |x|x|x| |
      | | | | | |
    Quand  je passe à la génération suivante
    Alors la génération suivante devrait contenir
      | |x|x|x| |
      | | | | | |
      | |x| |x| |
      | | |x| | |
    Quand  je passe à la génération suivante
    Alors la génération suivante devrait contenir
      | | |x| | |
      | |x| |x| |
      | | |x| | |
      | | |x| | |







