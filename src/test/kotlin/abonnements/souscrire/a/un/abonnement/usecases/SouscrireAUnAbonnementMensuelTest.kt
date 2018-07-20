package abonnements.souscrire.a.un.abonnement.usecases

import abonnements.souscrire.a.un.abonnement.infrastructure.AbonnementHardCodedRepository
import administration.de.formules.domain.Formule
import administration.de.formules.domain.FormuleId
import administration.de.formules.infrastructure.FormuleHardCodedRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class SouscrireAUnAbonnementMensuelTest {
    // TODO injection des repo en se basant sur les interfaces dans SouscrireAUnAbonnementMensuel
    // TODO Revoir l'utilisation des UUID (methode statiques fromUUID, idGenerators  en interface + implem UUID)

    @Test
    fun `Je peux souscrire à un abonnement mensuel`() {
        // given
        val formuleRepository = FormuleHardCodedRepository()
        val abonnementRepository = AbonnementHardCodedRepository()
        val usecaseTesté = SouscrireAUnAbonnementMensuel(formuleRepository, abonnementRepository)
        val formuleId = FormuleId("123-456")
        val abonnéId = AbonnéId("789-1023")
        var formule = Formule(formuleId, BigDecimal(60))
        formuleRepository.enregistrerFormule(formule)
        val commande = SouscrireAUnAbonnementMensuelCommande(formuleId, abonnéId)

        // when
        val évènement = usecaseTesté.execute(commande)

        // then
        val abonnement = abonnementRepository.trouverParId(évènement.abonnementId)
        assertThat(abonnement.prix).isEqualTo("60")
    }
}