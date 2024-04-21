package hwagae.psp.service;

import hwagae.psp.entity.MainCategory;
import hwagae.psp.entity.SubCategory;
import hwagae.psp.repository.MainCategoryRepository;
import hwagae.psp.repository.SubCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class HomeService {
    private final SubCategoryRepository subCategoryRepository;
    private final MainCategoryRepository mainCategoryRepository;

    public List<SubCategory> getSubCategory() {
        return subCategoryRepository.findAll();
    }

    public List<MainCategory> getMainCategory() {
        return mainCategoryRepository.findAll();
    }
}