package hwagae.psp.controller;

import hwagae.psp.entity.MainCategory;
import hwagae.psp.entity.SubCategory;
import hwagae.psp.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final HomeService homeService;

    /**
     * 카테고리 목록 주기
     */

    public List<SubCategory> getSubCategory(){
        return homeService.getSubCategory();
    }

    public List<MainCategory> getMainCategory(){
        return homeService.getMainCategory();
    }

}
