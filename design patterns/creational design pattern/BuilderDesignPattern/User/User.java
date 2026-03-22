/**
 * User class demonstrating multiple important OOP + Design concepts:
 *
 * 🔹 Encapsulation:
 *    - All fields are private → hidden from external classes
 *    - Data can only be accessed in a controlled way
 *
 * 🔹 Immutability:
 *    - All fields are final → once assigned, cannot be changed
 *    - No setter methods → object state cannot be modified after creation
 *    - Improves safety, thread-safety, and predictability
 *
 * 🔹 Builder Design Pattern:
 *    - Used to create objects step-by-step
 *    - Solves telescoping constructor problem (too many constructors)
 *    - Separates object construction from representation
 *
 * 🔹 Required vs Optional Fields:
 *    - Required → passed in Builder constructor
 *    - Optional → set using builder methods
 *
 * 🔹 Method Chaining:
 *    - Each setter returns 'this' → allows chaining
 *
 * 🔹 Validation:
 *    - build() method ensures required fields are not null
 */
public class User {

    // 🔹 Required fields (must be provided)
    private final String userName;
    private final String emailAddress;

    // 🔹 Optional fields (can be skipped)
    private final String phoneNumber;
    private final int age;
    private final String address;

    /**
     * Private constructor:
     * - Prevents direct object creation using 'new'
     * - Forces object creation through Builder only
     */
    private User(UserBuilder userBuilder) {
        this.userName = userBuilder.userName;
        this.emailAddress = userBuilder.emailAddress;
        this.phoneNumber = userBuilder.phoneNumber;
        this.age = userBuilder.age;
        this.address = userBuilder.address;
    }

    /**
     * Static Builder Class:
     *
     * Why static?
     * - Does not require outer class object
     * - Can be accessed using: new User.UserBuilder(...)
     */
    public static class UserBuilder {

        // 🔹 Required fields
        private final String userName;
        private final String emailAddress;

        // 🔹 Optional fields
        private String phoneNumber;
        private int age;
        private String address;

        /**
         * Constructor for required fields
         */
        public UserBuilder(String userName, String emailAddress) {
            this.userName = userName;
            this.emailAddress = emailAddress;
        }

        /**
         * Setter methods for optional fields
         * - Return 'this' → enables method chaining
         */

        public UserBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this; // method chaining
        }

        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        /**
         * build() method:
         * - Final step to create User object
         * - Performs validation
         */
        public User build() {

            // 🔹 Validation for required fields
            if (userName == null || emailAddress == null) {
                throw new IllegalStateException("Username and Email cannot be null");
            }

            // 🔹 Create immutable User object
            return new User(this);
        }
    }

    /**
     * Utility method to display user information
     */
    public void printUserInfo() {
        System.out.println("User Info:");
        System.out.println("Name: " + userName);
        System.out.println("Email: " + emailAddress);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }
}
