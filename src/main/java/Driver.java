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
        p.setLocation(0);
        p.setName("Saahil Kumar");
        p.setNuid(0);
        p.setSchedule(new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3});
        p.setSpec(new int[]{1, 2, 1, 2});
        p.setWeight(new double[]{0.01, 0.1, 0.4, 0.3, 0.19});
        User user = new User("https://tri-op.firebaseio.com/Person.json", p);
        ArrayList<Integer> indexes = user.getTopfive();
        for (int i : indexes) {
            Person temp = user.getPersons().get(i);
            System.out.println("Name: " + temp.getName());
            System.out.println("Age: " + temp.getAge());
            System.out.println("Co-op: " + temp.getCoop());
            System.out.println("Future: " + temp.getFuture());
            System.out.println("Location: " + temp.getFuture());
            System.out.println("-------------------");
        }
    }
}
