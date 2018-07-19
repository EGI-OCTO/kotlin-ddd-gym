package administration.de.formules.usecases.creer.une.formule

import administration.de.formules.domain.Formule
import administration.de.formules.domain.FormuleRepository
import java.math.BigDecimal

class CréerUneFormuleMensuelle constructor(private val formuleRepository: FormuleRepository) {
    fun execute(commande: CréerUneFormuleMensuelleCommande): FormuleMensuelleCréée {
        val formule = Formule(commande.id, BigDecimal(10))
        formuleRepository.enregistrerFormule(formule)
        return FormuleMensuelleCréée()
    }

}