package com.example.educational_courses_catalog.dao;

import com.example.educational_courses_catalog.entity.Score;

import java.util.List;

public interface ScoreDao {

    Score findById(Long Id);

    List<Score> findAll();

    boolean update(Score score);
}
