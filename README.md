# Desafío Literalura
![badge literalura](https://github.com/user-attachments/assets/45790814-4e98-42c2-af57-d178a2a95d53)

Este es un desafío de Java Spring Boot que implementa una aplicación de consola para gestionar libros y autores en una base de datos PostgreSQL.

## Funcionalidades

La aplicación permite:
- **Buscar un libro por título**: Muestra la información detallada de un libro registrado.
- **Listar todos los libros registrados**: Proporciona una lista completa de los libros almacenados.
- **Listar todos los autores registrados**: Muestra información detallada de los autores, incluyendo los libros asociados.
- **Listar autores que vivieron en un año específico**: Filtra autores que estaban vivos en un año determinado.
- **Listar libros por idioma**: Muestra libros según el idioma especificado.

## Tecnologías Utilizadas

- **Java**: Lenguaje principal de desarrollo.
- **Spring Boot**: Framework utilizado para la configuración y desarrollo del backend.
- **PostgreSQL**: Sistema de base de datos relacional.
- **Maven**: Herramienta de gestión de dependencias y construcción del proyecto.

## Configuración del Proyecto

1. **Clonar el repositorio**:
   ```bash
   git clone <URL_del_repositorio>
   cd desafio-literalura
Configuración de la base de datos:

Asegúrate de tener una base de datos PostgreSQL llamada Biblioteca.
Utiliza el siguiente comando SQL para crearla si aún no existe:

```
        CREATE DATABASE Biblioteca;
```
**Editar el archivo application.properties: Actualiza las credenciales según tu entorno:**

Desde un IDE (como IntelliJ o Eclipse): Ejecuta la clase principal *ChallengeLiteraluraApplication*.

#### Uso de la Aplicación
Una vez que la aplicación esté en ejecución, se mostrará un menú de opciones en la consola. Usa el número correspondiente para navegar por las opciones disponibles.

- Ejemplo de Ejecución


    Menu de opciones:
    1- Buscar libro por titulo
    2- Listar libros registrados
    3- Listar autores registrados
    4- Listar autores vivos en un determinado año
    5- Listar libros por idioma
    0- Salir

- Elija la opción a través de su número:
    Buscar Libro por Título
1
Ingrese el nombre del libro que desea buscar
Don Quijote
El libro ya existe en la base de datos
--------- LIBRO ---------
Titulo: Don Quijote
Autor: Cervantes Saavedra, Miguel de
Idioma: Español
Numero de descargas: 12454
-------------------------
Requisitos Previos
- Java 17 o superior instalado.
- PostgreSQL 13 o superior configurado y en ejecución.
- Maven instalado para gestionar dependencias.


Propiedad intelectual de Alura Latam
| Repositorio hecho por Wuilliams González

Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

