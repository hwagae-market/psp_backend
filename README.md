# 🏰 다풀어

사용자가 만들어가는 문제 공유 플랫폼 다풀어입니다. <br>
다풀어 플랫폼은 기존 문제 공유 플랫폼과 다르게, 개발자가 문제를 업데이트하는 것을 기다리지 않아도 내가 만들거나, 누군가 만든 문제를 풀어볼 수 있도록 서비스를 제공합니다. <br>


<br>

## 📌 프로젝트 개요

- **주요 목표와 하위 목표**
  - 문제 공유 플랫폼 구현
    - 사용자 간 문제를 등록하거나, 등록된 문제를 풀 수 있는 환경 제공
  - 회원 관리
    - JWT를 활용하여 사용자 로그인 구현
  - 문제 구독 서비스 제공
    - 원하는 문제들이 있다면, 해당 문제들을 구독할 수 있는 기능 구현
    - 구독한 문제를 한 눈에 쉽게 볼 수 있는 UI 제공
  - 오답노트 기능 제공
    - 틀린 문제를 그냥 지나치지 않고, 공부할 수 있게 오답노트 기능을 구현


<br>

## 💻 사용한 기술

### Front-End

<img src="https://img.shields.io/badge/react-61DAFB?style=for-the-badge&logo=react&logoColor=black"> <img src="https://img.shields.io/badge/redux-764ABC?style=for-the-badge&logo=redux&logoColor=white"> <img src="https://img.shields.io/badge/typescript-3178C6?style=for-the-badge&logo=typescript&logoColor=white"> <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white">

### Back-End

<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">

### DB

<img src="https://img.shields.io/badge/mariadb-003545?style=for-the-badge&logo=mariadb&logoColor=white"> <img src="https://img.shields.io/badge/h2-0000bb?style=for-the-badge&logo=h2&logoColor=white">

### ETC

<img src="https://img.shields.io/badge/discord-5865F2?style=for-the-badge&logo=discord&logoColor=white"> <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"> <img src="https://img.shields.io/badge/gitbook-3884FF?style=for-the-badge&logo=gitbook&logoColor=white"> <img src="https://img.shields.io/badge/googlesheets-34A853?style=for-the-badge&logo=googlesheets&logoColor=white">

<br>

## 📁 Repository 구조

<table style="width: 100% !important;">
<tr>
<th align="center">
<img width="384" height="1">
<p>Front-End</p>
</th>
<th align="center">
<img width="384" height="1">
<p>Back-End</p>
</th>
</tr>
<tr>
<td>

```
BACKEND
├─java
│  └─hwagae
│      └─psp
│          ├─config
│          │  ├─annotation
│          │  ├─aop
│          │  ├─authentication
│          │  └─filter
│          ├─controller
│          ├─dto
│          │  ├─request
│          │  └─response
│          ├─entity
│          ├─exception
│          ├─repository
│          └─service
└─resources
    ├─static
    └─templates
```

</td>
</tr>
</table>

<br>

## 💾 ERD

![다풀어](https://www.erdcloud.com/d/KKEhozeLcvBxmsZNC)

<br>

## 📌 더보기
