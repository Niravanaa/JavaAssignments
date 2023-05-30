# Book Management System

This is a Java program that implements a book management system. It includes three classes: `Book`, `BookList`, and `Driver`.

## Book Class

The `Book` class represents a book and contains information such as the title, author, price, ISBN, genre, and year of publication. It provides methods to access and manipulate these attributes.

### Attributes

- `title`: The title of the book.
- `author`: The author(s) of the book.
- `price`: The price of the book.
- `ISBN`: The ISBN of the book.
- `genre`: The abbreviated genre of the book.
- `year`: The year of publication of the book.

### Methods

- `toString()`: Returns the string representation of the `Book` object.
- `getTitle()`: Returns the title of the book.
- `getAuthor()`: Returns the author(s) of the book.
- `getPrice()`: Returns the price of the book.
- `getISBN()`: Returns the ISBN of the book.
- `getGenre()`: Returns the genre of the book.
- `getYear()`: Returns the year of publication of the book.

## BookList Class

The `BookList` class represents a list of books and provides methods to manipulate the list.

### Attributes

- `head`: The head of the linked list that stores the books.

### Methods

- `addToStart(Book book)`: Adds a book to the start of the list.
- `displayContent()`: Displays the contents of the book list.
- `storeRecordsByYear(int year)`: Stores the records of a given year in a file.
- `delConsecutiveRepeatedRecords()`: Deletes consecutive repeated records from the list.
- `extractAuthList(String authorName)`: Creates a new list with records of a specific author.
- `insertBefore(long ISBN, Book book)`: Inserts a book before the record with a given ISBN.
- `insertBetween(long ISBN1, long ISBN2, Book book)`: Inserts a book between two records with given ISBNs.
- `swap(long ISBN1, long ISBN2)`: Swaps the positions of two records with given ISBNs.

## Driver Class

The `Driver` class is the main driver of the program. It creates instances of `Book` and `BookList`, reads data from a file, performs operations on the book list, and interacts with the user through a menu.

### Methods

- `main(String[] args)`: The main method of the program. Executes the interactive program and performs operations on the book list based on user input.

## Usage

To use this program, compile and run the `Driver` class. The program will read book data from a file called "Books.txt", separate the books into two lists (bad books and good books) based on the year of publication, write the bad books to a file called "YearErr.txt", display the contents of the good books list, and then execute an interactive program where the user can perform various operations on the book list.

## Note

This program assumes that the book data is provided in a specific format in the "Books.txt" file. Make sure the file follows the correct format for proper functioning of the program.

