DROP
    TABLE
        IF EXISTS group_person;

DROP
    TABLE
        IF EXISTS personne;

DROP
    TABLE
        IF EXISTS pays;

DROP
    TABLE
        IF EXISTS groupe;

CREATE
    TABLE
        pays(
            idpays INT NOT NULL AUTO_INCREMENT,
            nompays VARCHAR(90) NOT NULL,
            capitale VARCHAR(60),
            PRIMARY KEY(idpays)
        );

CREATE
    TABLE
        personne(
            idp INT NOT NULL AUTO_INCREMENT,
            nomp VARCHAR(30) NOT NULL,
            prenoms VARCHAR(35),
            dateNaissance DATE,
            sexe CHAR(1),
            id_pays INT,
            PRIMARY KEY(idp)
        );

CREATE
    TABLE
        groupe(
            idg INT NOT NULL AUTO_INCREMENT,
            nomg VARCHAR(30) NOT NULL,
            description VARCHAR(50),
            PRIMARY KEY(idg)
        );

CREATE
    TABLE
        personne_groupe(
            personne_id INT NOT NULL,
            groupe_id INT NOT NULL,
            FOREIGN KEY(personne_id) REFERENCES personne(idp) ON
            DELETE
                RESTRICT ON
                UPDATE
                    CASCADE,
                    FOREIGN KEY(groupe_id) REFERENCES groupe(idg) ON
                    DELETE
                        RESTRICT ON
                        UPDATE
                            CASCADE,
                            PRIMARY KEY(
                                personne_id,
                                groupe_id
                            )
        );

INSERT
    INTO
        pays(
            nompays,
            capitale
        )
    VALUES(
        'Cote dIvoire',
        'Abidjan'
    );

INSERT
    INTO
        pays(
            nompays,
            capitale
        )
    VALUES(
        'France',
        'Paris'
    );

INSERT
    INTO
        pays(
            nompays,
            capitale
        )
    VALUES(
        'Usa',
        'New York'
    );

INSERT
    INTO
        pays(
            nompays,
            capitale
        )
    VALUES(
        'Allemangne',
        'Berlin'
    );

INSERT
    INTO
        pays(
            nompays,
            capitale
        )
    VALUES(
        'Canada',
        'Montreal'
    );

INSERT
    INTO
        pays(
            nompays,
            capitale
        )
    VALUES(
        'Chine',
        'Pekin'
    );

INSERT
    INTO
        pays(
            nompays,
            capitale
        )
    VALUES(
        'Afrique du Sud',
        'Johanesbourg'
    );

INSERT
    INTO
        pays(
            nompays,
            capitale
        )
    VALUES(
        'Espagne',
        'Madrid'
    );

INSERT
    INTO
        pays(
            nompays,
            capitale
        )
    VALUES(
        'Japon',
        'Tokyo'
    );

INSERT
    INTO
        personne(
            nomp,
            prenoms,
            dateNaissance,
            sexe,
            id_pays
        )
    VALUES(
        'user1',
        'prenomsUser1,',
        '1987-02-01',
        'M',
        9
    );

INSERT
    INTO
        personne(
            nomp,
            prenoms,
            dateNaissance,
            sexe,
            id_pays
        )
    VALUES(
        'user2',
        'prenomsUser2,',
        '1981-08-11',
        'M',
        3
    );

INSERT
    INTO
        personne(
            nomp,
            prenoms,
            dateNaissance,
            sexe,
            id_pays
        )
    VALUES(
        'user3',
        'prenomsUser3,',
        '1982-12-01',
        'F',
        1
    );

INSERT
    INTO
        personne(
            nomp,
            prenoms,
            dateNaissance,
            sexe,
            id_pays
        )
    VALUES(
        'user4',
        'prenomsUser4,',
        '1982-10-22',
        'F',
        6
    );

INSERT
    INTO
        personne(
            nomp,
            prenoms,
            dateNaissance,
            sexe,
            id_pays
        )
    VALUES(
        'user5',
        'prenomsUser5,',
        '1990-01-31',
        'M',
        7
    );

INSERT
    INTO
        groupe(
            nomg,
            description
        )
    VALUES(
        'groupeA',
        'groupe de personne de la familleA '
    );

INSERT
    INTO
        groupe(
            nomg,
            description
        )
    VALUES(
        'groupeB',
        'groupe de personne de la familleB '
    );

INSERT
    INTO
        groupe(
            nomg,
            description
        )
    VALUES(
        'groupeC',
        'groupe de personne de la familleC'
    );

INSERT
    INTO
        groupe(
            nomg,
            description
        )
    VALUES(
        'groupeD',
        'groupe de personne de la familleD'
    );

INSERT
    INTO
        groupe(
            nomg,
            description
        )
    VALUES(
        'groupeE',
        'groupe de personne de la familleE'
    );

INSERT
    INTO
        groupe(
            nomg,
            description
        )
    VALUES(
        'groupeF',
        'groupe de personne de la familleF'
    );

INSERT
    INTO
        personne_groupe(
            personne_id,
            groupe_id
        )
    VALUES(
        5,
        1
    );

INSERT
    INTO
        personne_groupe(
            personne_id,
            groupe_id
        )
    VALUES(
        5,
        2
    );

INSERT
    INTO
        personne_groupe(
            personne_id,
            groupe_id
        )
    VALUES(
        2,
        3
    );

INSERT
    INTO
        personne_groupe(
            personne_id,
            groupe_id
        )
    VALUES(
        2,
        1
    );

INSERT
    INTO
        personne_groupe(
            personne_id,
            groupe_id
        )
    VALUES(
        3,
        1
    );

INSERT
    INTO
        personne_groupe(
            personne_id,
            groupe_id
        )
    VALUES(
        3,
        2
    );

INSERT
    INTO
        personne_groupe(
            personne_id,
            groupe_id
        )
    VALUES(
        4,
        2
    );

INSERT
    INTO
        personne_groupe(
            personne_id,
            groupe_id
        )
    VALUES(
        4,
        3
    );

INSERT
    INTO
        personne_groupe(
            personne_id,
            groupe_id
        )
    VALUES(
        1,
        3
    );

INSERT
    INTO
        personne_groupe(
            personne_id,
            groupe_id
        )
    VALUES(
        1,
        5
    );