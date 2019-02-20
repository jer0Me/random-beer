package com.jerome.random.beer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BeerService {

    private final BeerRepository beerRepository;

    @Autowired
    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Transactional(readOnly = true)
    public BeerDto findRandomBeer() {
        return mapBeerToBeerDto(
                beerRepository.findById(getRandomBeerId())
                        .orElseThrow(BeerNotFoundException::new)
        );
    }

    private BeerDto mapBeerToBeerDto(Beer beer) {
        return new BeerDto.BeerDtoBuilder()
                .name(beer.getName())
                .description(beer.getDescription())
                .abv(beer.getAbv())
                .breweryLocation(beer.getBreweryLocation())
                .build();
    }

    private long getRandomBeerId() {
        long leftLimit = 1L;
        long rightLimit = beerRepository.countAll();
        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    }
}
