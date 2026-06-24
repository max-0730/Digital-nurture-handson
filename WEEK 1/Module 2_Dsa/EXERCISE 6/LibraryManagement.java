class Book {

    int bookId;
    String title;
    String author;

    Book(int bookId,
         String title,
         String author) {

        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
}

public class LibraryManagement {

    // Linear Search
    public static int linearSearch(Book[] books,
                                   String target) {

        for (int i = 0; i < books.length; i++) {

            if (books[i].title.equalsIgnoreCase(target)) {

                return i;
            }
        }

        return -1;
    }

    // Binary Search
    public static int binarySearch(Book[] books,
                                   String target) {

        int low = 0;
        int high = books.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result =
                    books[mid].title.compareToIgnoreCase(target);

            if (result == 0)
                return mid;

            if (result < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        Book[] books = {

                new Book(
                        101,
                        "C",
                        "Dennis Ritchie"),

                new Book(
                        102,
                        "C++",
                        "Bjarne Stroustrup"),

                new Book(
                        103,
                        "Java",
                        "James Gosling"),

                new Book(
                        104,
                        "Python",
                        "Guido van Rossum")
        };

        String searchTitle = "Java";

        int linearResult =
                linearSearch(
                        books,
                        searchTitle);

        if (linearResult != -1) {

            System.out.println(
                    "Linear Search: Book Found");

            System.out.println(
                    books[linearResult].title +
                    " by " +
                    books[linearResult].author);
        }
        else {

            System.out.println(
                    "Book Not Found");
        }

        int binaryResult =
                binarySearch(
                        books,
                        searchTitle);

        if (binaryResult != -1) {

            System.out.println(
                    "\nBinary Search: Book Found");

            System.out.println(
                    books[binaryResult].title +
                    " by " +
                    books[binaryResult].author);
        }
        else {

            System.out.println(
                    "Book Not Found");
        }
    }
}