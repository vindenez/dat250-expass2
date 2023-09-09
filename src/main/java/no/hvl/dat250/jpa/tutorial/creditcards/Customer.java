package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.*;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Address> addresses = new ArrayList<>();;

    @ManyToMany
    private List<CreditCard> creditCards;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(addresses, customer.addresses) && Objects.equals(creditCards, customer.creditCards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, addresses, creditCards);
    }
}
