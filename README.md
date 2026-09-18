# Automatización de Pruebas y Despliegue

## 1. Descripción del proyecto

Este proyecto corresponde a una implementación de automatización de pruebas utilizando Java y Maven. Su objetivo es integrar control de versiones, pruebas automatizadas y procesos de integración y despliegue continuo.

La aplicación desarrollada corresponde a una calculadora sencilla, utilizada como base para demostrar diferentes tipos de pruebas dentro de un flujo automatizado.

## 2. Tecnologías utilizadas

* Java 17
* Maven
* JUnit 4.13.2
* Git
* GitHub
* GitHub Actions

## 3. Estructura del proyecto

```text
automatizacion-examen/
├── .github/
│   └── workflows/
│       ├── ci.yml
│       └── deployment.yml
├── deployments/
│   └── test/
├── src/
│   ├── main/
│   └── test/
├── .gitignore
├── pom.xml
└── README.md
```

## 4. Estrategia de pruebas

Se implementaron tres niveles de validación:

### Pruebas unitarias

Las pruebas unitarias verifican individualmente los métodos de la clase `Calculadora`.

Se comprueban operaciones como:

* Suma.
* Multiplicación.
* División.
* Manejo de división por cero.

Se ejecutan mediante:

```bash
mvn test
```

### Pruebas de integración

Las pruebas de integración verifican la interacción entre `ServicioCalculadora` y `Calculadora`.

Se comprueba que el servicio pueda utilizar correctamente las operaciones proporcionadas por la calculadora.

Se ejecutan mediante:

```bash
mvn verify
```

### Pruebas de aceptación

Las pruebas de aceptación validan un escenario completo desde la perspectiva del resultado esperado por el usuario.

Se ejecutan mediante:

```bash
mvn test -Dtest=AcceptanceTest
```

## 5. Integración continua

El archivo:

```text
.github/workflows/ci.yml
```

implementa un pipeline de integración continua.

El flujo contiene:

1. Compilación del proyecto.
2. Ejecución de pruebas unitarias.
3. Ejecución de pruebas de integración.

El pipeline se ejecuta automáticamente cuando se realizan cambios en las ramas configuradas.

## 6. Pipeline de despliegue

El archivo:

```text
.github/workflows/deployment.yml
```

implementa el proceso de despliegue.

El flujo considera:

1. Construcción del proyecto.
2. Ejecución de pruebas de aceptación.
3. Preparación del ambiente Green.
4. Cambio del ambiente activo hacia Green.
5. Rollback hacia Blue cuando se simula un fallo.

## 7. Estrategia Blue-Green

El proyecto utiliza una estrategia Blue-Green para representar el despliegue en un ambiente de prueba.

Inicialmente, el ambiente Blue se encuentra activo:

```text
Blue → Activo
Green → Nueva versión
```

Durante el despliegue, la nueva versión se prepara en Green:

```text
Blue → Versión anterior
Green → Nueva versión
```

Si la validación es correcta, Green pasa a ser el ambiente activo.

Si ocurre un problema, se ejecuta rollback:

```text
Green → Fallo
Blue → Activo nuevamente
```

## 8. Ejecución local

Para ejecutar las pruebas unitarias:

```bash
mvn test
```

Para ejecutar el ciclo completo de Maven:

```bash
mvn clean verify
```

Para ejecutar las pruebas de aceptación:

```bash
mvn test -Dtest=AcceptanceTest
```

## 9. Control de versiones

El proyecto utiliza Git para mantener el historial de cambios.

La rama principal es:

```text
main
```

El desarrollo se realizó mediante:

```text
feature/automatizacion
```

Los cambios son registrados mediante commits descriptivos.

## 10. Evidencias

Las principales evidencias del proyecto corresponden a:

* Ejecución exitosa de Maven.
* Repositorio GitHub con las ramas configuradas.
* Ejecución exitosa del pipeline CI.
* Ejecución de las pruebas unitarias.
* Ejecución de las pruebas de integración.
* Ejecución de las pruebas de aceptación.
* Despliegue exitoso hacia Green.
* Ejecución del rollback hacia Blue.

## 11. Conclusión

La implementación permitió integrar pruebas automatizadas dentro de un flujo de desarrollo utilizando Maven, Git y GitHub Actions. La separación entre pruebas unitarias, de integración y de aceptación permite validar diferentes niveles del proyecto antes de realizar un despliegue.

Además, la incorporación de una estrategia Blue-Green permite representar un mecanismo de despliegue controlado, manteniendo la posibilidad de regresar a la versión anterior mediante rollback cuando se presenta un fallo.
