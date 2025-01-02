package mubir.fp;

public class MyAdder {
    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> triFunction = MyUtils::add;
//        TriFunction<Integer, Integer, Integer, Integer> triFunction
//                = (a, b, c) -> MyUtils.add(a, b, c);

        int x = triFunction.apply(3, 4, 5);
        System.out.println(x);
    }
}
