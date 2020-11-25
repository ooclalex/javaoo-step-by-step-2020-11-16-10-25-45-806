package practice07;

public class Teacher extends Person {
    private Klass klass;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        String strClass = klass != null ? "Class " + klass.getNumber() : "No Class";
        return super.introduce() + " I am a Teacher. I teach " + strClass + ".";
    }

    public String introduceWith(Student student) {
        StringBuilder intro = new StringBuilder(super.introduce());
        intro.append(" I am a Teacher. ");
        if (klass.equals(student.getKlass())) {
            intro.append("I teach ").append(student.getName()).append(".");
        } else {
            intro.append("I don't teach ").append(student.getName()).append(".");
        }

        return intro.toString();
    }
}