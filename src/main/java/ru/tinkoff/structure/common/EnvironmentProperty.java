package ru.tinkoff.structure.common;

public enum EnvironmentProperty {

    CASHTAN_STORIES,
    BASE_SITE_URL;

    public String readProperty() {
        return PropertiesController.getProperty(getPropertyName());
    }

    public String getPropertyName() {
        return name().toLowerCase().replaceAll("_", ".");
    }
}
