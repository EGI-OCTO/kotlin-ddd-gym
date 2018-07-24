package abonnements.souscrire.a.un.abonnement.usecases

import abonnements.souscrire.a.un.abonnement.domain.Abonnement
import abonnements.souscrire.a.un.abonnement.domain.AbonnementId
import abonnements.souscrire.a.un.abonnement.domain.AbonnementRepository
import abonnements.souscrire.a.un.abonnement.infrastructure.AbonnéHardCodedRepository
import administration.de.formules.domain.FormuleRepository
import java.util.*

class SouscrireAUnAbonnementMensuel constructor(
        private val formuleRepository: FormuleRepository,
        private val abonnementRepository: AbonnementRepository,
        private val abonnéHardCodedRepository: AbonnéHardCodedRepository
) {
    fun execute(commande: SouscrireAUnAbonnementMensuelCommande): AbonnementMensuelSouscrit {

        val formule = formuleRepository.trouverParId(commande.formuleId)
        val abonné = abonnéHardCodedRepository.trouverParId(commande.abonnéId)
        val abonnementId = AbonnementId(UUID.randomUUID().toString())
        val abonnement = Abonnement(abonnementId, abonné, formule)
        abonnementRepository.enregistrerAbonnement(abonnement)

        return AbonnementMensuelSouscrit(abonnementId)
    }
}