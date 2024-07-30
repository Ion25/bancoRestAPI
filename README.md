# bancoRestAPI

# Principios SOLID
### Single Responsibility Principle (SRP)
Cada clase y módulo debe tener una única responsabilidad o razón para cambiar.
* Entidades (Entities): Cada entidad, como Cliente, Cuenta, y Transferencia, tiene la responsabilidad exclusiva de representar los datos del dominio y las operaciones directamente relacionadas con esos datos.
* Servicios de Dominio: Cada servicio de dominio, como VerificacionIdentidadServicio, tiene una única responsabilidad de manejar una parte específica de la lógica de negocio.
* Repositorios: Cada repositorio, como ClienteRepositorio, tiene la responsabilidad única de manejar la persistencia de una entidad específica.

### Open/Closed Principle (OCP)
El software debe estar abierto para extensión pero cerrado para modificación.
* Interfaces y Abstracciones: Utilizamos interfaces en application/ports/inbound y application/ports/outbound para definir contratos que las implementaciones concretas deben seguir, permitiendo extender el comportamiento sin modificar las clases existentes.
* Patrón de Repositorio: Las interfaces de repositorio permiten agregar nuevas funcionalidades de persistencia sin cambiar las implementaciones existentes.

### Liskov Substitution Principle (LSP)
Los objetos de una clase base deben poder ser reemplazados por objetos de una clase derivada sin alterar el funcionamiento del programa.

* Implementaciones de Interfaces: Las implementaciones de interfaces en application/ports/outbound (como ClienteRepositorio) siguen este principio al asegurar que cualquier implementación concreta puede sustituir a la abstracción sin afectar el comportamiento esperado.

### Interface Segregation Principle (ISP)
Los clientes no deben verse obligados a depender de interfaces que no utilizan.

* Interfaces Especializadas: Las interfaces en application/ports/inbound y application/ports/outbound están diseñadas para ser específicas a sus necesidades, evitando interfaces grandes y genéricas. Por ejemplo, CuentaService y ClienteRepositorio tienen métodos específicos y relevantes a su contexto.

### Dependency Inversion Principle (DIP)
Los módulos de alto nivel no deben depender de módulos de bajo nivel, sino de abstracciones.

* Inyección de Dependencias: Utilizamos la inyección de dependencias a través de Spring para asegurar que las clases dependan de interfaces y no de implementaciones concretas. Esto se observa en la forma en que los servicios y controladores reciben sus dependencias.
* Patrón de Puertos y Adaptadores: Esta arquitectura asegura que los componentes del dominio y la lógica de negocio dependan de abstracciones definidas en los puertos y no directamente de los detalles de infraestructura.

# Domain-driven design
Entidades, Objetos de Valor, [Servicios de Dominio,] Agregados, Fábricas y Repositorios

# Patrones de Arquitectura
Arquitectura Hexagonal usando DDD

# Pruebas de APIs
* Postman

# Pruebas de Rendimiento

# Pruebas de Seguridad