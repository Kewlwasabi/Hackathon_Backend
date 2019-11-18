import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Driver {
    public static void main(String[] args) {
        User user = new User("https://tri-op.firebaseio.com/Person.json");
        user.setAge(18);
        user.setCoop(0);
        user.setFuture(0);
        user.setLocation(0);
        user.setName("Saahil Kumar");
        user.setNuid(0);
        user.setSchedule(new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3});
        user.setSpec(new int[]{1, 2, 2, 1});
        user.setWeight(new double[]{0.01, 0.1, 0.4, 0.3, 0.19});
        user.initData();
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
