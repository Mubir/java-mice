package mubir.mygeneric.basic;

public class Client {
    public static void main(String[] args) {
        WhyGen obj = new WhyGen();
        obj.ComOkRunE("Why this input", 69);

        try {
            obj.ComOkRunET("we will", "add & print");
        } catch (Exception e) {
            System.out.println("############## »");
            System.out.println(e);
            System.out.println("############## »");
        } finally {
            obj.ComOkRunOkAsTypeSafe("My Bad!! fixed", 69);
        }
    }
}
