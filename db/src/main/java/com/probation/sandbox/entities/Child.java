package com.probation.sandbox.entities;

import com.probation.sandbox.entities.base.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class Child extends AbstractEntity {

    @NotNull
    private String name;

    @NotNull
    private String tariff;

    @NotNull
    private Boolean gender;

    @NotNull
    private Date birthday;

    @NotNull
    @ManyToOne
    @JoinColumn(name="parent_id")
    private Parent parent;
}
