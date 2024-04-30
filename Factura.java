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
        id = (int) (long) obj.get("id");
        id_pedido = (int) (long) obj.get("id_pedido");
        importe = (float) (long) obj.get("importe");
        descuento = (float) (long) obj.get("descuento");
        base = (float) (long) obj.get("base");
        iva = (float) (long) obj.get("iva");
        total = (float) (long) obj.get("total");


    }

    @Override
    public String toString() {
        String str = "";
        str += "id=" + id + "\n";
        str += "id_pedido=" + id_pedido+ "\n";
        str += "base=" + base + "\n";
        str += "descuento=" + descuento + "\n";
        str += "iva=" + iva + "\n";
        str += "total=" + total + "\n";




        return (str);
    }


}

