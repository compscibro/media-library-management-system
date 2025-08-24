/**
 * @author Mohammed Abdur Rahman.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class represents the library of media items. It contains a list of labeled media items, 
 * and provides methods for adding labeled media items, returning a filtered subset of items 
 * in the library, and sorting the media library.
 */
public class MediaLibrary 
{

    /**
     * A list of labeled media items. (No getters or setters)
     */
    private final List<Label<String, Media>> library;

    /**
     * A default constructor which initializes the library.
     */
    public MediaLibrary() {
        library = new ArrayList<>();
    }

    /**
     * A method for adding media to the library. The first argument is a string, the second the media item. 
     * 
     * @param name A string that stores the label of the duplicate media item that was being added.
     * @param media A reference to the duplicate media item.
     * @throws MediaAlreadyInLibrary if the media item is already in the library.
     */
    public void add(String name, Media media) throws MediaAlreadyInLibrary 
    {
        Label<String, Media> newLabel = new Label<>(name, media);

        // Duplicates
        for (Label<String, Media> label:library) {
            if (label.equals(newLabel)) {
                throw new MediaAlreadyInLibrary(name, media);
            }
        }

        // add new label for media in library
        library.add(newLabel);
    }

    /**
     * This method creates and returns a new list of labeled media items. This new list 
     * should contain all of the labeled media items from the library for which the given 
     * mediaFilter's matches method returned true.
     */
    public List<Label<String, Media>> filter(MediaFilter mediaFilter) 
    {
        List<Label<String, Media>> filteredList = new ArrayList<>();

        for (Label<String, Media> label:library) {
            if (mediaFilter.matches(label)) {
                filteredList.add(label);
            }
        }
        return filteredList;
    }

    /**
     * This method sorts the data member library according to the following rules:
     * Books come before Movies, Movies come before Series, Series come before Music
     * Books are sorted first by author, then by title
     * Movies are sorted first by title, then by year
     * Series are sorted just by title
     * Music is sorted first by artist, then by year, then by title
     */
    public void sort() {
        Collections.sort(library);
    }

    // public static void main(String[] args) {
    //     System.out.println("Compiled");
    //     System.out.println(Passed all the test case);
    // }


}
