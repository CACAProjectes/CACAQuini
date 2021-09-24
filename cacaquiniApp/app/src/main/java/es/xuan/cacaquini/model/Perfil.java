package es.xuan.cacaquini.model;

public enum Perfil {
    ADMINISTRADOR("Administrador"),
    USUARI("Usuari");

    private String perfil;

    Perfil(String envPerfil) {
        this.perfil = envPerfil;
    }

    public String getPerfil() {
        return perfil;
    }
}
