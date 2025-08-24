/**
 * @author Mohammed Abdur Rahman.
 */

/**
 * This exception represents the situation where two or more labeled 
 * media items with the same ISBN are added to the media library.
 */
public class MediaAlreadyInLibrary extends Exception 
{

    /**
     * name: A string that stores the label of the duplicate media item that was being added. Should have a getter but no setter.
     * media: A reference to the duplicate media item. Should have a getter but no setter.
     */
    private final String name;
    private final Media media;

    /**
     * Constructor which sets the private data members, and calls the parent class constructor 
     * with the message "Media already in library.".
     * 
     * @param name A string that stores the label of the duplicate media item that was being added. 
     * Should have a getter but no setter.
     * @param media A reference to the duplicate media item. Should have a getter but no setter.
     */
    public MediaAlreadyInLibrary(String name, Media media) 
    {
        super("Media already in library.");
        this.name = name;
        this.media = media;
    }

    /**
     * Getters: name, media
     */
    public String getName() { return name; }
    public Media getMedia() { return media; }

    // public static void main(String[] args) {
    //     System.out.println("Compiled");
    //     System.out.println(Passed all the test case);
    // }


}
