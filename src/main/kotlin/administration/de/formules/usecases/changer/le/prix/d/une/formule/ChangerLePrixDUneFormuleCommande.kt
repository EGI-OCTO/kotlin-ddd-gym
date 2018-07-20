package administration.de.formules.usecases.changer.le.prix.d.une.formule

import administration.de.formules.domain.FormuleId
import java.math.BigDecimal

data class ChangerLePrixDUneFormuleCommande(val formuleId: FormuleId, val nouveauPrix: BigDecimal)
