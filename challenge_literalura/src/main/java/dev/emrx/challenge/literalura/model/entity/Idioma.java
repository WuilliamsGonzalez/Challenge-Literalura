package dev.emrx.challenge.literalura.model.entity;

public enum Idioma {
    INGLES("en", "Inglés"),
    ESPANIOL("es", "Español"),
    FRANCES("fr", "Francés"),
    PORTUGUES("pt", "Portugués");

    private String abreviatura;
    private String nombre;

    Idioma(String abreviatura, String nombre) {
        this.abreviatura = abreviatura;
        this.nombre = nombre;
    }

    public static Idioma fromString(String text) {
        for (Idioma idioma : Idioma.values()) {
            if (idioma.abreviatura.equalsIgnoreCase(text)) {
                return idioma;
            }
        }
        throw new IllegalArgumentException("Ningún idioma encontrado: " + text);
    }

    public String getNombre() {
        return nombre;
    }

    public String mostrar() {
        return abreviatura + " - " + nombre;
    }

    @Override
    public String toString() {
        return abreviatura;
    }
}