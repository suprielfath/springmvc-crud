package supri.com.test.mylibrary.util;

import org.springframework.stereotype.Component;


public enum TypeOfBooks {
	NOVEL("one of novel"),
	DOCUMENTATION("documentation"),
	OTHER("other");

    private String url;

    TypeOfBooks(String url) {
        this.url = url;
    }

    public String url() {
        return url;
    }

}
