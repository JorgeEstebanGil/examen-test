package com.example.demo.service;

import com.example.demo.model.Examen;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Spy;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.assertj.core.util.DateUtil.now;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class ExamenServiceTest {

    ExamenService service = new ExamenService();

    @Test
    public void testAgeChecker() {
        LocalDate fechaNacimiento = LocalDate.now().minusYears(30);
        Date fechaNacimientoDate = Date.from(fechaNacimiento.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Date hoy = Date.from(Instant.now());
        long ageEsperada = 30;
        long age = service.ageChecker(fechaNacimientoDate, hoy);
        assertNotNull(age);
        assertEquals(ageEsperada, age);
        assertInstanceOf(Long.class, age);
    }

    @Test
    public void testDivisionChecker() {
        int dividendo = 10;
        int divisor = 2;
        int resltadoEsperado = dividendo/divisor;

        int resultado = service.divisionChecker(dividendo, divisor);
        assertNotNull(resultado);
        assertEquals(resltadoEsperado, resultado);
        assertInstanceOf(Integer.class, resultado);
    }
}