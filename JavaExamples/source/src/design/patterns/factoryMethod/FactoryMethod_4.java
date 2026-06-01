package design.patterns.factoryMethod;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Stream;

public class FactoryMethod_4 {
    // Torna Flexível a Criação de objetos com Factory Methods
    // Virtual constructor

    public static void main(String[] args) {
        // Static Factory Methods
        Calendar.getInstance(); //Calendar é uma classe abstrata
        NumberFormat.getInstance();
        Stream.of(1, 2, 3, 4);
        List.of(1, 2, 3, 4);
        Integer valueOf = Integer.valueOf("1234");

    }

}

