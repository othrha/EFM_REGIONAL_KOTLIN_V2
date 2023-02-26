package partie_pratique_1

class exercice1 {


    fun String.estVideOuBlanche(){
        if (isEmpty()){ println("is empty") }
        if(isBlank()) { println("is blank") }
    }

    fun String.sigle(): String {
        val mots= this.split(" ").filter { it.isNotBlank() }
        val sigle = StringBuilder()
        for (mo in mots) {
            sigle.append(mo[0].toUpperCase())
        }
        return sigle.toString()
    }

}