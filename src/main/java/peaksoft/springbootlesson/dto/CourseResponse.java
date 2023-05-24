package peaksoft.springbootlesson.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import peaksoft.springbootlesson.entity.Company;

import java.time.LocalDate;
@Getter
@Setter

public class CourseResponse {
    private String courseName;
    private String durationMonth;
    private LocalDate localDate;
    private Boolean isActive;
    private Boolean isDeleted;
//    private Company company;
    private Long companyId;
    private String companyName;
}
