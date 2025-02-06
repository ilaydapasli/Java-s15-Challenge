package models;

import java.util.Date;

public class Faculty extends MemberRecord {
    private String department;

    public Faculty(int memberID, String name, Date dateOfMembership, int maxBookLimit, String department) {
        super(memberID, name, dateOfMembership, maxBookLimit);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public void issueBook() {
        System.out.println("Fakülte Üyesi: " + getName() + " kitap ödünç aldı.");
        super.issueBook();
    }
}
