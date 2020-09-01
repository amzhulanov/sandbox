package com.probation.sandbox.services;

import com.probation.sandbox.entities.Child;
import com.probation.sandbox.repositories.ChildRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@Slf4j
public class ChildService {
    private final ChildRepository childRepository;

    @Autowired
    public ChildService(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    public List<Child> getAllChildsByParent(grpc.ParentId grpcParentId) {
        return childRepository.findChildByParentId((long) grpcParentId.getId()).orElse(null);
    }

    public Child saveChild(Child child){
        return childRepository.save(child);
    }
}
