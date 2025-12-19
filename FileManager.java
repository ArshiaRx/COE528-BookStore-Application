package bookstoreapp;

/**
 *
 * @author vguru
 */

import java.nio.file.*;
import java.nio.charset.Charset;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class FileManager {
    public static void write(ArrayList<Object> items, String type) throws IOException {
        Path path = Paths.get(type + ".txt");
        List<String> details = items.stream().map(item -> item.toString()).collect(Collectors.toList());
        Files.write(path, details, Charset.defaultCharset());
    }
    
    public static ArrayList read(String type) throws IOException {
        Path path = Paths.get(type + ".txt");
        if (type.equals("books")) {
            List<String> text = Files.lines(path).collect(Collectors.toList());
            ArrayList<Book> books = new ArrayList<>();
            for (String s : text) {
                s = s.trim();                          // Remove leading/trailing whitespace
                if (s.isEmpty())
                    continue;                           // Skip empty lines
                // Find the last space - everything before is the book name, after is the price
                int lastSpaceIndex = s.lastIndexOf(" ");
                if (lastSpaceIndex == -1) continue;      // Skip invalid lines
                String bookName = s.substring(0, lastSpaceIndex).trim();
                String priceStr = s.substring(lastSpaceIndex + 1).trim();
                try {
                    double price = Double.parseDouble(priceStr);
                    books.add(new Book(bookName, price));
                } catch (NumberFormatException e) {
                    
                    // Skip invalid price lines
                    continue;
                }
            }
            return books;
        }
        else {
            List<String> text = Files.lines(path).collect(Collectors.toList());
            ArrayList<Customer> customers = new ArrayList<>();
            for (String s : text) {
                String[] d = s.split(" ");
                customers.add(new Customer(d[0], d[1], Integer.parseInt(d[2])));
            }
            return customers;
        }
    }
}
