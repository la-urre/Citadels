package com.montaury.citadelles.tour.action;

import com.montaury.citadelles.*;
import com.montaury.citadelles.joueur.Joueur;
import com.montaury.citadelles.quartier.Carte;
import com.montaury.citadelles.tour.AssociationJoueurPersonnage;
import com.montaury.citadelles.tour.AssociationsDeTour;
import io.vavr.collection.Set;

public class ActionEchangerCartesAvecPioche implements Action {
    @Override
    public boolean estRéalisablePar(Joueur joueur, AssociationsDeTour associations, Pioche pioche) {
        return !joueur.main().estVide() && pioche.peutFournirCartes(1);
    }

    @Override
    public void réaliser(AssociationJoueurPersonnage associationJoueurPersonnage, AssociationsDeTour associations, Pioche pioche) {
        Set<Carte> cartesAEchanger = associationJoueurPersonnage.joueur().controlleur.choisirPlusieursParmi(associationJoueurPersonnage.joueur().main().cartes());
        associationJoueurPersonnage.joueur().main().retirer(cartesAEchanger);
        associationJoueurPersonnage.joueur().ajouterCartesALaMain(pioche.echangerCartes(cartesAEchanger.toList()));
    }
}