package dev.luanfernandes.biblioteca.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PathConstants {
    private static final String API = "/api";

    public static final String EMPRESTIMO_V1 = API + "/v1/emprestimos";
    public static final String EMPRESTIMO_ID = EMPRESTIMO_V1 + "/{id}";
    public static final String EMPRESTIMO_DEVOLVER = EMPRESTIMO_ID + "/devolver";

    public static final String FUNCIONARIO_V1 = API + "/v1/funcionarios";
    public static final String FUNCIONARIO_ID = FUNCIONARIO_V1 + "/{id}";

    public static final String LIVRO_V1 = API + "/v1/livros";
    public static final String LIVRO_ID = LIVRO_V1 + "/{id}";
    public static final String LIVRO_AUTOR = LIVRO_V1 + "/autor";

    public static final String USUARIO_V1 = API + "/v1/usuarios";
    public static final String USUARIO_ID = USUARIO_V1 + "/{id}";
}
