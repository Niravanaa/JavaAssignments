// -----------------------------------------------------
// Assignment 3
// Written by: Nirav Patel #40248940
// -----------------------------------------------------

/**
 * TooManyFieldsException is a custom exception class that extends the base Exception class.
 * It is thrown when the number of fields exceeds a certain limit.
 */
class TooManyFieldsException extends Exception {
    /**
     * Constructs a new TooManyFieldsException with the specified error message.
     *
     * @param s the error message.
     */
    public TooManyFieldsException(String s) {
        super(s);
    }
}

/**
 * TooFewFieldsException is a custom exception class that extends the base Exception class.
 * It is thrown when the number of fields is under a certain threshold.
 */
class TooFewFieldsException extends Exception {
    /**
     * Constructs a new TooFewFieldsException with the specified error message.
     *
     * @param s the error message.
     */
    public TooFewFieldsException(String s) {
        super(s);
    }
}

/**
 * MissingFieldException is a custom exception class that extends the base Exception class.
 * It is thrown when the a certain field of a record is missing.
 */
class MissingFieldException extends Exception {
    /**
     * Constructs a new MissingFieldException with the specified error message.
     *
     * @param s the error message.
     */
    public MissingFieldException(String s) {
        super(s);
    }
}

/**
 * UnknownGenreException is a custom exception class that extends the base Exception class.
 * It is thrown when the genre is not identifiable.
 */
class UnknownGenreException extends Exception {
    /**
     * Constructs a new UnknownGenreException with the specified error message.
     *
     * @param s the error message.
     */
    public UnknownGenreException(String s) {
        super(s);
    }
}

/**
 * BadIsbn10Exception is a custom exception class that extends the base Exception class.
 * It is thrown when the Isbn10 of the syntax-correct record is invalid.
 */
class BadIsbn10Exception extends Exception {
    /**
     * Constructs a new BadIsbn10Exception with the specified error message.
     *
     * @param s the error message.
     */
    public BadIsbn10Exception(String s) {
        super(s);
    }
}

/**
 * BadIsbn13Exception is a custom exception class that extends the base Exception class.
 * It is thrown when the Isbn13 of the syntax-correct record is invalid.
 */
class BadIsbn13Exception extends Exception {
    /**
     * Constructs a new BadIsbn13Exception with the specified error message.
     *
     * @param s the error message.
     */
    public BadIsbn13Exception(String s) {
        super(s);
    }
}

/**
 * BadPriceException is a custom exception class that extends the base Exception class.
 * It is thrown when the price is a negative double.
 */
class BadPriceException extends Exception {
    /**
     * Constructs a new BadPriceException with the specified error message.
     *
     * @param s the error message.
     */
    public BadPriceException(String s) {
        super(s);
    }
}

/**
 * BadYearException is a custom exception class that extends the base Exception class.
 * It is thrown when the year is not between the closed interval [1995, 2010].
 */
class BadYearException extends Exception {
    /**
     * Constructs a new BadYearException with the specified error message.
     *
     * @param s the error message.
     */
    public BadYearException(String s) {
        super(s);
    }
}