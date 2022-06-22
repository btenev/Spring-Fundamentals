package softuni.bg.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.bg.model.dto.ProductAddDto;
import softuni.bg.model.dto.ProductViewDto;
import softuni.bg.model.entity.ProductEntity;
import softuni.bg.model.enums.CategoryEnum;
import softuni.bg.repository.CategoryRepository;
import softuni.bg.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    public boolean addProduct(ProductAddDto productAddDto) {
        Optional<ProductEntity> name = this.productRepository.findByName(productAddDto.getName());

        if(name.isPresent()) {
            return false;
        }

        ProductEntity product = this.modelMapper.map(productAddDto, ProductEntity.class);
        product.setCategory(this.categoryRepository.findByName(productAddDto.getCategory()));

        this.productRepository.save(product);

        return true;
    }

    public BigDecimal sumOfAllProducts() {
        return this.productRepository.findTotalPrice();
    }

    public List <ProductViewDto> findAllProductsByCategoryName(CategoryEnum name) {

        return this.productRepository
                .findProductEntitiesByCategory_Name(name)
                .stream()
                .map(productEntity -> this.modelMapper.map(productEntity, ProductViewDto.class))
                .collect(Collectors.toList());
    }

    public void removeProduct(long id) {
        this.productRepository.deleteById(id);
    }

    public void removeAllProducts() {
        this.productRepository.deleteAll();
    }
}
