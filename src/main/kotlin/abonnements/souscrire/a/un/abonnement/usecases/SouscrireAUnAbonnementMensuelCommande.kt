package abonnements.souscrire.a.un.abonnement.usecases

import abonnements.souscrire.a.un.abonnement.domain.AbonnéId
import administration.de.formules.domain.FormuleId

data class SouscrireAUnAbonnementMensuelCommande(val formuleId: FormuleId, val abonnéId: AbonnéId)
