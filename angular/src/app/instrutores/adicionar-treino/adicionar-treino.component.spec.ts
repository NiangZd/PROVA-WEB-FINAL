import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdicionarTreinoComponent } from './adicionar-treino.component';

describe('AdicionarTreinoComponent', () => {
  let component: AdicionarTreinoComponent;
  let fixture: ComponentFixture<AdicionarTreinoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdicionarTreinoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdicionarTreinoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
