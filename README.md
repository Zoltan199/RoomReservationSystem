# My Spring Boot Vue App

Este proyecto es una aplicación full-stack que combina Spring Boot en el lado del servidor y Vue.js con Vuetify en el lado del cliente para la administración de habitaciones, clientes y reservaciones.

## Contenido

- [Requisitos](#requisitos)
- [Configuración del Proyecto](#configuración-del-proyecto)
- [Backend (Spring Boot)](#backend-spring-boot)
- [Frontend (Vue.js + Vuetify)](#frontend-vuejs--vuetify)
- [Ejecución del Proyecto](#ejecución-del-proyecto)

## Requisitos

- [Node.js](https://nodejs.org/) (para Vue.js)
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) (para Spring Boot)
- [Maven](https://maven.apache.org/)

## Configuración del Proyecto

1. **Backend (Spring Boot)**: Importa el proyecto en tu IDE favorito y configura las dependencias de Maven. Asegúrate de tener Java 17 instalado.

2. **Frontend (Vue.js + Vuetify)**: En la carpeta `src/main/resources/static/templates.public` estarán los archivos generados por Vue.js.


## Backend (Spring Boot)

- La capa de datos se simula utilizando archivos `.json`.
- Los servicios (`RoomService`, `ClientService`, `ReservationService`) manejan la lógica de negocio y la interacción con el archivo `data.json`.
- Los controladores (`RoomController`, `ClientController`, `ReservationController`) definen los endpoints REST para la administración de habitaciones, clientes y reservaciones.

## Frontend (Vue.js + Vuetify)

- Las vistas y componentes Vue.js se encuentran en el directorio `/resources/templates.public'
- Se utiliza Vuetify para el diseño y los componentes visuales.

## Ejecución del Proyecto

  **Backend (Spring Boot)**: Ejecuta la aplicación Spring Boot desde tu IDE o mediante Maven.



