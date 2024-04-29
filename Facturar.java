import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



public class Facturar {

    // Necesito un metodo
    // que llame a geturi
    // y pasarle solo la parte que tiene que modificar

    public static void main(String[] args) {
    http.EstablecerConexion("Pareja19","zfTEpynxL");

    // Quiero probar que puedo, descargarme los clientes del 1 al 5


       JSONArray ClientesList = http.Get_array("/clientes");
       for(int i = 0 ; i < ClientesList.size(); i++){

            System.out.println(JSON_PARSER.SEPARADOR + ClientesList.get(i));
        }



        System.out.println("Imprimirmos los 5 Primeros Clientes");

        for (int i =1; i<= 5 ; i++) {

           JSONObject Cliente = http.Get_Object("/clientes/" + i);

            System.out.println(JSON_PARSER.SEPARADOR + Cliente);

        }

        System.out.println("Imprimirmos los 5 Primeros Articulos");
        // Quiero probar que puedo, descargarme los articulos del 1 al 5

        for (int i =1; i<= 5 ; i++) {

            JSONObject Articulo = http.Get_Object("/articulos/" + i);

            System.out.println(JSON_PARSER.SEPARADOR + Articulo);

        }

        // Quiero probar que puedo, descargarme los pedidos del 1 al 5

        System.out.println("Imprimirmos los 5 Primeros Pedidos");

        for (int i =1; i<= 5 ; i++) {

            JSONObject Pedidos = http.Get_Object("/pedidos/" + i);

            System.out.println(JSON_PARSER.SEPARADOR + Pedidos);

        }
    // Imprimir los Items del Pedido 1.

        System.out.println("Imprimo los items del pedido ");
        JSONObject ItemsPedido = http.Get_Object("/items/" + 1);

        System.out.println(JSON_PARSER.SEPARADOR + ItemsPedido);

        // Se elimina todas las facturas
        http.Delete("6");

        // Crear una Nueva Factura con los id de pedido = 1, y con importe =1235.22
        int pedid4= 4; Double importe = 1235.22;
        String FacturaNueva = http.ParseStringPOST(pedid4, importe);

        // STRING FORMAT, EL JSON A PELO;


        //http.Post("hola", FacturaNueva);

        // Deberia de poder guardarme, el id de la factura.
        // Por que tengo que meterselo luego


        // Me falta de el ultimo post, donde genero la factura
        // poder guardarme el id, de factura que me devuelve


        // Para poder probarlo, se que tengo la factura creada, en el

        // Para crearme el string uri lo genero con parseStringPut

        float descuento = 123.52F;
        float base = 1111.70F;
        float iva = 223.46F;
        float total = 1345.16F;

        String ModificarFactura = http.ParseStringPUT(descuento, base, iva, total);

 //       http.Put("130",ModificarFactura);






    }

}
