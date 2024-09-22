package mubir.mygeneric.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WhyGen {

    /**
     * it will compile ok but gets no RuntimeError as
     * we cast string obj as string int obj as Integer.
     *
     */
    public void ComOkRunE(String str, int n) {
        // list added items of object type.
        List list = new ArrayList();
        // any type can be added.
        list.add(str);
        list.add(n);

        String[] oops = new String[2];
        // type casting needed
        String oopsS = (String) list.get(0);
        Integer oopsI = (int) list.get(1);

        System.out.println(oopsS + " «-» " + oopsI);
    }

    /**
     * No runtime error as we added str only
     * but supposed to RuntimeError as not type-safe.
     * Its lucky that only string is being added but when
     * we retrive data we can cast string as int and thats
     * goes ok during compile time but runtime it fails.
     */
    public void ComOkRunET(String str, String str1) {

        List list = new ArrayList();
        list.add(str);
        list.add(str1);

        String[] oops = new String[2];
        oops[0] = (String) list.get(0);
        // str type cast to int throws error .
        Integer oopsI = (int) list.get(1);
        System.out.println(oopsI);
    }

    public void ComOkRunOkAsTypeSafe(String str, int n) {
        List<String> list = new ArrayList();
        list.add(str);
        // throws compile time error as type mis-match
        //list.add(n);
        list.add(" int not allowed");
        String[] oops = new String[2];
        oops[0] = list.get(0);
        oops[1] = list.get(1);

        Arrays.stream(oops).toList().forEach(System.out::print);
    }

}
