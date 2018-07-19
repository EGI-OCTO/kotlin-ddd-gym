package abonnements.souscrire.a.un.abonnement.infrastructure

import abonnements.souscrire.a.un.abonnement.domain.Abonnement

class AbonnementHardCodedRepository {
    private val abonnements = HashMap<String, Abonnement>()

    fun trouverParId(abonnementId: String): Abonnement {
        return abonnements[abonnementId] ?: throw AbonnementNonTrouvéException()
    }

    fun enregistrerAbonnement(abonnement: Abonnement) {
        abonnements[abonnement.id] = abonnement
    }
}

class AbonnementNonTrouvéException : RuntimeException()
