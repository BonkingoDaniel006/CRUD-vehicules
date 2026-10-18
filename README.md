# Gestion de stock de véhicules

Ce projet est une petite application en ligne de commande réalisée pour me familiariser avec Java. Elle permet de gérer les opérations CRUD (*Create, Read, Update, Delete*) sur un stock de véhicules.

## Fonctionnalités

- Ajouter un véhicule avec son immatriculation, sa marque et son prix.
- Afficher les véhicules enregistrés.
- Rechercher un véhicule par son immatriculation.
- Modifier sa marque, son prix ou son immatriculation.
- Supprimer un véhicule.
- Refuser l’ajout d’un véhicule dont l’immatriculation est déjà utilisée.

Les données sont conservées en mémoire pendant l’exécution du programme : elles ne sont pas sauvegardées à la fermeture.

## Organisation du projet

- `Main.java` : point d’entrée du programme, menu et interactions avec l’utilisateur.
- `Vehicule.java` : classe qui représente un véhicule et ses informations.
- `GestionStock.java` : opérations de gestion du stock, conservé dans une `HashMap` indexée par immatriculation.

## Prérequis

Un JDK Java 14 ou supérieur est nécessaire, notamment pour la syntaxe `switch` utilisée dans le menu.

## Compiler et lancer

Depuis le dossier du projet, compilez les fichiers :

```bash
javac Main.java Vehicule.java GestionStock.java
```

Puis lancez l’application :

```bash
java Main
```

Suivez les choix affichés dans le menu pour gérer les véhicules. Choisissez `6` pour quitter.

## Notions Java pratiquées

Le projet met en pratique les classes et les objets, les attributs et méthodes, les collections (`Map` et `HashMap`), les listes, les méthodes CRUD, les entrées au clavier avec `Scanner` et l’affichage personnalisé avec `toString()`.
