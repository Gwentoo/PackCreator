package pack

class Pack(val map: Map<String, Any>){

    fun getPackAuthor():String{
        return map["Author"] as String
    }

    fun getPackDesk():String{
        return map["Desc"] as String
    }

    fun getPackPreview():String{
        return map["Preview"] as String
    }

    fun getPackName():String{
        return map["PackName"] as String
    }

    fun getRoundCount():Int{
        return map["Rounds"] as Int
    }

    fun getRoundNames():MutableList<String>{
        val roundsList = mutableListOf<String>()
        for (i in 1 .. getRoundCount()){
            val newValue = (map["round${i}"] as Map<*, *>)
                .get("NameRound") as String
            roundsList.add(newValue)
        }
        return roundsList
    }

    fun getThemesCount():MutableList<Int>{
        val themeCount = mutableListOf<Int>()
        for (i in 1 .. getRoundCount()){
            val newValue = (map["round${i}"] as Map<*, *>)
                .get("ThemeCount") as Int
            themeCount.add(newValue)
        }
        return themeCount
    }

    fun getNamesThemeOfRound(round: Int):MutableList<String>{
        val themesList = mutableListOf<String>()
        val themesCount = getThemesCount()
        for (i in 1..themesCount[round-1]){
            val newValue = (map["round${round}"] as Map<*, *>)
                .get("Theme${i}")
                .let{theme -> (theme as Map<*, *>)
                    .get("ThemeName") as String}
            themesList.add(newValue)
        }
        return themesList
    }

    fun getQuestCountOfTheme(round: Int, theme: Int):Int{
        val count = (map["round${round}"] as Map<*, *>)
            .get("Theme${theme}")
            .let{th -> (th as Map<*, *>)
                .get("QuestCount") as Int}

        return count
    }

    fun getQuestionPrice(round: Int, theme: Int, quest: Int):Int{
        val price = (map["round${round}"] as Map<*, *>)
            .get("Theme${theme}")
            .let{th -> (th as Map<*, *>)
                .get("Questions") as Map<*,  *>}
            .get("Quest${quest}")
            .let{qu -> (qu as  Map<*,  *>)
                .get("Price") as Int}

        return price
    }

    fun getQuestionAnswer(round: Int, theme: Int, quest: Int):String{
        val answer = (map["round${round}"] as Map<*, *>)
            .get("Theme${theme}")
            .let{th -> (th as Map<*, *>)
                .get("Questions") as Map<*,  *>}
            .get("Quest${quest}")
            .let{qu -> (qu as  Map<*,  *>)
                .get("Answer").toString()}

        return answer
    }

    fun getQuest(round: Int, theme: Int, quest: Int): MutableList<String>{
        val questList = mutableListOf<String>()
            val Quest = (map["round${round}"] as Map<*, *>)
                .get("Theme${theme}")
                .let{th -> (th as Map<*, *>)
                    .get("Questions") as Map<*,  *>}
                .get("Quest${quest}")
                .let{qu -> (qu as  Map<*,  *>)
                    .get("Quest") as Map<*, *>}
        for  (key in Quest.keys){
            questList.add(Quest[key.toString()].toString())
        }

        return questList
    }

}