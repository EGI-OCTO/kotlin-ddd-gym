package administration.de.formules.usecases.changer.le.prix.d.une.formule

import java.math.BigDecimal

data class ChangerLePrixDUneFormuleCommande(val formuleId: String, val nouveauPrix: BigDecimal)
