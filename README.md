# Prueba tecnica Backend Datacenter

Se contruyó una aplicación WEB en Java utilizando el framework SpringBoot y Gradle como gestor de dependencias.

## Funcionamiento 🔧
La aplicación expone  sus servicios por defecto en el puerto 3000, tomando como base la 
URL  dominio:3000/api/v1.

### Servicio de Role
1. dominio:3000/api/v1/role

Este endpoint permite agregar roles a la aplicación.
La aplicación cuando inicia carga el archivo data.sql a la base de datos con los 
valores iniciales de roles "SELLER" Y "ADMIN".
Solo podrá agregar roles quien posea un rol de administrador.


### Servicio Usuario
1. dominio:3000/api/v1/user

Este servicio permite realizar un CRUD completo sobre los usuarios. Al momento de crear un usuario se le puede asignar una lista de roles
que permitirá definir los recursos a los cuales podrá tener acceso el usuario.
Solo podrá agregar usuarios quien posea un rol de administrador.
2.  dominio:3000/api/v1/user/auth/login

Este endpoint permitirá autenticar un usuario enviando las credenciales mediante un basic athorization.
Si ésta es exitosa, la aplicación retornará un JWT para poder consumir los demas recursos según los roles que tenga el usuario.
El archivo data.sql inserta 5 usuarios iniciales a la base de datos.

| username        | password | roles        |
|-----------------|----------|--------------|
| pedro@gmail.com | 6145     | SELLER       |
| maria@gmail.com | 6145     | SELLER       |
| diana@gmail.com | 6145     | SELLER       |
| ana@gmail.com   | 6145     | SELLER ADMIN |
| juan@gmail.com  | 6145     | SELLER ADMIN |

### Servicio Operadores

1. dominio:3000/api/v1/operator

Este endpoint permite insertar y obterner los operadores en la base de datos.
El archivo data.sql carga inicialmente los solicitados en el ejercicio:
TIGO, MOVISTAR, COMCEL Y UFF.
 
La política de seguridad que se estableció los usuarios, tanto SELLER O ADMIN, podrán
obtener el listado de operadores, pero solo el ADMIN podrá insertar o eliminar operadores.

### Servicio Recarga

1. dominio:3000/api/v1/recharge

Este endpoint permite insertar y listar las recargas realizadas por los vendedores.
Como política de seguridad se estableció que solo los administradores podrán obtener el listado
de todas las recargas para ver las estadísticas.

En este enlace comparto la documentación.
https://documenter.getpostman.com/view/19057359/2s9YXk3M4x

En la imagen el diagrama de relación de la base de datos.
!["menu1"](/assets/db.png)

## Comenzando 🚀

## Despliegue 📦
Para correr localmente, esta aplicación debe contar con un 
JDK de **Java-17** o superiores. Además  debe correr localmente
**Docker** en el equipo, debido a que la aplicación configurará de forma automática
una base de datos  postgres-SQL.

## Configuración para prueba local ⚙️
Para ejecutar  localmente clonar el repositorio:
1. git clone https://github.com/asuridev/datacenter-backend.git
2. Abrir el directorio con el editor de preferencias y ejecutar.

**Nota** :
Cuando requiera correr la aplicación por segunda vez, en el archivo
application-dev.yml del directorio resources coloque el valor de la propiedad sql.init.mode en **never**
con el fin de que no intente crear y cargar los datos iniciales nuevamente a la base de datos.


