package mubir.fp;

import java.io.IOException;

public class CustSupplierThatThorwExp {

    public static void main(String[] args) {
        ThrowingSupplier<Integer, IOException> sE = () -> {
            // Now no need to write the code inside try-catch
            // custom supplier can throw checked exp.
            return 9;
        };

        try {
            sE.get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
