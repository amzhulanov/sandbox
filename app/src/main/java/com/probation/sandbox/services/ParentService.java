package com.probation.sandbox.services;

import com.probation.sandbox.entities.Parent;
import com.probation.sandbox.repositories.ParentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class ParentService {
    private final ParentRepository parentRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public ParentService(ParentRepository parentRepository,BCryptPasswordEncoder passwordEncoder) {
        this.parentRepository = parentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Parent findParentByEmail(String email) {
        return parentRepository.findParentByEmail(email).orElse(null);

    }

    @Transactional
    public Long saveParent(Parent parent) {
        Parent newParent= new Parent();
        newParent.setName(parent.getName());
        newParent.setTimeZone(parent.getTimeZone());
        newParent.setEmail(parent.getEmail());
        if (parent.getPassword() != null) {
            newParent.setPassword(passwordEncoder.encode(parent.getPassword()));
        }

        return parentRepository.save(newParent).getId();
    }
}
