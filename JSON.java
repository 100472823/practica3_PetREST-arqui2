import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.util.HashMap;
import java.util.ArrayList;

public class JSON {
    private static final String SEPARADOR = "························\n";
    private static final String JSON_OBRAS = "["
            + "{"
            + "\"titulo\":\"Hamlet\","
            + "\"autor\":\"William Shakespeare\","
            + "\"ano\":1601,"
            + "\"precio\":9.98"
            + "},"
            + "{"
            + "\"titulo\":\"La Divina Comedia\","
            + "\"autor\":\"Dante\","
            + "\"ano\":1321,"
            + "\"precio\":16.95"
            + "},"
            + "{"
            + "\"titulo\":\"La vida es Sueño\","
            + "\"autor\":\"Calderon\","
            + "\"ano\":1635,"
            + "\"precio\":8.24"
            + "}"
            + "]";

    private static final String JSON_TENORIO = "{"
            + "\"titulo\":\"Don Juan Tenorio\","
            + "\"autor\":\"Zorrilla\","
            + "\"ano\":1844,"
            + "\"precio\":9.45"
            + "}";

    public static void main(String[] args) {
        switch (args[0]) {
            case "p":
                Publicar();
                break;
            case "o":
                Interpretar_obra(JSON_TENORIO);
                break;
            case "c":
                Interpretar_coleccion(JSON_OBRAS);
                break;
        }
    }

    private static void Interpretar_obra(String json_string) {
        JSONObject obj = (JSONObject) Interpretar_json(json_string);
        Obra obra = new Obra(obj);
        System.out.println(SEPARADOR + obra);
    }

    private static void Interpretar_coleccion(String json_string) {
        JSONArray array = (JSONArray) Interpretar_json(json_string);
        JSONObject objeto;
        int n = array.size();
        ArrayList<Obra> obras = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            objeto = (JSONObject) array.get(i);
            obras.add(new Obra(objeto));
        }

        for (Obra obra : obras)
            System.out.println(SEPARADOR + obra);
    }

    private static void Publicar() {
        HashMap<String, Object> mapa = new HashMap<>();
        mapa.put("titulo", "Esperando a Godot");
        mapa.put("autor", "Samuel Becket");
        mapa.put("ano", 1955);
        mapa.put("precio", 7.55);

        JSONObject jo = new JSONObject(mapa);
        String json = jo.toString();
        System.out.println(json);
    }

    private static Object Interpretar_json(String json_string) {
        JSONParser parser = new JSONParser();
        Object obj = null;

        try {
            obj = parser.parse(json_string);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(666);
        }

        return (obj);
    }
}

class Obra {
    public String titulo;
    public String autor;
    public int ano;
    public float precio;

    public Obra(JSONObject obj) {
        titulo = (String) obj.get("titulo");
        autor = (String) obj.get("autor");
        ano = (int) (long) obj.get("ano");
        precio = (float) (double) obj.get("precio");

    }

    public String toString() {
        String str = "";
        str += "título=" + titulo + "\n";
        str += "autor=" + autor + "\n";
        str += "ano=" + ano + "\n";
        str += "precio=" + precio + "\n";

        return (str);
    }
}
