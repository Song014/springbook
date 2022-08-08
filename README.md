# springbook

프로젝트 처음만들었을때 할 일
1. encoding 설정
  * window > prefer... > encoding 검색 > utf-8로 변경
  * xml 수정   
  	``` 
	<!-- 캐릭터 인코딩 필터 설정  -->
	<!-- 컨트롤러에서 response.setCharacterEncoding()를매번 실행하지 않기 위해 서블릿 필터를 이용해 처리  -->
	<filter>

		<filter-name>encodingFilter</filter-name>

		<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>

		<init-param>

			<param-name>encoding</param-name>

			<param-value>UTF-8</param-value>

		</init-param>

		<init-param>

			<param-name>forceEncoding</param-name>

			<param-value>true</param-value>

		</init-param>
	</filter>
	<filter-mapping>

		<filter-name>encodingFilter</filter-name>

		<url-pattern>/*</url-pattern>
	</filter-mapping>
	 <!-- jsp 파일 utf-8 페이지 인코딩 설정 <%@ page pageEncoding="UTF-8" %>  -->
	<jsp-config>

		<jsp-property-group>

			<url-pattern>*.jsp</url-pattern>

			<page-encoding>UTF-8</page-encoding>

		</jsp-property-group>
	</jsp-config>

  	```
2. 톰캣 서버 연동
3. pom.xml 버전 체크
  * 자바버전 1.8
  * 스프링프레임워크 5.0.7
  * junit 4.12
  * maven 플러그인 1.8
  
 4. maven 디펜던시 추가 안될때 Window - Preferences - Maven > 다운로드 관련 다 체크
 5. [db테스트를 위한 sql 생성](./src/main/resources/springbook.sql) 
  
 
 ## 결합도
 
 * [TVUser.java](./src/main/java/polymorphism/TVUser.java)
 
