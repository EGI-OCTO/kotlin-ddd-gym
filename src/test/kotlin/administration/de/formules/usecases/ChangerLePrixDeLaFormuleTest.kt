package administration.de.formules.usecases

import administration.de.formules.domain.FormuleId
import administration.de.formules.domain.Prix
import administration.de.formules.infrastructure.FormuleHardCodedRepository
import administration.de.formules.usecases.changer.le.prix.d.une.formule.ChangerLePrixDUneFormule
import administration.de.formules.usecases.changer.le.prix.d.une.formule.ChangerLePrixDUneFormuleCommande
import administration.de.formules.usecases.creer.une.formule.CréerUneFormuleMensuelle
import administration.de.formules.usecases.creer.une.formule.CréerUneFormuleMensuelleCommande
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChangerLePrixDeLaFormuleTest {
    @Test
    fun `Changer le prix d'une formule`() {
        // given
        val formuleId = FormuleId("1234-5678")
        val repository = FormuleHardCodedRepository()
        val créactionCommande = CréerUneFormuleMensuelleCommande(formuleId, Prix(10.00))
        val créationFormule = CréerUneFormuleMensuelle(repository)
        créationFormule.execute(créactionCommande)

        val nouveauPrix = Prix(50.00)
        val commande = ChangerLePrixDUneFormuleCommande(formuleId, nouveauPrix)
        val usecaseTesté = ChangerLePrixDUneFormule(repository)

        //when
        usecaseTesté.execute(commande)

        //then
        val formule = repository.trouverParId(formuleId)
        assertThat(formule.prix).isEqualTo(nouveauPrix)
    }
}
