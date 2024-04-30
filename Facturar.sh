#!/bin/bash

# Compilar el archivo Facturar.java
javac -cp ./:json-simple-1.1.1.jar Facturar.java

# Verificar si la compilación fue exitosa
if [ $? -eq 0 ]; then
    echo "Compilación exitosa, ejecutando el programa..."
    # Ejecutar la clase Facturar
    java -cp ./:json-simple-1.1.1.jar Facturar
else
    echo "Error en la compilación, por favor verifica tu código."
fi

# Eliminar archivos .class
echo "Limpiando archivos .class..."
rm *.class
echo "Limpieza completada."
