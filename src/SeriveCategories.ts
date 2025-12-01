import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { CategoryDto } from "./models/Category";
import { Observable } from "rxjs";



@Injectable({
    providedIn:'root'
})
export class ServiceCategories{


baseUrl:string='http://localhost:8080/api/categories';

constructor(private http:HttpClient){}

getAllCategories():Observable<CategoryDto[]>{
 return  this.http.get<CategoryDto[]>(`${this.baseUrl}`);
}




}