import org.json.simple.JSONObject;

 public class Cliente {
     public int id;
     public String nombre;
     public String cif;
     public String Direccion;
     public float descuento;

     public Cliente(JSONObject obj) {
         id = (int) (long) obj.get("id");
         nombre = (String) obj.get("nombre");
         cif = (String) obj.get("cif");
         Direccion = (String) obj.get("Direccion");
         descuento = (float) (double) obj.get("descuento");

     }

     @Override
     public String toString() {
         String str = "";
         str += "id=" + id + "\n";
         str += "nombre=" + nombre + "\n";
         str += "cif=" + cif + "\n";
         str += "Direccion=" + Direccion + "\n";
         str += "descuento=" + descuento + "\n";

         return (str);
     }


 }

