/**
 * Demo of using a canonical constructor to prevent a mutable list from being modified.
 */

/*
 * This code is part of the course "Java SE 17 Advanced Language Features" for Pluralsight.
 *
 * Copyright (C) 2022 by Jesper de Jong (jesper@jdj-it.com).
 */

import java.time.LocalDateTime;
import java.util.List;

public record OrderRecord(long id, CustomerRecord customer, LocalDateTime dateTime,
		List<OrderLine> lines) {

	// You can implement the canonical constructor yourself, for example to validate
	// arguments or make defensive copies of mutable arguments.
	public OrderRecord(final long id, final CustomerRecord customer, final LocalDateTime dateTime,
			final List<OrderLine> lines) {
		// Validation of the arguments.
		assert customer != null : "customer must not be null";
		assert dateTime != null : "dateTime must not be null";
		assert lines != null && !lines.isEmpty() : "lines must not be null or empty";

		// The canonical constructor must initialize all fields of the record.
		this.id = id;
		this.customer = customer;
		this.dateTime = dateTime;
		this.lines = List.copyOf(lines); // Making an unmodifiable defensive copy of the argument
											// (which might be a mutable List).
	}
}
