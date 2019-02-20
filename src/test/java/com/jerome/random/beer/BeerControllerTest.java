package com.jerome.random.beer;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.*;

public class BeerControllerTest {

    private BeerController beerController;
    private BeerService mockBeerService;

    public BeerControllerTest() {
        mockBeerService = mock(BeerService.class);
        beerController = new BeerController(mockBeerService);
    }

    @Test
    public void shouldReturnRandomBeerFromService() {
        beerController.findRandomBeer();
        verify(mockBeerService).findRandomBeer();
    }

    @Test
    public void shouldThrowResponseStatusExceptionWhenBeerNotFoundExceptionIsThrown() {
        when(mockBeerService.findRandomBeer()).thenThrow(new BeerNotFoundException());
        try {
            beerController.findRandomBeer();
        } catch (ResponseStatusException e) {
            assertThat(e.getStatus()).isEqualTo(HttpStatus.NOT_FOUND);
        }
    }
}
