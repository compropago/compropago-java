ComproPago API - Java SDK
=========================

[![Build Status](https://travis-ci.org/josebsx/compropago-php.svg?branch=master)](https://travis-ci.org/josebsx/compropago-java)

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/8d7881ac258ce680ffea#?env%5BComproPago%20API%5D=W3siZW5hYmxlZCI6dHJ1ZSwiZGVzY3JpcHRpb24iOnsiY29udGVudCI6IiIsInR5cGUiOiJ0ZXh0L3BsYWluIn0sInZhbHVlIjoiaHR0cHM6Ly9hcGkuY29tcHJvcGFnby5jb20iLCJrZXkiOiJob3N0In0seyJlbmFibGVkIjp0cnVlLCJkZXNjcmlwdGlvbiI6eyJjb250ZW50IjoiIiwidHlwZSI6InRleHQvcGxhaW4ifSwidmFsdWUiOiIiLCJrZXkiOiJwdWJsaWNfa2V5In0seyJlbmFibGVkIjp0cnVlLCJkZXNjcmlwdGlvbiI6eyJjb250ZW50IjoiIiwidHlwZSI6InRleHQvcGxhaW4ifSwidmFsdWUiOiIiLCJrZXkiOiJwcml2YXRlX2tleSJ9XQ==)

# Introducción

Con ComproPago puede recibir pagos vía SPEI y en efectivo.

La librería de ComproPago Java SDK le permite interactuar con el API de ComproPago en su aplicación. También cuenta con los métodos necesarios para facilitarle su desarrollo por medio de los servicios más utilizados.

# Índice de contenidos

- [Ayuda y soporte de ComproPago](#ayuda-y-soporte-de-compropago)
- [Requerimientos](#requerimientos)
- [Instalación](#instalación)
- [Guía básica de uso](#guía-básica-de-uso)
- [Métodos base del SDK](#métodos-base-del-sdk)
- [Enviar instrucciones por SMS](#enviar-instrucciones-por-sms)
- [Webhooks](#webhooks)

Ayuda y soporte de ComproPago
=============================

Puede obtener información acerca de nuestros servicios en alguno de los siguientes enlaces:
- [Centro de ayuda y soporte](https://compropago.com/ayuda-y-soporte)
- [Solicitar integración](https://compropago.com/integracion)
- [Guía para empezar a usar ComproPago](https://compropago.com/ayuda-y-soporte/como-comenzar-a-usar-compropago)
- [Información de contacto](https://compropago.com/contacto)

En caso de tener alguna pregunta o requerir el apoyo técnico, por favor contacte al correo: soporte@compropago.com y proporcionando la siguiente información:

- Nombre completo del propietario de la cuenta.
- URL del sitio web de la tienda.
- Teléfono local o celular.
- Correo electrónico del propietario de la cuenta.
- Texto detallado de la duda o requerimiento.
- En caso de presentar algún problema técnico, por favor enviar capturas de pantalla o evidencia para una respuesta más efectiva.

# Requerimientos

- [Java 1.8.x]()
- [Google Gson]()

# Instalación

Instalación via .jar
--------------------

Puedes descargar la última versión estable de el archivo .jar del SDK directamente desde el listado de versiones del repositorio o desde este [enlace](https://github.com/compropago/compropago-java/releases/latest). Posteriormente deberás incluirlo en tu proyecto.

Instalación por GitHub
----------------------

Puede descargar alguna de las versiones que hemos publicado aquí:
- [Versiones publicadas en GitHub](https://github.com/compropago/compropago-java/releases)

O si lo desea puede clonar nuestro repositorio de la siguiente forma:

```bash
# Repositorio en su estado actual (Puede ser una versión inestable)
git clone https://github.com/compropago/compropago-java.git
```

# Guía básica de uso

Se debe contar con una cuenta activa de ComproPago.

- [Registrarse en ComproPago](https://panel.compropago.com/users/sign_up)
- [Documentación detallada del SDK](http://demo.compropago.com/sdk/java)

Importación
-----------

Para poder hacer uso de la librería es necesario incluir las clases del archivo .jar

```java

```

Uso básico de la libreria
-------------------------

Para poder hacer uso del SDK y procesar las llamadas al API, es necesario que configurar sus llaves de conexión y crear un instancia de Cash o Spei. Sus llaves las encontrara en su Panel de ComproPago en el menú Configuración.

- [Consultar llaves de ComproPago](https://panel.compropago.com/panel/configuracion)

# Métodos base del SDK

Ordenes de pago mediante trasferencia (SPEI)
--------------------------------------------

### Crear una nueva orden de pago

### Verificar el estatus de la orden

Ordenes de pago en efectivo
---------------------------

### Listar proveedores para pago en efectivo

### Crear una nueva orden de pago en efectivo

### Verificar el estatus de la orden

# Enviar instrucciones por SMS

# Webhooks


Registrar un nuevo webhook
--------------------------

Listar webhooks registrados
---------------------------

Actualizar un webhook
---------------------

Eliminar un webhook
-------------------
