Backend Portafolio - PrysmaPH
Este es el proyecto de backend para una plataforma de portafolio web, desarrollado como un proyecto académico. La aplicación gestiona información sobre experiencias laborales, habilidades, proyectos y mensajes de contacto.

Tecnologías Utilizadas
Java 17: Lenguaje principal de programación.

Spring Boot 3.2.5: Framework para la creación de la API REST.

Maven: Gestor de dependencias y construcción del proyecto.

Spring Data JPA: Para la persistencia de datos y manejo de la base de datos.

SQL Server: Motor de base de datos utilizado.

Swagger (OpenAPI): Documentación interactiva de los servicios.

ModelMapper: Para la conversión sencilla entre objetos (DTOs y Modelos).

Requisitos Previos
Tener instalado el JDK 17.

Tener instalado Maven.

Contar con una instancia de SQL Server activa.

Configuración e Instalación
Clonar el repositorio:

Bash

git clone https://github.com/Jul1o1110/Backend2.git
Configurar la Base de Datos: Ve al archivo src/main/resources/application.properties y ajusta las credenciales de tu SQL Server:

Properties

spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=TuBaseDeDatos
spring.datasource.username=TuUsuario
spring.datasource.password=TuContraseña
Ejecutar la aplicación: Puedes usar tu IDE preferido o la terminal:

Una vez que la aplicación esté corriendo, puedes interactuar con los servicios a través de Swagger UI.

URL de Swagger: http://localhost:8080/swagger-ui/index.html

Módulos Principales:
Experiencia: Permite crear, editar y listar trayectorias laborales (/experiencia).

Proyectos: Gestión de los trabajos realizados (/proyecto).

Habilidades: Administración de conocimientos técnicos (/habilidad).

Mensajes: Recepción de mensajes desde el formulario de contacto (/mensaje).

Estructura de Carpetas: Separamos la lógica en Controller (quien recibe la petición), Service (quien tiene la lógica) y Repository (quien habla con la base de datos).