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
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order; // Reference to the associated Order

    @ManyToOne
    @JoinColumn(name = "dish_id", nullable = false)
    private Dish dish; // Reference to the associated Dish

    private Integer quantity; // Quantity of the dish ordered
    private Double price; // Price of a single dish item

    @Transient
    public Double getItemTotal() {
        return this.quantity * this.price; // Calculate the total for this line item
    }
}
