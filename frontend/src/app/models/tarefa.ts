export enum StatusEnum {
  PENDENTE = 'PENDENTE',
  CONCLUIDO = 'CONCLUIDO'
}

export enum PrioridadeEnum {
  ALTA = 'ALTA',
  MEDIA = 'MEDIA',
  BAIXA = 'BAIXA'
}

export interface Tarefa {
  id?: number;
  titulo: string;
  materia: string;
  dataEntrega: string;
  status: StatusEnum;
  prioridade: PrioridadeEnum;
}