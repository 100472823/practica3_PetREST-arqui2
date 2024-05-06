import org.json.simple.JSONObject;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Pedido {
    public int id;
    public int id_cliente;
    public Date fecha;


    public Pedido(JSONObject obj) {
        id = (int) (long) obj.get("id");
        id_cliente = (int) (long) obj.get("id_cliente");


        String fecha_str = (String) obj.get("fecha");
        SimpleDateFormat fecha_format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Parseando la cadena de fecha y asignándola al atributo 'fecha'
            fecha = fecha_format.parse(fecha_str);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    @Override
    public String toString() {
        String str = "";
        str += "id=" + id + "\n";
        str += "id_cliente=" + id_cliente+ "\n";
        str += "fecha=" + fecha+ "\n";



        return (str);
    }
    // Método para formatear la fecha en el formato deseado
    public String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

}

