package pl.sda.intermediate16.bookstore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategorySearchServiceTest {
    @Test
    void filterCategoriesShouldWork() {
        CategorySearchService categorySearchService = new CategorySearchService();
        List<CategoryDTO> categoryDTOList = categorySearchService.filterCategories("lektury"); // ctr alt V - wyrzucenie do zmiennej
    CategoryDTO c4 = categoryDTOList.stream()
            .filter(c->c.getId().equals(4))
            .findFirst()
            .orElse(null);
        Assertions.assertTrue(((CategoryDTO) c4).getCategoryState().isOpen());
    }
}