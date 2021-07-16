# 일학습중간평가 - 생산관리 시스템 (MesMonitoring)

---------------------

### 과제 개요
다음은 생산관리 모니터링을 실시하는 프로그램이다. \
생산관리 데이터베이스를 구축하고, 생산수량을 자동으로 모니터링 하는 프로그램을 작성하시오.

### 개발 환경
최소 개발 환경 - Eclipse4.7(Oxygen), Java(Java SE JDK 8), Tomcat(9), DBMS(MariaDB 10) \
실제 개발 환경 - Eclipse4.7.3a(Oxygen.3a), Java(Java SE JDK 8), Tomcat(9), DBMS(MariaDB 10)

### 총 개발 기간 [20H]
[2H] 2021년 06월 08일 (화) - 개발 환경 구축 \
[3H] 2021년 06월 09일 (수) - '생산관리 시스템 화면'·'제품 입력 화면'·'제품 조회, 수정, 삭제 화면' 뷰 작성, DAO·DAO Base 생성, DB 연동 \
[5H] 2021년 06월 10일 (목) - '제품 입력 화면' 구현(InsertServlet), '제품 조회, 수정, 삭제 화면' 일부 구현(SelectServlet, UpdateServlet) \
[5H] 2021년 06월 21일 (월) - '제품 조회, 수정, 삭제 화면' 구현(DeleteServlet), '우선 생산 제품 화면' 구현(PreProductServlet), \
                              '이익 순위 제품 화면' 구현(RankProductServlet), '그룹별 재고 수량 화면' 구현(StockProductServlet) \
[5H] 2021년 06월 22일 (화) - 전체 기능 테스트 및 보완

---------------------

### 웹페이지 도식
![마인드맵](https://user-images.githubusercontent.com/49296529/122859427-fa01c400-d356-11eb-8785-7f5af6e863ed.PNG)

---------------------

### 과제 요구사항 목록
![2e1d7a53-2c24-4d7d-9438-9ed3145b4752 hwp-0001](https://user-images.githubusercontent.com/49296529/125903331-9d87b0ce-8c46-4144-9e1b-34db128cf748.jpg)
![2e1d7a53-2c24-4d7d-9438-9ed3145b4752 hwp-0002](https://user-images.githubusercontent.com/49296529/125903352-9dbd47c0-3c4f-4084-b7bb-58fccf2f1eb7.jpg)
![2e1d7a53-2c24-4d7d-9438-9ed3145b4752 hwp-0005](https://user-images.githubusercontent.com/49296529/125903389-22c6ee8a-9201-4d47-856e-034b1a5fd4eb.jpg)
![2e1d7a53-2c24-4d7d-9438-9ed3145b4752 hwp-0006](https://user-images.githubusercontent.com/49296529/125903397-9c808637-dbae-4178-a756-63eb59b09fe5.jpg)
![2e1d7a53-2c24-4d7d-9438-9ed3145b4752 hwp-0007](https://user-images.githubusercontent.com/49296529/125903403-4ae1effa-b0ad-41aa-a458-216afad700e5.jpg)
![2e1d7a53-2c24-4d7d-9438-9ed3145b4752 hwp-0008](https://user-images.githubusercontent.com/49296529/125903412-f6c5ba24-9f5e-476c-a3ee-6df10d469e11.jpg)


---------------------
