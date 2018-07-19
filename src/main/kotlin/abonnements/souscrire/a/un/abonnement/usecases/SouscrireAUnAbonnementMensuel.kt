package abonnements.souscrire.a.un.abonnement.usecases

import abonnements.souscrire.a.un.abonnement.domain.Abonnement
import abonnements.souscrire.a.un.abonnement.infrastructure.AbonnementHardCodedRepository
import administration.de.formules.infrastructure.FormuleHardCodedRepository
import java.util.*

class SouscrireAUnAbonnementMensuel constructor(private val formuleRepository: FormuleHardCodedRepository, private val abonnementRepository: AbonnementHardCodedRepository) {
    fun execute(commande: SouscrireAUnAbonnementMensuelCommande): AbonnementMensuelSouscrit {

        val formule = formuleRepository.trouverParId(commande.formuleId)

        val abonnementId = UUID.randomUUID().toString()
        val abonnement = Abonnement(abonnementId, formule.prix)
        abonnementRepository.enregistrerAbonnement(abonnement)

        return AbonnementMensuelSouscrit(abonnementId)
    }
}