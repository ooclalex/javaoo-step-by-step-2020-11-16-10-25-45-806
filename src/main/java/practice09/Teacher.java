package practice09;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Teacher extends Person {
    private List<Klass> klasses;


    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, List<Klass> klasses) {
        super(id, name, age);
        this.klasses = klasses;
    }

    public List<Klass> getKlass() {
        return klasses;
    }

    @Override
    public String introduce() {
        String strClass = "Class ";
        if (klasses == null || klasses.size() == 0) {
            strClass = "No Class";
        }
        else {
            strClass = "Class ";
            strClass += klasses.stream().map(Klass::getNumber).map(String::valueOf).collect(Collectors.joining(", "));
//            for (Klass klass : klasses) {
//                strClass += klass.getNumber() + ", ";
//            }
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
}
