package practice10;

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
        if (klass.getLeader() != null && klass.getLeader().equals(this)) {
            return super.introduce() + " I am a Student. I am Leader of Class " + klass.getNumber() + ".";
        }
        return super.introduce() + " I am a Student. I am at Class " + klass.getNumber() + ".";
    }
}
