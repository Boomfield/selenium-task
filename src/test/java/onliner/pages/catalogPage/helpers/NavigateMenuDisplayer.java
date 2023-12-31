package onliner.pages.catalogPage.helpers;

import onliner.interfaces.MenuDisplayer;

public enum NavigateMenuDisplayer implements MenuDisplayer {
    ELECTRONIC("Электроника");

    private final String displayName;

    NavigateMenuDisplayer(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
}
