package com.example.educational_courses_catalog.service.impl;

import com.example.educational_courses_catalog.common.Result;
import com.example.educational_courses_catalog.dao.ScoreDao;
import com.example.educational_courses_catalog.dao.UserDao;
import com.example.educational_courses_catalog.entity.Score;
import com.example.educational_courses_catalog.entity.User;
import com.example.educational_courses_catalog.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreDao scoreDao;

    @Autowired
    private UserDao userDao;

    private void findTeacherName(Score score){
        String teacherId = score.getTeacher();
        User user = userDao.findById((long) Integer.parseInt(teacherId));
        score.setTeacher(user.getUsername());
    }

    @Override
    @Transactional
    public Result findAll() {
        List<Score> scores = scoreDao.findAll();
        for (Score score : scores) {
            findTeacherName(score);
        }
        return Result.success("success", scores);
    }

    @Override
    @Transactional
    public Result update(Score score) {
        Score score1 = scoreDao.findById(score.getId());
        Double newScore = (score.getScore() + score1.getScore()) / 2;
        score.setScore(newScore);
        boolean update = scoreDao.update(score);
        return update ? Result.success("update successfully")
                : Result.error("update failed");
    }
}
