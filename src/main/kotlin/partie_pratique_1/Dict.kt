package partie_pratique_1

class Dictionnaire {


        var Dic = ArrayList<Ent>()


        fun nombresEntrées():Int{
            return Dic.size

        }

        fun ajouter(e:Ent){
            if (Dic.contains(e)){
                throw Exception("already exist")
            }else Dic.add(e)
        }

        fun supprimer(e:Ent):Boolean{
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
                if (di.motAnglais==motAnglais){
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
                if (di.motFrancais == motFrancais) {
                    motsAnglais.add(di.motAnglais)
                }
            }
            return motsAnglais
        }

        fun motsFrancais(): Set<String> {
            return Dic.map { it.motFrancais }.toSet()
        }
        fun dictionnaireFrAn():HashMap<String,ArrayList<String>>{
            val dictionnaire = HashMap<String, ArrayList<String>>()
            for (di in Dic) {
                val motsAnglais = dictionnaire.getOrDefault(di.motFrancais, ArrayList())
                motsAnglais.add(di.motAnglais)
                dictionnaire[di.motFrancais] = motsAnglais
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



    

