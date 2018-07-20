package abonnements.souscrire.a.un.abonnement.infrastructure

import abonnements.souscrire.a.un.abonnement.domain.Abonnement
import abonnements.souscrire.a.un.abonnement.domain.AbonnementId

class AbonnementHardCodedRepository {
    private val abonnements = HashMap<String, Abonnement>()

    fun trouverParId(abonnementId: AbonnementId): Abonnement {
        return abonnements[abonnementId.id] ?: throw AbonnementNonTrouvéException()
    }

    fun enregistrerAbonnement(abonnement: Abonnement) {
        abonnements[abonnement.id.id] = abonnement
    }
}

class AbonnementNonTrouvéException : RuntimeException()
