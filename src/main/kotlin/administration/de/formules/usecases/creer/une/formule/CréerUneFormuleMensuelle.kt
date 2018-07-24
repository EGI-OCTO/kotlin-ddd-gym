package administration.de.formules.usecases.creer.une.formule

import administration.de.formules.domain.Formule
import administration.de.formules.domain.FormuleRepository
import administration.de.formules.domain.Prix
import java.math.BigDecimal

class CréerUneFormuleMensuelle constructor(private val formuleRepository: FormuleRepository) {
    fun execute(commande: CréerUneFormuleMensuelleCommande): FormuleMensuelleCréée {
        val formule = Formule(commande.id, commande.prix)
        formuleRepository.enregistrerFormule(formule)
        return FormuleMensuelleCréée()
    }

}