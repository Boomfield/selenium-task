package onliner.pages.catalogPage.components.helpers;

import onliner.interfaces.MenuDisplayer;

public enum TelevisionSubMenuDisplayer implements MenuDisplayer {
    TV("Телевизоры");

    private final String displayName;

    TelevisionSubMenuDisplayer(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
}
