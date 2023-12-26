package pages.catalogPage.components.helpers;

public enum ElectronicCategory {
    TELEVISIONS("Телевидение");
    private final String displayName;

    ElectronicCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
