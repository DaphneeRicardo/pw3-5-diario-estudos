import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DiarioEstudosService } from '../../services/diario-estudos.service';
import { Tarefa } from '../../models/tarefa';

@Component({
  selector: 'app-lista-tarefas',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './lista-tarefas.html',
  styleUrl: './lista-tarefas.css'
})
export class ListaTarefas implements OnInit {

  private diarioService = inject(DiarioEstudosService);

  tarefas: Tarefa[] = [];
  carregando = false;
  erro = '';

  ngOnInit(): void {
    this.listarTarefas();
  }

  listarTarefas(): void {
    this.carregando = true;
    this.erro = '';

    this.diarioService.listarTarefas().subscribe({
      next: (dados) => {
        this.tarefas = dados;
        this.carregando = false;
      },
      error: (erro) => {
        console.error('Erro ao buscar tarefas:', erro);
        this.erro = 'Não foi possível carregar as tarefas.';
        this.carregando = false;
      }
    });
  }

  concluirTarefa(id: number): void {
    const tarefa = this.tarefas.find(t => t.id === id);

    if (!tarefa) return;

    this.diarioService.concluirTarefa(id).subscribe({
      next: () => {
        this.listarTarefas();
      },
      error: (erro) => {
        console.error('Erro ao concluir tarefa:', erro);
        this.erro = 'Não foi possível concluir a tarefa.';
      }
    });
  }

  excluirTarefa(id: number): void {
    if (!confirm('Deseja realmente excluir esta tarefa?')) {
      return;
    }

    this.diarioService.excluirTarefa(id).subscribe({
      next: () => {
        this.listarTarefas();
      },
      error: (erro) => {
        console.error('Erro ao excluir tarefa:', erro);
        this.erro = 'Não foi possível excluir a tarefa.';
      }
    });
  }
}