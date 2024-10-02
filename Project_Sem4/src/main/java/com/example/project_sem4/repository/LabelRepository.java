package com.example.project_sem4.repository;

import com.example.project_sem4.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRepository extends JpaRepository<Label, Integer> {
}
