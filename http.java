// Crea la clase http para agrupar las peticiones httpp. 
// Metodo get, para obtener los array de objetos JSON Array, y el get para objetos sueltos JSON object. 

// Necesitamos tambien un post put y delete que acepten directamente las uris, sin la parte invariante
// en caso de que sea necesario los datos en formato json

// En caso de que el status de la respuesta sea distinto de 200 debe reportarlo y terminar la ejecucion. 

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class http {

    // Abrir la cumunicacion
    static HttpClient cliente;

    public static void main(String[] args) {
        cliente = HttpClient.newHttpClient();
        switch (args[0]) {
            case "g":
                Get();
                break;
            case "p":
                Post();
                break;
        }
    }

    private static void Get() {
        // Enviar la petición
        String uri = "http://10.202.20.125/petrest/articulos/6";
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
    }

    private static void Post() {
        String body = "{\"id_pedido\":1,\"importe\":12.22}";
        String usr_psw = "pareja19:zfTEpynxL";
        String credenciales = Base64.getEncoder().encodeToString(usr_psw.getBytes(StandardCharsets.UTF_8));
        String uri = "http://10.202.20.125/petrest/facturas";

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
        String uri = "http://10.202.20.125/petrest" + uri1;
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

        return null;
    }

    public static JSONObject Get_Object(String uri) {

        return null;
    }

    public static void Delete(String uri) {

    }

    public static void Put(String uri, String json_data) {

    }

}