import java.math.BigDecimal;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class RecordMain {
	public static void main(String[] args) {
		var product = new ProductRecord(1, "Apple", "Tasty apples");

		var productId = product.id();
		var productName = product.name();
		System.out.printf("Product %d has name: %s%n", productId, productName);

        var customer = new CustomerRecord(500567L, "Joe Smith", "joe.smith@example.com");


        var product1 = new ProductRecord(100123L, "Apples", "Tasty red apples");
        var product2 = new ProductRecord(100346L, "Bread", "Whole-wheat loaf");

        var lines = new ArrayList<OrderLine>();
        lines.add(new OrderLine(product1, 6, new BigDecimal("5.94")));
        lines.add(new OrderLine(product2, 2, new BigDecimal("2.50")));

        // Create a new order, passing it a mutable ArrayList of order lines.
        // var order = new Order(200201L, customer, LocalDateTime.now(), lines);
        var order = new Order(200201L, null, LocalDateTime.now(), lines);
        System.out.println(order);

        // Adding an order line to the list after creating the order will not modify the order, because its constructor has made a copy of the list.
        var orderLine = new OrderLine(new ProductRecord(100892L, "Bananas", "Yellow bananas"), 1, new BigDecimal("0.99"));
        lines.add(orderLine);
        System.out.println(order);

        // Getting the list of order lines from the order and adding an element to it will cause an UnsupportedOperationException because the copy of the list
        // that the Order object holds is unmodifiable.
        try {
            order.lines().add(orderLine);
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot add to an unmodifiable list");
        }
	}
}