package pages.catalogPage.components.helpers;

public enum TelevisionCategory {
    TV("Телевизоры");

    private final String displayName;

    TelevisionCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
