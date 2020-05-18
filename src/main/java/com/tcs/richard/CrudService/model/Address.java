package com.tcs.richard.CrudService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @JsonBackReference
    @NonNull
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "persona_id", nullable = false)
    @ToString.Exclude
    private Person person;

    @NonNull
    @NotNull
    @NotEmpty
    private String street;

    @NonNull
    @NotNull
    @NotEmpty
    private String number;
}
