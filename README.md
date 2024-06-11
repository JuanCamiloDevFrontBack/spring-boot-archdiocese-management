# Proyecto en Java V.17 - Spring Boot V.3.3.0
# Temática: Administración de Usuarios
## Estado del Proyecto: En Desarrollo

Este repositorio contiene un proyecto práctico sobre Java V.17 y Spring Boot V.3.3.0,
que permite efectuar acciones de tipo `CRUD` sobre la información a manipular
utilizando la arquitectura de microservicio, complementada con una base de datos en postgresSQL
que almacena y gestiona toda la información de los usuarios.
Este proyecto se divide en 4 ramas `main`, `develop`, `database-postgres`, `collections-test` y `deploy-render`.

Los perfiles siguen en implementación:
[//]: <> (Adicionalmente el proyecto cuenta con 2 ambientes, el de `Producción` y `Desarrollo`.)

## Estructura del Proyecto

La estructura del proyecto se diseño teniendo en consideración las mejores prácticas de organización de un proyecto Java con Spring y Spring Boot, quedando su estructura de la siguiente manera:
* src
    * main/java/com/example/microservice_archdiocese_management
        * exception
        * modules
            * module-xyz
                * restcontroller
                * dao
                * dto
                * entity
                * service
        * utils
    * resource

## Url API con sus Endpoints

La `API` proporciona las siguintes direcciones a acceder por el cliente para retornar la información:

* `GET: http://localhost:9091/archdiocese-management/features`
* `GET: http://localhost:9091/archdiocese-management/features/list-parishes`
* `GET: http://localhost:9091/archdiocese-management/features/list-priests`

* `POST: http://localhost:9091/archdiocese-management/features/add-parishes`
* `POST: http://localhost:9091/archdiocese-management/features/add-priests`

* `PATCH: http://localhost:9091/archdiocese-management/features/update-parishes`
* `PATCH: http://localhost:9091/archdiocese-management/features/update-priests`

* `DELETE: http://localhost:9091/archdiocese-management/features/delete-parishes/{id}`
* `DELETE: http://localhost:9091/archdiocese-management/features/delete-parishes/{id}`

Nota:
1- Al probar en despliegue se reemplaza el `http://localhost:9091/` por `https://spring-boot-archdiocese-management.onrender.com/`.
2- La base de datos esta activa por tiempo muy limitado, por ello es posible que si se consulta en producción no este funcionando.

## Tecnologías Utilizadas

Se utilizan las siguientes herramientas:
* Java V.17
* Spring
    * Spring Boot V.3.3.0
    * Spring Web 
    * Lombok
    * JDCB POSTGRES
    * JPA
    * Developer Tools
    * JUnit
    * mockito
* Maven V.3.8.6
* PostgresSQL V16.3

## Ramas

### `main`

La rama `main` se utiliza solo para proporcionar información básica del repositorio,
en este caso el archivo `README`.

### `develop`

En la rama `develop` encontrarás el proyecto de Java con Spring -  Spring Boot, el cual gestiona usuarios. Incluye la creación de menús para las pantallas a las que pueden acceder,
así como otras funcionalidades como la creación de usuarios, asignación de permisos y la actualización de su información de contacto, entre otras.

Cabe mencionar que el proyecto ya tiene configurado 2 ambientes, correspondientes a `application-prod.properties`(si se despliega a producción tomaría este archivo) y
`application-dev.properties`(al desplegarlo en modo desarrollo toma este archivo).

### `database-postgres`

En la rama `database-postgres` encontrarás el script de mariadb, el cual contiene la base de datos exportada
en phpmyAdmin que gestiona la información de los usuarios.

### `collections-test`

En la rama `collections-test` encontrarás las colecciones de Postman o Insomnia, donde se valido el funcionamiento del microservicio RestFullAPI.

## Instrucciones de Ejecución

### Rama Develop

Para poner en ejecución el proyecto de la presente rama se requieren los siguientes items:
* Git instalado para clonar el repositorio remoto en la máquina local.
* Java JDK instalado para correrlo en la máquina local.
* Maven instalado para la administración del proyecto y sus dependencias.
* Xampp instalado, porque ya trae mariadb al instalarlo, pero si gusta puede descargar mariadb sin utilizar xampp.
* Editor de código ó IDE instalado, en este caso se utilizó Suit Tools 4, pero puede utilizar otro, por ejemplo IntelliJ.
* Clonar el repositorio: `https://github.com/JuanCamiloDevFrontBack/user-management.git`.
* Postman instalado para probar el microservicio, sin embargo puede utilizar el de su preferencia o bien utilizar como alternativa `Insomnia`.

### Pasos para Poner en Ejecución la Aplicación

Ejecutar los siguientes comandos:
1. `git clone https://github.com/JuanCamiloDevFrontBack/user-management.git`.
2. Importar el script que esta en la rama `database-mariadb` en `PhpMyAdmin`.
3. Ejecutar la base de datos de forma local importada en el paso # 2.
4. `mvn clean install` ó desde el propio IDE o edItor de código.
5. Poner en ejecución el proyecto del repositorio: `https://github.com/JuanCamiloDevFrontBack/user-management.git`.
7. Abrir en postman o el navegador la siguiente url: `GET: http://localhost:9091/autodidact/login/welcome-msg`.