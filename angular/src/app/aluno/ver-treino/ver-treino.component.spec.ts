import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerTreinoComponent } from './ver-treino.component';

describe('VerTreinoComponent', () => {
  let component: VerTreinoComponent;
  let fixture: ComponentFixture<VerTreinoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VerTreinoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VerTreinoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
