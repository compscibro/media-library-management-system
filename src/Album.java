/**
 * @author Mohammed Abdur Rahman.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * This subclass of Music represents complete albums, 
 * overrides the constructor, getType(), and toString() methods
 */
public class Album extends Music 
{

    /**
     * A list of strings representing the tracks on the album. 
     * The trackList may refer to an ArrayList or LinkedList, but the return value for the getter should 
     * be the interface type List with the appropriate type specifier.
     */
    private final List<String> trackList;

    /**
     * A constructor which sets the private data members. Should call the parent class constructor. 
     * The argument trackList is a List of strings which should be added to the private data member 
     * using addAll(...)
     * 
     * @param format An instance of the Format enum.
     * @param isbn A string representing the ISBN of this media item.
     * @param genre A string representing the genre of this media item.
     * 
     * @param artist A string with the name of the artist. 
     * @param title A string with the title of the piece. 
     * @param year An integer representing the year the piece was released. 
     * 
     * @param trackList The list of tracks on the album.
     */
    public Album(Format format, String isbn, String genre, String artist, String title, int year, List<String> trackList) 
    {
        super(format, isbn, genre, artist, title, year);

        // EXCEPTION HANDLING *********************************************
        if (trackList == null) {
            throw new IllegalArgumentException("Track list cannot be null");
        }
        // EXCEPTION HANDLING *********************************************

        this.trackList = new ArrayList<>();
        this.trackList.addAll(trackList);
    }

    /**
     * Getters: trackList
     */
    public final List<String> getTrackList() { return trackList; }

    /**
     * @return the string "Album".
     */
    @Override
    public String getType() { return "Album"; }

    /**
     * A string representation of this object. Adds the string ", 
     * Tracks: trackList" to the return value of the toString() 
     * method of the parent class. Consider how inheritance can 
     * enable code reuse in this method.
     */
    @Override
    public String toString() {
        return super.toString() + ", Tracks: " + trackList;
    }

    /**
     * Compares this Album to another Media item
     * */
    @Override
    public int compareTo(Media a) {
        if (!(a instanceof Album)) {
            throw new ClassCastException("Can only compare Album to other Album instances.");
        }
        Album otherAlbum = (Album) a;

        // Artist
        int artistComparison = this.getArtist().compareTo(otherAlbum.getArtist());
        if (artistComparison != 0) {
            return artistComparison;
        }

        // Year
        int yearComparison = Integer.compare(this.getYear(), otherAlbum.getYear());
        if (yearComparison != 0) {
            return yearComparison;
        }

        // Title
        return this.getTitle().compareTo(otherAlbum.getTitle());
    }

    // public static void main(String[] args) {
    //     System.out.println("Compiled");
    //     System.out.println(Passed all the test case);
    // }

}
