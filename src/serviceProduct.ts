import { Sighup } from './models/sighup';
import { Login } from './models/login';
import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpClientModule } from '@angular/common/http';
import { ProductDto } from './models/ProductDto';

@Injectable({

  providedIn: 'root'
}
)
export class ServiceProduct{

baseUrl:string='http://localhost:8080/api/products';

constructor(private http: HttpClient) {}

getProducts():Observable<ProductDto[]>{
  return this.http.get<ProductDto[]>(`${this.baseUrl}`);
}





}