package com.probation.sandbox.services;

import com.probation.sandbox.entities.Parent;
import com.probation.sandbox.repositories.ParentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class ParentService {
    private final ParentRepository parentRepository;

    @Autowired
    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }


    public Parent findParentByEmail(String email) {
        return parentRepository.findParentByEmail(email).orElse(null);

    }

    public Long saveParent(Parent parent) {
        return parentRepository.save(parent).getId();
    }
}
