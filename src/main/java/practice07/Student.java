package practice07;

public class Student extends Person {
    private final Klass klass;

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        return super.introduce() + " " + "I am a Student. I am " +
                (klass.getLeader() != null && klass.getLeader().equals(this)
                        ? "Leader of" : "at") + " Class " + klass.getNumber() + ".";
    }
}
