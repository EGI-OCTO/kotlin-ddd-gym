package administration.de.formules.usecases

class CréerUneFormuleMensuelle {
    fun execute(commande: CréerUneFormuleMensuelleCommande): FormuleMensuelleCréée {
        return FormuleMensuelleCréée()
    }

}