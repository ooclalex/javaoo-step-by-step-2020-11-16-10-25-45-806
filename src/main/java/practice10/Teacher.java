package practice10;

import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private List<Klass> klasses;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, List<Klass> klasses) {
        super(id, name, age);
        this.klasses = klasses;
        klasses.forEach(k -> k.setTeacher(this));
    }

    public List<Klass> getKlass() {
        return klasses;
    }

    @Override
    public String introduce() {
        String strClass;
        if (klasses == null || klasses.size() == 0) {
            strClass = "No Class";
        }
        else {
            strClass = "Class ";
            strClass += klasses.stream().map(Klass::getNumber).map(String::valueOf).collect(Collectors.joining(", "));
        }
        return super.introduce() + " I am a Teacher. I teach " + strClass + ".";
    }

    public String introduceWith(Student student) {
        StringBuilder intro = new StringBuilder(super.introduce());
        intro.append(" I am a Teacher. ");
        if (isTeaching(student)) {
            intro.append("I teach ").append(student.getName()).append(".");
        } else {
            intro.append("I don't teach ").append(student.getName()).append(".");
        }

        return intro.toString();
    }

    public boolean isTeaching(Student student) {
        return klasses.stream().anyMatch(i -> i.getNumber() == student.getKlass().getNumber());
    }

    public List<Klass> getClasses() {
        return klasses;
    }

    public void notifyNewMember(Student student, Klass klass) {
        System.out.printf("I am %s. I know %s has joined %s.\r\n",
                this.getName(), student.getName(), klass.getDisplayName());
    }

    public void notifyNewLeader(Student student, Klass klass) {
        System.out.printf("I am %s. I know %s become Leader of %s.\r\n",
                this.getName(), student.getName(), klass.getDisplayName());
    }
}
