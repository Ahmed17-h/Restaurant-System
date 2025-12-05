============================================================
TEAM MEMBERS
============================================================
Ahmed Mahmoud Ibrahim         - ID: 20230650
Mahmoud Ahmed Ibrahim         - ID: 20230368
TA: Marwa Ahmed           - Section: IS_S3,4

============================================================
HOW TO RUN THE PROJECT
============================================================
1. Open the project in IntelliJ IDEA or VS Code 
2. Navigate to: src/main/java/com/restaurant/Main.java
3. Run Main.java
4. Follow the interactive console menu

============================================================
DESIGN PATTERNS IMPLEMENTED
============================================================
- Facade           → RestaurantFacade (unified interface)
- Abstract Factory → VegMenuFactory, NonVegMenuFactory, KidsMenuFactory
- Decorator        → ExtraCheese, ExtraSauce, MushroomTopping (add-ons once only)
- Strategy         → PizzaDiscount, KidsMenuDiscount, MeatDiscount, ChickenDiscount
- Observer         → KitchenNotification & WaiterNotification (real-time alerts)

============================================================
TEST CASES & DISCOUNT SCENARIOS (As Required in Assignment)
============================================================

Test Case 1: Pizza Discount (15% off when ordering 2 or more pizzas)
--------------------------------------------------------------------
Input:
- Menu: Non-Vegetarian
- Items: Margherita Pizza + Pepperoni Pizza
- Add-ons: None
- Payment: Cash
Expected Result: 15% discount applied
Sample Output:
Subtotal: EGP 195.00
Discount (15% Pizza): EGP 29.25
Tax (14%): EGP 23.21
TOTAL: EGP 189.96

Test Case 2: Kids Menu Discount (10% off on any Kids meal)
--------------------------------------------------------------------
Input:
- Menu: Kids
- Item: Kids Cheese Pizza
- Add-ons: Extra Cheese
- Order Type: Dine-in
Expected Result: 10% Kids discount applied automatically
Sample Output:
Subtotal: EGP 80.00
Discount (10% Kids): EGP 8.00
Tax (14%): EGP 10.08
TOTAL: EGP 82.08

Test Case 3: Meat Discount (EGP 25 off on Pepperoni Pizza)
--------------------------------------------------------------------
Input:
- Menu: Non-Vegetarian
- Item: Pepperoni Pizza only
Expected Result: EGP 25 Meat discount applied
Sample Output:
Subtotal: EGP 110.00
Discount (Meat): EGP 25.00
Tax (14%): EGP 11.90
TOTAL: EGP 96.90

Test Case 4: Multiple Add-ons (Only once per type - Decorator Pattern)
--------------------------------------------------------------------
Input:
- Item: Chicken Burger
- Try to add Extra Cheese twice
Expected Result: Second attempt rejected with message "Already added!"
Output:
→ Extra Cheese added
→ Extra Cheese already added!

Test Case 5: Observer Pattern - Kitchen & Waiter Notification
--------------------------------------------------------------------
Expected Result: On every order placement:
[KITCHEN] New Order #1001 received! Start preparing.
[WAITER] Order #1001 placed - Type: dine-in

Test Case 6: Multiple Menus (Abstract Factory Pattern)
--------------------------------------------------------------------
- Selecting "Vegetarian" → Only veg items available
- Selecting "Non-Vegetarian" → Meat items available
- Selecting "Kids" → 4 special kids meals displayed

Test Case 7: Payment Methods (Strategy Pattern)
--------------------------------------------------------------------
- Cash → "Paid in Cash"
- Credit Card → "Paid via Credit Card"
- Mobile Wallet → "Paid via Mobile Wallet"

Test Case 8: Order Types + Waiter Message Change
--------------------------------------------------------------------
- Dine-in → [WAITER] Customer arrived for dine-in
- Delivery → [WAITER] Prepare for delivery
- Takeaway → [WAITER] Customer waiting for takeaway

============================================================
DISCOUNT PRIORITY (Automatic Detection)
============================================================
1. Kids Menu Discount (10%)      → Highest priority if any kids item
2. Pizza Discount (15%)          → If 2+ pizzas
3. Meat Discount (EGP 25)        → If Pepperoni present
4. Chicken Discount (EGP 20)     → If Chicken Burger present
5. No discount                   → Otherwise

============================================================
FEATURES FULLY IMPLEMENTED 
============================================================
- Unified customer interface (Facade)
- Multiple menu types with families (Abstract Factory)
- Customizable add-ons (Decorator - once per type)
- Multiple discount strategies (Strategy - auto applied)
- Kitchen & Waiter notification (Observer)
- Multiple payment methods
- Full order workflow with tax (14%)
- Clean, professional receipt
- Fully extensible & modular design
- 100% SOLID compliant

