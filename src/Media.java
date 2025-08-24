/**
 * @author Mohammed Abdur Rahman.
 */

/**
 * This class is an abstract class for representing different kinds of media
 * (music, movies, books, etc.). All of the media in the media library will be 
 * subclasses (or sub-subclasses) of this class. It should implement the 
 * Comparable interface, and specify the generic type for that interface 
 * so that Media can be compared to other Media. The details of the compareTo 
 * method should be left to subclasses.
 */
public abstract class Media implements Comparable<Media>
{
    /**
     * ISBN: A string representing the ISBN of this media item. Should have a getter (final),
     * but no setter. Getter should capitalize ISBN (so getISBN).
     * 
     * GENRE: A string representing the genre of this media item. Should have a getter (final) but no setter
     * 
     * FORMAT:  An instance of the Format enum (described below). Should have a getter (final) but no setter.
     */
    private final String isbn;
    private final String genre;
    private final Format format;

    /**
     * @return a string representing the type of the media.
     * The details of this method should be left to subclasses.
     */
    public abstract String getType();
    
    /**
     * This constructor with 3 parameters. Initializes private data members.
     * @param format An instance of the Format enum.
     * @param isbn A string representing the ISBN of this media item.
     * @param genre A string representing the genre of this media item.
     */
    public Media(Format format, String isbn, String genre)
    {
        this.format = format;
        // Getter should capitalize ISBN
        this.isbn = isbn.toUpperCase();
        this.genre = genre;
    }
    
    /**
     * Getters: format, isbn, genre | Setters: [None]
     */
    public final Format getFormat() { return format; }
    public final String getISBN() { return isbn; }
    public final String getGenre() { return genre; }

    /**
     * Overrides the parent class version to return true if the given 
     * object is also a media item, and their ISBNs match. Otherwise, return false.
     * Note: Override here to avoid implementing mutiple equals() method in each respective sub-classes.
     */
    @Override
    public boolean equals(Object obj)
    {
    	if (this == obj) { return true; }

    	if (!(obj instanceof Media)) { return false; }

    	Media media = (Media) obj;
    	return isbn.equals(media.isbn);
	}
    
    /**
     * @return a string representation of this media. This should have the form
     * "Type: type, ISBN: isbn, Genre: genre, Format: format",
     * replacing the italicized placeholders with the string returned by
     * getType, isbn, genre, and format values. Spacing, spelling, capitalization are all important. 
     * Carefully implementing this method will allow for significant code reuse in subclasses.
     */
    @Override
    public String toString() {
        return "Type: " + getType() + ", ISBN: " + isbn + ", Genre: " + genre + ", Format: " + format;
    }
    
    /**
     * The details of the compareTo method should be left to subclasses
     */
    public abstract int compareTo(Media m);

    // public static void main(String[] args) {
    //     System.out.println("Compiled");
    //     System.out.println(Passed all the test case);
    // }


}




