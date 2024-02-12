package com.example.demo.model;

import com.example.demo.controller.ExamenController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest
@AutoConfigureMockMvc
public class ExamenTest {

    Examen examen;
    @Test
    void testGetIdWHenIsNotEmpty(){
        examen = new Examen(1, 10, 2, null);
        assertEquals(1, examen.getId());
    }

    @Test
    void testGetIdWhenIsEmpty(){
        examen = new Examen(null, 10, 2, null);
        assertNull(examen.getId());
    }

    @Test
    void testGetDivisorWhenIsNotEmpty(){
        examen = new Examen(1, 10, 2, null);
        assertEquals(2, examen.getDivisor());
    }

    @Test
    void testGetDivisorWhenIsEmpty(){
        examen = new Examen(1, 10, null, null);
        assertNull(examen.getDivisor());
    }

    @Test
    void testGetFechaNacimientoWhenIsNotEmpty(){
        examen = new Examen(1, 10, 2, new Date(121, 9, 1)); // El mes debe ser 9 en lugar de 10
        assertNotNull(examen.getFechaNacimiento()); // Debe ser assertNotNull en lugar de assertNull
    }


    @Test
    void testGetFechaNacimientoWhenIsEmpty(){
        examen = new Examen(1, 10, 2, null);
        assertNull(examen.getFechaNacimiento());
    }

    @Test
    void testSetIdWhenIsNotEmpty(){
        examen = new Examen(1, 10, 2, null);
        examen.setId(20);
        assertEquals(20, examen.getId());
    }
    @Test
    void testSetIdWhenIsEmpty(){
        examen = new Examen(null, 10, 2, null);
        examen.setId(20);
        assertEquals(20, examen.getId());
    }


    @Test
    void testSetDividendoWhenIsNotEmpty(){
        examen = new Examen(1, 10, 2, null);
        examen.setDividendo(20);
        assertEquals(20, examen.getDividendo());
    }
    @Test
    void testSetDividendoWhenIsEmpty(){
        examen = new Examen(1, null, 2, null);
        examen.setDividendo(20);
        assertEquals(20, examen.getDividendo());
    }

    @Test
    void testSetDivisorWhenIsNotEmpty(){
        examen = new Examen(1, 10, 2, null);
        examen.setDivisor(20);
        assertEquals(20, examen.getDivisor());
    }

    @Test
    void testSetDivisorWhenIsEmpty(){
        examen = new Examen(1, 10, null, null);
        examen.setDivisor(20);
        assertEquals(20, examen.getDivisor());
    }

    @Test
    void testSetFechaNacimientoWhenIsNotEmpty(){
        examen = new Examen(1, 10, 2, null);
        examen.setFechaNacimiento(new Date(121, 9, 20)); // El mes debe ser 9 en lugar de 10
        assertNotNull(examen.getFechaNacimiento()); // Debe ser assertNotNull en lugar de assertNull
    }


    @Test
    void testSetFechaNacimientoWhenIsEmpty(){
        examen = new Examen(1, 10, 2, null);
        examen.setFechaNacimiento(null);
        assertNull(examen.getFechaNacimiento());
    }

    @Test
    void testToString(){
        examen = new Examen(1, 10, 2, null);
        assertEquals("Examen [id=1, dividendo=10, divisor=2, fechaNacimiento=null]", examen.toString());
    }
}