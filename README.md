# 자바 스프링 CRUD 게시판

IDE : IntelliJ2022

Java : temurin 11

Spring Boot 2.7.6, Spring MVC, JPA

View : Thymeleaf

Database : MySQL 8.0.31

## 애플리케이션 아키텍쳐

![image](https://user-images.githubusercontent.com/90087519/209016952-34aa3d24-81d5-4086-8574-efd658b473a6.png)


Controller : 웹 계층, GET 조회는 곧바로 Repository 접근

Service : 비즈니스 로직, 트랜잭션 처리

Repository : JPA 사용

Entity : 엔티티 모음

## REST API

![image](https://user-images.githubusercontent.com/90087519/209013760-703e6674-587c-4aa7-8af0-2d40a617c45a.png)

## 게시판 목록 화면

<img src="https://user-images.githubusercontent.com/90087519/209009205-3b237e18-5c70-4d40-9090-bb1edc6d0bb5.png" width="800" height="400"/>

## 게시판 수정 화면

<img src="https://user-images.githubusercontent.com/90087519/209014158-cf669c9b-97be-4de3-bcb7-b26c9ad08037.png" width="800" height="400"/>

## GET API

![image](https://user-images.githubusercontent.com/90087519/209015175-1dc8a2d6-96ca-41de-ab2d-6ed17dd6ddce.png)

## POST API

![image](https://user-images.githubusercontent.com/90087519/209015280-f74b6a4e-847a-41f8-89ec-e74cb4560c9b.png)
