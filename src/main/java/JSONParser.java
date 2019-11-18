import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class JSONParser {
    ObjectMapper objectMapper;
    String json;
    JsonNode jsonNode;

    public JSONParser(String json) throws JsonProcessingException {
        this.json = json;
        objectMapper = new ObjectMapper();
        jsonNode = objectMapper.readTree(json);
    }

    public Person createPerson(String data) {
        try {
            Person temp = objectMapper.readValue(data, Person.class);
            return temp;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
