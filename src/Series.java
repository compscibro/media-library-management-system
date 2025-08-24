/**
 * @author Mohammed Abdur Rahman.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * This subclass of Media represents TV series.
 */
public class Series extends Media 
{

    /**
     * title: A string representing the title of the series. Should have a getter (final) but no setter.
     * 
     * 
     * cast: A list of strings representing the names of the cast in this series. 
     * Should have a getter (final) but no setter. The cast variable may refer to an ArrayList or LinkedList, 
     * but the return value for the getter should be the interface type List with the appropriate type specifier.
     * 
     * episodes: A list of strings representing the names of the episodes in the series. 
     * Follows the same rules as cast.
     */
    private final String title;
    private final List<String> cast;
    private final List<String> episodes;

    /**
     * Constructor to initialize all fields, including those from the superclass.
     * @param format An instance of the Format enum.
     * @param isbn A string representing the ISBN of this media item.
     * @param genre A string representing the genre of this media item.
     * @param title A string with the title of the piece. Should have a getter (final) but no setter.
     * @param cast A list of strings representing the names of the cast in this series.
     * @param episodes A list of strings representing the names of the episodes in the series. 
     */
    public Series(Format format, String isbn, String genre, String title, List<String> cast, List<String> episodes) 
    {
        super(format, isbn, genre);

        // EXCEPTION HANDLING *********************************************
        if (title == null || cast == null || episodes == null) {
            throw new IllegalArgumentException("Title, cast, or episodes cannot be null");
        }
        // EXCEPTION HANDLING *********************************************

        this.title = title;
        this.cast = new ArrayList<>();
        this.cast.addAll(cast); 
        this.episodes = new ArrayList<>();
        this.episodes.addAll(episodes); 
    }

    /**
     * Getters: title, cast, episodes
     */
    public final String getTitle() { return title; }
    public final List<String> getCast() { return cast; }
    public final List<String> getEpisodes() { return episodes; }

    /**
     * @return the string "Series".
     */
    @Override
    public String getType() { return "Series"; }

    /**
     * A string representation of this object. Has the form "Title: title, 
     * " followed by the information given in the format of the toString() method of the parent class.
     */
    @Override
    public String toString() {
        return "Title: " + title + ", " + super.toString();
    }

    /**
     * Returns the relative ordering of this media item. See the description in Music 
     * and MediaLibrary for more details.
     */
    @Override
    public int compareTo(Media s) {
        // EXCEPTION HANDLING *********************************************
        if (!(s instanceof Series)) {
            throw new ClassCastException("Can only compare Series to other Series.");
        }
        // EXCEPTION HANDLING *********************************************

        return this.title.compareTo(((Series) s).getTitle());
    }

    // public static void main(String[] args) {
    //     System.out.println("Compiled");
    //     System.out.println(Passed all the test case);
    // }
}
