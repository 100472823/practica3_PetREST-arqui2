import org.json.simple.JSONObject;
import java.util.Date;

public class Pedido {
    public int id;
    public int id_cliente;
    //public Date fecha;


    public Pedido(JSONObject obj) {
        id = (int) (long) obj.get("id");
        id_cliente = (int) (long) obj.get("id_cliente");
        //fecha = (Date) obj.get("fecha");


    }

    @Override
    public String toString() {
        String str = "";
        str += "id=" + id + "\n";
        str += "id_cliente=" + id_cliente+ "\n";
       // str += "fecha=" + fecha+ "\n";



        return (str);
    }


}

