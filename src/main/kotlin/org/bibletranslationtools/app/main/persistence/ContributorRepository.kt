package org.bibletranslationtools.app.main.persistence

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.bibletranslationtools.app.main.entity.Contributor
import java.io.File

class ContributorRepository {

    fun getAll(): List<Contributor> {
        return jacksonObjectMapper().readValue(getResourceAsString())
    }

    fun add(contributor: Contributor) {
        val list = getAll().toMutableList()
        list.add(contributor)
        val json = jacksonObjectMapper().writeValueAsString(list)
        writeJsonToResource(json)
    }

    fun addAll(contributors: List<Contributor>) {
        val currentList = getAll()
        val json = jacksonObjectMapper().writeValueAsString(currentList + contributors)
        writeJsonToResource(json)
    }

    fun setAll(contributors: List<Contributor>) {
        val json = jacksonObjectMapper().writeValueAsString(contributors)
        writeJsonToResource(json)
    }

    private fun getResourceAsString(): String {
        val path = javaClass.classLoader.getResource("contributors.json").file
        return File(path).readText()
    }

    private fun writeJsonToResource(json: String) {
        val path = javaClass.classLoader.getResource("contributors.json").file
        File(path).writeText(json)
    }
}