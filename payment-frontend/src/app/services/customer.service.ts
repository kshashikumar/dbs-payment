import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { map,catchError,tap} from 'rxjs/operators';
import { Customer } from '../models/Customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http:HttpClient) { }

  getAllCustomers(): Observable<Customer[]> {
     return this.http.get<Customer[]>("http://localhost:8080/api/customers").pipe(
       tap((customers) => console.log("No customers : "+customers.length)),
        catchError(this.handleError));

  }

  getCustomerById(id: string): Observable<Customer> {
    return this.http.get<Customer>("http://localhost:8080/api/customer/"+id).pipe(
      tap((customer) => console.log(customer)),
       catchError(this.handleError));

 }


  private handleError(error: any) {
    console.error(error);
    return throwError(error);
}

}
