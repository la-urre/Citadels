package com.montaury.citadelles.personnage;

import io.vavr.collection.List;

public class PersonnageAleatoirePrevu extends PersonnageAleatoire {
    public PersonnageAleatoirePrevu(List<Personnage> personnages) {
        this.personnages = personnages;
    }

    @Override
    public Personnage parmi(List<Personnage> personnages) {
        Personnage prevu;
        do {
            prevu = this.personnages.head();
            this.personnages = this.personnages.tail();
        }
        while (!personnages.contains(prevu));
        return prevu;
    }

    private List<Personnage> personnages;
}