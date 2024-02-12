package com.example.demo.service;

import com.example.demo.model.Examen;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Spy;

import java.util.Date;

import static org.assertj.core.util.DateUtil.now;
import static org.junit.Assert.*;

public class ExamenServiceTest {

    ExamenService service = new ExamenService();

    @Test
    public void TestAgeChecker() {
        Examen examen = new Examen(1,1, 1, new Date(2005, 0, 1));
        Long expectedAge = 16L;
        assertEquals(expectedAge, service.ageChecker(examen.getFechaNacimiento(), new Date()));
    }

    @Test
    public void divisionChecker() {
    }
}