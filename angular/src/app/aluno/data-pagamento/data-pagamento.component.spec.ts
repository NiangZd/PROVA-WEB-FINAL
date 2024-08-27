import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DataPagamentoComponent } from './data-pagamento.component';

describe('DataPagamentoComponent', () => {
  let component: DataPagamentoComponent;
  let fixture: ComponentFixture<DataPagamentoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DataPagamentoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DataPagamentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
