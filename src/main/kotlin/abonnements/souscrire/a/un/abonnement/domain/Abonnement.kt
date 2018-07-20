package abonnements.souscrire.a.un.abonnement.domain

import abonnements.souscrire.a.un.abonnement.usecases.AbonnéId
import java.math.BigDecimal

class Abonnement(val id : AbonnementId, val abonnéId : AbonnéId, val prix : BigDecimal)
data class AbonnementId(val id : String)
