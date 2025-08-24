/**
 * @author Mohammed Abdur Rahman.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * This subclass of Media represents movies.
 */
public class Movie extends Media 
{

    /**
     * title: A string representing the title of the movie. Should have a getter (final) but no setter.
     * 
     * director: A string for the name of the director. Should have a getter (final) but no setter.
     * 
     * year: An integer representing the year the movie was released. Should have a getter (final) but no setter.
     * 
     * cast: A list of strings representing the names of the cast of the movie. Should have a getter (final) but no setter. 
     * The cast may refer to an ArrayList or LinkedList, but the return value for the getter should be 
     * the interface type List with the appropriate type specifier.
     */
    private final String title;
    private final String director;
    private final int year;
    private final List<String> cast;

    /**
     * @param format An instance of the Format enum.
     * @param isbn A string representing the ISBN of this media item.
     * @param genre A string representing the genre of this media item.
     * @param title A string with the title of the piece. Should have a getter (final) but no setter.
     * @param director A string for the name of the director. Should have a getter (final) but no setter.
     * @param year An integer representing the year the movie was released. Should have a getter (final) but no setter.
     * @param cast A list of strings representing the names of the cast of the movie. 
     */
    public Movie(Format format, String isbn, String genre, String title, String director, int year, List<String> cast) 
    {
        super(format, isbn, genre);

        // EXCEPTION HANDLING *********************************************
        if (title == null || director == null || cast == null) {
            throw new IllegalArgumentException("Title, director, and cast cannot be null");
        }
        // EXCEPTION HANDLING *********************************************

        this.title = title;
        this.director = director;
        this.year = year;
        this.cast = new ArrayList<>();
        this.cast.addAll(cast);
    }

    /**
     * Getter: title, director, year, cast
     */
    public final String getTitle() { return title; }
    public final String getDirector() { return director; }
    public final int getYear() { return year; }
    public final List<String> getCast() { return cast; }

    /**
     * @return the string "Movie".
     */
    @Override
    public String getType() { return "Movie"; }

    /**
     *  A string representation of this object. Has the form "Title: title, 
     * Year: year, " followed by the information given in the format of 
     * the toString() method of the parent class.
     */
    @Override
    public String toString() {
        return "Title: " + title + ", Year: " + year + ", " + super.toString();
    }

    /**
     * Returns the relative ordering of this media item. See the description in Music and MediaLibrary for more details.
     */
    @Override
    public int compareTo(Media m) 
    {
        // EXCEPTION HANDLING *********************************************
        if (!(m instanceof Movie)) {
            throw new ClassCastException("Can only compare Movies to other Movies.");
        }
        // EXCEPTION HANDLING *********************************************

        Movie otherMovie = (Movie) m;

        // Compare -> title
        int titleComparison = this.title.compareTo(otherMovie.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        }
        // Compare -> year
        return Integer.compare(this.year, otherMovie.getYear());
    }
    // public static void main(String[] args) {
    //     System.out.println("Compiled");
    //     System.out.println(Passed all the test case);
    // }


}

