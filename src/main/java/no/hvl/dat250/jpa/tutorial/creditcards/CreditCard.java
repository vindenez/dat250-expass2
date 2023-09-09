package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;
    private Integer balance;
    private Integer creditLimit;

    @ManyToMany(mappedBy = "creditCards")
    private List<Customer> customers;

    @ManyToOne
    private Bank bank;

    @ManyToOne
    private Pincode pincode;


    public Bank getOwningBank() {
        return getBank();
    }
}
