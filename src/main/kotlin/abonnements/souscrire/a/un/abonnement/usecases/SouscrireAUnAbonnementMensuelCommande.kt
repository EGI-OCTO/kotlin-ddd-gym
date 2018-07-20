package abonnements.souscrire.a.un.abonnement.usecases

import administration.de.formules.domain.FormuleId

data class SouscrireAUnAbonnementMensuelCommande(val formuleId: FormuleId, val abonnéId: AbonnéId)
data class AbonnéId(val id : String)