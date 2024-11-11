# postPractice
목적 : CRUD 기능 연습

1. application.properties에 DB 관련 정보 저장 (URL, USERNAME, PASSWORD)
2. domain 정의

    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

3. Repository
4. Service
5. Controller (1차 목표)
1차 resource는 demo_basic 사용
2차 resource는 demo_final 사용

6. 조회 수 기능
7. 좋아요 기능 (로그인 기능 제외)
8. 댓글 기능
9. 페이징 
10. 조회수, 작성일 정렬 + 제목, 내용 검색기능