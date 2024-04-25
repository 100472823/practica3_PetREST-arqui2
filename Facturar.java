import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



public class Facturar {

    // Necesito un metodo
    // que llame a geturi
    // y pasarle solo la parte que tiene que modificar

    public static void main(String[] args) {
    http.EstablecerConexion("Pareja19","zfTEpynxL");

    // Quiero probar que puedo, descargarme los clientes del 1 al 5

        for (int i =1; i<= 5 ; i++) {

           JSONObject Cliente = http.Get_Object("/clientes/" + i);

            System.out.println(JSON_PARSER.SEPARADOR + Cliente);

        }


        // Quiero probar que puedo, descargarme los articulos del 1 al 5

        for (int i =1; i<= 5 ; i++) {

            JSONObject Articulo = http.Get_Object("/articulos/" + i);

            System.out.println(JSON_PARSER.SEPARADOR + Articulo);

        }

        // Quiero probar que puedo, descargarme los pedidos del 1 al 5

        for (int i =1; i<= 5 ; i++) {

            JSONObject Pedidos = http.Get_Object("/pedidos/" + i);

            System.out.println(JSON_PARSER.SEPARADOR + Pedidos);

        }
    // Imprimir los Items del Pedido 1.


        JSONObject ItemsPedido = http.Get_Object("/items/" + 1);

        System.out.println(JSON_PARSER.SEPARADOR + ItemsPedido);

        // Crear una Nueva Factura con los id de pedido = 1, y con importe =1235.22
        http.Post("hola", "hola");





    }

}
