package abonnements.souscrire.a.un.abonnement.domain

sealed class Abonné (val id : AbonnéId)
class Etudiant(id : AbonnéId) : Abonné(id)
class Adulte(id : AbonnéId) : Abonné(id)
data class AbonnéId(val id : String)