package pl.sda.intermediate16.bookstore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
    // ta klasa jest po to, aby uzupelnic informacje na froncie, zawiera dodatkowe pola (categoryState w tym wypadku)

    private Integer id;
    private Integer parentID;
    private String categoryName;
    private CategoryState categoryState;
    private CategoryDTO parentCat; // pole do stworzenia referencji do parenta

}
