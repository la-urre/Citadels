package com.montaury.citadelles.action;

import com.montaury.citadelles.AssociationJoueurPersonnage;
import com.montaury.citadelles.Pioche;
import com.montaury.citadelles.TourDeJeu;
import com.montaury.citadelles.faux.FauxControlleur;
import com.montaury.citadelles.joueur.Joueur;
import com.montaury.citadelles.personnage.Personnage;
import org.junit.Test;

import static com.montaury.citadelles.CitésPredefinies.citéVide;
import static org.assertj.core.api.Assertions.assertThat;

public class ActionRecevoirUnePieceDevrait {
    @Test
    public void donner_une_piece_au_joueur() {
        Joueur joueur = new Joueur("Toto", 12, citéVide(), new FauxControlleur());
        ActionRecevoirUnePiece action = new ActionRecevoirUnePiece();

        action.réaliser(new AssociationJoueurPersonnage(joueur, Personnage.VOLEUR), new TourDeJeu(), Pioche.vide());

        assertThat(joueur.trésor().pieces()).isEqualTo(1);
    }

}