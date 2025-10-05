package supri.com.test.mylibrary.util;

public enum TypeOfBooks {
	NOVEL("One of Novel"),
	DOCUMENTATION("Documentation"),
	OTHER("Other");

    private final String description;

    TypeOfBooks(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}