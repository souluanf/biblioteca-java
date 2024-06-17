package dev.luanfernandes.biblioteca.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class OpenApiConfigConstants {
    public static final String OPENAPI_INFO_TITLE = "Biblioteca Java API";
    public static final String OPENAPI_INFO_VERSION = "0.0.1";
    public static final String OPENAPI_INFO_DESCRIPTION = "API para biclioteca";
    public static final String OPENAPI_CONTACT_NAME = "Luan Fernandes";
    public static final String OPENAPI_CONTACT_EMAIL = "contact@luanfernandes.dev";
    public static final String OPENAPI_CONTACT_URL = "https://luanfernandes.dev";
    public static final String OPENAPI_EXTERNAL_DOCS_DESCRIPTION = "Git repository";
    public static final String OPENAPI_EXTERNAL_DOCS_URL = "https://github.com/souluanf/biblioteca-java";

    public static final String OPENAPI_SERVERS_URLS = "${openapi-servers-urls}";
}
