package com.gmdhody.apiforrajerapt1.repositories;

import com.gmdhody.apiforrajerapt1.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
    @Query("select c from Categoria c where c.status=1 order by c.nombre asc ")
    public List<Categoria> findAllByStatus();
    @Query("select c.nombre from Categoria c where c.status=1")
    public List<String> findNombresByStatus();
}
