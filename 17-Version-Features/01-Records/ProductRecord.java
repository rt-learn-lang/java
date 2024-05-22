/*
 * This code is part of the course "Java SE 17 Advanced Language Features" for Pluralsight.
 *
 * Copyright (C) 2022 by Jesper de Jong (jesper@jdj-it.com).
 */

/**
 * Example of a record with the same functionality as the immutable class {@link ProductCls}.
 */
public record ProductRecord(long id, String name, String description) {
}
