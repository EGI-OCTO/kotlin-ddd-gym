package administration.de.formules.usecases.creer.une.formule

import administration.de.formules.domain.FormuleId
import administration.de.formules.domain.Prix

data class CréerUneFormuleMensuelleCommande(val id: FormuleId, val  prix: Prix)
