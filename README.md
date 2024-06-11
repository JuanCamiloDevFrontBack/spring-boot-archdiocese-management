# Proyecto en Java V.17 - Spring Boot V.3.2.0
# Temática: User Management
## Estado del Proyecto: En Desarrollo

Este repositorio contiene un proyecto práctico sobre Java V.17 y Spring Boot V.3.2.0,
que permite efectuar acciones de tipo `CRUD` sobre la información a manipular
utilizando la arquitectura de microservicio, complementada con una base de datos en mariadb
que almacena y gestiona toda la información de los usuarios.
Este proyecto se divide en 4 ramas `main`, `develop`, `database-mariadb` y `collections-postman`.

[//]: <> (Adicionalmente el proyecto cuenta con 2 ambientes, el de `Producción` y `Desarrollo`.)

## Estructura del Proyecto

La estructura del proyecto se diseño teniendo en consideración las mejores prácticas de organización de un proyecto Java con Spring y Spring Boot, quedando su estructura de la siguiente manera:
* src
    * main/java/com/autodidact/usermanagement
        * exception
        * module
            * module-xyz
                * controller
                * dao
                * dto
                * entity
                * service
        * util
    * resource

## Url API con sus Endpoints

La `API` proporciona las siguintes direcciones a acceder por el cliente para retornar la información:
* `GET: http://localhost:9091/autodidact/login/welcome-msg`
* `POST: /url???`
* `POST: /url???`

## Tecnologías Utilizadas

Se utilizan las siguientes herramientas:
* Java V.17
* Spring
    * Spring Boot V.3.2.0
    * Spring Web 
    * Lombok
    * JDCB API
    * JPA
    * Developer Tools
    * JUnit
    * mockito
* Maven V.3.8.6
* MariaDB V10.4.28

## Ramas

### `main`

La rama `main` se utiliza solo para proporcionar información básica del repositorio,
en este caso el archivo `README`.

### `develop`

En la rama `develop` encontrarás el proyecto de Java con Spring -  Spring Boot, el cual gestiona usuarios. Incluye la creación de menús para las pantallas a las que pueden acceder,
así como otras funcionalidades como la creación de usuarios, asignación de permisos y la actualización de su información de contacto, entre otras.

Cabe mencionar que el proyecto ya tiene configurado 2 ambientes, correspondientes a `application-prod.properties`(si se despliega a producción tomaría este archivo) y
`application-dev.properties`(al desplegarlo en modo desarrollo toma este archivo).

### `database-mariadb`

En la rama `database-mariadb` encontrarás el script de mariadb, el cual contiene la base de datos exportada
en phpmyAdmin que gestiona la información de los usuarios.

### `collections-postman`

En la rama `collections-postman` encontrarás las colecciones de postman, donde se valido el funcionamiento del microservicio RestFullAPI.

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
