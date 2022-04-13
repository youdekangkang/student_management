package com.example.educational_courses_catalog.controller;

import com.example.educational_courses_catalog.common.Result;
import com.example.educational_courses_catalog.entity.Score;
import com.example.educational_courses_catalog.service.ScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "score management")
@CrossOrigin
@RestController
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @ApiOperation("find all teachers' scores")
    @GetMapping("findAll")
    public Result findAll(){
        return scoreService.findAll();
    }

    @ApiOperation("update a teacher's score")
    @PutMapping("/update")
    public Result update(@RequestBody Score score){
        return scoreService.update(score);
    }

}
