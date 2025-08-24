/**
 * @author Mohammed Abdur Rahman.
 */

/**
 * This subclass of Media represents books.
 */
public class Book extends Media 
{

    /**
     * title: A string representing the title of the book. Should have a getter (final) but no setter.
     * author: A string representing the author of the book. Should have a getter (final) but no setter.
     * publisher: A string representing the publisher of the book. Should have a getter (final) but no setter.
     */
    private final String title;
    private final String author;
    private final String publisher;

    /**
     * A constructor which sets the private data members. Should call the parent class constructor.
     * 
     * @param format An instance of the Format enum.
     * @param isbn A string representing the ISBN of this media item.
     * @param genre A string representing the genre of this media item.
     * @param title A string representing the title of the book. Should have a getter (final) but no setter.
     * @param author A string representing the author of the book. Should have a getter (final) but no setter.
     * @param publisher A string representing the publisher of the book. Should have a getter (final) but no setter.
     */
    public Book(Format format, String isbn, String genre, String author, String title, String publisher) 
    {
        super(format, isbn, genre);

        // EXCEPTION HANDLING *********************************************
        if (author == null || title == null || publisher == null) {
            throw new IllegalArgumentException("Author, title, or publisher cannot be null");
        }
        // EXCEPTION HANDLING *********************************************

        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    /**
     * Getters: title, author, publisher
     */
    public final String getTitle() { return title; }
    public final String getAuthor() { return author; }
    public final String getPublisher() { return publisher; }

    /**
     * Returns the string "Book".
     */
    @Override
    public String getType() { return "Book"; }

    /**
     * A string representation of this object.
     * Has the form "Title: title, Author: author, " followed by the 
     * information given in the format of the toString() method of the parent class.
     */
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", " + super.toString();
    }

    /**
     * Returns the relative ordering of this media item. See the description in Music and MediaLibrary for more details.
     */
    @Override
    public int compareTo(Media b) 
    {
        // EXCEPTION HANDLING *********************************************
        if (!(b instanceof Book)) {
            throw new ClassCastException("Can only compare Books to other Books.");
        }
        // EXCEPTION HANDLING *********************************************

        Book otherBook = (Book) b;

        // author
        int authorComparison = this.author.compareTo(otherBook.getAuthor());
        if (authorComparison != 0) {
            return authorComparison;
        }
        // title
        return this.title.compareTo(otherBook.getTitle());
    }
    // public static void main(String[] args) {
    //     System.out.println("Compiled");
    //     System.out.println(Passed all the test case);
    // }


}
