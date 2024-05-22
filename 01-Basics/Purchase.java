import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Purchase(long productId, int quantity, BigDecimal price, LocalDateTime dateTime) {

	// Add your solution here
	public Purchase {
		if (quantity <= 0)
			throw new IllegalArgumentException("Quantity must be greater than 0");

		if (price.doubleValue() <= 0)
			throw new IllegalArgumentException("Price must be greater than 0");

		if (dateTime.isBefore(LocalDateTime.now()))
			throw new IllegalArgumentException("dateTime must be a past date");
	}
}
