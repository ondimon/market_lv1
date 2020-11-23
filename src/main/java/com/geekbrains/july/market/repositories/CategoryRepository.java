package com.geekbrains.july.market.repositories;

import com.geekbrains.july.market.entities.Category;
import com.geekbrains.july.market.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
