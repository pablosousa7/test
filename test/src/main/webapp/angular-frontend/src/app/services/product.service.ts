import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../models/Product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {


  constructor(private http: HttpClient) { }

  getProducts(): Observable<Product[]> {
    return this.http.get("http://localhost:8080/api/products");
  }

  getProduct(id: number): Observable<Product>{
    return this.http.get("http://localhost:8080/api/product/" + id);
  }
}
