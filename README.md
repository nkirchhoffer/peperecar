# papote-car-back

## Configuration de la BDD

Vous pouvez télécharger le bin de PostgreSQL.

Pour la première configuration de la bdd, il faudra se placer dans pgsql/bin

```
+-- postgresql
|   +-- data
|   +-- pgsql
|   |  +-- bin    
|   |  +-- doc 
|   |  +-- lib
|   |  +-- ...  
```

puis saisir les commandes suivantes :

```shell script
$ initdb -D ../../data -E utf8
$ pg_ctl -D ../../data -l logfile start
$ createuser -s -P popotecar-admin
Enter password for new role: popotecar-admin
Enter it again: popotecar-admin
$ createdb -O popotecar-admin -E utf8 popotecar 
```

Lancer la base de données

```
$ pg_ctl -D ../../data -l logfile start
```
Arrêter la base de données

```
$ pg_ctl -D ../../data -l logfile stop
```

Réinitialiser la base de données

```
$ dropdb popotecar && createdb -O popotecar-admin -E utf8 popotecar
```

## Lancement de l'application

```
$ mvnw spring-boot:run
```

***
