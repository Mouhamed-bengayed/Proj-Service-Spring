package com.example.glsib.Repository;

import com.example.glsib.Entite.Comment;
import com.example.glsib.Entite.Provider;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider,Long> {
}
