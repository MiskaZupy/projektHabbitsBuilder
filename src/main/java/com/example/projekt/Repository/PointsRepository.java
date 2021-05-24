package com.example.projekt.Repository;

import com.example.projekt.Entities.Points;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PointsRepository implements CrudRepository<Points, Long> {
    @Override
    public <S extends Points> S save(S s) {
        return null;
    }

    @Override
    public <S extends Points> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Points> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Points> findAll() {
        return null;
    }

    @Override
    public Iterable<Points> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Points points) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Points> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
