# AppMobileRechercheEmploies
Application android de recherche d'emploie sur une plateforme d'offre, développée avec **spring boot(backend)**,**android studio (frontend)** et pour la gestion des données nous avons utilisé le SGBD **MySQL**. Tout le code de l'application est écrit en **JAVA**

##### L'application permet aux utilisateurs de consulter les offres disponibles sur la plateforme par catégories mais aussi d'y postuler, ils peuvent aussi consulter les CVs disponibles sur la plateforme.

## Backend de l'application

![alt text](/endpoint.png?raw=true)
Pour tester les APIs Spring Boot, nous utilisons **swagger-ui**. C'est ainsi qu'après le lancement du swagger-ui, nous avons:
### Le schéma de stockage des CVs dans MySQL en utilisant une methode POST HTTP
![alt text](/schema_bd.png?raw=true)
### Envoie de données de CV dans MySQL à partir de swagger-ui
![alt text](/postuleEndpoint.png?raw=true)
### Liste de tous les CVs disponible dans la base de données en utilisant une methode GET HTTP
![alt text](/lister.png?raw=true)

## Frontend: l'application mobile

### L'interface du lanceur de l'application : Goye Tchetchi Yan qui signifie recherche d'emploi en langue Zarma
![alt text](/launcher.png?raw=true)
### Menu principale de l'application: L'utilisateur clique seulement sur l'icône correspondant à ce qu'il veut faire, par exemple lister les CVs
![alt text](/homePage.png?raw=true)
### Liste des CVs disponibles sur la plateforme: On peut voir le détail d'un CVs juste en cliquant dessus, ce qui va ouvrir une nouvelle activité
![alt text](/listeCVs.png?raw=true)
### Détail du CV de l'utilisateur Sofiane:
![alt text](/detailCV.png?raw=true)
### Liste des offres disponibles sur la plateforme: ici aussi, il peut voir le détail d'un offre juste en cliquant dessus voir même y postuler
![alt text](/listeOffre.png?raw=true)
### Détail de l'offre:
![alt text](/detailOffre.png?raw=true)
### Page pour postuler: Pour postuler à un offre, l'utilisateur doivent remplir tous les champs et puis cliquer sur le button postuler pour envoyer son CV. Il sera automatiquement rédiriger à la page des offres.
![alt text](/pagePostuler.png?raw=true)
