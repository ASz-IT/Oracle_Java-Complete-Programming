/*
 * Copyright (C) 2021 aszit
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package labs.pm.app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import labs.pm.data.Drink;
import labs.pm.data.Food;
import labs.pm.data.Product;
import labs.pm.data.ProductManager;
import labs.pm.data.Rating;

/**
 * {@code Shop} class represent an application that manages Products 
 * @version 4.0
 * @author aszit
 */
public class Shop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AtomicInteger clientCount = new AtomicInteger(0);
        ProductManager pm = ProductManager.getInstanc();
        Callable<String> client = () -> {
            String clientId = "Client " + clientCount.incrementAndGet();
            String threadName = Thread.currentThread().getName();
            int productId = ThreadLocalRandom.current().nextInt(6)+101;
            String languageTag = ProductManager.getSupportedLocales()
                                               .stream()
                                               .skip(ThreadLocalRandom.current().nextInt(4))
                                               .findFirst().get();
            StringBuilder log = new StringBuilder();
            log.append(clientId+" "+threadName+"\n-\tstart of log\t-\n");
            log.append(pm.getDiscount(languageTag)
                         .entrySet()
                         .stream()
                         .map(entry -> entry.getKey()+"\t"+entry.getValue())
                    .collect(Collectors.joining("\n")));
            Product product = pm.reviewProduct(productId, Rating.FOUR_STARS, "Yet another review");
            log.append((product !=null)
                        ? "\nProduct"+productId+" reviewd"
                        : "\nProduct"+productId+" not reviewd");
            pm.printProductReport(productId, languageTag, clientId);
            log.append(clientId+" generated report for "+productId+" product");
            log.append("\n-\tend of log\t-\n");
            return log.toString();
        };
        List<Callable<String>> clients = Stream.generate(()->client).limit(5).collect(Collectors.toList());
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try {
            List<Future<String>> results = executorService.invokeAll(clients);
            executorService.shutdown();
            results.stream().forEach(result-> {
                try {
                    System.out.println(result.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        pm.printProductReport(101, "en-GB");
//        pm.createProduct(164, "Kombucha", BigDecimal.valueOf(4.99), Rating.FOUR_STARS);
//        pm.reviewProduct(164, Rating.FIVE_STARS, "Excellent coffe!");
//        pm.reviewProduct(164, Rating.FIVE_STARS, "Ideal coffe!");
//        pm.reviewProduct(164, Rating.FOUR_STARS, "Fine coffe!");
//        pm.reviewProduct(164, Rating.FIVE_STARS, "Super coffe!");
//        pm.printProductReport(164 );
////        pm.dumpData();
//
//        pm.printProductReport(102);
//
//        pm.printProductReport(102);
//
////
//        Comparator<Product> ratingSorter = (p1, p2) -> p2.getRating().ordinal() - p1.getRating().ordinal();
//        Comparator<Product> priceSorter = (p1, p2) -> p1.getPrice().compareTo(p2.getPrice());
//        Predicate<Product> filter = p -> p.getPrice().floatValue() < 333;
//        pm.printProducts(filter, ratingSorter.thenComparing(priceSorter).reversed());
    }
    
}
