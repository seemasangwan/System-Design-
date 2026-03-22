/**
 * Main class to demonstrate usage of Builder Design Pattern
 */
public class Main {

    public static void main(String[] args) {

        /**
         * 🔹 Creating User object using Builder
         *
         * Flow:
         * 1. Call UserBuilder constructor with required fields
         * 2. Set optional fields using setter methods
         * 3. Call build() to create final immutable User object
         */

        User user1 = new User.UserBuilder("seema", "seema@gmail.com")
                .setPhoneNumber("21324") // optional field
                .build(); // creates User object

        /**
         * 🔹 Another User object with different optional fields
         */
        User user2 = new User.UserBuilder("rohit", "rohit@gmail.com")
                .setAge(19)              // optional field
                .setAddress("abc")       // optional field
                .build();

        /**
         * 🔹 Printing user details
         */
        user1.printUserInfo();
        user2.printUserInfo();

        /**
         * 🧠 Key Observations:
         *
         * ✔ Only required fields are mandatory (userName, email)
         * ✔ Optional fields can be added as needed
         * ✔ Code is readable and flexible
         * ✔ Object is immutable → cannot be changed after creation
         */
    }
}
