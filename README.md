# MasterAnnonce - Application de gestion d'annonces

Ce projet est une application web Java EE développée avec **JSP / Servlet / JDBC**, permettant la gestion complète d'annonces (CRUD).

## Objectifs pédagogiques

- Manipuler les **servlets** et **JSP**.
- Interagir avec une base de données **MySQL** via **JDBC**.
- Appliquer la logique MVC côté back-end.
- Prendre en main les **formulaires**, la validation, la gestion des erreurs.
- Intégrer le framework **Bootstrap 5** pour le design.

---

## Fonctionnalités

| Fonction | Description |
|---------|-------------|
| Lister | Affiche toutes les annonces enregistrées |
| Ajouter | Formulaire pour créer une nouvelle annonce |
| Modifier | Formulaire de mise à jour avec pré-remplissage |
| Supprimer | Suppression sécurisée via POST et confirmation |

---

## Technologies utilisées

- Java 17
- Servlet & JSP
- JDBC (avec `PreparedStatement`)
- MySQL 8
- Bootstrap 5 + Bootstrap Icons
- JSTL

---

## Configuration

### Prérequis

- Java JDK 17+
- Apache Tomcat (10 recommandé)
- MySQL Server
- Maven (si utilisé)
- IDE compatible (IntelliJ, Eclipse)

###  Base de données

Créer une base `MasterAnnonce` dans MySQL :

```sql
CREATE DATABASE MasterAnnonce;

USE MasterAnnonce;

CREATE TABLE annonce (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  description TEXT NOT NULL,
  adress VARCHAR(255) NOT NULL,
  mail VARCHAR(255) NOT NULL,
  date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```
---

## Connexion (fichier `ConnectionDB.java`)

```java
private static final String URL = "jdbc:mysql://localhost:3306/MasterAnnonce?serverTimezone=UTC";
private static final String USER = "root";
private static final String PASSWORD = "toto";
```
---

## Structure du projet

```plaintext
src/
├── models/         
│   └── Annonce.java
├── dao/            
│   ├── AnnonceDAO.java
│   └── DAO.java
├── servlets/       
│   ├── AnnonceAdd.java
│   ├── AnnonceUpdate.java
│   ├── AnnonceDelete.java
│   ├── AnnonceList.java
│   └── HelloWorld.java
├── utils/          
│   └── ConnectionDB.java

ressources/
├── script.sql  

webapp/
├── WEB-INF/  
│   └── web.xml   
├── AnnonceList.jsp
├── AnnonceAdd.jsp
├── AnnonceUpdate.jsp
├── hello.jsp
├── index.jsp
```
---

## Bonnes pratiques intégrées

- **Validation côté serveur**  
  Tous les champs sont vérifiés côté serveur avec des messages d’erreur clairs pour guider l’utilisateur.

- **Re-remplissage des champs en cas d’erreur**  
  Les champs du formulaire conservent les données saisies si une erreur survient, évitant à l’utilisateur de tout retaper.

- **Suppression sécurisée**  
  Les suppressions se font via un formulaire en `POST` avec une **confirmation JavaScript**, évitant les suppressions accidentelles par simple clic de lien.

- **Factorisation des DAO**  
  Le DAO générique (`DAO<T>`) permet d’encapsuler la logique d’accès aux données de manière réutilisable et centralisée.

-  **Respect du découplage MVC**  
  Le projet suit une architecture claire :
    - **Modèle** (`models`)
    - **Contrôleur** (`servlets`)
    - **Vue** (`JSP`)  
      assurant lisibilité, maintenabilité et évolutivité.


## Auteur
- **Elsa Hadjadj**
- Projet réalisé dans le cadre du **TP AIR n°1** (BUT Informatique)

