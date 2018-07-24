package abonnements.souscrire.a.un.abonnement.infrastructure

import abonnements.souscrire.a.un.abonnement.domain.Abonné
import abonnements.souscrire.a.un.abonnement.domain.AbonnéId

class AbonnéHardCodedRepository {
    private val abonnés = HashMap<String, Abonné>()

    fun trouverParId(abonnéId: AbonnéId): Abonné {
        return abonnés[abonnéId.id] ?: throw AbonnéNonTrouvéException()
    }

    fun enregistrerAbonné(abonné: Abonné) {
        abonnés[abonné.id.id] = abonné
    }

}

class AbonnéNonTrouvéException : RuntimeException()
