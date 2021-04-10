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
import java.util.Locale;
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
        ProductManager pm = new ProductManager(new Locale("pl", "PL"));
        
        Product p1 = pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
        pm.printProductReport();
        p1 = pm.reviewProduct(p1, Rating.FOUR_STARS, "Really nice cup of Tea");
        pm.printProductReport();
//        Product p2 = pm.createProduct(102, "Coffe", BigDecimal.valueOf(1.99), Rating.FOUR_STARS);
//        Product p3 = pm.createProduct(103, "Cake", BigDecimal.valueOf(3.99), Rating.FIVE_STARS, LocalDate.now().plusDays(2)); 
//        Product p4 = pm.createProduct(105, "Cake", BigDecimal.valueOf(3.99), Rating.TWO_STARS, LocalDate.now()); 
//        Product p5 = p3.applyRating(Rating.THREE_STARS);
//        Product p6 = pm.createProduct(104, "Chocolade", BigDecimal.valueOf(2.99), Rating.FIVE_STARS);
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
