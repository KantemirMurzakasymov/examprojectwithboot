package peaksoft.examprojectwithboot.apiControllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import peaksoft.examprojectwithboot.dto.requests.CourseRequest;
import peaksoft.examprojectwithboot.dto.responses.CourseResponse;
import peaksoft.examprojectwithboot.services.CourseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('SUPER_ADMIN')")
@RequestMapping("api/courses")

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

    @GetMapping("find/{id}")
    public CourseResponse findById(@PathVariable Long id){
        return  courseService.findById(id);
    }

    @PutMapping("update/{id}")
    public CourseResponse update(@PathVariable Long id, @RequestBody CourseRequest courseRequest){
        return courseService.update(courseRequest,id);
    }

    @DeleteMapping("delete/{id}")
    public CourseResponse delete(@PathVariable Long id){
        return courseService.delete(id);
    }
}
