//SEMPRE DECLARAR (import {}) ESSE componente em algum MODULO ( app.Modules.ts)

import { Component } from '@angular/core';

//Anotação para criar um componente personalizado
@Component({
    selector: "hello", //Criar um componente (TAG na página)
    templateUrl: "./hello.component.html", 
})

export class HelloComponet { //export torna a classe visível para outros componentes
    clientes: Cliente[] = [];
    constructor(){
        let fulano = new Cliente('Fulano' , 30);
        let cicrano = new Cliente('Cicrano' , 24);
        let rolifield = new Cliente('Rolifield' , 68);
        this.clientes = [fulano, cicrano, rolifield];
    }
    
}

 class Cliente{
    nome: string;
    idade: number;
    constructor(pNome: string , pIdade: number){
        this.nome = pNome;
        this.idade = pIdade;
    }
}