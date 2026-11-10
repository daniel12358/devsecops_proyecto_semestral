# DevSecOps Lab Project UMB

Este proyecto implementa la arquitectura completa solicitada en la Guía de Laboratorio 7 (Sesiones 13 y 14) de Taller de Programación.

## Características principales
- **Spring Boot 3.2.3** con Java 21.
- **Autenticación Stateless mediante JWT** con firmas HMAC-SHA256.
- **Control de Acceso Basado en Roles (RBAC)** (`ROLE_ADMIN` y `ROLE_USER`).
- **Mutation Testing configurado con PIT** (Threshold > 60%).
- **Pipeline CI/CD en GitHub Actions** con integración a SonarCloud y validación estricta de métricas de mutación.
- **Seguridad HTTP**: Headers de Content Security Policy (CSP), protección Clickjacking, y deshabilitación explícita de CSRF para API REST stateless.

## Cómo ejecutar localmente
```bash
mvn clean package
mvn spring-boot:run
```

## Ejecutar Mutation Testing (PIT)
```bash
mvn test pitest:mutationCoverage
```
Los reportes HTML se generan en `target/pit-reports/index.html`.
