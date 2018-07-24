package abonnements.souscrire.a.un.abonnement.domain

import administration.de.formules.domain.Formule
import administration.de.formules.domain.Prix

class Abonnement(
        val id : AbonnementId,
        val abonné : Abonné,
        val formule : Formule
) {
    var prix: Prix = when(abonné) {
        is Etudiant -> {
            formule.prix.avecRéduction(0.2)
        }
        is Adulte -> {
            formule.prix
        }
    }

}
data class AbonnementId(val id : String)
