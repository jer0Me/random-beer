import { BeerService } from './services/beer.service';
import { BeerComponent } from './containers/beer/beer.component';
import { BeerRoutingModule } from './beer-routing.module';
import { NgModule } from '@angular/core';
import { SharedModule } from '../shared/shared.module';
import { BeerDetailsComponent } from './components/beer-details/beer-details.component';

@NgModule({
  declarations: [
    BeerComponent,
    BeerDetailsComponent
  ],
  providers: [
    BeerService
  ],
  imports: [
    SharedModule,
    BeerRoutingModule
  ]
})
export class BeerModule { }
