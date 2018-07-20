package abonnements.souscrire.a.un.abonnement.infrastructure

import abonnements.souscrire.a.un.abonnement.domain.Abonnement
import abonnements.souscrire.a.un.abonnement.domain.AbonnementId
import abonnements.souscrire.a.un.abonnement.domain.AbonnementRepository

class AbonnementHardCodedRepository : AbonnementRepository {
    private val abonnements = HashMap<String, Abonnement>()

    override fun trouverParId(abonnementId: AbonnementId): Abonnement {
        return abonnements[abonnementId.id] ?: throw AbonnementNonTrouvéException()
    }

    override fun enregistrerAbonnement(abonnement: Abonnement) {
        abonnements[abonnement.id.id] = abonnement
    }
}

class AbonnementNonTrouvéException : RuntimeException()
