package pl.sda.intermediate16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCategoryDAOTest {
    @Test
    void shouldPopulateCategoriesListProperly(){
        InMemoryCategoryDAO inMemoryCategoryDAO = new InMemoryCategoryDAO();
        List<Category> categoryList = inMemoryCategoryDAO.getCategoryList();
        Assertions.assertEquals(4, pickParentId(categoryList));
    }
    private Integer pickParentId(List<Category> categoryList){
        return categoryList.stream()
                .filter(c->c.getId().equals(5))
                .findFirst()
                .map(e->e.getParentID())// uruchomi sie tylko kiedy FindFirst cos znajdzie
                .orElse(null); // uruchomi sie tylko wtedy kiedy nic nie zostani znalezione
    }
}