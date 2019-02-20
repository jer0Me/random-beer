import { Beer } from './../../models/beer.model';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-beer-details',
  template: `
  <div class="card" *ngIf="beer">
    <div class="card-body">
      <h5 class="card-title">{{ beer.name }} {{ beer.abv }}%</h5>
      <h6 class="card-subtitle mb-2 text-muted"> {{ beer.breweryLocation }}</h6>
      <p class="card-text">{{ beer.description }}</p>
    </div>
</div>
  `,
  styleUrls: ['./beer-details.component.scss']
})
export class BeerDetailsComponent implements OnInit {

  @Input()
  beer: Beer;

  constructor() { }

  ngOnInit() {
  }

}
