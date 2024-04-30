import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Requests {





    public static int[] Lista(String uri) {


        // Con esta uri, que es la parte que varia
         JSONArray ResultJSON = http.Get_array(uri);

        int [] returnList = new int[ResultJSON.size()];

        // Con este array obtenido, queremos leer,
        // y guardar los indices en formato int;


        // Parsing each element of the JSONArray into the returnList as integers
        for (int i = 0; i < ResultJSON.size(); i++) {
            returnList[i] = ((Long) ResultJSON.get(i)).intValue();

        }
        return returnList;



    }

    public static Articulo Articulo(int id) {

            // No se si aqui quiere que compruebe en la lista
        /// Si el indice que me pasan es correcto o no

        JSONObject ArticuloNuevo = http.Get_Object("/articulos/"+id);
        //Con este id, obtenido, creamos el nuevo objeto articulo y devolvemos

        Articulo Articulo = new Articulo(ArticuloNuevo);

        return Articulo;


    }


    public static Cliente Cliente(int id) {

        // No se si aqui quiere que compruebe en la lista
        /// Si el indice que me pasan es correcto o no

        JSONObject ClienteNuevo = http.Get_Object("/clientes/"+id);
        //Con este id, obtenido, creamos el nuevo objeto articulo y devolvemos

        Cliente ClienteNuevoC = new Cliente(ClienteNuevo);

        return ClienteNuevoC ;

    }


    public static Item Item(int id) {

        // No se si aqui quiere que compruebe en la lista
        /// Si el indice que me pasan es correcto o no

        JSONObject ItemNuevo = http.Get_Object("/items/"+id);
        //Con este id, obtenido, creamos el nuevo objeto articulo y devolvemos

        Item ItemNuevoC = new Item(ItemNuevo);

        return ItemNuevoC ;


    }


    public static Pedido Pedido(int id) {

        // No se si aqui quiere que compruebe en la lista
        /// Si el indice que me pasan es correcto o no

        JSONObject PedidoNuevo = http.Get_Object("/pedidos/"+id);
        //Con este id, obtenido, creamos el nuevo objeto articulo y devolvemos

        Pedido ItemNuevoC = new Pedido(PedidoNuevo);

        return ItemNuevoC ;


    }









}
