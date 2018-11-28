package pages;

public enum Language {
    RU("RUS"),
    ENG("ENG");

    private String value;
    Language(String value){
        this.value=value;
    }

    @Override
    public String toString() {
        return value;
    }
}
