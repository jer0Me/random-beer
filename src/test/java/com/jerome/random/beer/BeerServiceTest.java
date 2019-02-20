package com.jerome.random.beer;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BeerServiceTest {

    private BeerService beerService;
    private BeerRepository mockBeerRepository;

    public BeerServiceTest() {
        this.mockBeerRepository = mock(BeerRepository.class);
        beerService = new BeerService(mockBeerRepository);
    }

    @Test
    public void shouldRetrieveARandomBeerFromTheRepository() {
        Beer beer = new Beer();
        beer.setName("Guinness");
        beer.setDescription("Guinness is an Irish dry stout that originated in the brewery of Arthur Guinness");
        beer.setAbv(4.10);
        beer.setBreweryLocation("Dublin");
        when(mockBeerRepository.findById(any())).thenReturn(Optional.of(beer));

        BeerDto beerDto = beerService.findRandomBeer();

        assertThat(beerDto.getName()).isEqualTo(beer.getName());
        assertThat(beerDto.getDescription()).isEqualTo(beer.getDescription());
        assertThat(beerDto.getAbv()).isEqualTo(beer.getAbv());
        assertThat(beerDto.getBreweryLocation()).isEqualTo(beer.getBreweryLocation());
    }

    @Test(expected = BeerNotFoundException.class)
    public void shouldThrowBeerNotFoundExceptionIfThereIsNotAnyBeer() {
        beerService.findRandomBeer();
    }
}
