var x ={};

// x.texto ="Hola" // Sin coma.
// X. entero = 12564
x.real= 12.22;
// Cuidado con entero o no entero, no puedo cargar un numero entero en un double. 
x.flag = true;
// Declarado en bool. 
// NULL,4, para que tenga separadores etc
// o es un objeto dentro del objeto de x
x.o= {};
// Array
x.arr = [];
x.arr = [0] = "222";
x.arr[1] = 22.22;
x.o.texto = "ADIOS";
// No es obligatorio usar ; a mi me gusta
var json = JSON.stringify(x,null,4);
console.log(json);
// Cuando imprimes varios, no tienes que poner la coma. 

//en el json object, en funcion, va a generar un json object en java, y 
// Si se encuentra en [], va a generar un json array. 
// Para parsearlo en java, necesitamos saber que objeto vamos a usar. 

// Para publicar, vamos a unir cadena a manos en vez de publicar, contrusimos un string a con los datos JSON.java/Obra
// sabemos que atributo tiene ese objeto, tendremos que castearlos a ese objeto y sacar el valor. 

//HTTP
// PROTOCOLO DE TRANSFERENCIA SIN ESTADO; CLIENTE SERVIDOR; RESPONDE A PETICIONES REQUEST. 
// CLIENTE HACE UN REQUEST; SERVER HACE RESPONSE. 

// LA TRANSMISION DE DATOS ES FORMATO TEXTO:

// GET : SERVIDOR; VERSION HTTP
// HACE UN GET; URL ES DONDE TENEMOS EL SERVICIO PETREST. 
// NI PUT NI POST NI DELETE DESDE NAVEGADOR. 

// ESPECIFICO EL ARTICULO QUE QUIERO LEER , me voy metiendo en los distitno

// CURL, OBTENER FACTURA 3, LA OBTENCION DE LA FACTURA. 
//USUARIO PAREJA19
// NECESITAMOS CREDENCIALES; PARA CADA FACTURA. 

// CURL -X POST; para que no haga por defecto, get, 
// Como es un put, necestio meterle la informacion que va a ir en esa factura. 

// VALORES REALES CON DECIMALES. FLOAT. 

// PETICION; ABRIR UNA PETICION RECOGER LA RESPUESTA INTERPRETARLA; Y PROCESARLA. 

