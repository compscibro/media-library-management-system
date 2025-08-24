/**
 * @author Mohammed Abdur Rahman.
 */

/**
 * This class implements the MediaFilter interface, and represents a search style filter, 
 * matching labeled media items which contain a given search string among their data members, or in their label.
 */
public class SearchFilter implements MediaFilter 
{

    /**
     * searchTerm: the string to search for in each media item. No getters or setters.
     */
    private final String searchTerm;

    /**
     * Constructor which takes a single string, and should set the private data member.
     * @param searchTerm the string to search for in each media item. No getters or setters.
     */
    public SearchFilter(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    /**
     * @return true if the label contains the searchTerm, or if the searchTerm is in the string 
     * returned by the toString method of the media item. You may find the 
     * string method indexOf useful for this.
     */
    @Override
    public boolean matches(Label<String, Media> label) 
    {
        // if in key
        if (label.getKey().indexOf(searchTerm) != -1) {
            return true;
        }
        // if in media
        return label.getValue().toString().indexOf(searchTerm) != -1;
    }
    
    // public static void main(String[] args) {
    //     System.out.println("Compiled");
    //     System.out.println(Passed all the test case);
    // }


}
