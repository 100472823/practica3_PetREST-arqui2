import org.json.simple.JSONObject;

public class Item {
    public int id;
    public int id_pedido;
    public int id_articulo;
    public int  cantidad;

    public Item(JSONObject obj) {
        id = (int) (long) obj.get("id");
        id_pedido = (int) (long) obj.get("id_pedido");
        id_articulo = (int) (long) obj.get("id_articulo");
        cantidad = (int) (long) obj.get("cantidad");


    }

    @Override
    public String toString() {
        String str = "";
        str += "id=" + id + "\n";
        str += "id_pedido=" + id_pedido+ "\n";
        str += "id_articulo=" + id_articulo + "\n";
        str += "cantidad=" + cantidad + "\n";

        return (str);
    }


}

