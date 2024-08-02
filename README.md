# bancoRestAPI

# Principios SOLID
* Factory
* DTO

# Domain-driven design
Entidades, Objetos de Valor, [Servicios de Dominio,] Agregados, Fábricas y Repositorios

# Patrones de Arquitectura
Arquitectura Hexagonal usando DDD

# Pruebas de APIs
* Postman

# Pruebas de Rendimiento

# Pruebas de Seguridad


# Proyecto de Diseño Orientado al Dominio (DDD)

## Introducción

Este proyecto implementa los principios de Diseño Orientado al Dominio (DDD) utilizando una arquitectura hexagonal. El objetivo es crear una aplicación modular, mantenible y escalable que sigue los patrones de diseño de software recomendados.

## Domain-Driven Design (DDD)

### Entidades
Las entidades representan objetos del dominio con identidad propia que persiste a lo largo del tiempo. Son fundamentales para el modelado del dominio y contienen tanto datos como comportamiento.

### Objetos de Valor
Los objetos de valor representan conceptos del dominio que se distinguen por sus propiedades en lugar de su identidad. Son inmutables y su igualdad se determina por los valores de sus propiedades.

### Servicios de Dominio
Los servicios de dominio encapsulan lógica de negocio que no pertenece a ninguna entidad u objeto de valor. Son responsables de operaciones que involucran múltiples objetos del dominio o no pueden ser fácilmente asignadas a una sola entidad.

### Agregados
Los agregados son clústeres de objetos del dominio que se tratan como una unidad de consistencia. Tienen una entidad raíz que controla el acceso a los demás objetos del agregado.

### Fábricas
Las fábricas son responsables de la creación de objetos complejos del dominio, encapsulando la lógica necesaria para construirlos y asegurando su consistencia desde el momento de su creación.

### Repositorios
Los repositorios actúan como intermediarios entre el dominio y la capa de persistencia, proporcionando métodos para recuperar y almacenar agregados y otros objetos del dominio.

## Patrones de Arquitectura

### Arquitectura Hexagonal usando DDD
La arquitectura hexagonal, también conocida como Puertos y Adaptadores, permite aislar el núcleo del dominio de los detalles técnicos e infraestructura. Utilizando DDD, se enfoca en:

- **Core del Dominio:** La lógica de negocio central, modelada usando entidades, objetos de valor, servicios de dominio, agregados y fábricas.
- **Adaptadores de Entrada:** Interfaces y controladores que permiten la interacción con el sistema, como API RESTful.
- **Adaptadores de Salida:** Implementaciones concretas de interfaces para interactuar con bases de datos, servicios externos, etc.

## Pruebas de APIs

### Postman
Se utilizan colecciones de Postman para realizar pruebas automáticas de las APIs desarrolladas. Estas pruebas aseguran que las endpoints respondan correctamente y se comporten de acuerdo a lo esperado.

### Pruebas de Rendimiento
Las pruebas de rendimiento evalúan la capacidad del sistema para manejar cargas de trabajo bajo diferentes condiciones. Herramientas como JMeter pueden ser utilizadas para simular múltiples usuarios y medir tiempos de respuesta y throughput.

### Pruebas de Seguridad
Las pruebas de seguridad se enfocan en identificar y corregir vulnerabilidades dentro de la aplicación. Se pueden emplear herramientas como OWASP ZAP para escanear las APIs y asegurar que cumplen con los estándares de seguridad.

## Conclusión

Este proyecto demuestra cómo aplicar principios de DDD junto con una arquitectura hexagonal para construir sistemas robustos y mantenibles. A través de pruebas rigurosas de API, rendimiento y seguridad, se asegura que el sistema no solo sea funcional, sino también eficiente y seguro.
# Prácticas BPM

## Procesos de Negocio

### 1. Proceso de Apertura de Cuentas

#### 1.1. Modelo y Descripción del Modelo
Permite abrir cuentas bancarias a los nuevos clientes.

#### 1.2. Roles Involucrados
- **Cliente**: Persona que solicita la apertura de una cuenta bancaria.
- **Sistema Bancario**: Plataforma tecnológica utilizada para gestionar las cuentas bancarias.

#### 1.3. Actores
- **Solicitante**: Cliente que inicia el proceso de apertura de cuenta.
- **Oficial de Servicio al Cliente**: Empleado del banco que asiste al solicitante en el proceso de apertura de cuenta.

#### 1.4. Diagrama
![Diagrama de Apertura de Cuentas](ProcesosNegocio/imgs/procesoAperturaCuenta.png)

### 2. Proceso de Transferencias de Fondos

#### 2.1. Modelo y Descripción del Modelo
Gestiona las transferencias de fondos entre cuentas dentro del banco.

#### 2.2. Roles Involucrados
- **Remitente**: Persona que realizara la transaccion a otra cuenta que sera el destinatario.
- **Sistema Bancario**: Plataforma tecnológica utilizada para gestionar la transaccion.

#### 2.3. Actores
- **Remitente**: Cliente que inicia el proceso de solicitud de transaccion de fondos.
- **Oficial de Tranferencias**: Empleado del banco que asiste al remitente y da el visto bueno a la transferencia de fondos.

#### 2.4. Diagrama
![Diagrama de Apertura de Cuentas](ProcesosNegocio/imgs/ProcesoTransferenciaFondos.png)

### 3. Proceso de Pago de Servicios

#### 3.1. Modelo y Descripción del Modelo
Permite a los clientes pagar facturas y servicios a través del banco.

#### 3.2. Roles Involucrados
- **Cliente**: Persona que realizara el pago a traves del sistema bancario.
- **Sistema Bancario**: Plataforma tecnológica utilizada para realizar pagos de servicios.

#### 3.3. Actores
- **Cliente**: Cliente que inicia el proceso de pago de servicios.
- **Proveedor de Servicios**: Empleado del banco que asiste al cliente en el pago de servicios.

#### 3.4. Diagrama
![Diagrama de Apertura de Cuentas](ProcesosNegocio/imgs/PagoDeServicios-2.0.png)

### 4. Proceso de Solicitud de Préstamos

#### 4.1. Modelo y Descripción del Modelo
Permite a los clientes solicitar y gestionar préstamos bancarios.

#### 4.2. Roles Involucrados
- **Cliente**: Persona que solicitara un prestamo al banco.
- **Sistema Bancario**: Plataforma tecnológica encargada de aprobar y supervisar el prestamo.

#### 4.3. Actores
- **Cliente**: Cliente que inicia el proceso para una solicitud de prestamo.
- **Oficial de Prestamos**: Empleado del banco que asistira al cliente en la solicitud del prestamo y en la aprobacion del prestamo.

#### 4.4. Diagrama
![Diagrama de Apertura de Cuentas](ProcesosNegocio/imgs/SolicitudDePrestamo-2.0.png)

### 5. Proceso de Gestión de Tarjetas de Crédito

#### 5.1. Modelo y Descripción del Modelo
Gestiona la emisión de tarjetas de crédito.

#### 5.2. Roles Involucrados
- **Cliente**: Persona que realizara la solicitud para obtener una tarjeta de credito.
- **Sistema Bancario**: Plataforma tecnológica encargada de emitir las tarjetas de credito.

#### 5.3. Actores
- **Cliente**: Cliente que inicia el proceso para solicitar una tarjeta de credito.
- **Oficial de Tarjetas de Credito**: Empleado del banco que evaluara si el cliente es apto para obtener una tarjeta de credito.

#### 5.4. Diagrama
![Diagrama de Apertura de Cuentas](ProcesosNegocio/imgs/GestionDeTarjetasCredito-2.0.png)

