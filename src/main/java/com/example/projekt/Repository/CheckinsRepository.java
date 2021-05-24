package com.example.projekt.Repository;

import com.example.projekt.Entities.Checkins;
import com.example.projekt.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CheckinsRepository implements CrudRepository<Checkins, Long> {
    @Override
    public <S extends Checkins> S save(S s) {
        return null;
    }

    @Override
    public <S extends Checkins> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Checkins> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Checkins> findAll() {
        return null;
    }

    @Override
    public Iterable<Checkins> findAllById(Iterable<Long> iterable) {
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
    public void delete(Checkins checkins) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Checkins> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
