package iticbcn.yeray.mvc.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long product_id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String company;
    @Column
    private float price;
    @Column
    private long units;
    @Column(name = "creation_at")
    private LocalDateTime creationDate;
    @Column(name = "updated_at")
    private LocalDateTime updateDate;
    @Column
    private String subcategory;

/*     @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="subcategory_id")
    private Subcategory subcategory;    */ 
}
