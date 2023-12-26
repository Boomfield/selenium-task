package pages.components.helpers;

public enum HeaderMenu {
    CATALOG("Каталог");

    private final String displayName;

    HeaderMenu(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
