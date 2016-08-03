# ComproPago Java SDK v1.0.0

## Descripción

La librería de `ComproPago Java SDK` le permite interactuar con el API de ComproPago en su aplicación.
También cuenta con los métodos necesarios para facilitarle su desarrollo por medio de los servicios
más utilizados (SDK).

Con ComproPago puede recibir pagos en OXXO, 7Eleven y muchas tiendas más en todo México.

[Registrarse en ComproPago](https://compropago.com)

## Índice de Contenidos

- [Ayuda y Soporte de ComproPago](#ayuda-y-soporte-de-compropago)
- [Requerimientos](#requerimientos)
- [Instalación ComproPago SDK](#instalación-compropago-sdk)
- [Documentación](#documentación)
- [Guía básica de Uso](#guía-básica-de-uso)
- [Guía de Versiones](#guía-de-versiones)


## Ayuda y Soporte de ComproPago

- [Centro de ayuda y soporte](https://compropago.com/ayuda-y-soporte)
- [Solicitar Integración](https://compropago.com/integracion)
- [Guía para Empezar a usar ComproPago](https://compropago.com/ayuda-y-soporte/como-comenzar-a-usar-compropago)
- [Información de Contacto](https://compropago.com/contacto)

## Requerimientos

* Java 1.8.x
* [Google Gson 2.7](https://github.com/google/gson)


## Instalación ComproPago Java SDK

### Instalación via .jar

Puedes dercargar la ultma vercion estable de el archivo .jar del SDK directamente desde el listado de versiones del repositorio o desde este [enlace][latest-jar].
Posteriormente debera de incluirlo en su proyecto.

### Instalación por GitHub

Puede descargar alguna de las versiones que hemos publicado:

- [Consultar Versiones Publicadas en GitHub](https://github.com/compropago/compropago-ruby/releases)

O si o lo desea puede obtener el repositorio

```bash
#repositorio en su estado actual (*puede no ser versón estable*)
git clone https://github.com/compropago/compropago-java.git
```

## Documentación

### Documentación ComproPago Java SDK

### Documentación de ComproPago

**[API de ComproPago](https://compropago.com/documentacion/api)**

ComproPago te ofrece un API tipo REST para integrar pagos en efectivo en tu comercio electrónico o tus aplicaciones.

**[General](https://compropago.com/documentacion)**

Información de Comisiones y Horarios, como Transferir tu dinero y la Seguridad que proporciona ComproPAgo


**[Herramientas](https://compropago.com/documentacion/boton-pago)**

* Botón de pago
* Modo de pruebas/activo
* WebHooks
* Librerías y Plugins
* Shopify

## Guía básica de Uso

Se debe contar con una cuenta activa de ComproPago. [Registrarse en ComproPago](https://compropago.com)

### General

Para poder hacer uso de la librería es necesario incluir las clases del archivo .jar

```java
import compropagosdk.*
```

### Configuración del Cliente

Para poder hacer uso de la gema y llamados al API es necesario que primero configure sus Llaves de conexión y crear un instancia de Client.
*Sus llaves las encontrara en su Panel de ComproPago en el menú Configuración.*

[Consulte Aquí sus Llaves](https://compropago.com/panel/configuracion)

```java
/**
 * @param String publickey     Llave publica correspondiente al modo de la tienda
 * @param String privatekey    Llave privada correspondiente al modo de la tienda
 * @param boolean live         Modo de la tienda (false = Test | true = Live)
 * @param string contained     (optional) App User agent
 */
Client client = new Client(
    "pk_test_5989d8209974e2d62",  // publickey
    "sk_test_6ff4e982253c44c42",  // privatekey
    false,                        // live
    null                          // contaiden
);
```

### Uso Básico del SDK

> Consulte la documentación de la librería Ruby de ComproPago para conocer más de sus capacidades, configuraciones y métodos.


#### Llamados al los servicios por SDK

Para poder hacer uso de los servicos de ComproPago, solo debe de llamar a los metodos contenidos en la propiedad **api** de la variable **client** como se muestra a continuación.


#### Métodos base del SDK

##### Crear una nueva orden de Pago


```java
/**
 * @param [String] order_id          Id de la orden
 * @param [String] order_name        Nombre del producto o productos de la orden
 * @param [Double]  order_price      Monto total de la orden
 * @param [String] customer_name     Nombre completo del cliente
 * @param [String] customer_email    Correo electronico del cliente
 * @param [String] payment_type      (default = OXXO) Valor del atributo internal_name" de un objeto "Provider"
 * @param [String] image_url         (optional) Url a la imagen del producto
 */

PlaceOrderInfo order = new PlaceOrderInfo(
    "123",                                // order_id
    "M4 Style Ruby",                      // order_name
    1000,                                 // order_price
    "Eduardo Aguilar",                    // customer_name
    "eduardo.aguilar@compropago.com",     // customer_email
    "OXXO",                               // payment_type
    null                                  // image_url
)


// Llamada al metodo "place_order" del API para generar la orden

/**
 * @param [PlaceOrderInfo] order
 * @return [NewOrderInfo]
 */
NewOrderInfo neworder = client.api.placeOrder(order);
```

###### Prototipo del metodo placeOrder()

```java
/**
 * @param [PlaceOrderInfo] info
 * @return
 * @throws Exception
 */
public NewOrderInfo placeOrder(PlaceOrderInfo info) throws Exception;
```

##### Verificar el Estatus de una orden

Para verificar el estatus de una orden generada es necesario llamar al metodo **verifyOrder** que provee el atributo **api** del objeto **Client** y el cual regresa una instancia **CpOrderInfo**. Este metodo recibe como parametro el ID generado por ComproPago para cada orden. Tambien puede obtener este ID desde un objeto **NewOrderInfo** accediendo al metodo **getId**.

```java
// Guardar el ID de la orden
String order_id = "ch_xxxx_xxx_xxx_xxxx";

// U obtenerlo de un objetdo NewOrderInfo
String order_id = neworder.getId();


// Se manda llamar al metodo del API para recuperar la informacion de la orden
CpOrderInfo info = client.api.verifyOrder(order_id);
```

###### Prototipo del metodo verifyOrder()

```java
/**
 * @param String orderId
 * @return
 * @throws Exception
 */
public CpOrderInfo verifyOrder(String orderId) throws Exception ;
```


##### Obtener el listado de las tiendas donde se puede realizar el Pago

Para obtener el listado de Proveedores disponibles para realizar el pago de las ordenes es necesario consutar el metodo **listProviders** que se encuentra alojado en el atributo **api** del objeto **Client** y el cual regresa una instancia de tipo **ArrayList** la cual contendra objetos de tipo **Provider**

```java
ArrayList<Provider> providers = client.api.listProviders();
```

###### Prototipo del metodo listProviders()

```java
/**
 * @param boolean auth    Forzar autentificación
 * @param float   limit   Filtro por limete de transaccion de proveedor
 * @param boolean fetch   Forzar busqueda en base de datos
 * @return
 * @throws Exception
 */

// Forma 1
public ArrayList<Provider> listProviders(boolean auth, float limit, boolean fetch) throws Exception ;

// Forma 2
public ArrayList<Provider> listProviders(boolean auth, float limit) throws Exception;

// Forma 3
public ArrayList<Provider> listProviders(boolean auth) throws Exception;

// Forma 4
public ArrayList<Provider> listProviders() throws Exception;
```

##### Envio de instrucciones SMS

Para realizar el el envio de las instrucciones de compra via SMS es necesario llamar al metodo **sendSmsInstructions** que se que se encuentra alojado en el atributo **api** del objeto **Client** y el cual regresa una instancia de tipo **SmsInfo**

```java
// Numero al cual se enviaran las instrucciones
String phone_number = "55xxxxxxxx";

// Id de la orden de compra de cual se enviaran las instrucciones
String order_id = "ch_xxxxx-xxxxx-xxxxx-xxxxx";

// Llamada al metodo del API para envio de las instrucciones
SmsInfo smsinfo = client.api.sendSmsInstructions(phone_number , order_id);
```

###### Prototipo del metodo sendSmsInstructions()

```java
/**
 * @param String number
 * @param String orderId
 * @return
 * @throws Exception
 */
public SmsInfo sendSmsInstructions(String number, String orderId) throws Exception;
```

#### Webhooks

Los webhooks son de suma importancia para el proceso las ordenes de ComproPago, ya que estos se encargaran de recibir las notificaciones de el cambio en los estatus de las ordenes de compra generadas, tambien deberan contener parte de la logica de aprobacion en su tienda en linea. El proceso que siguen es el siguiente.

1. Cuando una orden cambia su estatus, nuestra plataforma le notificara a cada una de las rutas registradas, dicho cambio con la informacion de la orden modificada en formato JSON
2. Debera de recuperar este JSON en una cadena de texto para posterior mente convertirla a un objeto de todpo **CpOrderInfo** haciendo uso de la clase Factory que proporciona el SDK de la siguiente forma:

```java
// @param String cadenaObtenida
CpOrderInfo info = Factory.cpOrderInfo( cadenaObtenida );
```

3. Generar la logica de aprovacion correspondiente al estatus de la orden.

##### Crear un nuevo Webhook

Para crear un nuevo Webhook en la cuenta, se debe de llamar al metodo **createWebhook** que se encuentra alojado en el atributo **api** del objeto **Client** y el cual regresa una instancia de tipo **Webhook**

```java
// Se pasa como paramtro la URL al webhook
Webhook webhook = client.api.createWebhook("http://sitio.com/webhook");
```

###### Prototipo del metodo createWebhook()

```java
/**
 * @param String url
 * @return
 * @throws Exception
 */
public Webhook createWebhook(String url) throws Exception;
```

##### Actualizar un Webhook

Para actualizar la url de un webhoo, se debe de llamar al metodo **updateWebhook** que se encuentra alojado en el atributo **api** del objeto **Client** y el cual regresa una instancia de tipo **Webhook**

```java
Webhook updated_webhook = client.api.updateWebhook(webhook.getId(), "http://sitio.com/nuevo_webhook");
```

###### Prototipo del metodo updateWebhook()

```java
/**
 * @param String webhookId
 * @param String url
 * @return
 * @throws Exception
 */
public Webhook updateWebhook(String webhookId, String url) throws Exception;
```

##### Eliminar un Webhook

Para eliminar un webhook, se debe de llamar al metodo **deleteWebhook** que se encuentra alojado en el atributo **api** del objeto **Client**
y el cual regresa una instancia de tipo **Webhook**

```java
Webhook deleted_webhook = client.api.deleteWebhook(webhook.getId());
```

###### Prototipo del metodo deleteWebhook()

```java
/**
 * @param String webhookId
 * @return
 * @throws Exception
 */
public Webhook deleteWebhook(String webhookId) throws Exception;
```

##### Obtener listado de Webhooks registrados

Para obtener la lista de webhooks registrados den una cuenta, se debe de llamar al metodo **listWebhook** que se encuentra alojado en el atributo **api** del objeto **Client** y el cual regresa una instancia de tipo **Array** la cual contiene objetos de tipo **Webhook**

```java
ArrayList<Webhook> list = client.api.listWebhooks();
```

###### Prototipo del metodo listWebhook()

```java
/**
 * @return
 * @throws Exception
 */
public ArrayList<Webhook> listWebhooks() throws Exception;
```

[latest-jar]: https://github.com/compropago/compropago-juva/