import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HelloComponet } from './hello/hello.component';
import { CursoAngularComponent } from './curso-angular/curso-angular.component'
import { ClientesModule} from "./clientes/clientes.module"
//essa classe sempre vai ser a principal do angular

@NgModule({
  declarations: [ //declara tudo que criou nesse MODULE inicial do app
    AppComponent,
    HelloComponet,
    CursoAngularComponent
  ],
  imports: [ //IMPORTAÇÃO de Modules
    BrowserModule, //necessário para a aplicação rodar no browser
    AppRoutingModule, // navegação de componentes e telas
    ClientesModule
  ],
  exports: [ // EXPORTAR PARA OUTROS MODULOS

  ],
  providers: [], //Declaração de serviços
  bootstrap: [AppComponent] //Componente que inicializa a aplicação o modolo RAIZ
})
export class AppModule { }
