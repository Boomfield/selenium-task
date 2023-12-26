package pages.catalogPage.helpers;

public enum NavigateMenu {
    ELECTRONIC("Электроника");

    private final String displayName;

    NavigateMenu(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
