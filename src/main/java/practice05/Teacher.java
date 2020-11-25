package practice05;

public class Teacher extends Person {
    private int klass;
    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, int klass) {
        super(name, age);
        this.klass = klass;
    }

    public int getKlass() {
        return klass;
    }

    public String introduce() {
        String strClass = klass != 0 ? "Class " + klass : "No Class";
        return super.introduce() + " " + "I am a Teacher. I teach " + strClass + ".";
    }
}
