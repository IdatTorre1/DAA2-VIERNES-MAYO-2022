package com.hernan.pe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hernan.pe.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	Optional<Producto> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
