//package com.dawid.paymentsystem.acceptance;
//
//import com.dawid.paymentsystem.model.User;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.assertEquals;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class CreateUserTest {
//
//    @Autowired
//    private UserFinder userFinder;
//
//    @Test
//    public void shouldCreateUser() {
//        // given
//        User user = new User();
//        user.setFirstName("Jan");
//        user.setLastName("Kowalski");
//        user.setEmail("jan@jan.pl");
//        user.setPassword("owk5");
//
//        // then
//        UserDTO dto = userFinder.getUserDetails(1);
//        assertEquals("Jan", dto.getFirstName());
//        assertEquals("Nowak",dto.getLastName());
//        assertEquals("jan@jan.pl",dto.getEmail());
//        assertEquals("owk5", dto.getPassword());
//    }
//}
