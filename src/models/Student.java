package models;

import java.util.Date;

public class Student extends Member_Record {
    private String grade;

    public Student(int memberID, String name, Date dateOfMembership, int maxBookLimit, String grade) {
        super(memberID, name, dateOfMembership, maxBookLimit);
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public void issueBook() {
        System.out.println("Öğrenci: " + getName() + " kitap ödünç aldı.");
        super.issueBook();
    }
}
