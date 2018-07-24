package administration.de.formules.domain

import java.math.BigDecimal

class Formule(val id: FormuleId, var prix : Prix)
data class FormuleId(val id : String)
data class Prix(val montant : Double) {
    fun avecRéduction(pourcentageDeRéduction: Double): Prix {
        val reduction = BigDecimal(1 - pourcentageDeRéduction)
        return Prix(
                montant * (1 - pourcentageDeRéduction)
        )
    }
}