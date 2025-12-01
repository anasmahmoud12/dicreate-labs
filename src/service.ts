import { Sighup } from './models/sighup';
import { Login } from './models/login';
import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpClientModule } from '@angular/common/http';

@Injectable({

  providedIn: 'root'
}
)
export class Service{

baseUrl:string='http://localhost:8080/api/auth';

constructor(private http: HttpClient) {}

login(l:Login): Observable<string> {
  return this.http.post(`${this.baseUrl}/login`, l, {
    responseType: 'text'  
  });
}

Sighup(s:Sighup):Observable<any>{
return this.http.post(`${this.baseUrl}/register`,s
// if body not json make this to not give error
,{responseType:'text'}

);

}

getProducts():Observable<any>{
  return this.http.get(`${this.baseUrl}/`)

}





}