import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tarefa } from '../models/tarefa';

@Injectable({
  providedIn: 'root'
})
export class DiarioEstudosService {

  private http = inject(HttpClient);

  private apiUrl = 'http://localhost:8080/diarioEstudos/tarefas';

  // Listar todas as tarefas
  listarTarefas(): Observable<Tarefa[]> {
    return this.http.get<Tarefa[]>(this.apiUrl);
  }

  // Buscar tarefa por ID
buscarTarefa(id: number): Observable<Tarefa> {
  return this.http.get<Tarefa>(`${this.apiUrl}/${id}`);
}

  // Cadastrar tarefa
  cadastrarTarefa(tarefa: Tarefa): Observable<Tarefa[]> {
    return this.http.post<Tarefa[]>(this.apiUrl, tarefa);
  }

  // Atualizar tarefa
  atualizarTarefa(id: number, tarefa: Tarefa): Observable<Tarefa[]> {
    return this.http.put<Tarefa[]>(`${this.apiUrl}/${id}`, tarefa);
  }

  // Excluir tarefa
  excluirTarefa(id: number): Observable<Tarefa[]> {
    return this.http.delete<Tarefa[]>(`${this.apiUrl}/${id}`);
  }

  // Concluir tarefa
concluirTarefa(id: number): Observable<Tarefa[]> {
  return this.http.patch<Tarefa[]>(
    `${this.apiUrl}/${id}/concluir`,
    null
  );
}
}