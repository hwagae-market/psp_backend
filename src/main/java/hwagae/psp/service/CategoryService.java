package hwagae.psp.service;

import hwagae.psp.dto.request.RequestCategoryDto;
import hwagae.psp.entity.Category;
import hwagae.psp.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public void saveCategory(RequestCategoryDto requestCategory) {
        categoryRepository.save(requestCategory.toEntity());
    }

    public List<Category> searchByKeyword(String keyword) {
        return categoryRepository.findAllByNameContaining(keyword);
    }
}
