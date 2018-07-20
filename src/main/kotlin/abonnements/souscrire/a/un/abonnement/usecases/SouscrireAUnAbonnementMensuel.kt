package abonnements.souscrire.a.un.abonnement.usecases

import abonnements.souscrire.a.un.abonnement.domain.Abonnement
import abonnements.souscrire.a.un.abonnement.domain.AbonnementId
import abonnements.souscrire.a.un.abonnement.domain.AbonnementRepository
import abonnements.souscrire.a.un.abonnement.infrastructure.AbonnementHardCodedRepository
import administration.de.formules.domain.FormuleRepository
import java.util.*

class SouscrireAUnAbonnementMensuel constructor(private val formuleRepository: FormuleRepository, private val abonnementRepository: AbonnementRepository) {
    fun execute(commande: SouscrireAUnAbonnementMensuelCommande): AbonnementMensuelSouscrit {

        val formule = formuleRepository.trouverParId(commande.formuleId)

        val abonnementId = AbonnementId(UUID.randomUUID().toString())
        val abonnement = Abonnement(abonnementId, commande.abonnéId, formule.prix)
        abonnementRepository.enregistrerAbonnement(abonnement)

        return AbonnementMensuelSouscrit(abonnementId)
    }
}