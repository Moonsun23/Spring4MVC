package controller;

import hi1237.hello.spring4.controller.IndexController;


import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class indexControllerUnitTest {

    // mockMvc : 웹 어플리케이션을 어플리케이션 서버에 배포하지 않고도
    // 스프링 MVC의 동작을 재현할 수 있도록 제공하는 특수한 클래스
    private MockMvc mockMvc;

    // 테스트 수행 전 준비작업 정의
    @Before
    public void setUp() {
        // 테스트 할 클래스에 대한 mock 객체 생성
        // standaloneSetup(테스트 할 대상 클래스).build
        this.mockMvc = MockMvcBuilders.standaloneSetup(
           new IndexController()
        ).build();
    }

    // 테스트 수행
    @Test


    public void indexTest() throws Exception {
        // perform안에 get 방식 씀
        // perform : 실제 수행할 작업 정의
        // get: get 방식의 http 요청 생성
        // andExpect: 의도한 결과값이 전달되는지 확인
        // status: http 요청 후 서버로 부터의 응답코드 확인
        /// model: 컨트롤러에서 생성한 모델 객체
        // view: 컨트롤러에서 생성한 뷰 리졸버 객체
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("sayHello"))
                .andExpect(model().attribute("sayHello","Hello World! from Controller"))
                .andExpect(view().name("index.tiles"));
    }
    @Test


    public void indexViewTest() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();
        // sout 이 sysout 임..
        System.out.println(mvcResult.getModelAndView());
    }

}
