package administration.de.formules.domain

interface FormuleRepository {
    fun trouverParId(formuleId: FormuleId): Formule
    fun enregistrerFormule(formule: Formule)
}