# 프리온보딩 백엔드 인턴십 선발과제


## 사용 기술
Java, Spring boot, JPA, JUnit, REST


## 개발 방식
1. TDD
2. 성공 테스트뿐만 아니라 실패 테스트도 작성
3. 인터페이스를 이용한 개방-폐쇄 원칙 지키기
4. 멀티 모듈 사용


## 채용공고 등록
### REST API
#### HTTP
- POST

#### 행위 
- 채용공고를 등록한다.

#### 설명 
- 회사가 작성한 채용공고를 채용 사이트에 등록한다.
- 등록한 채용공고를 반환받는다.

#### URI 
- POST/recruitment

#### RequstBody 
- {title : 제목, 
companyNo : 회사 pk, 
career : 경력, 
degree : 학력, 
salary : 급여, 
detail : 상세정보, 
endDate : 마감일}

#### ResponseBody
- {title : 제목, 
career : 경력, 
degree : 학력, 
salary : 급여, 
detail : 상세정보, 
endDate : 마감일, 
companyName : 회사 이름, 
homePage: 홈페이지, 
address : 근무지 주소}

#### content type 
- application/json

#### Link 
- https://velog.io/@rladmswjd119/%ED%94%84%EB%A6%AC%EC%98%A8%EB%B3%B4%EB%94%A9-%EB%B0%B1%EC%97%94%EB%93%9C-%EC%9D%B8%ED%84%B4%EC%8B%AD-%EC%84%A0%EB%B0%9C%EA%B3%BC%EC%A0%9C-REST-API-Link

### 예외 상황 및 처리
- 필수 작성 값 누락시 예외 발생
- 중복 제목 채용공고 업로드 시 예외 발생


## 채용공고 수정
### REST API
#### HTTP
- PUT

#### 행위 
- 채용공고를 수정한다.

#### 설명 
- 회사는 등록한 채용공고를 수정할 수 있다.
- 수정하려고 하는 채용공고를 조회하고 수정한다.
- 수정된 채용공고를 반환받는다.

#### URI 
- PUT/recruitment/{no}

#### RequstBody 
- {title : 제목, 
career : 경력, 
degree : 학력, 
salary : 급여, 
detail : 상세정보, 
endDate : 마감일}

#### ResponseBody
- {title : 제목, 
career : 경력, 
degree : 학력, 
salary : 급여, 
detail : 상세정보, 
endDate : 마감일, 
companyName : 회사 이름, 
homePage: 홈페이지, 
address : 근무지 주소}

#### content type 
- application/json

#### Link 
- https://velog.io/@rladmswjd119/%ED%94%84%EB%A6%AC%EC%98%A8%EB%B3%B4%EB%94%A9-%EB%B0%B1%EC%97%94%EB%93%9C-%EC%9D%B8%ED%84%B4%EC%8B%AD-%EC%84%A0%EB%B0%9C%EA%B3%BC%EC%A0%9C-REST-API-Link

### 예외 상황 및 처리
- 필수 작성 값 누락시 예외 발생
- 수정하고자 하는 채용공고 조회 실패시 예외 발생


## 채용공고 삭제
### REST API
#### HTTP
- DELETE

#### 행위 
- 채용공고를 삭제한다.

#### 설명 
- 회사는 등록한 채용공고를 삭제할 수 있다.
- 삭제 후 회사가 작성한 채용공고 목록을 반환한다.

#### URI 
- DELETE/recruitment/{no}

#### RequstBody 
- {no: 채용공고 pk}

#### content type 
- application/json

#### Link 
- https://velog.io/@rladmswjd119/%ED%94%84%EB%A6%AC%EC%98%A8%EB%B3%B4%EB%94%A9-%EB%B0%B1%EC%97%94%EB%93%9C-%EC%9D%B8%ED%84%B4%EC%8B%AD-%EC%84%A0%EB%B0%9C%EA%B3%BC%EC%A0%9C-REST-API-Link

### 예외 상황 및 처리
- 삭제하고자 하는 채용공고 조회 실패시 예외 발생


## 채용공고 목록
### REST API
#### HTTP
- GET

#### 행위 
- 채용공고 목록을 가져온다.

#### 설명 
- 사용자는 채용 사이트에 게시된 채용공고 목록을 조회할 수 있다.
- 채용공고 목록 페이지에는 채용공고의 제목, 회사 이름, 경력, 지역, 포지션, 최종 학력만 표시된다.

#### URI 
- GET/all-recruitment

#### ResponseBody 
- {title : 제목, 
name : 회사 이름, 
career : 경력}

#### content type 
- application/json

#### Link 
- https://velog.io/@rladmswjd119/%ED%94%84%EB%A6%AC%EC%98%A8%EB%B3%B4%EB%94%A9-%EB%B0%B1%EC%97%94%EB%93%9C-%EC%9D%B8%ED%84%B4%EC%8B%AD-%EC%84%A0%EB%B0%9C%EA%B3%BC%EC%A0%9C-REST-API-Link

### 예외 상황 및 처리
- 채용 공고가 존재하지 않을시 예외 발생


## 채용공고 검색 (선택사항 및 가산점요소)
### REST API
#### HTTP
- GET

#### 행위 
- 특정 채용공고를 검색한다.

#### 설명 
- 사용자가 원하는 키워드가 제목에 포함된 채용공고를 검색한다.

#### URI 
- GET/recruitment/title={%search%}

#### RequstBody 
- {keyword: 제목 키워드, career: 경력, degree: 학력, address: 지역}

#### ResponseBody
- {title : 제목, 
name : 회사 이름, 
career : 경력}

#### content type 
- application/json

#### Link 
- https://velog.io/@rladmswjd119/%ED%94%84%EB%A6%AC%EC%98%A8%EB%B3%B4%EB%94%A9-%EB%B0%B1%EC%97%94%EB%93%9C-%EC%9D%B8%ED%84%B4%EC%8B%AD-%EC%84%A0%EB%B0%9C%EA%B3%BC%EC%A0%9C-REST-API-Link

### 예외 상황 및 처리
- 공백 혹은 null 검색시 에러 발생
- 검색한 키워드가 포함된 제목의 채용공고가 없을시 에러 발생


## 채용공고 상세 페이지 (선택사항 및 가산점요소)
### REST API
#### HTTP
- GET

#### 행위
- 채용공고의 상세 페이지를 조회한다.

#### 설명 
- 채용공고의 모든 정보를 조회할 수 있다.

#### URI
- GET/recruitment/{no}

#### RequstBody 
- {no: 채용공고 pk}

#### RespnseBody
- {title : 제목, 
career : 경력, 
degree : 학력, 
salary : 급여, 
detail : 상세정보, 
endDate : 마감일, 
companyName : 회사 이름, 
homePage: 홈페이지, 
address : 근무지 주소}

#### content type 
- application/json

#### Link 
- https://velog.io/@rladmswjd119/%ED%94%84%EB%A6%AC%EC%98%A8%EB%B3%B4%EB%94%A9-%EB%B0%B1%EC%97%94%EB%93%9C-%EC%9D%B8%ED%84%B4%EC%8B%AD-%EC%84%A0%EB%B0%9C%EA%B3%BC%EC%A0%9C-REST-API-Link

### 예외 상황 및 처리
- 존재하지 않는 채용공고의 상세페이지 조회시 예외 발생
