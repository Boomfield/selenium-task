package onliner.pages.components.helpers;

import onliner.interfaces.MenuDisplayer;

public enum HeaderMenuDisplayer implements MenuDisplayer {
    CATALOGUE("Каталог");

    private final String displayName;

    HeaderMenuDisplayer(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
}
