package com.tcs.richard.CrudService.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
@RequiredArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @JsonManagedReference
    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Address> address;

    @NonNull
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    @Min(0)
    private String age;

    @NonNull
    @NotNull
    @NotEmpty
    private String bloodType;
}
