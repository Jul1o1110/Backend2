# 🎓 Backend Portafolio - PrysmaPH (Guía Académica)

Este es el núcleo de servicios (Backend) para una plataforma de portafolio profesional. Ha sido desarrollado como un **Proyecto Académico** para demostrar la implementación de una arquitectura robusta, escalable y desacoplada utilizando el ecosistema de **Spring Boot**.

---

## 📘 Descripción General
La aplicación gestiona la persistencia y entrega de datos para cuatro pilares fundamentales de un portafolio: **Experiencia Laboral**, **Proyectos**, **Habilidades Técnicas** y un sistema de **Mensajería de Contacto**. 

El enfoque principal de este proyecto es el aprendizaje de la **Arquitectura Multicapa** y el uso de estándares de la industria para el desarrollo de APIs RESTful.

---

## 🛠️ Stack Tecnológico

| Tecnología | Rol | Descripción |
| :--- | :--- | :--- |
| **Java 17** | Lenguaje | Versión LTS que permite el uso de Records y mejoras en rendimiento. |
| **Spring Boot 3.2.5** | Framework | Base para la creación de microservicios y APIs. |
| **Maven** | Orquestador | Gestión de dependencias y ciclo de vida del proyecto. |
| **Spring Data JPA** | Persistencia | Abstracción de base de datos para evitar consultas SQL manuales. |
| **SQL Server** | Base de Datos | Motor relacional robusto para el almacenamiento persistente. |
| **Swagger (OpenAPI)** | Documentación | Interfaz interactiva para probar los endpoints en tiempo real. |
| **ModelMapper** | Mapper | Librería para transformar Entidades a DTOs de forma automática. |

---

## 📁 Estructura de Capas (Anatomía del Proyecto)

Para facilitar el aprendizaje, el código está organizado siguiendo la separación de responsabilidades:

1.  **Controller:** Puerta de entrada. Recibe peticiones HTTP y retorna respuestas JSON.
2.  **Service:** El cerebro. Contiene la lógica de negocio, validaciones y reglas del sistema.
3.  **Repository:** El puente. Se comunica directamente con SQL Server a través de JPA.
4.  **Entity / Model:** El corazón. Representa las tablas de la base de datos como objetos Java.
5.  **DTO (Data Transfer Object):** La máscara. Protege los datos sensibles y optimiza lo que se envía al cliente.

---

## 🔄 Flujo de una Petición (Data Flow)

Cuando un usuario interactúa con el Portafolio, la información viaja de la siguiente manera:



1.  **CLIENTE:** Envía solicitud HTTP (Ej: POST /proyecto).
2.  **CONTROLLER:** Valida la entrada y delega al Service.
3.  **SERVICE:** Aplica lógica de negocio y convierte DTO a Entidad.
4.  **REPOSITORY:** Traduce la acción a SQL (INSERT, UPDATE, etc.).
5.  **SQL SERVER:** Almacena el dato permanentemente.

---

## 🚀 Instalación y Configuración

### 1. Requisitos del Sistema
* **JDK 17** o superior.
* **Maven 3.8+**.
* Instancia de **SQL Server** activa.

### 2. Configuración de Base de Datos
Edita el archivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=NombreTuDB;encrypt=true;trustServerCertificate=true
spring.datasource.username=TuUsuario
spring.datasource.password=TuContraseña

# Hibernate: Crea las tablas automáticamente si no existen
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

git clone [https://github.com/Jul1o1110/Backend2.git](https://github.com/Jul1o1110/Backend2.git)
cd Backend2
mvn spring-boot:run

📖 Documentación de Endpoints (Swagger)
Accede a la consola interactiva aquí:

👉 URL: http://localhost:8080/swagger-ui/index.html

Experiencia: /experiencia

Proyectos: /proyecto

Habilidades: /habilidad

Mensajes: /mensaje

📚 Glosario Técnico Académico
API REST: Interfaz que permite que dos sistemas se comuniquen usando el protocolo HTTP.

Endpoint: Una URL específica donde la API recibe peticiones.

Inyección de Dependencias: Técnica donde Spring entrega los objetos necesarios a una clase automáticamente.

JPA (Java Persistence API): Estándar que permite manejar bases de datos como si fueran objetos de Java.

JSON: Formato de texto ligero usado para intercambiar datos entre el backend y el frontend.