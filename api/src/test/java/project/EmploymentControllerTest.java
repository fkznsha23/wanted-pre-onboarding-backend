package project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import project.dto.JobPostDetail;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmploymentControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private MultiValueMap<String, Object> map;

    @BeforeEach
    public void setUp(){
        testRestTemplate.delete("/employment/all-job-post");

        map = new LinkedMultiValueMap<>();
        map.add("title", "제목");
        map.add("position", "포지션");
        map.add("companyNo", 1);
        map.add("career", "경력");
        map.add("degree", "학력");
        map.add("salary", 1000000);
        map.add("detail", "상세정보");
        map.add("endDate", "2024-10-10");
    }

    @Test
    public void JobPostAddTest() {
        ResponseEntity<JobPostDetail> result = testRestTemplate.postForEntity("/employment/job-post", map, JobPostDetail.class);
        JobPostDetail postDetail = result.getBody();

        assertThat(postDetail.getTitle()).isEqualTo("제목");
    }

    @Test
    public void JobPostModifyTest(){
        ResponseEntity<JobPostDetail> addResult = testRestTemplate.postForEntity("/employment/job-post", map, JobPostDetail.class);
        JobPostDetail postDetail = addResult.getBody();

        MultiValueMap<String, Object> modifyMap = new LinkedMultiValueMap<>();
        modifyMap.add("no", postDetail.getNo());
        modifyMap.add("title", "수정된 제목");
        modifyMap.add("position", postDetail.getPosition());
        modifyMap.add("career", "수정된 경력");
        modifyMap.add("degree", postDetail.getDegree());
        modifyMap.add("salary", postDetail.getSalary());
        modifyMap.add("detail", "수정된 상세정보");
        modifyMap.add("endDate", "2024-10-10");

        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(modifyMap);
        ResponseEntity<JobPostDetail> updateResult = testRestTemplate.exchange("/employment/job-post", HttpMethod.PUT, entity, JobPostDetail.class);
        JobPostDetail update = updateResult.getBody();

        System.out.println(postDetail.getNo());
        System.out.println(update.getNo());

        assertThat(postDetail.getNo()).isEqualTo(update.getNo());
    }

    @Test
    public void getJobPostList(){

    }
}
