package mubir.mygeneric.compiletimesafety;

public class SafeClassClient {
    public static void main(String[] args) {
        EnsureRuntimeAndCompileTimeSafety<String> myClass = new EnsureRuntimeAndCompileTimeSafety<>("safety is number 1 priority");

        // Now, suppose you want to retrieve the target as a String:
        String targetString = myClass.getTarget(); // No cast required, and it's type-safe.

        System.out.println(targetString);

        // Now let's try assigning an Integer
        EnsureRuntimeAndCompileTimeSafety<Integer> intClass = new EnsureRuntimeAndCompileTimeSafety<>(42);

        // Attempting to retrieve it as a String would cause a compile-time error:
        // This line would NOT compile, preventing a ClassCastException.
        //String wrongTarget = (String) intClass.getTarget();
        System.out.println();
    }
}
