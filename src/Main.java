
import models.*;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        System.out.println("📚 Kütüphane Yönetim Sistemine Hoşgeldiniz!");

        while (true) {
            // Menü Seçenekleri
            System.out.println("\n1 - Kitap Ekle");
            System.out.println("2 - Kitap Güncelle");
            System.out.println("3 - Kitap Sil");
            System.out.println("4 - Tüm Kitapları Listele");
            System.out.println("5 - Kategoriye Göre Kitap Listele");
            System.out.println("6 - Yazara Göre Kitap Listele");
            System.out.println("7 - Kitap Ödünç Al");
            System.out.println("8 - Kitap İade Et");
            System.out.println("9 - Okuyucu Ekle");
            System.out.println("10 - Kullanıcı Borcunu Görüntüle");
            System.out.println("0 - Çıkış");
            System.out.print("Seçiminizi yapın: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Buffer temizleme

            switch (choice) {
                case 1: // 📖 Kitap Ekle
                    System.out.println("Kitap türünü seçin:");
                    System.out.println("1 - Normal Kitap");
                    System.out.println("2 - Dergi (Journal)");
                    System.out.println("3 - Ders Kitabı (StudyBook)");
                    System.out.println("4 - Magazin (Magazine)");
                    System.out.print("Seçiminizi girin: ");
                    int bookType = scanner.nextInt();
                    scanner.nextLine(); // Buffer temizleme

                    System.out.print("Kitap Adı: ");
                    String title = scanner.nextLine();
                    System.out.print("Yazar: ");
                    String author = scanner.nextLine();
                    System.out.print("Kategori: ");
                    String category = scanner.nextLine();
                    System.out.print("Baskı Bilgisi: ");
                    String edition = scanner.nextLine();

                    Book newBook = null;

                    switch (bookType) {
                        case 1: // Normal Kitap
                            newBook = new Book(library.getBooks().size() + 1, title, author, category, edition, new Date());
                            break;

                        case 2: // Dergi (Journal)
                            System.out.print("Yayıncı Adı: ");
                            String publisher = scanner.nextLine();
                            newBook = new Journals(library.getBooks().size() + 1, title, author, category, edition, new Date(), publisher);
                            break;

                        case 3: // Ders Kitabı (Study Book)
                            System.out.print("Ders Konusu: ");
                            String subject = scanner.nextLine();
                            newBook = new StudyBooks(library.getBooks().size() + 1, title, author, category, edition, new Date(), subject);
                            break;

                        case 4: // Magazin (Magazine)
                            System.out.print("Sayı Numarası: ");
                            int issueNumber = scanner.nextInt();
                            scanner.nextLine();
                            newBook = new Magazines(library.getBooks().size() + 1, title, author, category, edition, new Date(), issueNumber);
                            break;

                        default:
                            System.out.println("⚠ Geçersiz seçim! Normal kitap olarak ekleniyor.");
                            newBook = new Book(library.getBooks().size() + 1, title, author, category, edition, new Date());
                            break;
                    }

                    library.addBook(newBook);
                    break;

                case 2: // Kitap Güncelle
                    System.out.print("Güncellenecek Kitap ID: ");
                    int updateID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Yeni Ad: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Yeni Yazar: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Yeni Kategori: ");
                    String newCategory = scanner.nextLine();
                    System.out.print("Yeni Baskı: ");
                    String newEdition = scanner.nextLine();
                    library.updateBookInfo(updateID, newTitle, newAuthor, newCategory, newEdition);
                    break;

                case 3: // Kitap Sil
                    System.out.print("Silmek istediğiniz kitabın ID'sini girin: ");
                    int removeID = scanner.nextInt();
                    library.removeBook(removeID);
                    break;

                case 4: //  Tüm Kitapları Listele
                    library.listAllBooks();
                    break;

                case 5: //  Kategoriye Göre Kitap Listele
                    System.out.print("Kategori adı: ");
                    String searchCategory = scanner.nextLine();
                    library.listBooksByCategory(searchCategory);
                    break;

                case 6: //  Yazara Göre Kitap Listele
                    System.out.print("Yazar adı: ");
                    String searchAuthor = scanner.nextLine();
                    library.listBooksByAuthor(searchAuthor);
                    break;

                case 7: //  Kitap Ödünç Al
                    System.out.print("Ödünç almak istediğiniz kitabın ID'sini girin: ");
                    int borrowID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Okuyucu Adı: ");
                    String readerName = scanner.nextLine();

                    Book bookToBorrow = library.findBookById(borrowID);
                    Reader readerToBorrow = library.findReaderByName(readerName);

                    if (bookToBorrow != null && readerToBorrow != null) {
                        double price = 10.0; // Fiyat belirleme
                        readerToBorrow.borrowBook(bookToBorrow, price);
                    } else {
                        System.out.println("⚠ Kitap veya okuyucu bulunamadı!");
                    }
                    break;

                case 8: //  Kitap İade Et
                    System.out.print("İade etmek istediğiniz kitabın ID'sini girin: ");
                    int returnID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Okuyucu Adı: ");
                    String returnerName = scanner.nextLine();

                    Book bookToReturn = library.findBookById(returnID);
                    Reader readerToReturn = library.findReaderByName(returnerName);

                    if (bookToReturn != null && readerToReturn != null) {
                        double refund = 10.0; // Ücret iadesi
                        readerToReturn.returnBook(bookToReturn, refund);
                    } else {
                        System.out.println("⚠ Kitap veya okuyucu bulunamadı!");
                    }
                    break;

                case 9: //  Okuyucu Ekle
                    System.out.print("Okuyucu Adı: ");
                    String readerNameToAdd = scanner.nextLine();
                    System.out.print("Okuyucu ID'si: ");
                    int readerID = scanner.nextInt();
                    Reader newReader = new Reader(readerNameToAdd, readerID);
                    library.addReader(newReader);
                    break;

                case 10: //  Kullanıcı Borcunu Görüntüle
                    System.out.print("Borcunu görmek istediğiniz kullanıcının adını girin: ");
                    String userName = scanner.nextLine();
                    library.displayUserBalance(userName);
                    break;

                case 0: //  Çıkış
                    System.out.println("Sistem kapatılıyor...");
                    scanner.close();
                    return;

                default:
                    System.out.println("⚠ Geçersiz seçim! Tekrar deneyin.");
            }
        }
    }
}
