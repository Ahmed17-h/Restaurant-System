package com.restaurant;

import com.restaurant.addons.*;
import com.restaurant.discount.*;
import com.restaurant.facade.RestaurantFacade;
import com.restaurant.items.*;
import com.restaurant.order.Order;
import com.restaurant.payment.*;
import com.restaurant.utils.InputHelper;

public class Main {
    private static final RestaurantFacade facade = new RestaurantFacade();

    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("   Welcome to Cairo Restaurant System     ");
        System.out.println("===========================================\n");

        while (true) {
            System.out.println("1. Start New Order");
            System.out.println("2. Exit");
            int choice = InputHelper.readInt("Choose an option (1-2): ");

            if (choice == 2) {
                System.out.println("\nThank you for using our system! Goodbye!\n");
                break;
            }
            if (choice == 1) {
                processOrder();
            } else {
                System.out.println("Invalid choice! Please try again.\n");
            }
        }
    }

    private static void processOrder() {
        
        System.out.println("\n--- Select Menu Type ---");
        System.out.println("1. Vegetarian");
        System.out.println("2. Non-Vegetarian");
        System.out.println("3. Kids");
        int menuChoice = InputHelper.readInt("Enter your choice (1-3): ");

        String menuType = switch (menuChoice) {
            case 1 -> "veg";
            case 2 -> "nonveg";
            case 3 -> "kids";
            default -> {
                System.out.println("Invalid choice! Defaulting to Non-Vegetarian.");
                yield "nonveg";
            }
        };

        facade.selectMenu(menuType);
        InputHelper.pressEnterToContinue();

        
        System.out.println("\n--- Select Order Type ---");
        System.out.println("1. Dine-in");
        System.out.println("2. Delivery");
        System.out.println("3. Takeaway");
        int typeChoice = InputHelper.readInt("Enter your choice (1-3): ");

        String orderType = switch (typeChoice) {
            case 1 -> "dine-in";
            case 2 -> "delivery";
            case 3 -> "takeaway";
            default -> "dine-in";
        };

        Order order = facade.createOrder(orderType);

 
        while (true) {
            System.out.printf("\n--- Add Items to Order (Current: %d) ---\n", order.getItems().size());
            System.out.println("1. Add Pizza");
            System.out.println("2. Add Burger");
            System.out.println("3. Add Kids Meal");
            System.out.println("4. Finish Adding Items");
            int itemChoice = InputHelper.readInt("Choose (1-4): ");

            if (itemChoice == 4) break;

            IMenuItem selectedItem = null;

            if (itemChoice == 1) {
                System.out.println("\nPizza Options:");
                System.out.println("1. Margherita Pizza       - EGP 85.0");
                System.out.println("2. Pepperoni Pizza        - EGP 110.0");
                int pizzaChoice = InputHelper.readInt("Choose pizza (1-2): ");
                selectedItem = pizzaChoice == 1 ? new MargheritaPizza() : new PepperoniPizza();
            }
            else if (itemChoice == 2) {
                System.out.println("\nBurger Options:");
                System.out.println("1. Veggie Burger          - EGP 75.0");
                System.out.println("2. Crispy Chicken Burger  - EGP 95.0");
                int burgerChoice = InputHelper.readInt("Choose burger (1-2): ");
                selectedItem = burgerChoice == 1 ? new VeggieBurger() : new ChickenBurger();
            }
            else if (itemChoice == 3) {
                new com.restaurant.menu.KidsMenu().display();
            
                int kidsChoice = InputHelper.readInt("Choose kids meal (1-4): ");
                
                if (kidsChoice < 1 || kidsChoice > 4) {
                    System.out.println("Invalid choice! Defaulting to Chicken Nuggets.");
                    kidsChoice = 1;
                }
            
                IMenuItem item = new com.restaurant.menu.KidsMenu().getItems().get(kidsChoice - 1);
                            new com.restaurant.menu.KidsMenu().display();

                
                boolean cheese = false, sauce = false, mushroom = false;
                while (true) {
                    System.out.printf("%nAdd-ons for: %s%n", item.getName());
                    System.out.println("1. Extra Cheese (+15)" + (cheese ? " [Added]" : ""));
                    System.out.println("2. Extra Sauce (+10)"  + (sauce ? " [Added]" : ""));
                    System.out.println("3. Mushroom Topping (+20)" + (mushroom ? " [Added]" : ""));
                    System.out.println("4. Done");
                    int a = InputHelper.readInt("Choose (1-4): ");
                    if (a == 4) break;
                    if (a == 1 && !cheese) { item = new ExtraCheese(item); cheese = true; }
                    else if (a == 2 && !sauce) { item = new ExtraSauce(item); sauce = true; }
                    else if (a == 3 && !mushroom) { item = new MushroomTopping(item); mushroom = true; }
                    else System.out.println("Already added or invalid!");
                }
            
                order.addItem(item);
                System.out.printf("Added: %s - EGP %.2f%n%n", item.getDescription(), item.getPrice());
            }

            if (selectedItem != null) {
                
                boolean cheeseAdded = false, sauceAdded = false, mushroomAdded = false;

                while (true) {
                    System.out.printf("\nAdd-ons for: %s\n", selectedItem.getDescription());
                    System.out.println("1. Extra Cheese     (+15.0)" + (cheeseAdded ? " [Added]" : ""));
                    System.out.println("2. Extra Sauce      (+10.0)" + (sauceAdded ? " [Added]" : ""));
                    System.out.println("3. Mushroom Topping (+20.0)" + (mushroomAdded ? " [Added]" : ""));
                    System.out.println("4. No more add-ons");
                    int addonChoice = InputHelper.readInt("Choose (1-4): ");

                    if (addonChoice == 4) break;

                    switch (addonChoice) {
                        case 1 -> {
                            if (!cheeseAdded) {
                                selectedItem = new ExtraCheese(selectedItem);
                                cheeseAdded = true;
                                System.out.println("→ Extra Cheese added!");
                            } else {
                                System.out.println("→ Extra Cheese already added!");
                            }
                        }
                        case 2 -> {
                            if (!sauceAdded) {
                                selectedItem = new ExtraSauce(selectedItem);
                                sauceAdded = true;
                                System.out.println("→ Extra Sauce added!");
                            } else {
                                System.out.println("→ Extra Sauce already added!");
                            }
                        }
                        case 3 -> {
                            if (!mushroomAdded) {
                                selectedItem = new MushroomTopping(selectedItem);
                                mushroomAdded = true;
                                System.out.println("→ Mushroom Topping added!");
                            } else {
                                System.out.println("→ Mushroom Topping already added!");
                            }
                        }
                        default -> System.out.println("Invalid add-on choice!");
                    }
                }

                order.addItem(selectedItem);
                System.out.printf("Added: %s - EGP %.2f\n", selectedItem.getDescription(), selectedItem.getPrice());
            }
        }

        
        System.out.println("\n--- Select Payment Method ---");
        System.out.println("1. Cash");
        System.out.println("2. Credit Card");
        System.out.println("3. Mobile Wallet");
        int paymentChoice = InputHelper.readInt("Choose (1-3): ");

        IPaymentMethod payment = switch (paymentChoice) {
            case 1 -> new CashPayment();
            case 2 -> new CreditCardPayment();
            case 3 -> new MobileWalletPayment();
            default -> new CashPayment();
        };

        
        IDiscountStrategy discountStrategy;
        long pizzaCount = order.getItems().stream().filter(i -> "Pizza".equals(i.getCategory())).count();
        boolean hasKidsItem = order.getItems().stream().anyMatch(i -> "Kids".equals(i.getCategory()));

        if (hasKidsItem) {
            discountStrategy = new KidsMenuDiscount();
        } else if (pizzaCount >= 2) {
            discountStrategy = new PizzaDiscount();
        } else {
            discountStrategy = ord -> 0.0; // No discount
        }

        
        facade.checkout(order, discountStrategy, payment);

        System.out.println("\nOrder completed successfully!");
        InputHelper.pressEnterToContinue();
    }
}