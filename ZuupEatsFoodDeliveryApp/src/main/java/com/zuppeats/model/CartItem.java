package com.zuppeats.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart; // Reference to the Cart

    @ManyToOne
    @JoinColumn(name = "dish_id", nullable = false)
    private Dish dish; // Reference to the Dish or Product being added

    private Integer quantity;
    private Double price;

    // Calculated based on quantity * price for this item
    public Double getTotalPrice() {
        return this.quantity * this.price;
    }
}
