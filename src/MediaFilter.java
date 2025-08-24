/**
 * @author Mohammed Abdur Rahman.
 */

/**
 * This interface describes a single method, matches, 
 * which returns true if a given labeled media item matches the criteria of this filter.
 */
public interface MediaFilter 
{

    /**
     * this is the method that will be called by the media library when filtering the library. 
     * Items which return true will be included, items which return false will not be.
     */
    boolean matches(Label<String, Media> label);


    // public static void main(String[] args) {
    //     System.out.println("Compiled");
    //     System.out.println(Passed all the test case);
    // }
}
