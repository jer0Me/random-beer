import { Beer } from './../../models/beer.model';
import { BeerService } from '../../services/beer.service';
import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-beer',
  template: `
    <div id="main-panel">
      <h1>The Random Beer App</h1>
      <button class="btn btn-primary"
              (click)="findRandomBeer()">Show Another Beer</button>
    </div>

    <div id="content-panel">
      <app-beer-details [beer]="(beer$ | async)"></app-beer-details>
    </div>
  `,
  styleUrls: ['./beer.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class BeerComponent implements OnInit {

  beer$: Observable<Beer>;

  constructor(private beerService: BeerService) { }

  ngOnInit() {
    this.findRandomBeer();
  }

  findRandomBeer(): void {
    this.beer$ = this.beerService.findRandomBeer();
  }
}
