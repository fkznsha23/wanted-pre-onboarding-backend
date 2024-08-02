package project;

import entity.JobPost;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import project.dto.JobPostDetail;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmploymentControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;



    @Test
    public void employmentAddTest() {
        MultiValueMap<String , Object> map = new LinkedMultiValueMap<>();
        map.add("title", "제목");
        map.add("companyNo", 1);
        map.add("career", "경력");
        map.add("degree", "학력");
        map.add("salary", 1000000);
        map.add("detail", "상세정보");
        map.add("endDate", "2024-10-10");

        ResponseEntity<JobPostDetail> result = testRestTemplate.postForEntity("/employment/job-post", map, JobPostDetail.class);
        JobPostDetail postDetail = result.getBody();

        assertThat(postDetail.getTitle()).isEqualTo("제목");
    }
}
