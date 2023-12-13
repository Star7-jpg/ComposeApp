package com.example.composeapp.ui

import androidx.lifecycle.ViewModel

class FactsViewModel : ViewModel() {

    fun generateRandomsFacts(selectedAnimal : String) : String {
        return  if (selectedAnimal == "Dog") {
            getDogFacts().random()
        } else {
            getCatFacts().random()
        }
    }

    fun getDogFacts(): List<String> {
        val dogFacts = listOf(
            "Su domesticación comenzó en el Paleolítico Superior.",
            "Es la especie animal con mayor diversidad racial.",
            "Crean sociedades democráticas.",
            "Sus aptitudes para el trabajo son múltiples y muy diversas.",
            "No son carnívoros estrictos.",
            "Son animales muy voraces.",
            "Tienen “dientes de leche”.",
            "Sus sentidos difieren de los del ser humano.",
            "Son capaces de diagnosticar enfermedades con el olfato.",
            "Agradecen las caricias."
        )
        return dogFacts
    }

    fun getCatFacts(): List<String> {
        val catFacts = listOf(
            "La leche no es el mejor alimento para los gatos.",
            "Los gatos no perciben los sabores dulces.",
            "Emiten muchos sonidos para comunicarse.",
            "Su lenguaje es principalmente corporal.",
            "Tienen más huesos que los humanos.",
            "Pueden introducirse en huecos imposibles.",
            "Newton podría haber creado la primera puerta gatera.",
            "Los gatos también tienen récords mundiales.",
            "La nariz es la huella dactilar de los gatos.",
            "Sus bigotes funcionan como mecanoreceptores."
        )
        return catFacts
    }
}