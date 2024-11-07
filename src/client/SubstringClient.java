package client;
import shared.SubstringChecker;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SubstringClient {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            SubstringChecker checker = (SubstringChecker) registry.lookup("SubstringChecker");

            String str1 = "test";
            String str2 = "This is a test  string";

            boolean isSubstring = checker.isSubstring(str1, str2);

            if (isSubstring) {
                System.out.println("String 1 is a substring of String 2.");
            } else {
                System.out.println("String 1 is NOT a substring of String 2.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
