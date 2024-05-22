/*
 * This code is part of the course "Java SE 17 Advanced Language Features" for Pluralsight.
 *
 * Copyright (C) 2022 by Jesper de Jong (jesper@jdj-it.com).
 */

import java.math.BigDecimal;

public record OrderLine(ProductRecord product, int quantity, BigDecimal price) {
}
