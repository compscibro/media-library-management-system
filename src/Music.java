/**
 * @author Mohammed Abdur Rahman.
 */

/**
 * This abstract subclass of Media represents different types
 * of music, overrides the constructor, and toString() methods, and 
 * provides an implementation for the compareTo() method.
 * 
 * Note: Not implemented: getType()
 */
public abstract class Music extends Media 
{
    /**
     * artist: A string with the name of the artist. Should have a getter (final) but no setter.
     * title: A string with the title of the piece. Should have a getter (final) but no setter.
     * year: An integer representing the year the piece was released. Should have a getter (final) but no setter.
     */
    private final String artist;
    private final String title;
    private final int year;
    
    /**
     * Music(format, isbn, genre, artist, title, year): A constructor which sets the private data members.
     * 
     * @param format An instance of the Format enum.
     * @param isbn A string representing the ISBN of this media item.
     * @param genre A string representing the genre of this media item.
     * 
     * @param artist A string with the name of the artist. Should have a getter (final) but no setter.
     * @param title A string with the title of the piece. Should have a getter (final) but no setter.
     * @param year An integer representing the year the piece was released. Should have a getter (final) but no setter.
     */
    public Music(Format format, String isbn, String genre, String artist, String title, int year)
    {
        // should call the parent class constructor
        super(format, isbn, genre);

        // EXCEPTION HANDLING *********************************************
        if (artist == null || title == null) {
            throw new IllegalArgumentException("Artist or title cannot be null");
        }
        if (year < 0) {
            throw new IllegalArgumentException("Year cannot be negative");
        }
        // EXCEPTION HANDLING *********************************************

        this.artist = artist;
        this.title = title;
        this.year = year;
    }

    /**
     * Getters: artist, title, year | Setters: [None]
     */
    public final String getArtist() { return artist; }
    public final String getTitle() { return title; }
    public final int getYear() { return year; }

    /**
     * A string representation of this object. Has the form 
     * "Artist: artist, Year: year, Title: title, " 
     * followed by the information given in the format of the 
     * toString() method of the parent class. Consider how 
     * inheritance can enable code reuse in this method.
     * @return new string format
     */
    @Override
    public String toString() {
        return "Artist: " + artist + ", Year: " + year + ", Title: " + title + ", " + super.toString();
    }

    /**
     * This method returns an integer value representing whether the instance given 
     * as an argument should be ordered before or after the calling instance. 
     * Negative numbers indicate the calling instance (this) should be ordered first. 
     * Positive numbers indicate the argument should be ordered first. Zero indicates 
     * that both instances have the same ordering. This method is what's used to sort 
     * collections in the collections framework. See the description of the sort() method
     * in the MediaLibrary class for how this method should be implemented.
     */
    @Override
    public int compareTo(Media m)
    {
        // EXCEPTION HANDLING *********************************************
        if (!(m instanceof Music)) {
            throw new ClassCastException("Only compare Music to other Music instances.");
        }
        // EXCEPTION HANDLING *********************************************

        Music moreMusic = (Music) m;

        // compare -> artist
        int artistComparison = this.artist.compareTo(moreMusic.getArtist());
        if (artistComparison != 0) {
            // reverse
            return -artistComparison;
        }

        // compare -> year
        int yearComparison = Integer.compare(this.year, moreMusic.getYear());
        if (yearComparison != 0) {
            // reverse
            return -yearComparison;
        }

        // compare -> title: reverse
        return -this.title.compareTo(moreMusic.getTitle());
    }

    // public static void main(String[] args) {
    //     System.out.println("Compiled");
    //     System.out.println(Passed all the test case);
    // }

}
