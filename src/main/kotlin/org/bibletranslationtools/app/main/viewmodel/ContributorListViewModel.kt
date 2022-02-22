package org.bibletranslationtools.app.main.viewmodel

import javafx.beans.property.SimpleStringProperty
import org.bibletranslationtools.app.main.entity.Contributor
import org.bibletranslationtools.app.main.persistence.ContributorRepository
import tornadofx.*

class ContributorListViewModel: ViewModel() {
    private val contributorRepo: ContributorRepository = ContributorRepository()

    val nameInputProperty = SimpleStringProperty()
    val contributorList = observableListOf<Contributor>()

    init {
        contributorList.setAll(contributorRepo.getAll())
        contributorList.onChange {
            contributorRepo.setAll(contributorList)
        }
    }

    fun addContributor(contributor: Contributor) {
        contributorList.add(0, contributor)
    }
}