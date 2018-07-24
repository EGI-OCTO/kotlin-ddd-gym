package abonnements.souscrire.a.un.abonnement.usecases

import abonnements.souscrire.a.un.abonnement.domain.AbonnéId
import abonnements.souscrire.a.un.abonnement.domain.Adulte
import abonnements.souscrire.a.un.abonnement.domain.Etudiant
import abonnements.souscrire.a.un.abonnement.infrastructure.AbonnementHardCodedRepository
import abonnements.souscrire.a.un.abonnement.infrastructure.AbonnéHardCodedRepository
import administration.de.formules.domain.Formule
import administration.de.formules.domain.FormuleId
import administration.de.formules.domain.Prix
import administration.de.formules.infrastructure.FormuleHardCodedRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class SouscrireAUnAbonnementMensuelTest {
    lateinit var usecaseTesté: SouscrireAUnAbonnementMensuel
    lateinit var formuleRepository: FormuleHardCodedRepository
    lateinit var abonnementRepository: AbonnementHardCodedRepository
    lateinit var abonnéRepository: AbonnéHardCodedRepository

    // TODO Poser un test : La modification d'une formule ne modifie pas le prix d'un abonnement retro-activement
    // TODO Revoir l'utilisation des UUID (methode statiques fromUUID, idGenerators  en interface + implem UUID)

    @BeforeEach
    fun setUp() {
        formuleRepository = FormuleHardCodedRepository()
        abonnementRepository = AbonnementHardCodedRepository()
        abonnéRepository = AbonnéHardCodedRepository()
        usecaseTesté = SouscrireAUnAbonnementMensuel(formuleRepository, abonnementRepository, abonnéRepository)
    }

    @Test
    fun `Je peux souscrire à un abonnement mensuel`() {
        // given

        val abonnéId = AbonnéId("789-1023")
        val formuleId = FormuleId("123-456")
        var formule = Formule(formuleId, Prix(60.00))
        formuleRepository.enregistrerFormule(formule)
        val abonné = Adulte(AbonnéId("1234-567"))
        abonnéRepository.enregistrerAbonné(abonné)
        val commande = SouscrireAUnAbonnementMensuelCommande(formuleId, abonnéId)

        // when
        val évènement = usecaseTesté.execute(commande)

        // then
        val abonnement = abonnementRepository.trouverParId(évènement.abonnementId)
        assertThat(abonnement.prix).isEqualTo(Prix(60.00))
    }

    @Test
    fun `Je beneficie de 20% de réduction sur un abonnement mensuel si je suis étudiant`() {
        // Given
        val prixAbonnement = 50.00
        val etudiant = Etudiant(AbonnéId("1234-567"))
        abonnéRepository.enregistrerAbonné(etudiant)
        val formuleId = FormuleId("123-456")
        var formule = Formule(formuleId, Prix(prixAbonnement))
        formuleRepository.enregistrerFormule(formule)
        val commande = SouscrireAUnAbonnementMensuelCommande(formuleId, etudiant.id)

        // When
        val évènement = usecaseTesté.execute(commande)

        // Then
        val abonnement = abonnementRepository.trouverParId(évènement.abonnementId)
        assertThat(abonnement.prix).isEqualTo(Prix(prixAbonnement * (1 - 0.2)))
    }

}