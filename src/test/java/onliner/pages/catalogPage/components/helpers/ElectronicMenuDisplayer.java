package onliner.pages.catalogPage.components.helpers;

import onliner.interfaces.MenuDisplayer;

public enum ElectronicMenuDisplayer implements MenuDisplayer {
    TELEVISIONS("Телевидение");
    private final String displayName;

    ElectronicMenuDisplayer(String displayName) {
        this.displayName = displayName;
    }


    @Override
    public String getDisplayName() {
        return displayName;
    }
}
