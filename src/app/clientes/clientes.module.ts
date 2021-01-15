import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClientesComponent } from './clientes.component'; //mesma pasta ./



@NgModule({
  declarations: [
    ClientesComponent
  ],
  imports: [
    CommonModule //definir que é umo module comum
  ],
  exports: [ //exportar os componentes. ou domulos
    ClientesComponent
  ]
})
export class ClientesModule { }
