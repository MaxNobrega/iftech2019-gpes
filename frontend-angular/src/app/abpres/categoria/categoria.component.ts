import { Component, OnInit } from '@angular/core';
import { Categoria } from './entity/categoria';
import { CategoriaService } from './service/categoria.service';

@Component({
  selector: 'app-categoria',
  templateUrl: './categoria.component.html',
  styleUrls: ['./categoria.component.css']
})
export class CategoriaComponent implements OnInit {  


  categoria: Categoria

  constructor(private service: CategoriaService) {
    this.categoria = new Categoria()
  }

  ngOnInit() {
  }

  onSubmit(){
    this.service.create(this.categoria)
      .then(response => {
        console.log(response)
      })
      .catch(ex => {
        console.log(ex)
      })
  }
  

}
