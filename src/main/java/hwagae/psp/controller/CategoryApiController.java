package hwagae.psp.controller;

import hwagae.psp.dto.request.RequestCategoryDto;
import hwagae.psp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
