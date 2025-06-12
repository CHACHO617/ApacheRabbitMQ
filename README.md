# 📨 Taller RabbitMQ con Apache Camel

Este proyecto demuestra el uso del patrón de integración **Mensajería Asíncrona** utilizando **Apache Camel** y **RabbitMQ**, con el objetivo de desacoplar la lógica de un productor y un consumidor de mensajes.

---

## 🎯 Objetivo

Aplicar el patrón de mensajería asincrónica para demostrar el **desacoplamiento entre productores y consumidores**, configurando un broker de mensajería RabbitMQ y conectando rutas Camel en Java para producir y consumir mensajes.

---

## ⚙️ Tecnologías utilizadas

- Java
- Spring Boot
- Apache Camel
- RabbitMQ (vía Docker)
- Maven

---

## 🛠️ Instalación y ejecución

1. Ejecutar RabbitMQ en Docker:

```bash
docker run -d --hostname my-rabbit --name rabbitmq \
 -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```

2. Ejecutar el proyecto:

```bash
mvn spring-boot:run
```

3. Acceder al panel de RabbitMQ:  
   [http://localhost:15672](http://localhost:15672)  
   Usuario: `guest`  
   Contraseña: `guest`

---

## 📦 Estructura del proyecto

- `ProducerRoute.java`: genera un mensaje cada 5 segundos y lo envía a RabbitMQ.
- `ConsumerRoute.java`: consume mensajes desde la misma cola.
- `application.properties`: contiene la configuración base para Spring Boot y Camel.
- `pom.xml`: define las dependencias de Camel, RabbitMQ y Spring Boot.

---

## 📚 Patrón de integración aplicado

Se utilizó el patrón **Mensajería Asíncrona**, el cual permite que los sistemas intercambien información sin necesidad de estar conectados simultáneamente. En vez de una conexión directa, el mensaje viaja a través de un canal intermedio (RabbitMQ), lo que permite tolerancia a fallos, desacoplamiento entre componentes y procesamiento a ritmos diferentes.

---

## 🔄 Desacoplamiento Productor - Consumidor

El productor fue una ruta Camel configurada con un `timer` que genera un mensaje y lo envía a la cola `test.camel.queue`.  
El consumidor fue una ruta Camel distinta que escucha esa misma cola y procesa los mensajes entrantes.  
Gracias a RabbitMQ, ambos componentes están completamente desacoplados. El productor no sabe si hay consumidores disponibles, y los consumidores pueden estar apagados y luego volver a procesar los mensajes sin pérdida de información.

---

## ✅ Ventajas observadas

- **Tolerancia a fallos**: RabbitMQ guarda los mensajes si el consumidor está desconectado.
- **Escalabilidad**: se pueden agregar más consumidores fácilmente.
- **Mantenibilidad**: productor y consumidor se desarrollan e implementan por separado.
- **Visibilidad**: monitoreo completo a través del panel web de RabbitMQ.
- **Simplicidad**: rutas Camel concisas y declarativas para definir la lógica de integración.

---

## 📎 Repositorio del proyecto

🔗 [https://github.com/CHACHO617/ApacheRabbitMQ/tree/main](https://github.com/CHACHO617/ApacheRabbitMQ/tree/main)

---
