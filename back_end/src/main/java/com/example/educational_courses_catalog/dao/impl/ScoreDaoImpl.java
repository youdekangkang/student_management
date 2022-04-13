package com.example.educational_courses_catalog.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.educational_courses_catalog.dao.ScoreDao;
import com.example.educational_courses_catalog.entity.Score;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScoreDaoImpl implements ScoreDao {

    @Override
    public Score findById(Long Id) {
        return new Score().selectOne(new QueryWrapper<Score>().eq("id", Id));
    }

    @Override
    public List<Score> findAll() {
        return new Score().selectAll();
    }

    @Override
    public boolean update(Score score) {
        return score.updateById();
    }
}
