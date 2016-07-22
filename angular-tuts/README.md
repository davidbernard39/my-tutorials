# Créer une application Web avec Angular JS et Firebase

Tuto from http://code.tutsplus.com/series/creating-a-web-app-from-scratch-using-angularjs-and-firebase--cms-717

## Partie 1

Création d'une appli de blog où l'utilisateur peut s'identifier ou s'enregistrer et publier un article.

### Commencer avec Angular

- Récupérer le projet de démarrage angular-seed : `git clone https://github.com/angular/angular-seed.git`
- Installer les dépendances :
    - `cd angular-seed`
    - `npm install`
- Lancer le serveur : `npm start`
- Tester depuis le navigateur [http://localhost:8000/app/index.html](http://localhost:8000/app/index.html)

Le code de l'application se trouve dans le répertoire app. Le coeur de l'application se trouve dans le fichier `app.js`.

- Mise en place de la balise  `<div ng-view></div>`

- Création d'une page de login home
    - home/home.html contient la partie presentation
    - home/home.js contient la route et le controleur

- Ajout du module home dans le app.js et paramétrage par défaut de la route vers /home

### Commencer avec Firebase

- Créer un compte (compte google)
- Ajouter un système d'authentification par email/password.
- Ajouter un utilisateur avec mail et password
