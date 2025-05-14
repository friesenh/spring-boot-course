package com.codewithmosh.store.services;

import com.codewithmosh.store.entities.Address;
import com.codewithmosh.store.entities.Category;
import com.codewithmosh.store.entities.Product;
import com.codewithmosh.store.entities.User;
import com.codewithmosh.store.repositories.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
public class UserService {

    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    @Transactional
    public void showRelatedEntities() {
        var profile = profileRepository.findById(2L).orElseThrow();
        System.out.println(profile.getUser().getEmail());
    }

    public void fetchAddress() {
        var address = addressRepository.findById(1L).orElseThrow();
    }

    public void persistRelated() {
        var user = User.builder()
                .name("Jane Doe")
                .email("janedoe@gmail.com")
                .password("password")
                .build();

        var address = Address.builder()
                .street("Main Street")
                .city("Main City")
                .state("Main State")
                .zip("Main Zip")
                .build();

        user.addAddress(address);

        userRepository.save(user);
    }

    public void deleteRelated() {
        userRepository.deleteById(4L);
    }

    @Transactional
    public void manageProducts() {
        var product = productRepository.findById(4L).orElseThrow();
        productRepository.deleteById(product.getId());
    }
}
