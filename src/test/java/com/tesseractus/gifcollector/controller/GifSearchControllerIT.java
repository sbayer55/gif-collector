package com.tesseractus.gifcollector.controller;

import com.tesseractus.gifcollector.dao.User;
import com.tesseractus.gifcollector.dto.*;
import com.tesseractus.gifcollector.feign.GiphyFeign;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import javax.xml.bind.DatatypeConverter;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GifSearchControllerIT {
    @MockBean
    private GiphyFeign giphyFeign;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void before() {
        Integer gifCount = 3;
        String widthAndHeight = "10";
        String url = "http://localhost/git-url";

        GiphyFixedDto giphyFixedDto = new GiphyFixedDto();
        giphyFixedDto.setHeight(widthAndHeight);
        giphyFixedDto.setWidth(widthAndHeight);
        giphyFixedDto.setUrl(url);
        GiphyStillDto giphyStillDto = new GiphyStillDto();
        giphyStillDto.setHeight(widthAndHeight);
        giphyStillDto.setWidth(widthAndHeight);
        giphyStillDto.setUrl(url);
        GiphyOriginalDto giphyOriginalDto = new GiphyOriginalDto();
        giphyOriginalDto.setHeight(widthAndHeight);
        giphyOriginalDto.setWidth(widthAndHeight);
        giphyOriginalDto.setUrl(url);

        GiphyImagesDto giphyImagesDto = new GiphyImagesDto();
        giphyImagesDto.setFixedHeight(giphyFixedDto);
        giphyImagesDto.setFixedHeightSmallStill(giphyStillDto);
        giphyImagesDto.setOriginal(giphyOriginalDto);

        GiphyDataDto giphyDataDto = new GiphyDataDto();
        giphyDataDto.setImages(giphyImagesDto);

        GiphyPaginationDto giphyPaginationDto = new GiphyPaginationDto();
        giphyPaginationDto.setCount(gifCount);
        giphyPaginationDto.setTotalCount(gifCount);
        giphyPaginationDto.setOffset(0);

        GiphySearchResponseDto giphySearchResponseDto = new GiphySearchResponseDto();
        giphySearchResponseDto.setData(Collections.nCopies(gifCount, giphyDataDto));
        giphySearchResponseDto.setPagination(giphyPaginationDto);

        when(giphyFeign.findGif(any(), any(), any(), any(), any(), any(), any()))
                .thenReturn(giphySearchResponseDto);
    }

    @Test
    public void findGif() throws Exception {
        // Given
        String username = "steven";
        String password = "password";
        String authorizationHeader = "Basic " + DatatypeConverter.printBase64Binary((username + ":" + password).getBytes());

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        requestHeaders.add("Authorization", authorizationHeader);

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        HttpEntity<User> requestEntity = new HttpEntity<>(user, requestHeaders);

        String url = "http://localhost:" + port + "/api/gif-search";
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("q", "cat");


        // When
        ResponseEntity<GifSearchResponseDto> response = restTemplate.exchange(
                uriBuilder.toUriString(),
                HttpMethod.GET,
                requestEntity,
                GifSearchResponseDto.class);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody().getCount());
        assertNotNull(response.getBody().getGifs());
        assertNotNull(response.getBody().getOffset());
        assertNotNull(response.getBody().getTotalCount());
    }
}
