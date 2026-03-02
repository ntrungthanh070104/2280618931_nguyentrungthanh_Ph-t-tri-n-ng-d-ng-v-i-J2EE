package com.example.__nguyentrungthanh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.__nguyentrungthanh.model.Product;
import com.example.__nguyentrungthanh.service.CategoryService;
import com.example.__nguyentrungthanh.service.ProductService;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String listProducts(Model model) {
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("products", productList);
        return "product/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product/add";
    }

    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
        // Nếu có lỗi xác thực (để trống tên, giá sai, chưa chọn danh mục...)
        if (bindingResult.hasErrors()) {
            // Phải gửi lại danh sách categories để Form Select hiển thị được
            model.addAttribute("categories", categoryService.getAllCategories());
            return "product/add"; // Trả lại trang form thay vì crash ứng dụng
        }

        // Nếu dữ liệu hợp lệ thì mới lưu
        productService.saveProduct(product);
        return "redirect:/products";
    }
}