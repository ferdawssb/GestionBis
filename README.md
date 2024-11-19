Application Web de Gestion des Projets
Description
Ce projet consiste en le développement d'une application web de gestion des projets d'une entreprise utilisant SpringMVC. L'application permet de gérer les départements, les projets et les employés d'une entreprise, en respectant les règles d'organisation suivantes :

Un département est caractérisé par un identifiant et un nom.
Un projet est caractérisé par un identifiant, un titre et un état (non lancé, actif, achevé).
Un projet est développé dans un seul département.
Un employé est caractérisé par un identifiant et un nom.
Un employé travaille dans un seul projet.
Un employé appartient à un unique département.
Un employé possède une fonction dans le département (manager, ingénieur ou technicien).
Architecture
L'application est structurée en trois couches :

Model : Défini par les classes Departement, Projet et Employe.
DAO : Défini par les interfaces IDepartement, IProjet et IEmploye.
Controller : Défini par la classe AppController, qui représente le contrôleur SpringMVC.
L'application utilise Spring Data JPA pour la gestion de la persistance des données.

Interfaces Web
L'application propose plusieurs interfaces web pour interagir avec les données :

Liste des départements : Affiche la liste de tous les départements (Interface principale).
Liste des employés d'un département : Affiche les employés d'un département sélectionné.
Liste des projets d'un département : Affiche les projets d'un département sélectionné.
Liste des employés d'un projet : Affiche les employés d'un projet sélectionné.
Ajout d'un projet : Formulaire pour ajouter un nouveau projet.
Ajout d'un employé : Formulaire pour ajouter un nouvel employé.
