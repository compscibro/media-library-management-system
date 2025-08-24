/**
 * @author Mohammed Abdur Rahman.
 */

/**
 * This subclass of Music represents singles, and overrides the constructor, and getType() methods.
 */
public class Single extends Music 
{

    /**
     * Simply calls the parent class constructor with the given arguments.
     * 
     * @param format An instance of the Format enum.
     * @param isbn A string representing the ISBN of this media item.
     * @param genre A string representing the genre of this media item.
     * 
     * @param artist A string with the name of the artist. 
     * @param title A string with the title of the piece. 
     * @param year An integer representing the year the piece was released. 
     */

    public Single(Format format, String isbn, String genre, String artist, String title, int year) {
        super(format, isbn, genre, artist, title, year);
        // EXCEPTION HANDLING *********************************************
        if (artist == null || title == null) {
            throw new IllegalArgumentException("Artist and title cannot be null");
        }
        // EXCEPTION HANDLING *********************************************
    }

    /**
     * @return the string "Single".
     */
    @Override
    public String getType() { return "Single"; }

    // public static void main(String[] args) {
    //     System.out.println("Compiled");
    //     System.out.println(Passed all the test case);
    // }
}
