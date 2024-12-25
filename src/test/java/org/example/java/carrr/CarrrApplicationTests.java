package org.example.java.carrr;

import org.example.java.carrr.Entity.User;
import org.example.java.carrr.Repositary.UserRepo;
import org.example.java.carrr.Service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class CarrrApplicationTests {

    @Test
    void contextLoads() {
    }

    @Mock
    UserRepo userRepo;

    @InjectMocks
    UserService service;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser(){
        User user = new User();
        user.setEmail("sample123@gmail.com");
        user.setUserName("xyz");
        user.setPassword("123");
        service.create(user);
        verify(userRepo).save(user);
    }

    @Test
    void testGetUserByEmail(){
        User user = new User();
        user.setEmail("sample123@gmail.com");
        user.setUserName("xyz");
        user.setPassword("123");
        when(userRepo.getUserByEmail(user.getEmail())).thenReturn(user);
        User resultUser = service.getUser(user.getEmail());
        assertNotNull(resultUser);
        assertEquals(user.getEmail(), resultUser.getEmail());
        assertEquals(user.getUserName(), resultUser.getUserName());
        assertEquals(user.getPassword(), resultUser.getPassword());
        verify(userRepo).getUserByEmail(user.getEmail());
    }


}
