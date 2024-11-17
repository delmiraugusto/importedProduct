package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        List<Product> list =new ArrayList<>();

        System.out.print("Enter the number of product: ");
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            sc.nextLine();
            char letter = sc.nextLine().charAt(0);
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();

            if (letter == 'u') {
                System.out.print("Manufacture date (DD/MM/YYY): ");
                Date date = sdf.parse(sc.next());
                Product p = new UsedProduct(price, name, date);
                list.add(p);
            }
            else if (letter == 'i') {
                System.out.print("Customs fee: ");
                Double fee = sc.nextDouble();
                Product p = new ImportedProduct(price, name, fee);
                list.add(p);
            }
            else {
                Product p = new Product(price, name);
                list.add(p);
            }
        }

        System.out.println("\nPRICE TAGS:");
        for (Product p : list) {
            System.out.println(p.priceTag());
        }


        sc.close();
    }
}
