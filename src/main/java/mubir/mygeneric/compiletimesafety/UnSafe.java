package mubir.mygeneric.compiletimesafety;

public class UnSafe {
    public static void main(String[] args) {

        LostCompileTImeSafety obj = new LostCompileTImeSafety("safety is number 1 priority");
        // This is fine because we know it's a String.
        String myString = (String)obj.getTarget();
        System.out.println(myString);

        obj=new LostCompileTImeSafety(45);
        /** If you accidentally try to cast it to a String, it compiles fine, but...
         *  This compiles, but will throw a ClassCastException at runtime.
         */
        myString = (String) obj.getTarget();
        System.out.println(myString);
    }
}
