package practice10;


import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int number;
    private List<Student> members = new ArrayList<>();
    private Student leader;
    private Teacher teacher;

    public Klass(int number) {
        this.number = number;
    }

    public Teacher getTeacher() { return teacher; }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName() {
        return "Class " + number;
    }

    public void assignLeader(Student student) {
        if (members.contains(student)) {
            leader = student;
            if (teacher != null) {
                teacher.notifyNewLeader(student, this);
            }
        }
        else {
            System.out.println("It is not one of us.");
        }
    }

    public Student getLeader() {
        return leader;
    }

    public void appendMember(Student student) {
        members.add(student);
        if (teacher != null) {
            teacher.notifyNewMember(student, this);
        }
    }
}

