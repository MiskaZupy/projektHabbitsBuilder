package com.example.projekt.Repository;

import com.example.projekt.Entities.Coach;
import com.example.projekt.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CoachRepository implements CrudRepository<Coach, Long> {
    @Override
    public <S extends Coach> S save(S s) {
        return null;
    }

    @Override
    public <S extends Coach> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Coach> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Coach> findAll() {
        return null;
    }

    @Override
    public Iterable<Coach> findAllById(Iterable<Long> iterable) {
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
    public void delete(Coach coach) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Coach> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
