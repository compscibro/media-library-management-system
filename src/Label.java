/**
 * @author Mohammed Abdur Rahman.
 */

/**
 * This is a generic class, with two type specifications. 
 * The first type can be any type, the second type must implement the 
 * Comparable interface and be comparable to other instances of the same type. 
 * The Label class itself should also implement Comparable, 
 * such that Label instances are comparable to other Label instances of the 
 * same kind (same generic type specifiers). The specific syntax for this class 
 * declaration should be public class Label show below:
 */
public class Label<K, V extends Comparable<V>> implements Comparable<Label<K, V>> 
{

    /**
     * key: A reference of the first generic type. Should have a getter but no setter.
     * value: A reference of the second generic type. Should have a getter but no setter.
     */
    private final K key;
    private final V value;

    /**
     * A constructor which sets the private data members.
     * 
     * @param key A reference of the first generic type. Should have a getter but no setter.
     * @param value A reference of the second generic type. Should have a getter but no setter.
     */
    public Label(K key, V value) {

        // EXCEPTION HANDLING *********************************************
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key or value cannot be null");
        }
        // EXCEPTION HANDLING *********************************************

        this.key = key;
        this.value = value;
    }

    /**
     * Getters: key, value
     */
    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }

    /**
     * Overrides the parent class version to return true if the given object is also a Label instance, 
     * and this.value.equals(obj.value) returns true (you will need to cast the argument). Otherwise, 
     * return false.
     */
    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Label<?, ?>)) {
            return false;
        }

        Label<?, ?> other = (Label<?, ?>) obj;
        return this.value.equals(other.getValue());
    }

    /**
     * Returns the result of comparing the value data members (value.compareTo(other.getValue()).
     * If the generic specification is correct, there should be no need to cast anything.
     */
    @Override
    public int compareTo(Label<K, V> other) {
        // EXCEPTION HANDLING *********************************************
        if (other == null || other.getValue() == null) {
            throw new NullPointerException("Cannot compare to a null Label or a Label with a null value");
        }
        // EXCEPTION HANDLING *********************************************

        return this.value.compareTo(other.getValue());
    }

    // public static void main(String[] args) {
    //     System.out.println("Compiled");
    //     System.out.println(Passed all the test case);
    // }


}






