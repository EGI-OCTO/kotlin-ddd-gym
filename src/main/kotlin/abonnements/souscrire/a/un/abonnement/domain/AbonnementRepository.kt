package abonnements.souscrire.a.un.abonnement.domain

interface AbonnementRepository {
    fun trouverParId(abonnementId: AbonnementId): Abonnement
    fun enregistrerAbonnement(abonnement: Abonnement)
}