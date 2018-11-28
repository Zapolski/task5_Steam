package pages;

public enum Tabs {
    FORYOU("foryou_tab"),
    GENRE("genre_tab"),
    SOFTWARE("software_tab"),
    HARDWARE("hardware_tab"),
    VIDEOS("videos_tab");

    private String value;
    Tabs(final String values) {
        value = values;
    }
    public String toString() {
        return value;
    }
}
