# Microservicios con Spring Boot y Spring Cloud

Este proyecto implementa un conjunto de microservicios desarrollados en Java utilizando Spring Boot y Spring Cloud. Cada microservicio cumple un rol específico y se conecta a través de herramientas como Eureka, OAuth2 y un Gateway. El objetivo principal es mostrar una arquitectura basada en microservicios, altamente escalable, modular y desacoplada.

---

## Arquitectura del Proyecto

La arquitectura consta de los siguientes componentes:

1. **Config Server**: Servidor centralizado de configuración.
2. **Eureka Server**: Servidor de descubrimiento de servicios.
3. **Gateway Server**: Servidor para enrutar peticiones a los microservicios.
4. **OAuth2 Server**: Servidor de autenticación y autorización con OAuth2.
5. **Microservicios de dominio**:
   - Usuarios
   - Ítems
   - Productos
6. **Docker Compose**: Orquestador para el despliegue local.

---

## Descripción de los Repositorios

Cada componente del proyecto está alojado en un repositorio independiente:

### 1. [Docker Compose](https://github.com/MarioQuirosLuna/microservicio-docker-compose)

Contiene el archivo `docker-compose.yml` y configuraciones relacionadas para desplegar todos los servicios en contenedores Docker.

### 2. [Config Server](https://github.com/MarioQuirosLuna/microservicio-config-server)

- Implementa un servidor de configuración centralizado usando Spring Cloud Config.
- Las configuraciones se obtienen desde el repositorio [microservicio-config-files](https://github.com/MarioQuirosLuna/microservicio-config-files).

### 3. [Eureka Server](https://github.com/MarioQuirosLuna/microservicio-eureka-server)

- Servidor de registro y descubrimiento de servicios basado en Netflix Eureka.
- Permite que los microservicios se registren dinámicamente y se descubran entre sí.

### 4. [Gateway Server](https://github.com/MarioQuirosLuna/microservicio-gateway-server)

- Implementa un API Gateway con Spring Cloud Gateway.
- Se encarga de enrutar las peticiones hacia los diferentes microservicios y aplicar reglas de seguridad.

### 5. [Auth2 Server](https://github.com/MarioQuirosLuna/microservicio-oauth)

- Servidor de autenticación y autorización.
- Implementa OAuth2 para gestionar accesos seguros a los microservicios.

### 6. [Microservicio Usuarios](https://github.com/MarioQuirosLuna/microservicio-users)

- Gestiona la información de los usuarios.
- Incluye endpoints para operaciones CRUD.

### 7. [Microservicio Items](https://github.com/MarioQuirosLuna/microservicio-item)

- Gestiona la información de ítems.
- Se conecta al microservicio de productos para obtener detalles adicionales.

### 8. [Microservicio Productos](https://github.com/MarioQuirosLuna/microservicio-product)

- Gestiona la información de productos.
- Incluye operaciones CRUD.

### 9. [Libs Commons](https://github.com/MarioQuirosLuna/microservicio-libs-commons)

- Biblioteca de código reutilizable para los microservicios.
- Contiene clases comunes como modelos y utilidades.

### 10. [Repo Config Files](https://github.com/MarioQuirosLuna/microservicio-config-files)

- Repositorio centralizado que almacena los archivos de configuración utilizados por el Config Server.

---

## Características Principales

- **Desacoplamiento**: Cada microservicio es independiente y cumple un rol específico.
- **Escalabilidad**: Arquitectura basada en Eureka para escalar servicios según la demanda.
- **Seguridad**: Integración de OAuth2 para gestionar la autenticación y autorización.
- **Configuración Centralizada**: Uso de Spring Cloud Config para mantener configuraciones en un solo lugar.
- **Despliegue con Docker**: Los servicios pueden ejecutarse fácilmente en contenedores Docker con Docker Compose.

---

## Requisitos

1. **Java** 21.
2. **Maven** 3.8 o superior.
3. **Docker** y **Docker Compose** instalados.
4. **Postman** (opcional) para probar los servicios.

---

## Instalación y Ejecución

1. Clona cada repositorio de este proyecto.
2. Levanta una base de datos Oracle SQL por medio de docker.
3. Configura las variables de entorno en el archivo `application.properties` o `application.yml` según corresponda.
4. Navega al repositorio `microservicio-docker-compose` y ejecuta:

```bash
$ sudo docker-compose up --build
```

5. Accede a los siguientes servicios:

   - **Eureka Dashboard**: [http://localhost:8761](http://localhost:8761)
   - **Gateway Server**: [http://localhost:8080](http://localhost:8080)

---

## Recursos Adicionales

- [Curso en Udemy](https://www.udemy.com/course/microservicios-con-spring-boot-y-spring-cloud/learn/lecture/47816541?start=1#overview)
- [Documentación de Spring Cloud](https://spring.io/projects/spring-cloud)
- [Documentación de Docker](https://docs.docker.com/)

