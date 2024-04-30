import org.json.simple.JSONObject;

public class Articulo {
    public int id;
    public String referencia;
    public String nombre;
    public float precio;

    public Articulo(JSONObject obj) {
        id = (int) (long) obj.get("id");
        referencia = (String) obj.get("referencia");
        nombre = (String) obj.get("nombre");
        precio = (float) (double) obj.get("precio");

    }

    @Override
    public String toString() {
        String str = "";
        str += "id=" + id + "\n";
        str += "referencia=" + referencia+ "\n";
        str += "nombre=" + nombre + "\n";
        str += "precio=" + precio + "\n";


        return (str);
    }


}

