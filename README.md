# 프리온보딩 백엔드 인턴십 선발과제


## 사용 기술
Java, Spring boot, JPA, JUnit, REST


## 개발시 중요하게 생각한 것
1. TDD
2. 성공 테스트뿐만 아니라 실패 테스트도 생각하기
3. 인터페이스를 이용한 개방-폐쇄 원칙 지키기


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
- {}

#### content type 
- application/json

#### Link 
- 

### 예외 상황 및 처리


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
- {}

#### content type 
- application/json

#### Link 
- 

### 예외 상황 및 처리


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
- {}

#### content type 
- application/json

#### Link 
- 

### 예외 상황 및 처리


## 채용공고 목록
### REST API
#### HTTP
- GET

#### 행위 
- 채용공고 목록을 가져온다.

#### 설명 
- 사용자는 채용 사이트에 게시된 채용공고 목록을 조회할 수 있다.

#### URI 
- GET/all-recruitment

#### RequstBody 
- {}

#### content type 
- application/json

#### Link 
- 

### 예외 상황 및 처리


## 채용공고 검색
### REST API
#### HTTP
- GET

#### 행위 
- 채용공고를 등록한다.

#### 설명 
- 회사가 작성한 채용공고를 채용 사이트에 등록하고 등록한 채용공고를 반환받는다.

#### URI 
- POST/recruitment

#### RequstBody 
- {}

#### content type 
- application/json

#### Link 
- 

### 예외 상황 및 처리


## 채용공고 상세 페이지
### REST API
#### HTTP
- POST

#### 행위 

#### 설명 

#### URI 

#### RequstBody 
- {}

#### content type 
- application/json

#### Link 
- 

### 예외 상황 및 처리
