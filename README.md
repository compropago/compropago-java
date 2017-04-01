# ComproPago Java SDK

## Descripción

La librería de `ComproPago Java SDK` te permite interactuar con el API de ComproPago desde tu aplicación.
También cuenta con los métodos necesarios para facilitar el desarrollo por medio de los servicios
más utilizados (SDK).

Con ComproPago puedes recibir pagos en 7Eleven, Extra y más tiendas en todo México.

[Registrarse en ComproPago](https://compropago.com)

## Índice de Contenidos

- [Ayuda y soporte de ComproPago](#ayuda-y-soporte-de-compropago)
- [Requerimientos](#requerimientos)
- [Instalación ComproPago SDK](#instalación-compropago-sdk)
- [Documentación](#documentación)
- [Guía básica de uso](#guía-básica-de-uso)
- [Guía de versiones](#guía-de-versiones)


## Ayuda y Soporte de ComproPago

- [Centro de ayuda y soporte](https://compropago.com/ayuda-y-soporte)
- [Solicitar integración](https://compropago.com/integracion)
- [Guía para comenzar a usar ComproPago](https://compropago.com/ayuda-y-soporte/como-comenzar-a-usar-compropago)
- [Información de contacto](https://compropago.com/contacto)

## Requerimientos

* Java 1.8.x
* [Google Gson](https://github.com/google/gson)


## Instalación ComproPago Java SDK

### Instalación via .jar

Puedes descargar la última versión estable de el archivo .jar del SDK directamente desde el listado de versiones del 
repositorio o desde este [enlace](https://github.com/compropago/compropago-java/releases). Posteriormente deberás 
incluirlo en tu proyecto.

### Instalación por GitHub

Puedes descargar alguna de las versiones publicadas:

- [Consultar Versiones Publicadas en GitHub](https://github.com/compropago/compropago-java/releases)

O si o lo deseas puedes obtener el repositorio

```bash
#repositorio en su estado actual (*puede no ser versión estable*)
git clone https://github.com/compropago/compropago-java.git
```

## Documentación

### Documentación ComproPago Java SDK


**[API de ComproPago](https://compropago.com/documentacion/api)**

ComproPago te ofrece una API tipo REST para integrar pagos en efectivo en tu comercio electrónico o en tus aplicaciones.

**[General](https://compropago.com/documentacion)**

Información de Horarios y Comisiones, como Transferir tu dinero y la Seguridad que proporciona ComproPago.


**[Herramientas](https://compropago.com/documentacion/boton-pago)**

* Botón de pago
* Modo de pruebas/activo
* WebHooks
* Librerías y Plugins
* Shopify

## Guía básica de Uso

Se necesita una cuenta activa de ComproPago.

[Registrarse en ComproPago](https://compropago.com)

### General

Para poder hacer uso de la librería es necesario incluir las clases del archivo **.jar**

```java
import compropagosdk.Client;
import compropagosdk.factory.Factory;
import compropagosdk.factory.models.*;
```

### Configuración del Cliente

Para poder hacer uso del paquete y llamados al API es necesario que primero configures tus Llaves de conexión y 
crees un instancia de Client. *Sus llaves las encontraras en el Panel de ComproPago en el menú Configuración.*

[Consulta Aquí tus Llaves](https://compropago.com/panel/configuracion)

```java
/**
 * @param String publickey     Llave pública correspondiente al modo de la tienda
 * @param String privatekey    Llave privada correspondiente al modo de la tienda
 * @param boolean live         Modo de la tienda (false = Test | true = Live)
 */
Client client = new Client(
    "pk_test_5989d8209974e2d62",  // publickey
    "sk_test_6ff4e982253c44c42",  // privatekey
    false,                        // live
);
```

### Uso Básico del SDK

#### Llamados al los servicios por SDK

Para poder hacer uso de los servicos de ComproPago, solo debes llamar a los métodos contenidos en la propiedad 
**api** de la variable **client** como se muestra a continuación.

#### Métodos base del SDK

##### Crear una nueva órden de Pago

```java
/**
 * @param [String] order_id          Id de la orden
 * @param [String] order_name        Nombre del producto o productos de la órden
 * @param [double] order_price       Monto total de la orden
 * @param [String] customer_name     Nombre completo del cliente
 * @param [String] customer_email    Correo electrónico del cliente
 * @param [String] payment_type      (default = SEVEN_ELEVEN) Valor del atributo internal_name" de un objeto "Provider"
 * @param [String] currency          (default = MXN) tipo de moneda del campo order_price (MXN, USD, GBP, EUR)
 * @param [String] expiration_time   (default = null) fecha de expiración de la orden en formato Epoch
 */
// Información de la orden
Map<String, String> order_info = new HashMap<String, String>();
order_info.put("order_id", "123");
order_info.put("order_name", "M4 SDK Java");
order_info.put("order_price", "123.45");
order_info.put("customer_name", "Eduardo Aguilar");
order_info.put("customer_email", "eduardo.aguilar@compropago.com");
order_info.put("payment_type", "SEVEN_ELEVEN");
order_info.put("currency", "USD");
order_info.put("expiration_time", "1484799158");

// Creación del objeto PlaceOrderInfo
PlaceOrderInfo order = Factory.placeOrderInfo(order_info);

// Llamada al método "place_order" del API para generar la órden
NewOrderInfo neworder = client.api.placeOrder(order);
```

###### Prototipo del metodo placeOrder()

```java
/**
 * @param [PlaceOrderInfo] info
 * @return
 * @throws Exception
 */
public NewOrderInfo placeOrder(PlaceOrderInfo info);
```

##### Verificar el Estatus de una orden

Para verificar el estatus de una orden generada es necesario llamar al método **verifyOrder** que provee el atributo 
**api** del objeto **Client** y el cual regresa una instancia **CpOrderInfo**. Este método recibe como parámetro el ID 
generado por ComproPago para cada órden. También puede obtener este ID desde un objeto **NewOrderInfo** accediendo al 
atributo **id**.

```java
// Guardar el ID de la orden
String order_id = "ch_xxxx_xxx_xxx_xxxx";

// U obtenerlo de un objetdo NewOrderInfo
String order_id = neworder.id;

// Se manda llamar al metodo del API para recuperar la informacion de la orden
CpOrderInfo info = client.api.verifyOrder(order_id);
```

###### Prototipo del metodo verifyOrder()

```java
/**
 * @param [String] orderId
 * @return
 * @throws Exception
 */
public CpOrderInfo verifyOrder(String orderId);
```


##### Obtener el listado de las tiendas donde se puede realizar el Pago

Para obtener el listado de Proveedores disponibles para realizar el pago de las órdenes es necesario consultar el método
**listProviders** que se encuentra alojado en el atributo **api** del objeto **Client** y el cual regresa una instancia 
de tipo **ArrayList** la cual contendrá objetos de tipo **Provider**.

```java
Provider[] providers = client.api.listProviders();
```

###### Prototipo del metodo listProviders()

```java
/**
 * @param [boolean] auth    Forzar autenticación
 * @param [double]  limit   Filtro por límite de transaccion de proveedor
 * @param [boolean] fetch   Forzar búsqueda en base de datos
 * @return [Provider[]]
 * @throws Exception
 */

// Forma 1
public Provider[] listProviders(double limit, String currency);

// Forma 2
public Provider[] listProviders(double limit);

// Forma 3
public Provider[] listProviders();

```

##### Envio de instrucciones SMS

Para realizar el el envío de las instrucciones de compra vía SMS es necesario llamar al método **sendSmsInstructions** 
que se encuentra alojado en el atributo **api** del objeto **Client** y el cual regresa una instancia de tipo 
**SmsInfo**.

```java
// Numero al cual se enviaran las instrucciones
String phone_number = "55xxxxxxxx";

// Id de la orden de compra de cual se enviaran las instrucciones
String order_id = "ch_xxxxx-xxxxx-xxxxx-xxxxx";

// Llamada al metodo del API para envio de las instrucciones
SmsInfo smsinfo = client.api.sendSmsInstructions(phone_number , order_id);
```

###### Prototipo del método sendSmsInstructions()

```java
/**
 * @param [String] number
 * @param [String] orderId
 * @return [SmsInfo]
 * @throws Exception
 */
public SmsInfo sendSmsInstructions(String number, String orderId);
```

#### Webhooks

Los webhooks son de suma importancia para el proceso las órdenes de ComproPago, ya que éstos se encargaran de recibir 
las notificaciones del cambio de estatus de las órdenes de compra generadas. También deberán contener parte de la 
lógica de aprobación en su tienda en línea.

El proceso que siguen es el siguiente:

1. Cuando una orden cambia su estatus, nuestra plataforma le notificará a cada una de las rutas registradas, dicho 
cambio con la información de la órden modificada en formato JSON.
2. Debera de recuperar este JSON en una cadena de texto para posterior mente convertirla a un objeto de tipo 
**CpOrderInfo** haciendo uso de la clase Factory que proporciona el SDK de la siguiente forma:

```java
// @param String cadenaObtenida
CpOrderInfo info = Factory.cpOrderInfo( cadenaObtenida );
```

3. Generar la lógica de aprobación correspondiente al estatus de la órden.

##### Crear un nuevo Webhook

Para crear un nuevo Webhook en la cuenta, se debe de llamar al método **createWebhook** que se encuentra alojado en el 
atributo **api** del objeto **Client** y el cual regresa una instancia de tipo **Webhook**.

```java
// Se pasa como paramtro la URL al webhook
Webhook webhook = client.api.createWebhook("http://sitio.com/webhook");
```

###### Prototipo del metodo createWebhook()

```java
/**
 * @param [String] url
 * @return [Wenhook]
 * @throws Exception
 */
public Webhook createWebhook(String url);
```

##### Actualizar un Webhook

Para actualizar la url de un webhook, se debe de llamar al método **updateWebhook** que se encuentra alojado en el 
atributo **api** del objeto **Client** y el cual regresa una instancia de tipo **Webhook**.

```java
Webhook updated_webhook = client.api.updateWebhook(webhook.id, "http://sitio.com/nuevo_webhook");
```

###### Prototipo del metodo updateWebhook()

```java
/**
 * @param [String] webhookId
 * @param [String] url
 * @return [Wenhook]
 * @throws Exception
 */
public Webhook updateWebhook(String webhookId, String url);
```

##### Eliminar un Webhook

Para eliminar un webhook, se debe de llamar al método **deleteWebhook** que se encuentra alojado en el atributo **api** 
del objeto **Client** y el cual regresa una instancia de tipo **Webhook**.

```java
Webhook deleted_webhook = client.api.deleteWebhook(webhook.id);
```

###### Prototipo del metodo deleteWebhook()

```java
/**
 * @param [String] webhookId
 * @return [Wenhook]
 * @throws Exception
 */
public Webhook deleteWebhook(String webhookId);
```

##### Obtener listado de Webhooks registrados

Para obtener la lista de webhooks registrados den una cuenta, se debe de llamar al método **listWebhook** que se 
encuentra alojado en el atributo **api** del objeto **Client** y el cual regresa una instancia de tipo **Array** la 
cual contiene objetos de tipo **Webhook**

```java
webhook[] list = client.api.listWebhooks();
```

###### Prototipo del metodo listWebhook()

```java
/**
 * @return [Webhook[]]
 * @throws Exception
 */
public Webhook[] listWebhooks();
```
