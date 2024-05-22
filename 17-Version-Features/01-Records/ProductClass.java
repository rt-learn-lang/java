/**
 * Demo of a Product class to show how a record makes it much simpler.
 */

/*
 * This code is part of the course "Java SE 17 Advanced Language Features" for Pluralsight.
 *
 * Copyright (C) 2022 by Jesper de Jong (jesper@jdj-it.com).
 */
import java.util.Objects;

/**
 * Example of an immutable class.
 */
public final class ProductClass { // The class itself is final

	// Private final fields
	private final long id;
	private final String name;
	private final String description;

	// A constructor with a parameter for each field
	public ProductClass(final long id, final String name, final String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	// Getter methods for the fields
	public long getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public String getDescription()
	{
		return description;
	}

	// equals(Object o), hashCode() and toString() methods
	@Override
	public boolean equals(final Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		final ProductClass that = (ProductClass) o;
		return id == that.id && Objects.equals(name, that.name)
				&& Objects.equals(description, that.description);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id, name, description);
	}

	@Override
	public String toString()
	{
		return "ProductClass{" + "id=" + id + ", name='" + name + '\'' + ", description='"
				+ description + '\'' + '}';
	}
}
