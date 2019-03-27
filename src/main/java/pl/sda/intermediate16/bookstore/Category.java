package pl.sda.intermediate16.bookstore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    private Integer id;
    private Integer parentID;
    private String categoryName;


}
