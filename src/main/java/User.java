import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.*;

public class User extends Person{


    private ArrayList<Person> persons = new ArrayList<>();
    private ArrayList<Integer> topfive = new ArrayList<>();
    String url;

    public User(String url) {
        super();
        this.url = url;
    }

    public void initData() {
        persons = removeBad(getPersons(url));
        topfive = bestMatches(normalizeData(persons));
    }

    public ArrayList<Person> removeBad(ArrayList<Person> lop) {
        int gender = getSpec()[2];
        int preference = getSpec()[3];
        ArrayList<Person> badpersons = new ArrayList<Person>();

        for(Person pe : lop) {
            if(!((gender == pe.getSpec()[3]) && (preference == pe.getSpec()[2])))
                badpersons.add(pe);
        }

        for(Person x : badpersons) {
            lop.remove(x);
        }

        return lop;
    }

    public ArrayList<Person> getPersons(String url) {
        try {
            NetClientGet client = new NetClientGet();
            String data = client.getData(url);
            JSONParser parser = new JSONParser(data);
            ArrayList<Person> lop = new ArrayList<Person>();

            for (Iterator<Map.Entry<String, JsonNode>> it = parser.jsonNode.fields(); it.hasNext(); ) {
                Map.Entry<String, JsonNode> p = it.next();
                lop.add(parser.createPerson(p.getValue().toString()));
            }
            return lop;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public double[] normalizeData(ArrayList<Person> lop) {
        double[] normaldistances = new double[lop.size()];

        for(int i=0; i<lop.size(); i++) {
            double maxDist = (getWeight()[0] + getWeight()[1] + getWeight()[2] + getWeight()[3] * Math.pow(21*36, 0.5)/21 + getWeight()[4])
                    + lop.get(i).getWeight()[0] + lop.get(i).getWeight()[1] + lop.get(i).getWeight()[2] + lop.get(i).getWeight()[3] * Math.pow(21*36, 0.5)/21 + lop.get(i).getWeight()[4];
            normaldistances[i]= (1- (computeDistance(this, lop.get(i)) + computeDistance(lop.get(i), this)))/maxDist;
        }

        return normaldistances;
    }


    public ArrayList<Integer> bestMatches(double[] distances)
    {
        ArrayList<Double> distanceslist = new ArrayList<Double>();
        ArrayList<Integer> topfiveindex = new ArrayList<Integer>();

        // adding elements of array to arrayList.
        for (double dist : distances)
            distanceslist.add(dist);

        for(int i=4; i>=0; i--) {
            double max = Collections.max(distanceslist);
            int maxindex = distanceslist.indexOf(max);
            topfiveindex.add(maxindex);
            distanceslist.set(maxindex, -1.0);
        }

        return topfiveindex;

    }



    public double computeDistance(Person a, Person b)
    {
        double dist = ageDist(a.getAge(), b.getAge(), a.getSpec()[0], a.getSpec()[1], a.getWeight()[0]) +
                coopDist(a.getCoop(),b.getCoop(),a.getWeight()[1]) +
                locationDist(a.getLocation(),b.getLocation(),a.getWeight()[2]) +
                scheduleDist(a.getSchedule(),b.getSchedule(),a.getWeight()[3]) +
                futureDist(a.getFuture(),b.getFuture(),a.getWeight()[4]);

        return dist;
    }

    public double ageDist(int a, int b, int range, int specification, double weight)
    {//specification is either 0, 1, or 2, which represents must be at least younger, at least older, or do not care
        if(specification==0)
        {
            if((b >= a - range) && (b <= a))
                return weight;
            else
                return 0;
        }
        else if(specification==1)
        {
            if((b <= a + range) && (b >= a))
                return weight;
            else
                return 0;
        }
        else
            return weight;
    }

    public double coopDist(int a, int b, double weight)
    {
        if(a==b)
            return weight;
        else
            return 0;
    }

    public double locationDist(int a, int b, double weight)
    {
        if((a==0) && (b==0))
            return weight;
        else if((a==1) && (b==1))
            return weight/2;
        else
            return 0;
    }

    public double scheduleDist(int[] a, int[] b, double weight)
    {
        int counter=0;
        for(int i=0; i<a.length; i++)
        {
            counter+= Math.pow(a[i]-b[i],2);
        }
        return Math.pow(counter, 0.5) * weight/21;
    }

    public double futureDist(int a, int b, double weight)
    {
        return Math.abs(a-b) * weight;
    }

    public ArrayList<Integer> getTopfive() {
        return topfive;
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public void setTopfive(ArrayList<Integer> topfive) {
        this.topfive = topfive;
    }
}
