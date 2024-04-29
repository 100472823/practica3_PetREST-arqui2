// Crea la clase http para agrupar las peticiones httpp. 
// Metodo get, para obtener los array de objetos JSON Array, y el get para objetos sueltos JSON object. 

// Necesitamos tambien un post put y delete que acepten directamente las uris, sin la parte invariante
// en caso de que sea necesario los datos en formato json

// En caso de que el status de la respuesta sea distinto de 200 debe reportarlo y terminar la ejecucion. 

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;

public class http {

    private static String usr;
    private static String passwd;


    // Abrir la comunicacion
    static HttpClient cliente;


    public static void EstablecerConexion(String usr, String passwd) {

        // Me pasan las credenciales, cosa que voy a almacenar como variable global privada solo para mi clase
    http.usr= usr;
    http.passwd = passwd;
            cliente = HttpClient.newHttpClient();
            // establezco la conexion

    }

    public static void Post(String uri1, String json_data) {
        String body = json_data;
        // String body = "{\"id_pedido\":1,\"importe\":12.22}";
        String usr_psw = "pareja19:zfTEpynxL";
        String credenciales = Base64.getEncoder().encodeToString(usr_psw.getBytes(StandardCharsets.UTF_8));
        String uri = "http://localhost/petrest/facturas";

        // Enviar la petición
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Authorization", "Basic " + credenciales)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        // Recoger la respuesta
        HttpResponse<String> respuesta = null;
        try {
            respuesta = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(666);
        }

        // Procesar el estado de la respuesta
        int status = respuesta.statusCode();
        if (status != 200) {
            System.err.println("Status=" + status);
            System.exit(666);
        }

        // Procesar el cuerpo de la respuesta
        System.out.println(respuesta.body());
    }


    public static void Init(String usr, String pasw) {

        // Establece las credenciales para las peticiones necesarias.

    }

    // Por lo que yo tengo entendido entonces esto
    // Hay que usarlo, con los metodos base, que tenemos para que
    // cuando necesitemos alguna cosa, modifiquemos la string,pero solo la parte
    // necesaria

    // para que la clase facturas
    // imprima la listas de ids de cliente

    public static JSONArray Get_array(String uri1) {

        // Enviar la petición
        String uri = "http://localhost/petrest" + uri1;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        // Recoger la respuesta
        HttpResponse<String> respuesta = null;
        try {
            respuesta = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(666);
        }

        // Procesar el estado de la respuesta
        int status = respuesta.statusCode();
        if (status != 200) {
            System.err.println("Status=" + status);
            System.exit(666);

        }

        // Procesar el cuerpo de la respuesta
        System.out.println(respuesta.body());


        // Parseo de la respuesta a JSONArray
        JSONArray jsonArray = null;
        try {
            JSONParser parser = new JSONParser();
            jsonArray = (JSONArray) parser.parse(respuesta.body());
        } catch (ParseException e) {
            e.printStackTrace();
            System.exit(666);  // Manejo de la excepción de parseo
        }


        return jsonArray;
    }

    public static JSONObject Get_Object(String uri1) {
        // Enviar la petición
        String uri = "http://localhost/petrest" + uri1;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        // Recoger la respuesta
        HttpResponse<String> respuesta = null;
        try {
            respuesta = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(666);
        }

        // Procesar el estado de la respuesta
        int status = respuesta.statusCode();
        if (status != 200) {
            System.err.println("Status=" + status);
            System.exit(666);

        }

        // Procesar el cuerpo de la respuesta
        //System.out.println(respuesta.body());


        JSONObject obj = (JSONObject) JSON_PARSER.Interpretar_json(respuesta.body());
        JSONObject Objeto = new JSONObject(obj);
        //System.out.println(JSON_PARSER.SEPARADOR + Objeto);

        return Objeto;
    }

    public static void Delete(String uri1) {
        String usr_psw = "Pareja19:zfTEpynxL";  // Username and password for basic auth
        String credenciales = Base64.getEncoder().encodeToString(usr_psw.getBytes(StandardCharsets.UTF_8));
        String uri = "http://localhost/petrest/facturas/" +uri1;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Authorization", "Basic " + credenciales)  // Adding basic auth header
                .header("Content-Type", "application/json")
                .DELETE()
                .build();

        HttpResponse<String> respuesta = null;
        try {
            respuesta = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(666); // Exit with error code on failure
        }

        // Check the response status code
        int status = respuesta.statusCode();
        if (status != 200) { // Check for HTTP 200 status code
            System.err.println("Status=" + status);
            System.exit(666); // Exit with error code if status is not 200
        }

        // Print the response body
        System.out.println(respuesta.body());
    }

    // La parte de URI, aqui en el put, sera el id de factura
    public static void Put(String uri1, String json_data) {

        String body = json_data;
        // String body = "{\"id_pedido\":1,\"importe\":12.22}";
        String usr_psw = "pareja19:zfTEpynxL";
        String credenciales = Base64.getEncoder().encodeToString(usr_psw.getBytes(StandardCharsets.UTF_8));
        String uri = "http://localhost/petrest/facturas/"+ uri1;



        // Enviar la petición
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Authorization", "Basic " + credenciales)
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(body))
                .build();

        // Recoger la respuesta
        HttpResponse<String> respuesta = null;
        try {
            respuesta = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(666);
        }

        // Procesar el estado de la respuesta
        int status = respuesta.statusCode();
        if (status != 200) {
            System.err.println("Status=" + status);
            System.exit(666);
        }

        // Procesar el cuerpo de la respuesta
        System.out.println(respuesta.body());


    }

    // Declaro mi propia clase JSON, para que me devuelva los objetos

 public static String ParseStringPOST(int id_pedido, double importe)
    {
        HashMap<String,Object> mapa = new HashMap<>();
        mapa.put("id_pedido",id_pedido);
        mapa.put("importe",importe);

        JSONObject jo = new JSONObject(mapa);
        String json = jo.toString();
        System.out.println(json);
        return jo.toString();
    }
    public static String ParseStringPUT(float descuento, float base,float iva, float total)
    {
        HashMap<String,Object> mapa = new HashMap<>();
        mapa.put("descuento",descuento);
        mapa.put("base",base);
        mapa.put("iva",iva);
        mapa.put("total",total);

        JSONObject jo = new JSONObject(mapa);
        String json = jo.toString();
        System.out.println(json);
        return jo.toString();
    }




}