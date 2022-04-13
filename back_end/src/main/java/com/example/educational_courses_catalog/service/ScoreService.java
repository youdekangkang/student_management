package com.example.educational_courses_catalog.service;

import com.example.educational_courses_catalog.common.Result;
import com.example.educational_courses_catalog.entity.Score;

public interface ScoreService {

    Result findAll();

    Result update(Score score);
}
