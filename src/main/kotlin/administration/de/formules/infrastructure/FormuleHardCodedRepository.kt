package administration.de.formules.infrastructure

import administration.de.formules.domain.Formule
import administration.de.formules.domain.FormuleId
import administration.de.formules.domain.FormuleRepository

class FormuleHardCodedRepository : FormuleRepository {
    private val formules = HashMap<String, Formule>()

    override fun trouverParId(formuleId: FormuleId): Formule {
        return formules[formuleId.id] ?: throw FormuleNonTrouvéeException()
    }

    override fun enregistrerFormule(formule: Formule) {
        formules[formule.id.id] = formule
    }
}

class FormuleNonTrouvéeException : RuntimeException()
