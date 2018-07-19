package administration.de.formules.usecases.changer.le.prix.d.une.formule

import administration.de.formules.domain.FormuleRepository

class ChangerLePrixDUneFormule(private val repository: FormuleRepository) {
    fun execute(commande: ChangerLePrixDUneFormuleCommande): PrixDeLaFormuleModifié {
        val formule = repository.trouverParId(commande.formuleId)
        formule.prix = commande.nouveauPrix
        repository.enregistrerFormule(formule)
        return PrixDeLaFormuleModifié()
    }

}
