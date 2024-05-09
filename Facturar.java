
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.util.Locale;

public class Facturar {

    // Necesito un metodo
    // que llame a geturi
    // y pasarle solo la parte que tiene que modificar

    public static int JSONtoInt(JSONObject jsonObject) {
        // Obtener el valor de id_factura asegurándose que se maneja como Long
        long idFacturaLong = (Long) jsonObject.get("id_factura");

        // Convertir el valor de long a int
        int idFactura = (int) idFacturaLong;

        // Imprimir el valor
      //  System.out.println("El ID de la factura es: " + idFactura);
        return idFactura;
    }


    public static JSONObject convertirAJson(float importe, float descuento, float base, float iva, float total, float ivanum, int id_pedido) {
        JSONObject obj = new JSONObject();
        obj.put("importe", importe);
        obj.put("descuento", descuento);
        obj.put("base", base);
        obj.put("iva", iva);
        obj.put("total", total);
        obj.put("ivanum", ivanum);
        obj.put("id_pedido", id_pedido);
        return obj;
    }

    public static JSONObject CalcularFactura(int id_pedido, Cliente cliente) {

        // Calculamos el Importe de la Factura.

        float importe = 0;
        float descuento = 0;
        float base = 0;
        float iva = 0;
        float total = 0;
        float ivanum = 0.21F;


        int[] listaItems = Requests.Lista("/items");


        for (int i = 0; i < listaItems.length; i++) {


            Item ItemPedido = Requests.Item(listaItems[i]);
            if (id_pedido == ItemPedido.id_pedido) {

                Articulo ArticuloNuevo = Requests.Articulo(ItemPedido.id_articulo);
                // Ya tengo el articulo actual que voy a facturar

                importe += ArticuloNuevo.precio * ItemPedido.cantidad;
             //   System.out.println(importe);


            }
            // Una vez que termino de calcular el todal del improrte.

        }
        descuento = importe * cliente.descuento / 100;
        base = importe - descuento;
        iva = base * ivanum;
        total = iva + base;

        JSONObject json = convertirAJson(importe, descuento, base, iva, total, ivanum, id_pedido);

     //   System.out.println(json);
        //Factura FacturaGenerada = new Factura(json);

        return json;

    }

    public static void main(String[] args) {
        http.EstablecerConexion("Pareja19", "zfTEpynxL");


        /**********************GENERAR FACTURA ************************************************/


        // Quiero probar que puedo, descargarme los clientes del 1 al 5

        http.Delete("/6");

        int[] PedidosLista = Requests.Lista("/pedidos");

        // Se cuantos pedidos tengo, tendre que procesarlos

        // Recorrerme la lista de pedidos


        for (int i = 0; i < PedidosLista.length; i++) {

            // Creo un objeto nuevo, del pedido que voy a procesar

            Pedido PedidoNuevo = Requests.Pedido(PedidosLista[i]);


            // En este pedido Nuevo, tengo los atributos necesarios de pedidoss, que son
            // Como aqui tengo el id de cliente
            // Solicito obtener el objeto cliente, de este pedido para saber quien es

            Cliente ClienteNuevo = Requests.Cliente(PedidoNuevo.id_cliente);



            JSONObject Generada = CalcularFactura(PedidoNuevo.id, ClienteNuevo);

            // JSON OBJECT A POST
            String Factura = http.parseStringPOST(Generada);


            // JSON OBJECT a PUT

            String FacturaPut = http.ParseStringPUT(Generada);

            JSONObject idFacturaGenerada = http.Post("Hola", Factura);

            int idFactura = JSONtoInt(idFacturaGenerada);

            http.Put(String.valueOf(idFactura), FacturaPut);


        }


        /**********************GENERAR FACTURA ************************************************/

        /*********************PROCESAR E IMPRIMIR FACTURA ***********************************/

        Locale.setDefault(new Locale("es", "ES")); // Establece el Locale a España para usar comas

        int[] FacturasLista = Requests.Lista("/facturas");
        //System.out.println("Numero de facturas" + FacturasLista.length);


        // Mirar para recorrer el tema de las Facturas Listas.
        // Recorro todas las facturas que tengo por que tengo que, procesarlas
        int length1 = FacturasLista.length;

        for (int i = 0; i < length1; i++) {


            Factura FacturaNueva = Requests.Factura(FacturasLista[i]);

            // En esta factura tengo el id de pedido

            Pedido PedidoAsociado = Requests.Pedido(FacturaNueva.id_pedido);

            Cliente ClienteAsociado = Requests.Cliente(PedidoAsociado.id_cliente);
            System.out.println("######################################################################################");
            System.out.println("FACTURA");
            System.out.printf("%-15s %s\n","Fecha:",PedidoAsociado.formatDate(PedidoAsociado.fecha));
            System.out.println();
            System.out.printf("%-15s %s\n","Cliente:",ClienteAsociado.nombre);
            System.out.printf("%-15s %s\n","CIF",ClienteAsociado.cif);
            System.out.printf("%-15s %s\n","Dirección:",ClienteAsociado.Direccion);
            System.out.println();
            System.out.printf("%-10s %-50s %6s %8s %8s\n","Referencia","Nombre","Precio","Cantidad","Valor");
            System.out.println("--------------------------------------------------------------------------------------");
            // Encabezados de las columnas
            // Encabezados de las columnas
            // Encabezados de las columnas



            int[] listaItems = Requests.Lista("/items");
            for (int i1 = 0; i1 < listaItems.length; i1++) {

                Item ItemPedido = Requests.Item(listaItems[i1]);
                if (PedidoAsociado.id == ItemPedido.id_pedido) {

                    Articulo ArticuloNuevo = Requests.Articulo(ItemPedido.id_articulo);
                    System.out.printf(
                            Locale.getDefault(),
                            "%-10s %-50s %6.2f %8d %8.2f\n"
                            ,ArticuloNuevo.referencia,ArticuloNuevo.nombre
                            ,ArticuloNuevo.precio,ItemPedido.cantidad, ArticuloNuevo.precio*ItemPedido.cantidad);

                }
            }

            System.out.println("                                                               -----------------------");
            System.out.printf("%75s %10.2f\n","Importe",FacturaNueva.importe);
            System.out.printf("%75s %10.2f\n","Descuento",FacturaNueva.descuento);
            System.out.printf("%75s %10.2f\n","Base",FacturaNueva.base);
            System.out.printf("%75s %10.2f\n","IVA",FacturaNueva.iva);
            System.out.println("                                                               -----------------------");
            System.out.printf("%75s %10.2f\n","TOTAL",FacturaNueva.total);


            }


        }

    }



