package br.com.barbara.ErrorCenter;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import br.com.barbara.ErrorCenter.controller.UserController;
import br.com.barbara.ErrorCenter.model.UserAccount;
import br.com.barbara.ErrorCenter.repository.UserRepository;

@WebMvcTest(controllers = UserController.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserRepository userRepositoryMock;
	
	private List<UserAccount> userList;
	
	@BeforeEach
	void setUp() {
		this.userList = new ArrayList<UserAccount>();
		this.userList.add(new UserAccount());
		this.userList.add(new UserAccount());
	}
	
	@Test
	void shouldFindUserById() {
		Long id = userList.get(1).getId();
		
	}
	

}
