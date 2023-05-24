package peaksoft.springbootlesson.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import peaksoft.springbootlesson.dto.CourseRequest;
import peaksoft.springbootlesson.dto.CourseResponse;
import peaksoft.springbootlesson.entity.Company;
import peaksoft.springbootlesson.entity.Course;
import peaksoft.springbootlesson.repository.CompanyRepository;
import peaksoft.springbootlesson.repository.CourseRepository;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseService {
    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepository;

    public CourseResponse create(CourseRequest request){
        Course course = new Course();
        course.setCourseName(request.getCourseName());
        course.setDurationMonth(request.getDurationMonth());
        course.setLocalDate(LocalDate.now());
        course.setIsActive(course.getIsActive());
        course.setIsDeleted(course.getIsDeleted());
        Company company = companyRepository.findById(request.getCompanyId()).get();

        course.setCompany(company);
        courseRepository.save(course);
        log.info("Saved course: "+course.getCourseName());
        return mapToResponse(course);

    }

    public CourseResponse mapToResponse(Course course){
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setCourseName(course.getCourseName());
        courseResponse.setDurationMonth(course.getDurationMonth());
        courseResponse.setCompanyId(course.getCompany().getId());
        courseResponse.setCompanyName(course.getCompany().getCompanyName());
        courseResponse.setLocalDate(course.getLocalDate());
        courseResponse.setIsActive(course.getIsActive());
        courseResponse.setIsDeleted(course.getIsDeleted());
        return courseResponse;
    }



}
