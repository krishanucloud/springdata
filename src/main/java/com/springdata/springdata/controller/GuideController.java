package com.springdata.springdata.controller;

import com.springdata.springdata.entity.Guide;
import com.springdata.springdata.model.GuideModel;
import com.springdata.springdata.model.StudentModel;
import com.springdata.springdata.repository.GuideRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("guide")
public class GuideController {

    @Autowired
    private GuideRepository guideRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("retrieve-all")
    public List<GuideModel> getAllGuides() {

        List<Guide> guide = guideRepository.findAll();
        List<GuideModel> guideModelList = new ArrayList<>();
        guide.forEach(guide1 -> {
            GuideModel guideModel = modelMapper.map(guide1, GuideModel.class);
            guideModelList.add(guideModel);
        });
        return guideModelList;
    }

    @GetMapping("retrieve")
    public GuideModel getGuide() {

        Guide guide = guideRepository.findById(1L).get();
        GuideModel guideModel = new GuideModel();
        guideModel.setId(guide.getId());
        guideModel.setName(guide.getName());
        List<StudentModel> studentModels = guide.getStudents().stream()
                .map(studentEntity -> {
                    StudentModel studentModel = new StudentModel();
                    studentModel.setId(studentEntity.getId());
                    studentModel.setName(studentEntity.getName());
                    return studentModel;
                })
                .collect(Collectors.toList());
        guideModel.setStudents(studentModels);
        return guideModel;
    }
}
