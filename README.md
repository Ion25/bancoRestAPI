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

## Herramienta Utilizada

Link Informe: https://drive.google.com/file/d/1idunNmyrFZWGPyaF81257UjyACCMAA-w/view?usp=sharing

Para la evaluación de la seguridad de la aplicación, se utilizó OWASP ZAP (Versión 2.15.0), una herramienta open-source diseñada para encontrar vulnerabilidades en aplicaciones web.

## Parámetros del Informe
- **Fecha del escaneo**: 30 de marzo de 2024
- **Contextos**: No se seleccionó ningún contexto específico, por lo que se incluyeron todos de forma predeterminada.
- **Sitios Escaneados**: `http://localhost:8080`
- **Niveles de Riesgo Incluidos**: Alto, Medio, Bajo, Informativo
- **Niveles de Confianza Incluidos**: Confirmado por Usuario, Alta, Media, Baja

## Resumen del Informe
### Conteo de Alertas por Riesgo y Confianza
| Confianza    | Alto | Medio | Bajo | Informativo | Total |
|--------------|------|-------|------|-------------|-------|
| Alta         | 0    | 0     | 0    | 0           | 0     |
| Media        | 0    | 0     | 0    | 1           | 1     |
| Baja         | 0    | 0     | 0    | 0           | 0     |
| Confirmado   | 0    | 0     | 0    | 0           | 0     |
| **Total**    | 0    | 0     | 0    | 1           | 1     |

### Recuento de Alertas por Sitio y Riesgo
| Sitio                 | Alto | Medio | Bajo | Informativo |
|-----------------------|------|-------|------|-------------|
| http://localhost:8080 | 0    | 0     | 0    | 1           |

### Recuento de Alertas por Tipo de Alerta
| Tipo de Alerta          | Riesgo      | Cantidad |
|-------------------------|-------------|----------|
| Agente de Usuario Fuzzer| Informativo | 1        |

## Detalles de las Alertas
### Agente de Usuario Fuzzer
- **Riesgo**: Informativo
- **Confianza**: Media
- **Descripción**: El escáner activo identificó un comportamiento anómalo en la manipulación del agente de usuario.
- **Referencia**: [OWASP User Agent Fuzzer](https://www.zaproxy.org/docs/alerts/10104/)

## Acciones Recomendadas
1. **Revisión de Agente de Usuario**: Verificar las configuraciones del agente de usuario en la aplicación y ajustar según las mejores prácticas de seguridad.
2. **Mejora de Seguridad**: Implementar medidas adicionales para detectar y mitigar posibles manipulaciones de agentes de usuario.
3. **Monitoreo Continuo**: Continuar monitoreando y escaneando la aplicación regularmente utilizando herramientas como OWASP ZAP para asegurar que nuevas vulnerabilidades no sean introducidas.

## Enlaces de Referencia
- [OWASP ZAP](https://www.zaproxy.org/)
- [Guía de Pruebas de OWASP](https://owasp.org/wstg)

# Documentación de Servicios de Banco en base al estándar OpenAPI y la Herramienta Swagger

## Descripción General

Esta API permite gestionar diversos aspectos de los servicios bancarios, incluyendo clientes, cuentas, transacciones y más.

## Recursos

### Cliente
Representa a un cliente del banco.

#### Esquema
```json
{
  "Cliente": {
    "type": "object",
    "properties": {
      "id": {
        "type": "integer"
      },
      "nombre": {
        "type": "string"
      },
      "email": {
        "type": "string",
        "format": "email"
      },
      "telefono": {
        "type": "string"
      }
    }
  }
}
```

#### Operaciones

##### Obtener Lista de Clientes
Obtiene una lista de todos los clientes.

- **URL:** /api/clientes
- **Método:** GET
- **Respuesta:**
  - **Código 200:** Lista de clientes
  - **Ejemplo de respuesta:**
    ```json
    [
      {
        "id": 1,
        "nombre": "Juan Perez",
        "email": "juan.perez@example.com",
        "telefono": "123456789"
      }
    ]
    ```

##### Obtener Cliente por ID
Obtiene los detalles de un cliente específico por su ID.

- **URL:** /api/clientes/{id}
- **Método:** GET
- **Parámetros de ruta:**
  - id (integer, requerido): ID del cliente
- **Respuesta:**
  - **Código 200:** Detalles del cliente
  - **Código 404:** Cliente no encontrado
  - **Ejemplo de respuesta:**
    ```json
    {
      "id": 1,
      "nombre": "Juan Perez",
      "email": "juan.perez@example.com",
      "telefono": "123456789"
    }
    ```

##### Crear un Nuevo Cliente
Crea un nuevo cliente en el sistema.

- **URL:** /api/clientes
- **Método:** POST
- **Cuerpo de la solicitud:**
  ```json
  {
    "nombre": "Juan Perez",
    "email": "juan.perez@example.com",
    "telefono": "123456789"
  }
  ```
- **Respuesta:**
  - **Código 201:** Cliente creado
  - **Ejemplo de respuesta:**
    ```json
    {
      "id": 1,
      "nombre": "Juan Perez",
      "email": "juan.perez@example.com",
      "telefono": "123456789"
    }
    ```

##### Actualizar un Cliente
Actualiza los detalles de un cliente existente.

- **URL:** /api/clientes/{id}
- **Método:** PUT
- **Parámetros de ruta:**
  - id (integer, requerido): ID del cliente
- **Cuerpo de la solicitud:**
  ```json
  {
    "nombre": "Juan Perez",
    "email": "juan.perez@example.com",
    "telefono": "123456789"
  }
  ```
- **Respuesta:**
  - **Código 200:** Cliente actualizado
  - **Código 404:** Cliente no encontrado
  - **Ejemplo de respuesta:**
    ```json
    {
      "id": 1,
      "nombre": "Juan Perez",
      "email": "juan.perez@example.com",
      "telefono": "123456789"
    }
    ```

##### Eliminar un Cliente
Elimina un cliente del sistema.

- **URL:** /api/clientes/{id}
- **Método:** DELETE
- **Parámetros de ruta:**
  - id (integer, requerido): ID del cliente
- **Respuesta:**
  - **Código 204:** Cliente eliminado
  - **Código 404:** Cliente no encontrado

### Modelo de Datos

#### Esquema de Cliente
El modelo de datos del cliente incluye los siguientes campos:

- id (integer): ID único del cliente.
- nombre (string): Nombre del cliente.
- email (string): Dirección de correo electrónico del cliente.
- telefono (string): Número de teléfono del cliente.

#### Ejemplo de Cliente
```json
{
  "id": 1,
  "nombre": "Juan Perez",
  "email": "juan.perez@example.com",
  "telefono": "123456789"
}
```

## Servidor

- **Base URL:** http://localhost:8080/swagger-ui/index.html

## Herramienta Swagger

![swagger](https://github.com/user-attachments/assets/9504e344-69f0-43dd-aeca-336c9873a126)

