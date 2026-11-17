import { TestBed } from '@angular/core/testing';

import { DiarioEstudosService } from './diario-estudos-service';

describe('DiarioEstudosService', () => {
  let service: DiarioEstudosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DiarioEstudosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
