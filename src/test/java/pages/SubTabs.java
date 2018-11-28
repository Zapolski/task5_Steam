package pages;

import java.util.HashMap;
import java.util.Map;

public enum SubTabs {

    ACTION(new Lang(Language.ENG,"Action"),new Lang(Language.RU,"Экшен"));


    private Map<Language,String> langMap = new HashMap<Language, String>();

    SubTabs(Lang... lang){
        for (Lang lg: lang){
            langMap.put(lg.getLang(),lg.getValue());
        }
    }

    public String getValue(Language lang){
        return langMap.get(lang);
    }

}
