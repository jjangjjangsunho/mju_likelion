# 🦁 멋쟁이사자처럼 백엔드 과제 기록

> 명지대학교 멋쟁이사자처럼 [14]기 백엔드 파트 과제 및 실습 코드를 보관하는 리포지토리입니다.

<br>

## 🧑‍💻 Profile
* **Name:** 장선호
* **Track:** Backend (백엔드 파트)

<br>

## 🎯 학습 목표 (Learning Goals)
단순한 기능 구현을 넘어, 백엔드 개발자로서 다음과 같은 역량을 갖추는 것을 목표로 합니다.
* **객체지향 원칙(SOLID)**에 근거한 깨끗하고 유지보수하기 쉬운 자바 코드 작성
* **Spring Boot** 프레임워크의 동작 원리 이해 및 효율적인 RESTful API 설계
* **JPA/Hibernate**를 활용한 효율적인 데이터베이스 모델링 및 데이터 처리
* **Git/GitHub**를 활용한 버전 관리 및 협업 프로세스 숙달
  
<br>

## 🛠️ Tech Stack
<img src="https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white"/> <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat-square&logo=springboot&logoColor=white"/> <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white"/> <img src="https://img.shields.io/badge/Git-F05032?style=flat-square&logo=git&logoColor=white"/>

<br>

## 🗓️ Assignments (주차별 과제)

| 주차 | 과제명 | 핵심 학습 내용 | 상태 | 소스 코드 |
| :---: | :--- | :--- | :---: | :---: |
| **1주차** | Java 핵심 문법 및 흐름 | 기본 타입, 참조 타입, 배열, 조건문, 반복문, Scanner | ✅ 완료 | [📂 1주차](./src/week1) |
| **2주차** | Java 기초 및 객체지향 설계 | 클래스, 캡슐화 | ✅ 완료 | [📂 2주차](./src/week2) |
| **3주차** | Java 기초 및 객체지향 설계 | 상속, 다형성, 추상화 | ✅ 완료 | [📂 3주차](./src/week3) |
| **4주차** | Java Collection & 설계 확장 | List, Map, Generic | ✅ 완료 | [📂 4주차](./src/week4) |
| **5주차** | 자바로 배우는 Ioc/DI | IoC, DI, Construnctor Injection | ✅ 완료 | [📂 5주차](./src/week5) |
| **6주차** | Spring Boot 전환 | Spring Boot, Bean, Annotation | 🏃 진행 중 | [📂 6주차](./src/week6) |
| **7주차** | Rest API 설계(CRUD) | REST, HTTP, DTO | ⏳ 대기 | [📂 7주차](./src/week7) |
| **8주차** | JPA 기초 & 영속성 컨텍스트 | JPA, Entity. Respository | ⏳ 대기 | [📂 8주차](./src/week8) |
| **9주차** | 연관관계 & 트랜잭션 | @OneToMany, @@ManyToOne, Transactional | ⏳ 대기 | [📂 9주차](./src/week9) |
| **10주차** | 개인 미니 프로젝트: 예외 처리 통합 & 프론트엔드 연동 | Architecture, Refactoring | ⏳ 대기 | [📂 10주차](./src/week10) |



*(※ 표 안의 진행 상태는 `✅ 완료`, `🏃 진행 중`, `⏳ 대기` 등의 이모지를 활용하여 업데이트합니다.)*

<br> 

## 📁 Directory Structure

```text
📦 mju_likelion
 ┣ 📂 .idea           # IDE 설정 파일
 ┣ 📂 src             # 소스 코드 메인 폴더
 ┃ ┣ 📂 week1         # 1주차: Java 기초 및 입력 검증 실습
 ┃ ┣ 📂 week2         # 2주차: 상속(Inheritance) 실습
 ┃ ┣ 📂 week3         # 3주차: 상속, 다형성, 추상화 실습
 ┃ ┣ 📂 week4         # 4주차: List, Map, Generic 실습
 ┃ ┣ 📂 week5         # 5주차: IoC/DI 실습
 ┃ ┣ 📂 test          # 유닛 테스트 코드
 ┃ ┗ 📜 Main.java     # 메인 실행 파일
 ┣ 📂 test            # 루트 테스트 폴더
 ┣ 📜 .gitignore      # Git 제외 대상 설정
 ┣ 📜 Main.java       # 루트 메인 파일
 ┣ 📜 README.md       # 리포지토리 소개 파일
 ┗ 📜 likelion.iml    # 인텔리제이 프로젝트 모듈 파일
