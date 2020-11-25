package practice06;

public class Student extends Person {
    private int klassNo;
    private Klass klass;

    public Student(String name, int age) {
        super(name, age);
    }

    public Student(String name, int age, int klass) {
        super(name, age);
        this.klassNo = klass;
    }

    public Student(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public String introduce() {
        return super.introduce() + " " + "I am a Student. I am at Class " + klass.getNumber() + ".";
    }
}
