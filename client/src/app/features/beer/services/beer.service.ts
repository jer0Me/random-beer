import { Beer } from '../models/beer.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BeerService {

  constructor(private httpClient: HttpClient) { }

  findRandomBeer(): Observable<Beer> {
    return this.httpClient
      .get<Beer>('api/v1/beer/random');
  }
}
