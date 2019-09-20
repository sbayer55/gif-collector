package com.tesseractus.gifcollector.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LocalDateTimeDeserializerTest {
    @Mock
    private JsonParser jsonParser;

    @Mock
    private DeserializationContext deserializationContext;

    @InjectMocks
    private LocalDateTimeDeserializer localDateTimeDeserializer;

    @Test
    public void deserialize() throws IOException {
        // Given
        LocalDateTime expected = LocalDateTime.of(2019, 3, 16, 12, 6, 0);
        when(jsonParser.getText()).thenReturn("2019-03-16 12:06:00");

        // When
        LocalDateTime actual = localDateTimeDeserializer.deserialize(jsonParser, deserializationContext);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void deserializeBadArgument() throws IOException {
        // Given
        String value = "I am a string";
        when(jsonParser.getText()).thenReturn(value);
        when(jsonParser.getCurrentValue()).thenReturn(value);

        // When
        LocalDateTime actual = localDateTimeDeserializer.deserialize(jsonParser, deserializationContext);

        // Then
        assertEquals(LocalDateTime.MIN, actual);
    }
}