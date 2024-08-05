package project.controller;

import entity.Company;
import entity.JobPost;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.dto.*;
import project.service.CompanyService;
import project.service.EmploymentService;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employment")
public class EmploymentController {

    private final EmploymentService emplService;
    private final CompanyService companyService;

    @PostMapping("/job-post")
    public JobPostDetail addJobPost(@ModelAttribute JobPostForm form) {
        return emplService.createJobPostDetail(emplService.addPost(form));
    }

    @DeleteMapping("/all-job-post")
    public void allRemoveJobPost(){
        emplService.removeAllPost();
    }

    @DeleteMapping("/job-post")
    public List<JobSimplePost> removeJobPost(int postNo){
        JobPost post = emplService.removePost(postNo);
        List<JobPost> postList = emplService.getAllJobPostByCompanyNo(post.getCompanyNo());
        List<CompletableFuture<JobSimplePost>> comlList = emplService.changeSimplePost(postList);
        CompletableFuture<List<JobSimplePost>> simplList = emplService.changeAsync(comlList);

        return simplList.join();
    }

    @PutMapping("/job-post")
    public JobPostDetail updateJobPost(@ModelAttribute JobPostModifyForm form) {
        return emplService.createJobPostDetail(emplService.updateJobPost(form));
    }

    @GetMapping("/all-job-post")
    public List<JobSimplePost> getAllJobPost() {
        List<JobPost> postList = emplService.getAllJobPost();
        List<CompletableFuture<JobSimplePost>> complList = emplService.changeSimplePost(postList);
        CompletableFuture<List<JobSimplePost>> simplPostList = emplService.changeAsync(complList);

        return simplPostList.join();
    }

    @GetMapping("/job-post-detail/{no}")
    public JobPostDetail getJobPostDetailByNo(@PathVariable int no) {
        return emplService.createJobPostDetail(emplService.getJobPostByNo(no));
    }
}
