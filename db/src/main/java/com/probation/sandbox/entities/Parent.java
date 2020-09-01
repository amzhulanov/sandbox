package com.probation.sandbox.entities;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.probation.sandbox.entities.base.AbstractEntity;
import lombok.*;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class Parent extends AbstractEntity {

    @NotNull
    @Setter(AccessLevel.NONE)
    private String email;

    @NotNull
    private TimeZone timeZone;

    @NotNull
    private String name;

    @NotNull
    private String password;

    @OneToMany(mappedBy = "parent", orphanRemoval = true, cascade = CascadeType.ALL)
    protected List<Child> childList = new ArrayList<>();

    public Parent(String email,String name, String password,TimeZone tm) {
        this.email=email;
        this.name=name;
        this.password=password;
        this.timeZone=tm;
    }
}
