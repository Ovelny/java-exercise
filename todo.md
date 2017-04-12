# Todo

- [x] Rassembler tous les documents nécessaires dont UML
- [x] Désassembler l'UML et l'analyser en détails. Retranscrire le tout ici.
- [ ] Faire toutes les classes en modèles, en triant et supprimant ce qui a été inutilement fait
- [ ] Créer les premières functions d'ajout / get produits dans le manager et les tester


# L'UML décrit

- Le modèle stocke les données de produits, gère l'instance singleton et les catégories

- Le contrôleur gère les produits catégories et stock et contient les méthodes permettant d'agir sur 	  ces données

- La vue contient le programme principal pour les IHM et les interfaces

Il y a peu d'héritage sur cet UML. les 


# Consignes

La version 1 de l'application concerne la gestion du stock, soit:

- la gestion des produits
- la gestion des catégories de produit


Conceptualisation
Le diagramme suivant présente la structure minimale à respecter:

- les accesseurs/mutateurs, ainsi que les constructeurs sont laissés à l'appréciation des développeurs

- le diagramme peut-être enrichi (ajout de classes/méthodes/attributs)

- la classe Store est un singleton (patron de conception ou design-pattern)


- le diagramme respecte le patron d'architecture MVC :

	- l'impression de duplication de méthodes est normal
	- les responsabilités sont séparées par couche/sous-couche (Modèle-Vue-Contrôleur, avec des sous- 		  couches pour la partie contrôleur)



- les interfaces de la couche Vue laissent les développeurs libres de l'implémentation de l'IHM, dans 	  le respect des consignes suivantes:

	- l'IHM de consultation du stock sera une IHM web (pas d'applet), dont un des éléments implémentera 	  donc IStockConsultation
	
	- l'IHM de gestion du stock sera une IHM Swing' dont un des éléments implémentera donc        	-		  IStockManagement
	
	- note: il n'y a pas de critère de notation concernant la qualité artistique de l'interface; il est 	  fortement recommandé de se focaliser sur le fonctionnel avant de se pencher sur l'esthétisme si 		  les délais le permettent!
	


la base de données des produits sera contenue dans un fichier texte

le format du fichier est le suivant: idProduit;name;description;purchasingPrice;quantity;categoryLabel

il ne contient pas de ligne d'entête

le chemin absolu du fichier de base de données est contenu dans un fichier de configuration pour chacune des IHMs