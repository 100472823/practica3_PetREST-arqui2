import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class Facturar {

    // Necesito un metodo
    // que llame a geturi
    // y pasarle solo la parte que tiene que modificar

    public static long JSONtoLong(JSONObject jsonObject) {

        // Parsear el string a un objeto JSON¡
        // Obtener el valor de id_factura
        long idFactura = (long) jsonObject.get("id_factura");

        // Imprimir el valor
        System.out.println("El ID de la factura es: " + idFactura);
        return idFactura;

    }

    public static void main(String[] args) {
        http.EstablecerConexion("Pareja19", "zfTEpynxL");

        // Quiero probar que puedo, descargarme los clientes del 1 al 5

     int[] ClientesLista=  Requests.Lista("/clientes");

        System.out.println("Imprimirmos los 5 Primeros Clientes");

        for (int i = 1; i <= 5; i++) {

            JSONObject Cliente = http.Get_Object("/clientes/" + i);

            Cliente ClientN = new Cliente(Cliente);

            System.out.println(JSON_PARSER.SEPARADOR + ClientN.toString());

        }

        JSONArray ArticuloList = http.Get_array("/articulos");
        for (int i = 0; i < ArticuloList.size(); i++) {

            System.out.println(JSON_PARSER.SEPARADOR + ArticuloList.get(i));
        }

        System.out.println("Imprimirmos los 5 Primeros Articulos");
        // Quiero probar que puedo, descargarme los articulos del 1 al 5

        for (int i = 1; i <= 5; i++) {

           Articulo ArticuloN=  Requests.Articulo(i);

            System.out.println(JSON_PARSER.SEPARADOR + ArticuloN.toString());

        }

        JSONArray PedidosList = http.Get_array("/pedidos");
        for (int i = 0; i < PedidosList.size(); i++) {

            System.out.println(JSON_PARSER.SEPARADOR + PedidosList.get(i));
        }

        // Quiero probar que puedo, descargarme los pedidos del 1 al 5

        System.out.println("Imprimirmos los 5 Primeros Pedidos");

        for (int i = 1; i <= 5; i++) {

            JSONObject Pedidos = http.Get_Object("/pedidos/" + i);

            Pedido PedidoN = new Pedido(Pedidos);

            System.out.println(JSON_PARSER.SEPARADOR + PedidoN.toString());

        }
        // Imprimir los Items del Pedido 1.

        System.out.println("Imprimo los items del pedido ");
        JSONObject ItemsPedido = http.Get_Object("/items/" + 1);

        Item ItemN = new Item(ItemsPedido);

        System.out.println(JSON_PARSER.SEPARADOR + ItemN.toString());


        // Se elimina todas las facturas
        http.Delete("/6");

        // Crear una Nueva Factura con los id de pedido = 1, y con importe =1235.22
        int pedid4 = 4;
        Double importe = 1235.22;


        String FacturaNueva = http.ParseStringPOST(pedid4, importe);

        JSONObject ReturnFactura = http.Post("hola", FacturaNueva);

        long Facturaid = JSONtoLong(ReturnFactura);

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

        http.Put(String.valueOf(Facturaid), ModificarFactura);

    }

}
