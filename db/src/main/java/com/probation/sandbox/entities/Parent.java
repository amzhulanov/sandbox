package com.probation.sandbox.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;

import com.probation.sandbox.entities.base.AbstractEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class Parent extends AbstractEntity {

    @NotNull
    private String email;

    @NotNull
    private TimeZone timeZone;

    @NotNull
    private String name;

    @NotNull
    private String password;

    @OneToMany(mappedBy = "parent", orphanRemoval = true, cascade = CascadeType.ALL)
    protected List<Child> childList = new ArrayList<>();

    private AdminRole adminRole;

    @Value("${default.role}")
    private boolean adminRoleValue;

    @PostLoad
    void fillRoleCode() {
        this.adminRole = AdminRole.getById(adminRoleValue);
    }

    @PrePersist
    @PreUpdate
    void fillRoleCodeValue() {
        if (adminRole != null) {
            this.adminRoleValue = adminRole.isId();
        }
    }

    public Parent(String email, String name, String password, TimeZone tm) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.timeZone = tm;
    }

}
