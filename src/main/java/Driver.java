import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Driver {
    public static void main(String[] args) throws JsonProcessingException {
        NetClientGet client = new NetClientGet();
        String data = client.getData("https://tri-op.firebaseio.com/Person.json");
        JSONParser parser = new JSONParser(data);
        ArrayList<Person> persons = new ArrayList<Person>();

        for (Iterator<Map.Entry<String, JsonNode>> it = parser.jsonNode.fields(); it.hasNext(); ) {
            Map.Entry<String, JsonNode> p = it.next();
            persons.add(parser.createPerson(p.getValue().toString()));

        }
    }
}
