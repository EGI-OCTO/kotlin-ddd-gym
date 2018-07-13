package administration.de.formules.usecases

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CréerUneFormuleMensuelleTest {
    @Test
    fun `Créer une formule mensuelle renvoie le bon événement`() {
        // given
        val commande = CréerUneFormuleMensuelleCommande()
        val usecaseTesté = CréerUneFormuleMensuelle()

        //when
        val évènement = usecaseTesté.execute(commande)

        //then
        assertThat(évènement).isEqualToComparingFieldByField(FormuleMensuelleCréée())
    }
}