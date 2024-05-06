import org.json.simple.JSONObject;

public class Factura {
    public int id;
    public int id_pedido;
    public float importe;
    public float  descuento;
    public float  base;
    public float  iva;
    public float  total;

    public Factura(JSONObject obj) {
        // Asegurarse de que cada campo se extrae correctamente del JSONObject
        this.id = ((Number) obj.get("id")).intValue();  // Seguro para cualquier subclase de Number
        this.id_pedido = ((Number) obj.get("id_pedido")).intValue();
        this.importe = ((Number) obj.get("importe")).floatValue();
        this.descuento = ((Number) obj.get("descuento")).floatValue();
        this.base = ((Number) obj.get("base")).floatValue();
        this.iva = ((Number) obj.get("iva")).floatValue();
        this.total = ((Number) obj.get("total")).floatValue();

    }


    public String toStringPOST() {
        String str = "";

        str += "id_pedido=" + id_pedido+ "\n";
        str += "importe=" + total + "\n";

        return (str);
    }

    public String toStringPUT() {
        String str = "";

        str += "base=" + base + "\n";
        str += "descuento=" + descuento + "\n";
        str += "iva=" + iva + "\n";
        str += "total=" + total + "\n";





        return (str);
    }

    public static void ImprimirFactura(Cliente cliente, Pedido pedido, Factura factura) {
        System.out.println("#################################################");
        System.out.println("FACTURA");
        System.out.println("Fecha: 03-02-2023");
        System.out.println();
        System.out.println("Cliente: " + cliente);
        System.out.println("CIF: " + "cif");
        System.out.println("Dirección: " + "direccion");
        System.out.println();
        System.out.println("Referencia\tNombre\t\t\t\t\tPrecio\tCantidad\tValor");


        // Calcular total de cada item y subtotal
        //for (String[] item : "items") {
          //  double precio = Double.parseDouble(item[2]);
        //    int cantidad = Integer.parseInt(item[3]);
            //double valor = precio * cantidad;
           // "subtotal" += valor;
      //      System.out.printf("%s\t%s\t%s\t%s\t\t%.2f\n", item[0], item[1], item[2], item[3], valor);
      //  }


        System.out.println("-------------------------------------------------");
        System.out.printf("Importe: %.2f\n", "subtotal");
        System.out.printf("Descuento: %.2f\n", "descuento");
        System.out.printf("Base: %.2f\n", "base");
        System.out.printf("IVA: %.2f\n", "iva");
        System.out.printf("TOTAL: %.2f\n", "total");
        System.out.println("#################################################");


    }

}

