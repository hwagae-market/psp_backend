package hwagae.psp.controller;

import hwagae.psp.dto.request.RequestCategoryDto;
import hwagae.psp.dto.response.ResponseCategoryDto;
import hwagae.psp.entity.Category;
import hwagae.psp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryApiController {

    private final CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<String> saveCategory(@RequestBody RequestCategoryDto categoryDto) {
        categoryService.saveCategory(categoryDto);
        return ResponseEntity.ok("저장 완료");
    }

    @GetMapping("/search")
    public ResponseEntity<List<Category>> searchByKeyword(@RequestParam String keyword) {
        List<Category> searchResult = categoryService.searchByKeyword(keyword);

        return ResponseEntity.ok(searchResult);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ResponseCategoryDto>> getCategoryList() {
        List<ResponseCategoryDto> categoryList = categoryService.findAll();

        return ResponseEntity.ok(categoryList);
    }
}
