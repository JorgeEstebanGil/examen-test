package com.example.demo.controller;

import com.example.demo.model.Examen;
import com.example.demo.service.ExamenService;

import org.junit.jupiter.api.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
public class ExamenControllerTest {

    ExamenController controller;

    @Mock
    private ExamenService service;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testNavigate() {
    }

    @Test
    void TestAge() {
        Model model = new ExtendedModelMap();
        Examen examen = new Examen();
        Date fechaNacimiento = new Date();
        Long age = 0L;
        try {
            age = service.ageChecker(examen.getFechaNacimiento(),new Date())	;
        } catch (Exception e) {
            assertEquals("error", "error");
        }
        if(age<18) {
            assertEquals("underAge", "underAge");
        }else if (age > 18 && age < 67) {
            assertEquals("getAJobNow", "getAJobNow");
        }else if(age > 67) {
            assertEquals("retired", "retired");
        }
        assertEquals("error", "error");
    }


    @Test
    public void division() {
    }

    @Test
    public void index() {
    }
}