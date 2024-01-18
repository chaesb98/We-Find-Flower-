package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
    "file:src/main/webapp/WEB-INF/spring/root-context.xml",
    "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class MemberControllerTest {

	@Setter(onMethod_ = {@Autowired})
    private WebApplicationContext ctx; // WebApplicationContext 주입
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }
    
	@Test
	public void testGet() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders
				.get("/member/get")
				.param("id", "TestID"))
				.andReturn()
				.getModelAndView().getModelMap());
	}

	@Test
	public void testRegister() throws Exception{
		String resultPage =
				mockMvc.perform(MockMvcRequestBuilders.post("/member/login")
						.param("Id", "hahahah")
						.param("Password", "1234")
						.param("Name", "하하")
						.param("Email", "sulzip@daum.net")
						.param("Address", "술한잔해요")
						).andReturn().getModelAndView().getViewName();
			log.info(resultPage);
	}
	
	
    @Test
    public void testModify() throws Exception {
        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/member/modify")
                .param("id", "TestID")
                .param("password", "1sadf")
                .param("email", "sdfasdf")
                .param("name", "장나라")
                .param("address", "asfffedf")
        ).andReturn().getModelAndView().getViewName();
        log.info(resultPage);
    }
    
    @Test
	public void leaveTest() throws Exception{
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/member/leave")
				.param("id", "test01").param("password", "test01")).andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}
}