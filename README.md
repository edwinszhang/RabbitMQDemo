# RabbitMQ Demo
This is a repo just use for Rabbit MQ test

## Installation of Rabbit MQ
Please refer to official tutorial.

## Basic Configuration on Rabbit UI.
### Create vitual hosts

- Create a vitual host(VH) named */rabbit-zs*
- Add a user and grant permission fo this VH to the user

### Create exchange and queue, binding each other with routeKey

- Create a exchange named *test entry.zs*
- Create a queue named *test.brick.zs*
- Bind this queue to the new exchange, routeKey:*brick.zs*
- Finished the basic configuration on Rabbit UI.

## Write Hello World

### Import java client with maven

```xml
<dependency>
  <groupId>com.rabbitmq</groupId>
  <artifactId>amqp-client</artifactId>
  <version>3.6.1</version>
</dependency>
```
