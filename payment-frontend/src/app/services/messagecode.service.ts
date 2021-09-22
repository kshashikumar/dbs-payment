import { catchError, tap } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Message } from '../models/message';

@Injectable({
  providedIn: 'root'
})
export class MessagecodeService {

  constructor(private http:HttpClient) { }

  getAllMessages(): Observable<Message[]> {
    return this.http.get<Message[]>("http://localhost:8080/api/messages").pipe(
      tap((message) => console.log("No customers : "+message.length)),
       catchError(this.handleError));

 }


 private handleError(error: any) {
  console.error(error);
  return throwError(error);
}


}
