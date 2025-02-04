package models;

import java.util.Date;

public class Member_Record {
    private int memberID;
    private String name;
    private Date dateOfMembership;
    private int maxBookLimit;
    private int booksIssued;

    public Member_Record(int memberID, String name, Date dateOfMembership, int maxBookLimit) {
        this.memberID = memberID;
        this.name = name;
        this.dateOfMembership = dateOfMembership;
        this.maxBookLimit = maxBookLimit;
        this.booksIssued = 0;
    }

    public int getMemberID() {
        return memberID;
    }

    public String getName() {
        return name;
    }

    public void issueBook() {
        if (booksIssued < maxBookLimit) {
            booksIssued++;
        } else {
            System.out.println("Kitap limiti doldu!");
        }
    }

    public void returnBook() {
        if (booksIssued > 0) {
            booksIssued--;
        }
    }

    public int getBooksIssued() {
        return booksIssued;
    }
}
