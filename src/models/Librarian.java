package models;

public class Librarian extends Person {
    private String password;

    public Librarian(String name, int id, String password) {
        super(name, id);
        this.password = password;
    }

    public boolean verifyMember(MemberRecord member) {
        System.out.println(member.getName() + " doğrulandı.");
        return true;
    }

    public void issueBookToMember(Book book, MemberRecord member) {
        if (book.isAvailable()) {
            book.updateStatus(false, member.getName());
            member.issueBook();
            System.out.println("Kitap " + member.getName() + " adına ödünç verildi: " + book.getTitle());
        } else {
            System.out.println("Kitap zaten ödünç alınmış.");
        }
    }

    public void returnBookFromMember(Book book, MemberRecord member) {
        book.updateStatus(true, null);
        member.returnBook();
        System.out.println("Kitap iade alındı: " + book.getTitle());
    }
}
