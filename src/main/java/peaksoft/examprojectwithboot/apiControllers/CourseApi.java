package peaksoft.examprojectwithboot.apiControllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import peaksoft.examprojectwithboot.dto.requests.CourseRequest;
import peaksoft.examprojectwithboot.dto.responses.CourseResponse;
import peaksoft.examprojectwithboot.services.CourseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/course")

public class CourseApi {
    private final CourseService courseService;



    @PostMapping
    public CourseResponse create(@RequestBody CourseRequest courseRequest){
        return courseService.create(courseRequest);
    }

    @GetMapping
    public List<CourseResponse> getAllCourses(){
        return courseService.getAllCourses();
    }


}