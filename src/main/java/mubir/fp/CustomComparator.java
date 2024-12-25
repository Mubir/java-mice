package mubir.fp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomComparator {

    public class Product {
        String name;
        String age;

        String getName() {
            return this.name;
        }

        String getAge() {
            return this.age;
        }
    }

    public class CustomCom {
        public static int compareByNameAndAge(Product a, Product b) {
            return a.getName().compareTo(b.getAge());
        }
    }

    public static void main(String[] args) {
        List<Product> prod = new ArrayList<>();
        prod.sort(CustomCom::compareByNameAndAge);
        prod.sort(Comparator.comparing(Product::getName)
                .thenComparing(Product::getAge));
    }

}
