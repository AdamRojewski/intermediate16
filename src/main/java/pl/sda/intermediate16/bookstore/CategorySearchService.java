package pl.sda.intermediate16.bookstore;

import java.util.ArrayList;
import java.util.List;

public class CategorySearchService {
    public List<CategoryDTO> filterCategories(String categoryName) {
        List<Category> categoryList = InMemoryCategoryDAO.getInstance().getCategoryList();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();

        //musimy teraz zamienic elementy z category do categoryDTO
        for (Category category : categoryList) {
            categoryDTOList.add(buildCategoryDTO(category)); // koniec petli
        }
        for (CategoryDTO categoryDTO : categoryDTOList) {// ustalamy parentID
            if (categoryDTO.getParentID()==null){
                continue; // pozbywamy sie nullPointerException
            }
            //TODO mapa do ponizszego (klucz parentID) zamiast streama
            categoryDTO.setParentCat(
                    categoryDTOList.stream()
                            .filter(c -> c.getId().equals(categoryDTO.getParentID()))
                            .findFirst()
                            .orElse(null));
        }
        //sprawdzamy czy nazwa wpisana zgadza sie z nazwa kategorii
        for (CategoryDTO categoryDTO : categoryDTOList) {
            if (categoryName.trim().equals(categoryDTO.getCategoryName())){ // jesli category name wpisany przez uzytkownika to nazwa kategorii to:
                categoryDTO.getCategoryState().setOpen(true);
                categoryDTO.getCategoryState().setSelected(true); // mamy otwarte i zaznaczone kategorie, ktora zostala wybrana - potrzebne na froncie
                openParent(categoryDTO);
            }
        }

        return categoryDTOList;
    }

    // metodke odpalamy, aby otwierac parentow kategorii
    private void openParent(CategoryDTO categoryDTO) {
        categoryDTO.getCategoryState().setOpen(true);
        if (categoryDTO.getParentID()==null){
            return;
        }
        openParent(categoryDTO.getParentCat()); // zeby byla rekurencja, trzeba odpalic metode w metodzie

    }

    //              to jest wydzielona metoda pod zamienianie
    private CategoryDTO buildCategoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryName(category.getCategoryName().trim());
        categoryDTO.setId(category.getId());
        categoryDTO.setParentID(category.getParentID());
        categoryDTO.setCategoryState(new CategoryState());
        return categoryDTO;
    }
}
