import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.util.HashMap;
import java.util.ArrayList;


public class JSON_PARSER {
    public static final String SEPARADOR = "························\n";


    public static void InterpretarObjetos(String json_string) {

    }

    private static void Interpretar_ARRAY(String json_string) {
        JSONArray array = (JSONArray) Interpretar_json(json_string);
        JSONObject objeto;
        int n = array.size();
        ArrayList<Cliente> Clientes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            objeto = (JSONObject) array.get(i);
            Clientes.add(new Cliente(objeto));
        }

        for (Cliente Cliente: Clientes)
            System.out.println(SEPARADOR + Cliente);
    }


    private static void Publicar()
    {
        HashMap<String,Object> mapa = new HashMap<>();
        mapa.put("titulo","Esperando a Godot");
        mapa.put("autor","Samuel Becket");
        mapa.put("ano",1955);
        mapa.put("precio",7.55);

        JSONObject jo = new JSONObject(mapa);
        String json = jo.toString();
        System.out.println(json);
    }


    public static Object Interpretar_json(String json_string)
    {
        JSONParser parser = new JSONParser();
        Object obj=null;

        try {obj = parser.parse(json_string);}
        catch(Exception e){e.printStackTrace(); System.exit(666);}

        return (obj);
    }
}




