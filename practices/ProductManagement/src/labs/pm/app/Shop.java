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
import java.util.Locale;
import java.util.function.Predicate;

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
        ProductManager pm = new ProductManager("pl-PL");
        
//        pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
        pm.parseProduct("D,101,Tea,1.99,0,'2021-04-17");
        pm.printProductReport(101 );
        pm.parseReview("101,4,Really nice cup of Tea");
        pm.parseReview("101,2,Poor ea");
        pm.parseReview("101,5,Excelent Tea!");
        pm.parseReview("101,4,Good Tea");
        pm.parseReview("101,4,Fine Tea");
        pm.printProductReport(101);

        pm.parseProduct("F,103,Cake,4.99,0,2021-04-17");
//
//        pm.createProduct(102, "Coffe", BigDecimal.valueOf(4.99), Rating.FOUR_STARS);
//        pm.reviewProduct(102, Rating.FIVE_STARS, "Excellent coffe!");
//        pm.reviewProduct(102, Rating.FIVE_STARS, "Ideal coffe!");
//        pm.reviewProduct(102, Rating.FOUR_STARS, "Fine coffe!");
//        pm.reviewProduct(102, Rating.FIVE_STARS, "Super coffe!");
////        pm.printProductReport(102);
//
//        pm.createProduct(103, "Cake", BigDecimal.valueOf(2.99), Rating.NOT_RATED, LocalDate.now().plusDays(2));
////        pm.printProductReport(103);
//
//        pm.createProduct(104, "Cake", BigDecimal.valueOf(3.99), Rating.TWO_STARS, LocalDate.now());
//        pm.reviewProduct(104, Rating.FOUR_STARS, "Nice cake!");
//        pm.reviewProduct(104, Rating.TWO_STARS, "Bad quality cake");
////        pm.printProductReport(104);
//
//        pm.createProduct(105, "Chocolade", BigDecimal.valueOf(2.99), Rating.THREE_STARS, LocalDate.now().plusDays(9));
//        pm.reviewProduct(105, Rating.FOUR_STARS, "Nice cocolade!");
//        pm.reviewProduct(105, Rating.THREE_STARS, "good");
//        pm.printProductReport(105);
//
//        Comparator<Product> ratingSorter = (p1, p2) -> p2.getRating().ordinal() - p1.getRating().ordinal();
//        Comparator<Product> priceSorter = (p1, p2) -> p1.getPrice().compareTo(p2.getPrice());
//        Predicate<Product> filter = p -> p.getPrice().floatValue() < 3;
//        pm.printProducts(filter, ratingSorter.thenComparing(priceSorter).reversed());
//
//        pm.getDiscount().forEach(
//                (rating, discount) -> System.out.println(rating+"\t"+discount));
//        pm.printProducts(priceSorter);
//        Product p6 = pm.createProduct( 104, "Chocolade", BigDecimal.valueOf(2.99), Rating.FIVE_STARS);
//        Product p7 = pm.createProduct(104, "Chocolade", BigDecimal.valueOf(2.99), Rating.FIVE_STARS, LocalDate.now().plusDays(2));
//        Product p8 = p4.applyRating(Rating.FIVE_STARS);
//        Product p9 = p1.applyRating(Rating.TWO_STARS);
//        
////        if (p3 instanceof Food){
////            System.out.println(((Food)p3).getBestBefore());
////        }
//
//        System.out.println(p1.getBestBefore());
//        System.out.println(p3.getBestBefore());
//        
//        System.out.println(p1);
//        System.out.println(p2);
//        System.out.println(p3);
//        System.out.println(p4);
//        System.out.println(p5);
//        System.out.println(p6);
//        System.out.println(p7);
//        System.out.println(p8);
//        System.out.println(p9);
//        System.out.println(p1);
//        System.out.println(p6.equals(p7));
    }
    
}
