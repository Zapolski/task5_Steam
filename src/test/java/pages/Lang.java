package pages;

public class Lang {
    private Language lang;
    private String value;

    public Lang(Language lang, String value) {
        this.lang = lang;
        this.value = value;
    }

    public Language getLang() {
        return lang;
    }

    public String getValue() {
        return value;
    }
}
