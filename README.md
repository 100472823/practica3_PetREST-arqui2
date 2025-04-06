# 🐾 PetREST – Cliente REST en Java para Gestión de Pedidos

Este proyecto implementa un sistema cliente REST en Java, orientado a la gestión de pedidos, artículos y facturación. Utiliza peticiones HTTP y procesamiento de datos JSON para simular la comunicación con un servidor web, siguiendo el modelo cliente-servidor.

## 🧱 Estructura Principal

- `Articulo.java`, `Pedido.java`, `Factura.java`: Entidades del dominio.
- `httpClient.java`, `Requests.java`: Lógica de conexión HTTP.
- `JSON_PARSER.java`: Procesamiento de respuestas JSON.
- `Facturar.java`: Lógica de facturación.
- `.sh` script para ejecución automatizada.
- Librerías incluidas: `json-simple-1.1.1.jar`, `javanet-1.3.jar`.

## ▶️ Cómo ejecutar

Compila todos los `.java` y ejecuta `Facturar.java` o usa el script `Facturar.sh` (Linux/macOS):

```bash
sh Facturar.sh
Asegúrate de tener json-simple y javanet en tu classpath.

📦 Requisitos
JDK 8+

Librería json-simple para manejo de JSON.

Acceso a una API REST simulada o real para pruebas.

👥 Autores
Proyecto académico para prácticas de Arquitectura de Computadores II, UC3M.
