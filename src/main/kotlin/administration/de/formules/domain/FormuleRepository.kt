package administration.de.formules.domain

interface FormuleRepository {
    fun trouverParId(formuleId: String): Formule
    fun enregistrerFormule(formule: Formule)
}