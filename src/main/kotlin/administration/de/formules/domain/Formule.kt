package administration.de.formules.domain

import java.math.BigDecimal

class Formule(val id: FormuleId, var prix : BigDecimal)
data class FormuleId(val id : String)