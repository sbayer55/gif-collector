package com.tesseractus.gifcollector.controller;

import com.tesseractus.gifcollector.dto.GifSearchResponseDto;
import com.tesseractus.gifcollector.service.GifSearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GifSearchControllerTest {
    @Mock
    private GifSearchService gifSearchService;

    @InjectMocks
    private GifSearchController gifSearchController;

    @Test
    public void findGif() {
        // given
        GifSearchResponseDto expected = Mockito.mock(GifSearchResponseDto.class);
        when(gifSearchService.findGif(any(), any(), any()))
                .thenReturn(expected);

        // when
        GifSearchResponseDto actual = gifSearchController.findGif(null, null, null);

        // then
        verify(gifSearchService).findGif(any(), any(), any());
        assertEquals(expected, actual);
    }
}