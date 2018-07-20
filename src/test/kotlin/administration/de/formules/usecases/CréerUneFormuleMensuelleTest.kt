package administration.de.formules.usecases

import administration.de.formules.domain.FormuleId
import administration.de.formules.usecases.creer.une.formule.CréerUneFormuleMensuelleCommande
import administration.de.formules.infrastructure.FormuleHardCodedRepository
import administration.de.formules.usecases.creer.une.formule.CréerUneFormuleMensuelle
import administration.de.formules.usecases.creer.une.formule.FormuleMensuelleCréée
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CréerUneFormuleMensuelleTest {
    @Test
    fun `Je peux retrouver une formule par son identifiant`() {
        // given
        val formuleId = FormuleId("1234-567890")
        val commande = CréerUneFormuleMensuelleCommande(formuleId)
        val repository = FormuleHardCodedRepository()
        val usecaseTesté = CréerUneFormuleMensuelle(repository)
        usecaseTesté.execute(commande)

        //when
        val formule = repository.trouverParId(formuleId)

        //then
        assertThat(formule.id).isEqualTo(formuleId)
    }
}
