import { catchError,tap } from 'rxjs/operators';
import { Bank } from './../models/bank';
import { Observable, throwError } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BankService {

  constructor(private http:HttpClient) { }


  getBankById(id: string): Observable<Bank> {
    return this.http.get<Bank>("http://localhost:8080/api/bank/"+id).pipe(
      tap((bank) => console.log( bank)),
       catchError(this.handleError));

 }


  private handleError(error: any) {
    console.error(error);
    return throwError(error);
}

}
