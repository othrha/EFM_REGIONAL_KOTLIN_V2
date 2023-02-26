package partie_pratique_1

class Dictionnaire {

        var Dic:MutableList<Entree> = mutableListOf()


        fun nombresEntrées():Int{
            return Dic.size

        }

        fun ajouter(e:Entree){
            if (Dic.contains(e)){
                throw Exception("already exist")
            }else Dic.add(e)
        }

        fun supprimer(e:Entree):Boolean{
            if(Dic.contains(e)) {
                Dic.remove(e)
                return true
            }else {
                throw Exception("doesn't exist")
                return false
            }
        }

        fun supprimer(motAnglais:String):Boolean{
            var etat:Boolean=false
            for (di in Dic){
                if (di.anglais==motAnglais){
                    Dic.remove(di)
                    etat=true
                }else {
                    throw Exception("doesn't exist")
                    etat=false
                } }
            return etat
        }

        fun frAn(motFrancais:String): MutableList<String> {
            val motsAnglais = mutableListOf<String>()
            for (di in Dic) {
                if (di.francais == motFrancais) {
                    motsAnglais.add(di.anglais)
                }
            }
            return motsAnglais
        }

        fun motsFrancais(): Set<String> {
            return Dic.map { it.francais }.toSet()
        }
        fun dictionnaireFrAn():HashMap<String,ArrayList<String>>{
            val dictionnaire = HashMap<String, ArrayList<String>>()
            for (di in Dic) {
                val motsAnglais = dictionnaire.getOrDefault(di.francais, ArrayList())
                motsAnglais.add(di.anglais)
                dictionnaire[di.francais] = motsAnglais
            }

            return dictionnaire
        }
        override fun toString():String{
            val str = StringBuilder()
            for (di in Dic) {
                str.append(di.toString())
                str.append("\n")
            }
            return str.toString()
        }
    }

