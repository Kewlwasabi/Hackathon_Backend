import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Driver {
    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(18);
        p.setCoop(0);
        p.setFuture(0);
        p.setLocation(1);
        p.setName("Dumbass Ning");
        p.setNuid(0);
        p.setSchedule(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3});
        p.setSpec(new int[]{22, 1, 2, 1});
        p.setWeight(new double[]{0.3, 0, 0, 0, 0.7});
        User user = new User("https://tri-op.firebaseio.com/Person.json", p);
        System.out.println(user.getTopfive());
    }
}
