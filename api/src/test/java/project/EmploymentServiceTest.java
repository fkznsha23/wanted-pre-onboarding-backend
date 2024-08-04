package project;

import entity.JobPost;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import project.dto.JobPostForm;
import project.repository.EmploymentRepo;
import project.service.EmploymentService;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmploymentServiceTest {

    @Mock
    private EmploymentRepo repo;

    @InjectMocks
    private EmploymentService service;

    @Test
    public void 채용공고_등록_성공_테스트() {
        LocalDate endDate = mock(LocalDate.class);
        JobPostForm form = new JobPostForm("제목", 0, "경력", "학력", 3000000, "상세정보", endDate);
        ArgumentCaptor<JobPost> captor = ArgumentCaptor.forClass(JobPost.class);

        service.addPost(form);
        verify(repo).save(captor.capture());

        verify(repo, times(1)).save(captor.capture());
        assertThat(form.getTitle()).isEqualTo(captor.getValue().getTitle());
    }

    @Test
    public void 채용공고_등록_실패_테스트() {
        JobPostForm form = new JobPostForm(null, 0, null, null, 0.0, null, null);
        Throwable ex = assertThrows(NullPointerException.class , () -> service.addPost(form));

        assertThat(ex.getMessage()).isEqualTo("채용공고 필수 입력 칸이 비어있습니다.");
    }
    @Test
    public void 채용공고_조회_성공_테스트() {
        JobPost post = mock(JobPost.class);
        given(repo.getJobPostByNo(anyInt())).willReturn(post);

        service.getPost(anyInt());

        verify(repo, times(1)).getJobPostByNo(anyInt());
    }

    @Test
    public void 채용공고_조회_실패_테스트() {
        Throwable ex = assertThrows(RuntimeException.class, () -> service.getPost(anyInt()));

        assertThat(ex.getMessage()).isEqualTo("조회된 채용공고가 존재하지 않습니다.");
    }


    @Test
    public void 채용공고_삭제_성공_테스트() {
        JobPost post = mock(JobPost.class);
        given(repo.getJobPostByNo(anyInt())).willReturn(post);
        JobPost result = service.getPost(anyInt());

        service.removePost(result.getNo());

        verify(repo, times(1)).delete(result);
    }

    @Test
    public void 채용공고_삭제_실패_테스트(){
        Throwable ex = assertThrows(RuntimeException.class, () -> service.removePost(anyInt()));

        assertThat(ex.getMessage()).isEqualTo("삭제할 채용공고가 존재하지 않습니다.");
    }
}
