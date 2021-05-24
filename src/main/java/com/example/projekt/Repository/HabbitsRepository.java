package com.example.projekt.Repository;

import com.example.projekt.Entities.Habits;
import com.example.projekt.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class HabbitsRepository implements CrudRepository<Habits, Long> {
    @Override
    public <S extends Habits> S save(S s) {
        return null;
    }

    @Override
    public <S extends Habits> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Habits> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Habits> findAll() {
        return null;
    }

    @Override
    public Iterable<Habits> findAllById(Iterable<Long> iterable) {
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
    public void delete(Habits habits) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Habits> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}

