package models;

import java.util.ArrayList;
import java.util.List;

public class Reader extends Person {
    private List<Book> borrowedBooks;

    public Reader(String name, int id) {
        super(name, id);
        this.borrowedBooks = new ArrayList<>();

    }
    public void barrowBook(Book book){
        if (borrowedBooks.size()<5 && book.isAvailable()){
            borrowedBooks.add(book);
            book.updateStatus(false,getName());
            System.out.println(getName()+" kitabı ödünç alındı"+book.getTitle());

        }else {
            System.out.println("Kitabı ödünç alamazsınız. SInırı aştınız yada kitap müsait değil.");
        }
    }
    public void returnBook(Book book){
        if (borrowedBooks.contains(book)){
            borrowedBooks.remove(book);
            book.updateStatus(true,null);
            System.out.println(getName()+" kitabı geri iade etti"+ book.getTitle());
        }else {
            System.out.println("Bu kitap sizde değil");
        }


        }   @Override
        public void showInfo(){
            System.out.println("Okuyucu: " + getName() + " | ID: " + getId());
            System.out.println("Ödünç alınan kitaplar:");
            for (Book book : borrowedBooks) {
                System.out.println("- " + book.getTitle());
            }
    }
}
