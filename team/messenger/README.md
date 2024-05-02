# Bias - Messenger
![banner](https://github.com/NBC-Chapter3-4/Messenger/assets/60022205/b522348a-c7c2-4a63-92eb-fae30f92c8de)



# 팀 소개
|김찬교|김민준|최지원|박혜란|임채명|
|----|----|----|----|----|
|![김찬교](https://github.com/NBC-Chapter3-4/Messenger/assets/60022205/4de3634c-3d3a-4b76-93bc-0e0f21c94aeb)|![김민준](https://github.com/NBC-Chapter3-4/Messenger/assets/60022205/70d0b3ca-46a3-4912-a644-e9663ecd4b12)|![최지원](https://github.com/NBC-Chapter3-4/Messenger/assets/60022205/3c206118-4327-45a4-92f3-fc66ea63c954)|![박혜란](https://github.com/NBC-Chapter3-4/Messenger/assets/60022205/3ffb8933-0965-41d2-ade3-97a07b99f922)|![임채명](https://github.com/NBC-Chapter3-4/Messenger/assets/60022205/12ce2288-aeab-4dbe-aed0-a7e1783f20b0)|
|<div align=center>[@bettor](https://github.com/theBettor)</div>|<div align=center>[@agvber](https://github.com/agvber)</div>|<div align=center>[@ji-circle](https://github.com/ji-circle)</div>|<div align=center>[@lany159](https://github.com/lany159)</div>|<div align=center>[@LimChaem](https://github.com/LimChaem)</div>|


# 프로젝트 소개
> 연락처 애플리케이션 만들기 프로젝트를 통하여 제작하게 되었습니다.
>   1. FaceBook의 Messenger를 참조하였습니다.
>   2. Bias : 나의 최애들의 연락처를 관리하는 Messenger App

<br>

# 시작가이드
```
 $ git clone https://github.com/NBC-Chapter3-4/Messenger.git
```

# Stacks
## Environment
<img src="https://img.shields.io/badge/androidstudio-3DDC84?style=for-the-badge&logo=androidstudio&logoColor=white"><img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=Git&logoColor=white"><img src="https://img.shields.io/badge/Github-181717?style=for-the-badge&logo=Github&logoColor=white">

## Development
<img src="https://img.shields.io/badge/android-3DDC84?style=for-the-badge&logo=android&logoColor=white"> <img src="https://img.shields.io/badge/kotlin-7F52FF?style=for-the-badge&logo=Kotlin&logoColor=white">

## Communication 
<img src="https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=Notion&logoColor=white"> <img src="https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=Slack&logoColor=white">

# 화면구성
## SplashScreen
<img src="https://github.com/NBC-Chapter3-4/Messenger/assets/60022205/d344f991-208f-45fa-970b-c08e60d9c583" width="20%" height="20%"/>

## MainScreen
<img src="https://github.com/NBC-Chapter3-4/Messenger/assets/60022205/324eab78-9dd8-4029-8287-e902e953a193" width="20%" height="20%"/>
&nbsp;
&nbsp;
&nbsp;
&nbsp;
<img src="https://github.com/NBC-Chapter3-4/Messenger/assets/60022205/10ca007d-cc19-4976-8503-3f5664a5d714" width="20%" height="20%"/>
&nbsp;
&nbsp;
&nbsp;
&nbsp;
<img src="https://github.com/NBC-Chapter3-4/Messenger/assets/60022205/04633751-2c59-4c9d-886e-85af106ce9e8" width="20%" height="20%"/>


## InformationScreen
<img src="https://github.com/NBC-Chapter3-4/Messenger/assets/60022205/a30d4489-f418-40a2-ae61-34d210d5a281" width="20%" height="20%"/>
&nbsp;
&nbsp;
&nbsp;
&nbsp;
<img src="https://github.com/NBC-Chapter3-4/Messenger/assets/60022205/3c5745f1-479e-4f95-ba4f-f9f72a6f4a89" width="20%" height="20%"/>
&nbsp;
&nbsp;
&nbsp;
&nbsp;
<img src="https://github.com/NBC-Chapter3-4/Messenger/assets/60022205/31f34dff-5183-40d0-9e1b-6d4a9a4043b4" width="20%" height="20%"/>
&nbsp;
&nbsp;
&nbsp;
&nbsp;
<img src="https://github.com/NBC-Chapter3-4/Messenger/assets/60022205/9f51b19b-100e-4f98-80a7-ab6c881aea52" width="20%" height="20%"/>

## Notification
<img src="https://github.com/NBC-Chapter3-4/Messenger/assets/60022205/6f8a3122-ae35-4112-910e-e9cdffeaa63a" width="20%" height="20%"/>

## 주요기능
'Bias'는 나의 최애들의 연락처를 ♥️로 관리할 수 있습니다.

<br>

## 연락처 리스트
- Linear Layout, Grid Layout을 변환
- grid Layout으로 변환시에 ‘좋아요’ 필터 처리
- Tab Layout과 ViewPager 연동
- List Layout 하트 클릭시 ‘좋아요’ 표시.
- 알림 센터/채팅창 클릭 시 알림 Badge 비활성화

<br>

## 연락처 추가
- DialogFragment를 사용하여
- 커스텀 다이얼로그
- 문자열 정규표현식을 사용해서 값 체크

<br>

## 상세 정보
- 기본 연락처와 연동하여 call & message 버튼 처리
- DetailPage & Item Long Click 알람 다이얼 로그 생성

<br>

## My Page
- Tab Layout & View Pager를 통해 Mypage로 이동
- Custom Dialog로 회원 정보 수정

<br>
  
# 라이브러리
- **RecyclerView**: 대규모 데이터 세트에 제한된 창을 제공하기 위한 유연한 보기
- **ViewPager2**: 사용자가 데이터 페이지를 좌우로 넘길 수 있게 해주는 레이아웃 관리자
- **Circleimageview**: 둥근 프로필 이미지 표시
- **ViewBinding**: 뷰 바인딩 및 레이아웃 관리
