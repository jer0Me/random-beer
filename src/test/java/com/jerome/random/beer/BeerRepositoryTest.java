package com.jerome.random.beer;

import org.flywaydb.test.annotation.FlywayTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BeerRepositoryTest {

    @Autowired
    private BeerRepository beerRepository;

    @Test
    @FlywayTest(invokeBaselineDB = true)
    @Transactional
    public void shouldCountAllBeers() {
        assertThat(beerRepository.countAll()).isEqualTo(5);
    }

    @Test
    @FlywayTest(invokeBaselineDB = true)
    @Transactional
    public void shouldGetBeerById() {
        assertThat(beerRepository.findById(1L)).isNotEmpty();
    }
}
