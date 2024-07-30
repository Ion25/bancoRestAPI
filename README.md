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