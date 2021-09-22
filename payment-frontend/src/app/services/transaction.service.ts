import { map, catchError } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Transaction } from '../models/transaction';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  constructor(private http:HttpClient) { }

  addTransaction(transaction:Transaction):Observable<number>{
    let httpHeaders = new HttpHeaders({
      'Content-Type':'application/json'
    });
    return this.http.post<Transaction>("http://localhost:8080/api/transaction",JSON.stringify(transaction) , {
      headers: httpHeaders,
      observe: 'response'
    }).pipe(
      map(res=>res.status),
      catchError(this.handleError)
    );
  }



 private handleError(error: any) {
  console.error(error);
  return throwError(error);
}
}
