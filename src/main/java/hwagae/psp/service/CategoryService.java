package hwagae.psp.service;

import hwagae.psp.dto.request.RequestCategoryDto;
import hwagae.psp.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public void saveCategory(RequestCategoryDto requestCategory) {
        categoryRepository.save(requestCategory.toEntity());
    }
}
