package project;

import entity.JobPost;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.jooq.JooqTest;
import project.dto.JobPostForm;
import project.dto.JobPostModifyForm;
import project.repository.EmploymentRepo;
import project.service.EmploymentService;

import java.time.LocalDate;
import java.util.List;

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

    private ArgumentCaptor<JobPost> captor;
    private JobPostForm form;

    @BeforeEach
    public void setUp() {
        form = new JobPostForm("제목", "포지션", 0, "경력", "학력", 3000000, "상세정보", mock(LocalDate.class));
        captor = ArgumentCaptor.forClass(JobPost.class);
        service.addPost(form);
        verify(repo).save(captor.capture());
    }

    @Test
    public void 채용공고_등록_성공_테스트() {
        JobPost result = captor.getValue();

        verify(repo, times(1)).save(captor.capture());
        assertThat(form.getTitle()).isEqualTo(result.getTitle());
    }

    @Test
    public void 채용공고_등록_실패_테스트() {
        JobPostForm form = new JobPostForm(null, null, 0, null, null, 0.0, null, null);
        Throwable ex = assertThrows(NullPointerException.class , () -> service.addPost(form));

        assertThat(ex.getMessage()).isEqualTo("채용공고 필수 입력 칸이 비어있습니다.");
    }
    @Test
    public void 채용공고_조회_성공_테스트() {
        given(repo.getJobPostByNo(anyInt())).willReturn(captor.getValue());

        JobPost post = service.getPost(anyInt());

        verify(repo, times(1)).getJobPostByNo(anyInt());
        assertThat(form.getTitle()).isEqualTo(post.getTitle());
    }

    @Test
    public void 채용공고_조회_실패_테스트() {
        Throwable ex = assertThrows(RuntimeException.class, () -> service.getPost(anyInt()));

        assertThat(ex.getMessage()).isEqualTo("조회된 채용공고가 존재하지 않습니다.");
    }

    @Test
    public void 채용공고_삭제_성공_테스트() {
        given(repo.deleteByNo(anyInt())).willReturn(captor.getValue());

        JobPost post = service.removePost(anyInt());

        verify(repo, times(1)).deleteByNo(anyInt());
        assertThat(post.getTitle()).isEqualTo(form.getTitle());
    }

    @Test
    public void 채용공고_삭제_실패_테스트(){
        Throwable ex = assertThrows(RuntimeException.class, () -> service.removePost(anyInt()));

        assertThat(ex.getMessage()).isEqualTo("삭제할 채용공고가 존재하지 않습니다.");
    }

    @Test
    public void 채용공고_전체삭제_성공_테스트() {
        service.removeAllPost();

        verify(repo, times(1)).deleteAll();
    }

    @Test
    public void 채용공고_수정_성공_테스트(){
        JobPost post = captor.getValue();
        ArgumentCaptor<JobPost> modifyCaptor = ArgumentCaptor.forClass(JobPost.class);

        given(repo.getJobPostByNo(anyInt())).willReturn(post);
        JobPostModifyForm modifyForm = new JobPostModifyForm(post.getNo(), "수정된 제목", "수정된 포지션", "커리어", "학력", 100000
                                                            , "수정된 상세정보", mock(LocalDate.class));

        service.updateJobPost(modifyForm);
        verify(repo, times(2)).save(modifyCaptor.capture());
        JobPost modify = modifyCaptor.getValue();

        verify(repo, times(1)).getJobPostByNo(anyInt());
        assertThat(modify.getTitle()).isEqualTo(modifyForm.getTitle());
        assertThat(modify.getNo()).isEqualTo(modifyForm.getNo());
    }

    @Test
    public void 채용공고_수정_실패_테스트() {
        JobPostModifyForm modifyForm = new JobPostModifyForm(1, "수정된 제목", "수정된 포지션", "커리어", "학력", 100000
                , "수정된 상세정보", mock(LocalDate.class));

        Throwable ex = assertThrows(RuntimeException.class, () -> service.updateJobPost(modifyForm));

        assertThat(ex.getMessage()).isEqualTo("수정할 채용공고가 존재하지 않습니다.");
    }
}
