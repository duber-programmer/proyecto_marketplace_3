package com.example.marketplace.controller;
import com.example.marketplace.model.Product;
import com.example.marketplace.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/")
public class ProductController {
    private final ProductService service;
    public ProductController(ProductService service){this.service=service;}
    @GetMapping
    public String index(Model model){ model.addAttribute("products", service.listAll()); return "product-list";}
    @GetMapping("product/new")
    public String createForm(Model model){ model.addAttribute("product", new Product()); return "product-form";}
    @GetMapping("product/edit/{id}")
    public String editForm(@PathVariable Long id, Model model){ service.findById(id).ifPresent(p->model.addAttribute("product",p)); return "product-form";}
    @PostMapping("product")
    public String save(@Valid @ModelAttribute("product") Product product, BindingResult br){ if(br.hasErrors()) return "product-form"; service.save(product); return "redirect:/"; }
    @GetMapping("product/delete/{id}")
    public String delete(@PathVariable Long id){ service.deleteById(id); return "redirect:/"; }
}
