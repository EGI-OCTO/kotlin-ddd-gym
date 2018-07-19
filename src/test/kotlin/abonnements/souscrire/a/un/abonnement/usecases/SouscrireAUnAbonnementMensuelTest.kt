package abonnements.souscrire.a.un.abonnement.usecases

import abonnements.souscrire.a.un.abonnement.infrastructure.AbonnementHardCodedRepository
import administration.de.formules.domain.Formule
import administration.de.formules.infrastructure.FormuleHardCodedRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class SouscrireAUnAbonnementMensuelTest {
    // TODO nommer le test
    // TODO tester cas non passant
    // TODO refacto ?
    // TODO injection des repo en se basant sur les interfaces dans SouscrireAUnAbonnementMensuel
    // TODO Utiliser les UUID dans formule, abonné aussi
    
    @Test
    fun `xxx`() {
        // given
        val formuleRepository = FormuleHardCodedRepository()
        val abonnementRepository = AbonnementHardCodedRepository()
        val usecaseTesté = SouscrireAUnAbonnementMensuel(formuleRepository, abonnementRepository)
        val formuleId = "123-456"
        val abonnéId = "789-1023"
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