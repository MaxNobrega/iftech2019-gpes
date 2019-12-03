import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {



  url = 'http://localhost:8080/categorias'

  constructor(private http: HttpClient) { }

  create (data) {
    return this.http.post(this.url, data)
      .toPromise()
  }
}
