public class Person {
    private int age;
    private String name;
    private int nuid;
    private int coop;
    // 0: Spring
    // 1: Fall
    // 2: None
    private int location;
    // 0: In Boston
    // 1: Outside Boston
    private int[] schedule;
    private int future;
    // 0: Workforce
    // 1: Graduate
    // 2: PHD
    private double[] weight;
    private int[] spec;
    // 0: Range
    // 1: Specification

    public int getAge() {
        return age;
    }

    public int getCoop() {
        return coop;
    }

    public int getFuture() {
        return future;
    }

    public int getLocation() {
        return location;
    }

    public int getNuid() {
        return nuid;
    }

    public int[] getSchedule() {
        return schedule;
    }

    public int[] getSpec() {
        return spec;
    }

    public String getName() {
        return name;
    }

    public double[] getWeight() {
        return weight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCoop(int coop) {
        this.coop = coop;
    }

    public void setFuture(int future) {
        this.future = future;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNuid(int nuid) {
        this.nuid = nuid;
    }

    public void setSchedule(int[] schedule) {
        this.schedule = schedule;
    }

    public void setSpec(int[] spec) {
        this.spec = spec;
    }

    public void setWeight(double[] weight) {
        this.weight = weight;
    }
}